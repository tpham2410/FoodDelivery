package com.cybersoft.food_project.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "user")
public class UsersEntity {
    //    id int auto_increment,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    email varchar(255),
    @Column(name = "email")
    private String email;

//    password varchar(255),
    @Column(name = "password")
    private String password;

//    fullname varchar(100),
    @Column(name = "fullname")
    private String fullname;

//    token varchar(100),
    @Column(name = "token")
    private String token;

//    type_token varchar(10),
    @Column(name = "type_token")
    private String typeToken;

//    phone_number varchar(12),
    @Column(name = "phone_number")
    private String phoneNumber;

//    verify_code varchar(12),
    @Column(name = "verify_code")
    private String verifyCode;

//    verify_code_expired timestamp,
    @Column(name = "verify_code_expired")
    private String verifyCodeExpired;

//    is_active boolean default false,
    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(mappedBy = "usersEntity")
    private UserDetailEntity userDetailEntity;

    @OneToMany(mappedBy = "usersEntity")
    private Set<FoodReviewEntity> foodReviewEntities;

    @OneToMany(mappedBy = "usersEntity")
    private Set<TOderEntity> tOderEntities;

    public Set<TOderEntity> gettOderEntities() {
        return tOderEntities;
    }

    public void settOderEntities(Set<TOderEntity> tOderEntities) {
        this.tOderEntities = tOderEntities;
    }

    public Set<FoodReviewEntity> getFoodReviewEntities() {
        return foodReviewEntities;
    }

    public void setFoodReviewEntities(Set<FoodReviewEntity> foodReviewEntities) {
        this.foodReviewEntities = foodReviewEntities;
    }

    public UserDetailEntity getUserDetailEntity() {

        return userDetailEntity;
    }

    public void setUserDetailEntity(UserDetailEntity userDetailEntity) {
        this.userDetailEntity = userDetailEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTypeToken() {
        return typeToken;
    }

    public void setTypeToken(String typeToken) {
        this.typeToken = typeToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyCodeExpired() {
        return verifyCodeExpired;
    }

    public void setVerifyCodeExpired(String verifyCodeExpired) {
        this.verifyCodeExpired = verifyCodeExpired;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
