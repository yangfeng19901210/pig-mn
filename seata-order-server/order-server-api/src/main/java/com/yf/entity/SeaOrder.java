package com.yf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sea_order
 */
@TableName(value ="sea_order")
@Data
public class SeaOrder extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 订单名称
     */
    private String name;

    /**
     * 商品id
     */
    private Integer productId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}