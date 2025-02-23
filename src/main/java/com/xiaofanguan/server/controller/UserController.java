package com.xiaofanguan.server.controller;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.common.WebContext;
import com.xiaofanguan.server.pojo.User;
import com.xiaofanguan.server.service.UserService;
import com.xiaofanguan.server.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 新增用户
     */
    @PostMapping("/add")
    public ResponseResult<User> addUser(@Valid @RequestBody UserVO userVO) {
        User user = new User();
        user.setWechatUserId(userVO.getWechatUserId());
        user.setAvatar(userVO.getAvatar());
        user.setRole(userVO.getRole());
        user.setBalance(userVO.getBalance());
        user.setNickname(userVO.getNickname());
        user.setCreateTime(LocalDateTime.now());
        return userService.addUser(user);
    }

    /**
     * 根据微信用户ID查询用户
     */
    @GetMapping("/getByWechatUserId")
    public ResponseResult<User> getUserByWechatUserId() {
        return userService.getUserByWechatUserId(WebContext.getUserId());
    }

    /**
     * 修改用户角色
     */
    @PostMapping("/updateRole")
    public ResponseResult<User> updateUserRole(@RequestParam String id, @RequestParam String role) {
        // 从 WebContext 中获取 userId
        String userId = WebContext.getUserId();
        return userService.updateUserRole(userId, role);
    }
}