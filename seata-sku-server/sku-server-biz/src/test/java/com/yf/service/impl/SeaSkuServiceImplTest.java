package com.yf.service.impl;

import com.yf.entity.SeaSku;
import com.yf.service.SeaSkuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class SeaSkuServiceImplTest {
    @Resource
    private SeaSkuService seaSkuService;
    @Test
    void testSave(){
        for(int i=1;i<36;i++){
            SeaSku seaSku = new SeaSku();
            seaSku.setName("商品"+i);
            seaSku.setSkuAmount(30);
            seaSkuService.save(seaSku);
        }

    }

}