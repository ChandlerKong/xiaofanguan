package com.xiaofanguan.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.mapper.DishMapper;
import com.xiaofanguan.server.pojo.Dish;
import com.xiaofanguan.server.pojo.DishCategory;
import com.xiaofanguan.server.service.DishCategoryService;
import com.xiaofanguan.server.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishCategoryService dishCategoryService;


    @Override
    public ResponseResult<Dish> addDish(Dish dish) {
        dishMapper.insert(dish);
        return ResponseResult.success(dish);
    }

    @Override
    public ResponseResult<Dish> updateDish(Dish dish) {
        dishMapper.updateById(dish);
        return ResponseResult.success(dish);
    }

    @Override
    public ResponseResult<List<DishCategory>> getDishesByRestaurantId(String restaurantId) {
        List<DishCategory> dishCategories = dishCategoryService.getDishCategoriesByRestaurantId(restaurantId).getData();
        dishCategories.forEach(dishCategory -> {
            QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("category_id", dishCategory.getId())
                       .orderByAsc("create_time");
            List<Dish> dishes = dishMapper.selectList(queryWrapper);
            dishCategory.setDishes(dishes);
        });
        return ResponseResult.success(dishCategories);
    }
}