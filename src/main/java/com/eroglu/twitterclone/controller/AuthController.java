package com.eroglu.twitterclone.controller;

import com.eroglu.twitterclone.dto.LoginRequest;
import com.eroglu.twitterclone.dto.RegisterRequest;
import com.eroglu.twitterclone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private com.eroglu.twitterclone.dto.RegisterRequest RegisterRequest;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest RegisterRequest) {
        authService.signup(RegisterRequest);
        return new ResponseEntity<>("User Registration Successful",
                OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        authService.login(loginRequest);
        return new ResponseEntity<>("Login Successful",
                OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        authService.logout(request, response);
        return new ResponseEntity<>("Logout Successful",
                OK);


    }

}