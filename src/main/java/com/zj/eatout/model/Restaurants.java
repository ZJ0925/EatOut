package com.zj.eatout.model;

import java.sql.Time;

public class Restaurants {
    private int restaurantId;
    private String restaurantName;
    private String address;
    private String phone;
    private String cuisineType;
    private Time openingHours;
    private Time closingHours;
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
