package com.xiaofanguan.server.interceptor;

import com.xiaofanguan.server.common.ResponseResult;
import com.xiaofanguan.server.exception.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    // 白名单路径
    private static final List<String> WHITE_LIST = Arrays.asList("/user/add", "/user/getByWechatUserId");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        // 白名单路径直接放行
        if (WHITE_LIST.contains(requestURI)) {
            return true;
        }

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            throw new UnauthorizedException("Token is required");
        }

        // 这里可以添加 token 校验逻辑，例如解析 JWT 或者查询数据库
        // 假设 token 就是 userId
        String userId = token;

        // 将 userId 放入请求上下文
        request.setAttribute("userId", userId);

        return true;
    }
}