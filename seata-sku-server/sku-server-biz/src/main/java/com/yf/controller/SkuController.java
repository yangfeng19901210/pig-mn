package com.yf.controller;

import com.yf.entity.SeaSku;
import com.yf.service.SeaSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*********************************************************
 ** 库存管理controller
 ** <br><br>
 ** @ClassName: SkuController
 ** @author: yangfeng
 ** @date: 2024/7/3 10:44
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/sku")
@Slf4j
public class SkuController {
    @Resource
    private SeaSkuService seaSkuService;
    @PostMapping("/updateById")
    public boolean updateById(@RequestBody SeaSku seaSku){
        return seaSkuService.updateById(seaSku);
    }
}
