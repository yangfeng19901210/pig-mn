package com.yf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************************************
 ** nacos controller
 ** <br><br>
 ** @ClassName: NacosController
 ** @author: yangfeng
 ** @date: 2024/6/26 10:40
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/nacos")
@RefreshScope
@Slf4j
public class NacosController {
    @Value("${author.name:谦谦君子}")
    private String name;
    @Value("${author.age:100}")
    private Integer age;
    @GetMapping("/getAuthorInfo")
    public String getAuthorInfo(){
        return "作者姓名："+name+",年龄为："+age;
    }

}
