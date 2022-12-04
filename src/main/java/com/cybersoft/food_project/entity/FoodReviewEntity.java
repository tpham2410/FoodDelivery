package com.cybersoft.food_project.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "food_review")
public class FoodReviewEntity {
//    create table food_review(
//            id int auto_increment,
//            id_food int,
//            id_user int,
//            content text,
//            create_date timestamp default now(),
//    rate float,
//
//    primary key(id),
//    foreign key(id_food) references food(id),
//    foreign key(id_user) references user(id)
//            );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//            id_food int,
    @ManyToOne
    @JoinColumn(name = "id_food")
    private FoodEntity foodEntity;

//            id_user int,
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UsersEntity usersEntity;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private LocalDateTime time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
