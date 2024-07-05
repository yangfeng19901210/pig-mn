package com.yf.config.db;

import com.yf.domain.SysUser;

import java.util.LinkedHashMap;
import java.util.Map;

/*********************************************************
 ** 数据源模拟类
 ** <br><br>
 ** @ClassName: MnDataSource
 ** @author: yangfeng
 ** @date: 2024/6/25 16:08
 ** @version: 1.0.0
 *********************************************************/
public class MnDataSource {

    private static Map<Integer, SysUser> sysUserMap = new LinkedHashMap<>();

    static {
        sysUserMap.put(1,new SysUser(1,"张三"));
        sysUserMap.put(2,new SysUser(2,"李四"));
        sysUserMap.put(3,new SysUser(3,"王五"));
    }

    public static SysUser getById(Integer id){
        if(null==id){
          return null;
        }
        return sysUserMap.get(id);
    }
}
