package com.yf.feign;

import com.yf.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*********************************************************
 ** 用户feign接口定义
 ** <br><br>
 ** @ClassName: SysUserFeign
 ** @author: yangfeng
 ** @date: 2024/6/25 15:59
 ** @version: 1.0.0
 *********************************************************/
@FeignClient(name = "feign-server1",path = "/sysUser")
public interface SysUserFeign {
    @GetMapping("/getById/{id}")
    SysUser getById(@PathVariable("id") Integer id);
}
