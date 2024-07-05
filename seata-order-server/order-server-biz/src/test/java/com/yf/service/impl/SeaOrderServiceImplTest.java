package com.yf.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yf.SeaOrderQueryDTO;
import com.yf.entity.SeaOrder;
import com.yf.service.SeaOrderService;
import com.yf.util.DateTimeUtils;
import io.gitee.loulan_yxq.owner.core.collection.ArrayTool;
import io.gitee.loulan_yxq.owner.core.tool.ObjectTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class SeaOrderServiceImplTest {
    @Resource
    private SeaOrderService seaOrderService;
    @Test
    void testSave(){
        for(int i=0;i<25;i++){
            SeaOrder seaOrder = new SeaOrder();
            seaOrder.setName("可可订单"+i);
            seaOrder.setProductId(i);
            seaOrderService.save(seaOrder);
        }

    }
    @Test
    void testPageQuery(){
        Page<SeaOrder> pageParam = new Page<>(1,3);
        Page<SeaOrder> page = seaOrderService.page(pageParam);
        log.info(JSON.toJSONString(page));

    }

    @Test
    void buyProduct() {
        seaOrderService.buyProduct(1);
    }
    @Test
    void timeQuery(){
        SeaOrderQueryDTO query = new SeaOrderQueryDTO();
        String[] strArr = new String[2];
        strArr[0] = "2024-07-03 10:29:11";
        strArr[1] = "2024-07-04 10:29:11";
        query.setQueryTimeRound(strArr);
        query.setType("beforeSeven");
        QueryWrapper<SeaOrder> qw = new QueryWrapper<>();
        if (ObjectTool.isNotNull(query) && ArrayTool.isNotEmpty(query.getQueryTimeRound())) {
            qw.lambda().between(SeaOrder::getCrtTime,
                    LocalDateTime.parse(query.getQueryTimeRound()[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(query.getQueryTimeRound()[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        if(StrTool.isNotBlank(query.getType())){
            qw.lambda().between(SeaOrder::getCrtTime, DateTimeUtils.getDateTimes(query.getType())[0],DateTimeUtils.getDateTimes(query.getType())[1]);
        }
        seaOrderService.list(qw);

    }

}