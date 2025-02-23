package com.xiaofanguan.server.service;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.Dish;
import com.xiaofanguan.server.pojo.DishCategory;

import java.util.List;

public interface DishService {
    ResponseResult<Dish> addDish(Dish dish);
    ResponseResult<Dish> updateDish(Dish dish);
    ResponseResult<List<DishCategory>> getDishesByRestaurantId(String restaurantId);
}