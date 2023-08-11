package com.springboot.demo.service;

import com.springboot.demo.payload.LoginDto;
import com.springboot.demo.payload.LoginResponseDto;
import com.springboot.demo.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    RegisterDto register(RegisterDto registerDto);
    
    LoginResponseDto userLogin(LoginDto loginDto);
}
