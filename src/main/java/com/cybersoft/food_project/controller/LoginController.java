package com.cybersoft.food_project.controller;

import com.cybersoft.food_project.jwt.JwtTokenHelper;
import com.cybersoft.food_project.payload.request.SigninRequest;
import com.cybersoft.food_project.payload.response.DataResponse;
import com.cybersoft.food_project.payload.response.TokenResponse;
import com.cybersoft.food_project.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/signin")
public class LoginController {
    private  long expireTime = 8*60*60*1000;
    private long refreshExpireTime =  80*60*60*1000;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    LoginService loginService;

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @PostMapping
    public ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest){
//        boolean isSuccess = loginService.checkLogin(signinRequest.getUsername(), signinRequest.getPassword());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),
                signinRequest.getPassword());

        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);

        String token = jwtTokenHelper.generateToken(signinRequest.getUsername(),"authen",expireTime);
        String refreshToken = jwtTokenHelper.generateToken(signinRequest.getUsername(),"refresh",refreshExpireTime);


        DataResponse dataResponse = new DataResponse();
        TokenResponse tokenResponse = new TokenResponse();

        tokenResponse.setToken(token);
        tokenResponse.setRefreshToken(refreshToken);

        dataResponse.setStatus(HttpStatus.OK.value());
        dataResponse.setSuccess(true);
        dataResponse.setDescription("");
        dataResponse.setData(tokenResponse);

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);

    }
}
