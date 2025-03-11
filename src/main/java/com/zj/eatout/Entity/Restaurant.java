package com.zj.eatout.Entity;

import jakarta.persistence.*;

import java.sql.Time;


@Entity
@Table(name="restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="restaurant_id")
    private int restaurantId;

    @Column(name="restaurant_name")
    private String restaurantName;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="cuisine_type")
    private String cuisineType;

    @Column(name="opening_hours")
    private Time openingHours;

    @Column(name="closing_hours")
    private Time closingHours;
    @Column(name="restaurant_image_url")
    private String restaurantImageUrl;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Time getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Time openingHours) {
        this.openingHours = openingHours;
    }

    public Time getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(Time closingHours) {
        this.closingHours = closingHours;
    }

    public String getRestaurantImageUrl() {
        return restaurantImageUrl;
    }

    public void setRestaurantImageUrl(String restaurantImageUrl) {
        this.restaurantImageUrl = restaurantImageUrl;
    }
}
