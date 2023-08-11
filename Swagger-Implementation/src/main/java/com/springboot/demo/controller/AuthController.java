package com.springboot.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.payload.JWTAuthResponse;
import com.springboot.demo.payload.LoginDto;
import com.springboot.demo.payload.LoginResponseDto;
import com.springboot.demo.payload.RegisterDto;
import com.springboot.demo.service.AuthService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //START ::  BUILD Token Creation REST API
    @PostMapping(value = {"/accessToken"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){

        String token = authService.login(loginDto);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }
    //END ::  BUILD Token Creation REST API

    
    // START :: BUILD Register REST API
    @PostMapping(value = {"/register"})
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto){
    	
        //String response = ;
        return new ResponseEntity<>(authService.register(registerDto), HttpStatus.CREATED);
    }
    // END :: BUILD Register  REST API
    
    
    // START :: BUILD Login  REST API
//    @PostMapping(value = {"/login"})
//    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto){
//    	
//    	String response = authService.userLogin(loginDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
    
    @PostMapping(value = {"/login"})
    public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginDto loginDto){
    	
    	  return new ResponseEntity<>(authService.userLogin(loginDto), HttpStatus.OK);
    }
    // END :: BUILD Login  REST API

}