package com.cybersoft.food_project.dto;

import com.cybersoft.food_project.model.FoodModel;

import java.util.List;

public class RestaurantDetailDTO {
    private String title = "";
    private String image = "";
    private float avgRate = 0;
    private String description = "";
    private List<FoodModel> foodModels ;

    public List<FoodModel> getFoodModels() {
        return foodModels;
    }

    public void setFoodModels(List<FoodModel> foodModels) {
        this.foodModels = foodModels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(float avgRate) {
        this.avgRate = avgRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
