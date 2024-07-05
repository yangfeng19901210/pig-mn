package com.yf.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: BaseEntity
 ** @author: yangfeng
 ** @date: 2024/7/4 10:22
 ** @version: 1.0.0
 *********************************************************/
@Data
public class BaseEntity {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "crt_time" , fill = FieldFill.INSERT)
    private LocalDateTime crtTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "upt_time" , fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime uptTime;
}
