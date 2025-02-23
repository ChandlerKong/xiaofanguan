package com.xiaofanguan.server.service;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.Restaurant;

public interface RestaurantService {
    ResponseResult<Restaurant> updateBossAndCustomer(String id, String userIdBoss, String userIdCustomer);
    ResponseResult<Restaurant> updateNameAndDescription(String id, String restaurantName, String description);
    ResponseResult<Restaurant> getRestaurantById(String id);
}
