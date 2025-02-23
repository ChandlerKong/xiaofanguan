package com.xiaofanguan.server.common;

import javax.servlet.http.HttpServletRequest;

public class WebContext {
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();

    public static void setRequest(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }

    public static String getUserId() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return (String) request.getAttribute("userId");
        }
        return null;
    }

    public static void clear() {
        requestHolder.remove();
    }
}