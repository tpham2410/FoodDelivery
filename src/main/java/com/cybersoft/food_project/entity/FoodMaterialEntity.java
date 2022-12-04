package com.cybersoft.food_project.entity;

import com.cybersoft.food_project.entity.id.FoodMaterialId;

import javax.persistence.*;

@Entity(name = "food_material")
@IdClass(FoodMaterialId.class)
public class FoodMaterialEntity {
//    create table food_material(
//            id_food int,
//            id_material int,
//
//            primary key(id_food,id_material),
//    foreign key(id_food) references food(id),
//    foreign key(id_material) references material(id)
//            );
    @Id
    private int id_food;

    @Id
    private int id_material;

    @ManyToOne
    @JoinColumn(name = "id_food", insertable = false, updatable = false)
    private FoodEntity foodEntity;

    @ManyToOne
    @JoinColumn(name = "id_material", insertable = false, updatable = false)
    private MaterialEntity materialEntity;

    public int getId_food() {
        return id_food;
    }

    public void setId_food(int id_food) {
        this.id_food = id_food;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }

    public MaterialEntity getMaterialEntity() {
        return materialEntity;
    }

    public void setMaterialEntity(MaterialEntity materialEntity) {
        this.materialEntity = materialEntity;
    }
}
