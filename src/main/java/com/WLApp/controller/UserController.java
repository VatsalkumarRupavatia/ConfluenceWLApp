package com.WLApp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
class UserController {

    private final OAuth2RestTemplate restTemplate;

    @GetMapping
    ResponseEntity<?> myself(WebRequest request) {
        System.out.println("request:" + request);
        // System.out.println(restTemplate.getForObject("/user", Map.class));
        final Map<?, ?> result = restTemplate.getForObject("/user", Map.class);
        System.out.println("result:" + result);
        return ResponseEntity.ok(result);
    }
}
