package com.zj.eatout.dto_DataTransferObject;

import jakarta.validation.constraints.NotNull;

public class DishRequest {
    @NotNull
    private String dishName;
    @NotNull
    private String restaurantName;
    private String description;
    @NotNull
    private int price;
    @NotNull
    private String dishImageUrl;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }
}
