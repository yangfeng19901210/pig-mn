package com.yf;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/*********************************************************
 ** sentinel 启动类
 ** <br><br>
 ** @ClassName: SentinelServerApplication
 ** @author: yangfeng
 ** @date: 2024/6/27 10:36
 ** @version: 1.0.0
 *********************************************************/
@SpringBootApplication
public class SentinelServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServerApplication.class,args);
    }
}
