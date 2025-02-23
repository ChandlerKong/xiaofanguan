package com.xiaofanguan.server.controller;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.Restaurant;
import com.xiaofanguan.server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/updateBossAndCustomer")
    public ResponseResult<Restaurant> updateBossAndCustomer(@RequestParam String id, @RequestParam String userIdBoss, @RequestParam String userIdCustomer) {
        return restaurantService.updateBossAndCustomer(id, userIdBoss, userIdCustomer);
    }

    @PostMapping("/updateNameAndDescription")
    public ResponseResult<Restaurant> updateNameAndDescription(@RequestParam String id, @RequestParam String restaurantName, @RequestParam String description) {
        return restaurantService.updateNameAndDescription(id, restaurantName, description);
    }

    @GetMapping("/getById")
    public ResponseResult<Restaurant> getRestaurantById() {
        return restaurantService.getRestaurantById("");
    }
}
