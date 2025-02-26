package com.zj.eatout.service;

import com.zj.eatout.dto_DataTransferObject.RestaurantsRequest;
import com.zj.eatout.model.Restaurants;

public interface RestaurantService {
    Restaurants getRestaurantById(Integer restaurantId);
    Integer creatRestaurant(RestaurantsRequest restaurantsRequest);
    void deleteRestaurant(Integer restaurantId);
    void updateRestaurant(Integer restaurantId, RestaurantsRequest restaurantsRequest);
}
