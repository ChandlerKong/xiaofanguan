package com.xiaofanguan.server.service;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.pojo.User;

/**
 * 用户服务接口
 */
public interface UserService {
    ResponseResult<User> addUser(User user);

    ResponseResult<User> getUserByWechatUserId(String wechatUserId);

    ResponseResult<User> updateUserRole(String id, String role);
}