package com.cybersoft.food_project.security;

import com.cybersoft.food_project.entity.UsersEntity;
import com.cybersoft.food_project.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenProvider implements AuthenticationProvider {

    @Autowired
    LoginService loginService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //Xử lý logic code đăng nhập thành công hay thất bại
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String name = authentication.getName();
            String password = authentication.getCredentials().toString();
            UsersEntity usersEntity = loginService.checkLogin(name);

            if(usersEntity != null){
<<<<<<< HEAD
                return new UsernamePasswordAuthenticationToken(usersEntity.getEmail(), usersEntity.getPassword(), new ArrayList<>());
=======
               boolean isSuccess = passwordEncoder.matches(password, usersEntity.getPassword());
               if(isSuccess){
                   return new UsernamePasswordAuthenticationToken(usersEntity.getEmail(), usersEntity.getPassword(), new ArrayList<>());
               }
                return null;
>>>>>>> fffd574 (Add checkLoginByEmailAndPassword)
            } else {
                return null;
            }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
