package com.yf.task;

import com.yf.data.DB;
import com.yf.entity.Student;
import com.yf.service.StudentService;
import com.yf.util.DateTimeUtils;
import io.gitee.loulan_yxq.owner.json.tool.JsonTool;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource
    private StudentService studentService;
    @Scheduled(cron = "0 0/5 * ? * *")
    public void helloWorld(){
        log.info("执行。。。");
    }

    @Scheduled(cron = "0/30 * * ? * *")
    public void updateStatus(){
        log.info("执行更新状态");
        //获取所有用户数据
        List<Student> all = studentService.list();
        all.forEach(this::updateByEntity);
    }

    private void updateByEntity(Student entity){
        RLock lock = redissonClient.getLock(entity.getId() + "");
        boolean b = false;
        try {
            b = lock.tryLock(3, 3, TimeUnit.SECONDS);
            if(b){
                log.info("数据{} 获取到锁的时间为 {}",JsonTool.toJson(entity), DateTimeUtils.getCurrentTime());
                entity = studentService.getById(entity.getId());
                if(entity.getStatus().equals(0)){
                    entity.setStatus(1);
                    studentService.updateById(entity);
                }else{
                    log.info("数据状态已更新{}",JsonTool.toJson(entity));
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
