package com.xiaofanguan.server.service;

public interface WechatLoginService {
    /**
     * 处理微信小程序登录认证
     * @param code 微信小程序提供的code
     * @return 登录认证结果
     */
    String login(String code);
}