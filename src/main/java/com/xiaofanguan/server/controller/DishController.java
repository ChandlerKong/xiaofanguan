package com.xiaofanguan.server.controller;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.Dish;
import com.xiaofanguan.server.pojo.DishCategory;
import com.xiaofanguan.server.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping("/add")
    public ResponseResult<Dish> addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PostMapping("/update")
    public ResponseResult<Dish> updateDish(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
    }

    @GetMapping("/getByRestaurantId")
    public ResponseResult<List<DishCategory>> getDishesByRestaurantId() {
        return dishService.getDishesByRestaurantId("restaurantId");
    }

    @GetMapping("/deleteById")
    public ResponseResult<Boolean> deleteById(@RequestParam String id) {
        return dishService.deleteById(id);
    }
}