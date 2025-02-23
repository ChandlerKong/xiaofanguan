package com.xiaofanguan.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.mapper.UserMapper;
import com.xiaofanguan.server.pojo.User;
import com.xiaofanguan.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseResult<User> addUser(User user) {
        userMapper.insert(user);
        return ResponseResult.success(user);
    }

    @Override
    public ResponseResult<User> getUserByWechatUserId(String wechatUserId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wechat_user_id", wechatUserId);
        User user = userMapper.selectOne(queryWrapper);
        return ResponseResult.success(user);
    }

    @Override
    public ResponseResult<User> updateUserRole(String id, String role) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return ResponseResult.error(404, "User not found");
        }
        user.setRole(role);
        userMapper.updateById(user);
        return ResponseResult.success(user);
    }
}