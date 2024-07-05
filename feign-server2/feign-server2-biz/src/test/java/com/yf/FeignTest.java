package com.yf;

import com.alibaba.fastjson.JSON;
import com.yf.domain.SysUser;
import com.yf.feign.SysUserFeign;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*********************************************************
 ** feign 测试
 ** <br><br>
 ** @ClassName: FeignTest
 ** @author: yangfeng
 ** @date: 2024/6/25 16:21
 ** @version: 1.0.0
 *********************************************************/
@SpringBootTest
@Slf4j
public class FeignTest {

    private static List<SysUser> users = new ArrayList<>();
    static{
        users.add(new SysUser(1,"王可可",3));
        users.add(new SysUser(2,"娇娇",null));
        users.add(new SysUser(3,"君子",6));
    }

    @Resource
    private SysUserFeign sysUserFeign;
    @Test
    void getFeignUserTest(){
        System.out.println(sysUserFeign.getById(2));
    }
    @Test
    void testUpdate(){
        try {
            users.forEach(user ->{
                try {
                    user.setAge(user.getAge()+10);
                } catch (Exception e) {
                    log.error("数据更新异常",e);
                }
            });
        } catch (Exception e) {
            log.error("数据更新异常",e);
        } finally {
            log.info("更新后的数据为data ={}", JSON.toJSONString(users));
        }
    }

}
