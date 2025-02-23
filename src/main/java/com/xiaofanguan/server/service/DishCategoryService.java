package com.xiaofanguan.server.service;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.DishCategory;

import java.util.List;

public interface DishCategoryService {
    ResponseResult<DishCategory> addDishCategory(DishCategory dishCategory);
    ResponseResult<List<DishCategory>> getDishCategoriesByRestaurantId(String restaurantId);

    ResponseResult<Boolean> deleteById(String id);
}
