package com.xiaofanguan.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.mapper.DishCategoryMapper;
import com.xiaofanguan.server.pojo.DishCategory;
import com.xiaofanguan.server.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {
    private final DishCategoryMapper dishCategoryMapper;

    public DishCategoryServiceImpl(DishCategoryMapper dishCategoryMapper) {
        this.dishCategoryMapper = dishCategoryMapper;
    }

    @Override
    public ResponseResult<DishCategory> addDishCategory(DishCategory dishCategory) {
        dishCategory.setSortOrder(0); // 默认排序为0
        dishCategoryMapper.insert(dishCategory);
        return ResponseResult.success(dishCategory);
    }

    @Override
    public ResponseResult<List<DishCategory>> getDishCategoriesByRestaurantId(String restaurantId) {
        QueryWrapper<DishCategory> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("restaurant_id", restaurantId)
        queryWrapper.orderByAsc("create_time");
        List<DishCategory> dishCategories = dishCategoryMapper.selectList(queryWrapper);
        return ResponseResult.success(dishCategories);
    }

    @Override
    public ResponseResult<Boolean> deleteById(String id) {
        dishCategoryMapper.deleteById(id);
        return ResponseResult.success(true);
    }
}
