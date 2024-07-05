package com.yf.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 *  MyMetaObjectHandler 
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("crtTime", LocalDateTime.now(), metaObject);
        setFieldValByName("uptTime", LocalDateTime.now(), metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("uptTime", LocalDateTime.now(), metaObject);
    }
}