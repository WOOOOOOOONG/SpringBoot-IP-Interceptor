package com.velog.woong.ip.controller;

import com.velog.woong.ip.util.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DenyIpController {

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        String clientIp = Utils.getClientIP(request);

        if (isAllowed(clientIp)) {
            return "Success";
        } else {
            return "False";
        }
    }

    private boolean isAllowed(String clientIp) {
        // 여기에 허용된 IP 주소 목록을 설정합니다.
        // return clientIp.equals("127.0.0.1") || clientIp.equals("::1") || clientIp.equals("192.168.35.56");
        return true;
    }
}

