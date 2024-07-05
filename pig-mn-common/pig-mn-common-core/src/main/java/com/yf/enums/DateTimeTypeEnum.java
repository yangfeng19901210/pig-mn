package com.yf.enums;

import lombok.AllArgsConstructor;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: DateTimeTypeEnum
 ** @author: yangfeng
 ** @date: 2024/7/3 16:20
 ** @version: 1.0.0
 *********************************************************/
@AllArgsConstructor
public enum DateTimeTypeEnum {
    TODAY("today"),YESTERDAY("yesterday"),BEFORESEVEN("beforeSeven"),CURRENTMONTH("currentMonth"),BEFORETHIRTY("beforeThirty");
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DateTimeTypeEnum getByName(String name){
        DateTimeTypeEnum[] values = DateTimeTypeEnum.values();
        for (DateTimeTypeEnum value : values) {
            if(value.name.equals(name)){
                return value;
            }
        }
        return null;
    }
}
