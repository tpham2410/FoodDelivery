package com.cybersoft.food_project.repository;

import com.cybersoft.food_project.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
    List<UsersEntity> findByEmailAndPassword(String email, String password);
    List<UsersEntity> findByEmail(String email);
}
