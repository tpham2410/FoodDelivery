package com.cybersoft.food_project.entity;

import com.cybersoft.food_project.entity.id.OrderStatusId;

import javax.persistence.*;

@Entity(name = "order_status")
@IdClass(OrderStatusId.class)
public class OrderStatusEntity {
//    create table order_status(
//            id_order int,
//            id_status int,
//
//            primary key(id_order,id_status),
//    foreign key(id_order) references t_order(id),
//    foreign key(id_status) references status(id)
//            );
    @Id
    private int id_order;

    @Id
    private int id_status;

    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false, updatable = false)
    private TOderEntity tOderEntity;

    @ManyToOne
    @JoinColumn(name = "id_status", insertable = false, updatable = false)
    private StatusEntity statusEntity;

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public TOderEntity gettOderEntity() {
        return tOderEntity;
    }

    public void settOderEntity(TOderEntity tOderEntity) {
        this.tOderEntity = tOderEntity;
    }

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }
}
