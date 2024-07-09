package com.yf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 0-未更新 1-已更新
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}