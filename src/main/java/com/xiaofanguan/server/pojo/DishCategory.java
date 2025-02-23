package com.xiaofanguan.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@TableName("dish_category")
public class DishCategory {
    @TableId
    private String id = UUID.randomUUID().toString().replaceAll("-", ""); // 主键

    @TableField("restaurant_id")
    private String restaurantId = UUID.randomUUID().toString().replaceAll("-", ""); // 餐厅ID

    @TableField("category_name")
    private String categoryName; // 分类名称

    @TableField("sort_order")
    private Integer sortOrder = 0; // 排序，默认为0

    @TableField("create_time")
    private LocalDateTime createTime = LocalDateTime.now(); // 创建时间

    @TableField(exist = false)
    private List<Dish> dishes;
}