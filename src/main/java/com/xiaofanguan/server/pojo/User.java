package com.xiaofanguan.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 用户表实体类
 */
@Data
@TableName("user")
public class User {
    @TableId
    private String id = UUID.randomUUID().toString().replaceAll("-", ""); // 主键，使用UUID自动生成并去除横杠

    @NotBlank(message = "微信用户ID不能为空")
    @Size(max = 64, message = "微信用户ID长度不能超过64")
    @TableField("wechat_user_id")
    private String wechatUserId; // 微信用户ID

    private String avatar; // 用户头像

    @NotNull(message = "创建时间不能为空")
    @TableField("create_time")
    private LocalDateTime createTime; // 创建时间，使用LocalDateTime

    @NotBlank(message = "用户角色不能为空")
    private String role; // 用户角色（0:顾客, 1:老板）

    @NotNull(message = "用户余额不能为空")
    private Integer balance; // 用户余额

    @Size(max = 64, message = "用户昵称长度不能超过64")
    private String nickname; // 用户昵称
}