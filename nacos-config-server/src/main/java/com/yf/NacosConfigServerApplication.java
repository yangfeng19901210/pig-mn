package com.yf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import({TestBean1.class, TestBean2.class})
@ComponentScan(basePackages = {"com.yf","com.dsk","com.yzzg"})
public class NacosConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigServerApplication.class,args);
    }
}