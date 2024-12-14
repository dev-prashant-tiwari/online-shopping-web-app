package com.web_application.controller;

import com.web_application.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/login")
    ResponseEntity<Object>login(HttpServletRequest httpRequest){
        return authService.doLogin(httpRequest);
    }
}
