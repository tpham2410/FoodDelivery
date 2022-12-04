package com.cybersoft.food_project.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "food_detail")
public class FoodDetaiEntity {
//    create table food_detail(
//            id_food int auto_increment,
//            description text,
//            create_date timestamp,
//            rating float,
//
//            primary key(id_food),
//    foreign key(id_food) references food(id)
//            );
    @Id
    @Column(name = "id_food")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private LocalDate timestamp;

    @Column(name = "rating")
    private float rating;

    @OneToOne
    @JoinColumn(name = "id")
    private FoodEntity foodEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }
}
