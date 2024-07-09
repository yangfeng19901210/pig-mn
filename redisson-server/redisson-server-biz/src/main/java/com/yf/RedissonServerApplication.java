package com.yf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: RedissonServerApplication
 ** @author: yangfeng
 ** @date: 2024/7/9 13:52
 ** @version: 1.0.0
 *********************************************************/
@SpringBootApplication
@EnableScheduling
@MapperScan("com.yf.mapper")
public class RedissonServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedissonServerApplication.class,args);
    }
}
