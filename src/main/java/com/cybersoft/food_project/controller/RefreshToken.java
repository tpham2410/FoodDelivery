package com.cybersoft.food_project.controller;

import com.cybersoft.food_project.jwt.JwtTokenHelper;
import com.cybersoft.food_project.payload.response.DataResponse;
import com.cybersoft.food_project.payload.response.TokenResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/refresh-token")
public class RefreshToken {

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    private Gson gson = new Gson();
    private  long expireTime = 8*60*60*1000;
    private long refreshExpireTime =  80*60*60*1000;

    @PostMapping("")
    public ResponseEntity<?> index(@RequestParam("token ") String token){
        DataResponse dataResponse = new DataResponse();

        if (token != null){
            //Kiểm tra token có phải do hệ thống sinh ra không
            if (jwtTokenHelper.validateToken(token)){

                //Token hợp lệ
                String json = jwtTokenHelper.decodeToken(token);
                Map<String,Object> map = gson.fromJson(json, Map.class);
                System.out.println( json + " - " + map.get("type").toString());

                if(StringUtils.hasText("type") && map.get("type").toString().equals("refresh")){
                    String tokenAuthen = jwtTokenHelper.generateToken(map.get("username").toString(),"authen",expireTime);
                    String refreshToken = jwtTokenHelper.generateToken(map.get("username").toString(),"refresh",refreshExpireTime);



                    TokenResponse tokenResponse = new TokenResponse();

                    tokenResponse.setToken(tokenAuthen);
                    tokenResponse.setRefreshToken(refreshToken);

                    dataResponse.setStatus(HttpStatus.OK.value());
                    dataResponse.setSuccess(true);
                    dataResponse.setDescription("");
                    dataResponse.setData(tokenResponse);
                }


            }

        }

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

}
