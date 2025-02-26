package com.zj.eatout.dao;

import com.zj.eatout.dto_DataTransferObject.RestaurantsRequest;
import com.zj.eatout.model.Restaurants;

public interface RestaurantsDao {

    Restaurants getRestaurantById(Integer restaurantId);
    Integer createRestaurant(RestaurantsRequest restaurantsRequest);
    void deleteRestaurant(Integer restaurantId);
    void updateRestaurant(Integer restaurantId, RestaurantsRequest restaurantsRequest);
}
