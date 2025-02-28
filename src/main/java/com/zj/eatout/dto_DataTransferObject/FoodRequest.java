package com.zj.eatout.dto_DataTransferObject;

import jakarta.validation.constraints.NotNull;

public class FoodRequest {
    @NotNull
    private String foodName;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
