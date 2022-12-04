package com.cybersoft.food_project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "material")
public class MaterialEntity {
//    create table material(
//            id int auto_increment,
//            name varchar(100),
//
//    primary key(id)
//);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "materialEntity")
    private Set<FoodMaterialEntity> foodMaterialEntities;

    public Set<FoodMaterialEntity> getFoodMaterialEntities() {
        return foodMaterialEntities;
    }

    public void setFoodMaterialEntities(Set<FoodMaterialEntity> foodMaterialEntities) {
        this.foodMaterialEntities = foodMaterialEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
