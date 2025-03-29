//package com.xiaofanguan.server.service.impl;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xiaofanguan.server.common.ResponseResult;
//import com.xiaofanguan.server.pojo.User;
//import com.xiaofanguan.server.service.WechatLoginService;
//import com.xiaofanguan.server.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.transaction.annotation.Transactional;
//import java.time.LocalDateTime;
//
//@Service
//public class WechatLoginServiceImpl implements WechatLoginService {
//
//    @Autowired
//    private WechatConfig wechatConfig;
//
//    @Autowired
//    private UserService userService;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    @Transactional
//    public String login(String code) {
//        try {
//            // 微信登录凭证校验接口地址
//            String url = String.format(
//                "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
//                wechatConfig.getAppId(),
//                wechatConfig.getAppSecret(),
//                code
//            );
//            // 发送请求到微信服务器
//            String response = restTemplate.getForObject(url, String.class);
//            // 解析响应
//            JsonNode jsonNode = objectMapper.readTree(response);
//            // 检查是否有错误
//            if (jsonNode.has("errcode") && jsonNode.get("errcode").asInt() != 0) {
//                throw new RuntimeException("微信登录失败: " + jsonNode.get("errmsg").asText());
//            }
//            // 获取openId
//            String openId = jsonNode.get("openid").asText();
//            // 查询用户是否存在
//            ResponseResult<User> userResult = userService.getUserByWechatUserId(openId);
//            if (userResult.getData() == null) {
//                // 用户不存在，创建新用户
//                User newUser = new User();
//                newUser.setWechatUserId(openId);
//                newUser.setRole("0"); // 默认为顾客
//                newUser.setBalance(0); // 初始余额为0
//                newUser.setCreateTime(LocalDateTime.now());
//                userService.addUser(newUser);
//            }
//            return openId;
//        } catch (Exception e) {
//            throw new RuntimeException("微信登录失败: " + e.getMessage());
//        }
//    }
//}