package com.yf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: SkuServerApplication
 ** @author: yangfeng
 ** @date: 2024/7/3 10:33
 ** @version: 1.0.0
 *********************************************************/
@SpringBootApplication
@MapperScan("com.yf.mapper")
public class SkuServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkuServerApplication.class,args);
    }
}
