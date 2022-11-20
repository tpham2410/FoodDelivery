package com.cybersoft.food_project.services;

import com.cybersoft.food_project.entity.UsersEntity;
import com.cybersoft.food_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImp implements LoginService{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkLogin(String email, String password) {
        List<UsersEntity> users = userRepository.findByEmailAndPassword(email,password);
        System.out.println(email+ "  " +password);
        return users.size() > 0;
    }
}
