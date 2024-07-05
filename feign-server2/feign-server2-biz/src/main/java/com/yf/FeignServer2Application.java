package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @EnableFeignClients 是一个类级别的注解，主要用于启动feign客户端扫描
 * 当添加这个注解到你的Spring Boot应用主类或配置类上时，Spring Boot将会自动扫描指定包路径下的所有
 * @FeignClient注解的接口，并为每个接口创建一个实现类，这个实现类实际上就是一个HTTP客户端，
 * 能够以声明式的方式调用远程服务
 * 关键属性
 * basePackages：这是最重要的属性之一，它指定了要扫描@FeignClient接口的基包路径。你可以提供多个包路径，如示例所示，以逗号分隔。
 * 该注解需要加注在调用方服务所在的启动类上
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServer2Application {
    public static void main(String[] args) {
        SpringApplication.run(FeignServer2Application.class,args);
    }
}