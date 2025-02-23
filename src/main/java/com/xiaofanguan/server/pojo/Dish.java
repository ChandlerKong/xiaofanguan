package com.xiaofanguan.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("dish")
public class Dish {
    @TableId
    private String id; // 主键

    @TableField("category_id")
    private String categoryId; // 分类ID

    @TableField("dish_name")
    private String dishName; // 菜品名称

    @TableField("dish_description")
    private String dishDescription; // 菜品介绍

    @TableField("dish_image")
    private String dishImage; // 菜品图片

    @TableField("sort_order")
    private Integer sortOrder = 0; // 排序

    private Double price = 0.00; // 菜品价格

    @TableField("sold_quantity")
    private Integer soldQuantity = 0; // 已售数量

    @TableField("create_time")
    private LocalDateTime createTime = LocalDateTime.now(); // 创建时间
}