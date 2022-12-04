package com.cybersoft.food_project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "food")
public class FoodEntity {
//    create table food(
//            id int auto_increment,
//            name varchar(255),
//    image text,
//    price int,
//    id_category int,
//    id_restaurant int,
//
//    primary key(id),
//    foreign key(id_category) references category(id),
//    foreign key(id_restaurant) references restaurant(id)
//            );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private int price;

//    id_category int,
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;

//    id_restaurant int,
    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private RestaurantEntity restaurantEntity;

    @OneToOne(mappedBy = "foodEntity")
    private FoodDetaiEntity foodDetaiEntity;

    @OneToMany(mappedBy = "foodEntity")
    private Set<FoodReviewEntity> foodReviewEntities;

    @OneToMany(mappedBy = "foodEntity")
    private Set<FoodAddonEntity> foodAddonEntities;

    @OneToMany(mappedBy = "foodEntity")
    private Set<FoodMaterialEntity> foodMaterialEntities;

    @OneToMany(mappedBy = "foodEntity")
    private Set<FoodOrderEntity> foodOrderEntities;

    public Set<FoodOrderEntity> getFoodOrderEntities() {
        return foodOrderEntities;
    }

    public void setFoodOrderEntities(Set<FoodOrderEntity> foodOrderEntities) {
        this.foodOrderEntities = foodOrderEntities;
    }

    public Set<FoodMaterialEntity> getFoodMaterialEntities() {
        return foodMaterialEntities;
    }

    public void setFoodMaterialEntities(Set<FoodMaterialEntity> foodMaterialEntities) {
        this.foodMaterialEntities = foodMaterialEntities;
    }

    public Set<FoodAddonEntity> getFoodAddonEntities() {
        return foodAddonEntities;
    }

    public void setFoodAddonEntities(Set<FoodAddonEntity> foodAddonEntities) {
        this.foodAddonEntities = foodAddonEntities;
    }

    public Set<FoodReviewEntity> getFoodReviewEntities() {
        return foodReviewEntities;
    }

    public void setFoodReviewEntities(Set<FoodReviewEntity> foodReviewEntities) {
        this.foodReviewEntities = foodReviewEntities;
    }

    public FoodDetaiEntity getFoodDetaiEntity() {
        return foodDetaiEntity;
    }

    public void setFoodDetaiEntity(FoodDetaiEntity foodDetaiEntity) {
        this.foodDetaiEntity = foodDetaiEntity;
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }
}
