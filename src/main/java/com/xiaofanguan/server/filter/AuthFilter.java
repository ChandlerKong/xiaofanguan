package com.xiaofanguan.server.filter;

import com.xiaofanguan.server.common.WebContext;
import com.xiaofanguan.server.exception.UnauthorizedException;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthFilter implements Filter {

    // 白名单路径
    private static final List<String> WHITE_LIST = Arrays.asList("/demo/wechat/login");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        WebContext.setRequest(httpRequest);
        try {
            String requestURI = httpRequest.getRequestURI();
            // 白名单路径直接放行
            if (WHITE_LIST.contains(requestURI)) {
                chain.doFilter(request, response);
                return;
            }

            String token = httpRequest.getHeader("token");
            if (token == null || token.isEmpty()) {
//                throw new UnauthorizedException("Token is required");
                token = "1";
            }

            // 这里可以添加 token 校验逻辑，例如解析 JWT 或者查询数据库
            // 假设 token 就是 userId
            String userId = token;

            // 将 userId 放入请求上下文
            httpRequest.setAttribute("userId", userId);

            chain.doFilter(request, response);
        } finally {
            WebContext.clear();
        }
    }
}