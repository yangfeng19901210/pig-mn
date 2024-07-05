package com.yf.controller;

import com.yf.config.db.MnDataSource;
import com.yf.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************************************
 ** 系统用户controller
 ** <br><br>
 ** @ClassName: SysUserController
 ** @author: yangfeng
 ** @date: 2024/6/25 16:06
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {
    @GetMapping("/getById/{id}")
    public SysUser getById(@PathVariable Integer id){
        return MnDataSource.getById(id);
    }
}
