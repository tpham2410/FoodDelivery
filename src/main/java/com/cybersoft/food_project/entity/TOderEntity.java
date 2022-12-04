package com.cybersoft.food_project.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "t_order")
public class TOderEntity {
//    create table t_order(
//            id int auto_increment,
//            id_user int,
//            estimate_ship timestamp,
//            deliver_address text,
//
//            primary key(id),
//            foreign key(id_user) references user(id)
//            );

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estimate_ship")
    private LocalDateTime estimateShip;

    @Column(name = "deliver_address")
    private String deliverAddress;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UsersEntity usersEntity;

    @OneToMany(mappedBy = "tOderEntity")
    private Set<OrderStatusEntity> orderStatusEntities;

    @OneToMany(mappedBy = "tOderEntity")
    private Set<FileEntity> fileEntities;

    @OneToMany(mappedBy = "tOderEntity")
    private Set<FoodOrderEntity> foodOrderEntities;

    public Set<FoodOrderEntity> getFoodOrderEntities() {
        return foodOrderEntities;
    }

    public void setFoodOrderEntities(Set<FoodOrderEntity> foodOrderEntities) {
        this.foodOrderEntities = foodOrderEntities;
    }

    public Set<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(Set<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }

    public Set<OrderStatusEntity> getOrderStatusEntities() {
        return orderStatusEntities;
    }

    public void setOrderStatusEntities(Set<OrderStatusEntity> orderStatusEntities) {
        this.orderStatusEntities = orderStatusEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getEstimateShip() {
        return estimateShip;
    }

    public void setEstimateShip(LocalDateTime estimateShip) {
        this.estimateShip = estimateShip;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
