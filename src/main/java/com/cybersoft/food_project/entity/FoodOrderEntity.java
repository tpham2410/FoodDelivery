package com.cybersoft.food_project.entity;

import com.cybersoft.food_project.entity.id.FoodOrderId;

import javax.persistence.*;

@Entity(name = "food_order")
@IdClass(FoodOrderId.class)
public class FoodOrderEntity {
//    create table food_order(
//            id_order int,
//            id_food int,
//            price float,
//            quality int,
//            id_promo int,
//
//            primary key(id_order,id_food),
//            foreign key(id_order) references t_order(id),
//            foreign key(id_food) references food(id)
//            );
    @Id
    private int id_order;

    @Id
    private int id_food;

    @Column(name = "price")
    private float price;

    @Column(name = "quality")
    private int quality;

    @Column(name = "id_promo")
    private int idPromo;

    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private TOderEntity tOderEntity;

    @ManyToOne
    @JoinColumn(name = "id_food", insertable = false, updatable = false)
    private FoodEntity foodEntity;

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_food() {
        return id_food;
    }

    public void setId_food(int id_food) {
        this.id_food = id_food;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public TOderEntity gettOderEntity() {
        return tOderEntity;
    }

    public void settOderEntity(TOderEntity tOderEntity) {
        this.tOderEntity = tOderEntity;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }
}
