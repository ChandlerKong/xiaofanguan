package com.xiaofanguan.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.mapper.RestaurantMapper;
import com.xiaofanguan.server.pojo.Restaurant;
import com.xiaofanguan.server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public ResponseResult<Restaurant> updateBossAndCustomer(String id, String userIdBoss, String userIdCustomer) {
        Restaurant restaurant = restaurantMapper.selectById(id);
        if (restaurant == null) {
            return ResponseResult.error(404, "Restaurant not found");
        }
        restaurant.setUserIdBoss(userIdBoss);
        restaurant.setUserIdCustomer(userIdCustomer);
        restaurantMapper.updateById(restaurant);
        return ResponseResult.success(restaurant);
    }

    @Override
    public ResponseResult<Restaurant> updateNameAndDescription(String id, String restaurantName, String description) {
        Restaurant restaurant = restaurantMapper.selectById(id);
        if (restaurant == null) {
            return ResponseResult.error(404, "Restaurant not found");
        }
        restaurant.setRestaurantName(restaurantName);
        restaurant.setDescription(description);
        restaurantMapper.updateById(restaurant);
        return ResponseResult.success(restaurant);
    }

    @Override
    public ResponseResult<Restaurant> getRestaurantById(String id) {
//        Restaurant restaurant = restaurantMapper.selectById(id);
//        if (restaurant == null) {
            // 返回一个假的 Restaurant 对象
            Restaurant fakeRestaurant = new Restaurant();
            fakeRestaurant.setId("fakeId");
            fakeRestaurant.setBindTime(LocalDateTime.now());
            fakeRestaurant.setAddress("新希望家园");
            fakeRestaurant.setRestaurantName("梁文雪的小饭馆");
            fakeRestaurant.setDescription("梁文雪的小饭馆营业啦！！！");
            fakeRestaurant.setFileId("5ea4479b04d644c0b7a5bac17f398991");
            return ResponseResult.success(fakeRestaurant);
//        }
//        return ResponseResult.success(restaurant);
    }
}
