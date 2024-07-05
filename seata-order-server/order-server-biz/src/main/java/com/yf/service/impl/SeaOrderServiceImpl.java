package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.entity.SeaOrder;
import com.yf.entity.SeaSku;
import com.yf.feign.SkuFeign;
import com.yf.service.SeaOrderService;
import com.yf.mapper.SeaOrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author yangfeng
* @description 针对表【sea_order】的数据库操作Service实现
* @createDate 2024-07-03 09:45:20
*/
@Service
public class SeaOrderServiceImpl extends ServiceImpl<SeaOrderMapper, SeaOrder>
    implements SeaOrderService{
    @Resource
    private SkuFeign skuFeign;
    @GlobalTransactional
    @Override
    public boolean buyProduct(Integer productId) {
        SeaOrder order = new SeaOrder();
        order.setName("分布式事务商品购买");
        order.setProductId(productId);
        save(order);
        SeaSku sku = new SeaSku();
        sku.setId(productId);
        sku.setSkuAmount(19);
        skuFeign.updateById(sku);
//        return true;
        throw new RuntimeException("分布式事务异常测试");
    }
}




