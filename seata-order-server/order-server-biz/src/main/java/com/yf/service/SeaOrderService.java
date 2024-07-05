package com.yf.service;

import com.yf.entity.SeaOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yangfeng
* @description 针对表【sea_order】的数据库操作Service
* @createDate 2024-07-03 09:45:20
*/
public interface SeaOrderService extends IService<SeaOrder> {

    boolean buyProduct(Integer productId);

}
