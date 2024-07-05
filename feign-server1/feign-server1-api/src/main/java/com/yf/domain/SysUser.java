package com.yf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: SysUser
 ** @author: yangfeng
 ** @date: 2024/6/25 15:57
 ** @version: 1.0.0
 *********************************************************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {

    private Integer id;

    private String name;

    private Integer age;

    public SysUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
