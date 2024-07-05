package com.yf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: OrderServerApplication
 ** @author: yangfeng
 ** @date: 2024/7/3 10:12
 ** @version: 1.0.0
 *********************************************************/
@SpringBootApplication
@MapperScan("com.yf.mapper")
@EnableFeignClients
public class OrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class,args);
    }
}
