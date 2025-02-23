package com.xiaofanguan.server.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户表VO类
 */
@Data
public class UserVO {
    @NotBlank(message = "微信用户ID不能为空")
    @Size(max = 64, message = "微信用户ID长度不能超过64")
    private String wechatUserId; // 微信用户ID

    private String avatar; // 用户头像

    @NotBlank(message = "用户角色不能为空")
    private String role; // 用户角色（0:顾客, 1:老板）

    @NotNull(message = "用户余额不能为空")
    private Integer balance; // 用户余额

    @Size(max = 64, message = "用户昵称长度不能超过64")
    private String nickname; // 用户昵称
}