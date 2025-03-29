//package com.xiaofanguan.server.controller;
//
//import com.xiaofanguan.server.common.ResponseResult;
//import com.xiaofanguan.server.service.WechatLoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class WechatLoginController {
//
//    @Autowired
//    private WechatLoginService wechatLoginService;
//
//    /**
//     * 处理微信小程序登录认证
//     * @param code 微信小程序提供的code
//     * @return 登录认证结果，返回openId
//     */
//    @PostMapping("/wechat/login")
//    public ResponseResult<String> wechatLogin(@RequestParam String code) {
//        try {
//            String openId = wechatLoginService.login(code);
//            return ResponseResult.success(openId);
//        } catch (Exception e) {
//            return ResponseResult.error(500, e.getMessage());
//        }
//    }
//}