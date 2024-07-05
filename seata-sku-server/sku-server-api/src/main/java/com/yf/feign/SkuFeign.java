package com.yf.feign;

import com.yf.entity.SeaSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: SkuFeign
 ** @author: yangfeng
 ** @date: 2024/7/3 10:48
 ** @version: 1.0.0
 *********************************************************/
@FeignClient(name = "sku-server",path = "/sku")
public interface SkuFeign {
    @PostMapping("/updateById")
    boolean updateById(@RequestBody SeaSku seaSku);
}
