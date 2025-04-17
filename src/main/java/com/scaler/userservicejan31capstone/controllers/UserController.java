package com.scaler.userservicejan31capstone.controllers;

import com.scaler.userservicejan31capstone.dtos.*;
import com.scaler.userservicejan31capstone.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    UserService userService = new UserService();

    @PostMapping("/register")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto)
    {
        return null;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto)
    {
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto)
    {
        return null;
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable("token") String token)
    {
        return null;
    }


}
