package com.xiaofanguan.server.controller;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.DishCategory;
import com.xiaofanguan.server.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishCategory")
public class DishCategoryController {
    @Autowired
    private DishCategoryService dishCategoryService;

    @PostMapping("/add")
    public ResponseResult<DishCategory> addDishCategory(@RequestBody DishCategory dishCategory) {
        return dishCategoryService.addDishCategory(dishCategory);
    }

    @GetMapping("/getByRestaurantId")
    public ResponseResult<List<DishCategory>> getDishCategoriesByRestaurantId() {
        return dishCategoryService.getDishCategoriesByRestaurantId("");
    }


    @GetMapping("/deleteById")
    public ResponseResult<Boolean> deleteById(@RequestParam String id) {
        return dishCategoryService.deleteById(id);
    }
}
