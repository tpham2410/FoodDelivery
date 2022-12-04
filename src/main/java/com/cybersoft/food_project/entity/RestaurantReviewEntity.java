package com.cybersoft.food_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "restaurant_review")
public class RestaurantReviewEntity {
//    create table restaurant_review(
//            id int auto_increment,
//            id_restaurant int,
//            content text,
//            rate float,
//
//            primary key(id),
//    foreign key(id_restaurant) references restaurant(id)
//            );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name ="rate")
    private float rate;

    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    @JsonIgnore
    private RestaurantEntity restaurantEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }
}
