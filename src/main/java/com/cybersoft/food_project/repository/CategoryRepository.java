package com.cybersoft.food_project.repository;

import com.cybersoft.food_project.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Query(value = "select c.* from category as c order by c.id desc limit 6", nativeQuery = true)
    List<CategoryEntity> getExplorerCategory();
}
