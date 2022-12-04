package com.cybersoft.food_project.repository;

import com.cybersoft.food_project.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
    RestaurantEntity findById(int id);
}
