package com.yf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************************************
 ** 测试 controller
 ** <br><br>
 ** @ClassName: TestController
 ** @author: yangfeng
 ** @date: 2024/6/27 10:56
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping("/getInfo")
    public String getInfo(){
        return "获取到用户信息";
    }

    @GetMapping("/sayHello")
    public String sayHello(){
        return "你好啊，小菜鸟";
    }
}
