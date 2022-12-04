package com.cybersoft.food_project.entity;

import javax.persistence.*;

@Entity(name = "food_addon")
public class FoodAddonEntity {
//    create table food_addon(
//            id int auto_increment,
//            name varchar(100),
//            image text,
//            price int,
//            id_food int,
//
//            primary key(id),
//            foreign key(id_food) references food(id)
//    );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "id_food")
    private FoodEntity foodEntity;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }
}
