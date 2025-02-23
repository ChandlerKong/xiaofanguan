package com.xiaofanguan.server.service;

import org.springframework.stereotype.Service;

@Service
public class WechatLoginServiceImpl implements WechatLoginService {

    @Override
    public String login(String code) {
        // 实现具体的登录认证逻辑
        // 例如：通过code获取微信用户信息，生成token等
        return code;
    }
}