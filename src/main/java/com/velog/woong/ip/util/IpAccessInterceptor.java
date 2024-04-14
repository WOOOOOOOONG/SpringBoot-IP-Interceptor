package com.velog.woong.ip.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Component
public class IpAccessInterceptor implements HandlerInterceptor {

    private final List<String> allowedIPs = Arrays.asList("127.0.0.1", "::1"); // 허용된 IP 주소 목록

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientIp = Utils.getClientIP(request);

        if (!allowedIPs.contains(clientIp)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied"); // 차단
            return false;
        }

        return true;
    }
}

