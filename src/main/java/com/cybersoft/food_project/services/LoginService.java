package com.cybersoft.food_project.services;


import com.cybersoft.food_project.entity.UsersEntity;


public interface LoginService {
    boolean checkLogin(String email, String password);

    UsersEntity checkLogin(String email);
}
