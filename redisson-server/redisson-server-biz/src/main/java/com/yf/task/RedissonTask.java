package com.yf.task;

import com.yf.data.DB;
import com.yf.entity.Student;
import io.gitee.loulan_yxq.owner.json.tool.JsonTool;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: RedissonTask
 ** @author: yangfeng
 ** @date: 2024/7/9 13:54
 ** @version: 1.0.0
 *********************************************************/
@Component
@Slf4j
public class RedissonTask {

    @Autowired
    private RedissonClient redissonClient;
    @Scheduled(cron = "0 0/5 * ? * *")
    public void helloWorld(){
        log.info("执行。。。");
    }

    @Scheduled(cron = "0/30 * * ? * *")
    public void updateStatus(){
        log.info("执行更新状态");
        //获取所有用户数据
        List<Student> all = DB.getAll();
        all.forEach(this::updateByEntity);
    }

    private void updateByEntity(Student entity){
        RLock lock = redissonClient.getLock(entity.getId() + "");
        boolean b = false;
        try {
            b = lock.tryLock(0, 6, TimeUnit.SECONDS);
            if(b){
                log.info("更新数据 data{} 的状态", JsonTool.toJson(entity));
                Student student = DB.getById(entity.getId());
                if(student.getStatus().equals(0)){
                    student.setStatus(1);
                    DB.updateById(student);
                    Thread.sleep(1000*5);
                }else{
                    log.info("状态已更新");
                }
            }else{
                log.info("系统忙，获取锁失败");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if(b && lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
