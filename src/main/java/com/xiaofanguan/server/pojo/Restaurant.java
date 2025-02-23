package com.xiaofanguan.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("restaurant")
public class Restaurant {
    @TableId
    private String id; // 主键

    @TableField("user_id_boss")
    private String userIdBoss; // 老板ID

    @TableField("user_id_customer")
    private String userIdCustomer; // 顾客ID

    @TableField("bind_time")
    private LocalDateTime bindTime; // 绑定时间

    @TableField("restaurant_name")
    private String restaurantName; // 餐厅名称

    private String description; // 餐厅介绍

    private String address; // 餐厅地址

    private String fileId; // 餐馆图片地址
}