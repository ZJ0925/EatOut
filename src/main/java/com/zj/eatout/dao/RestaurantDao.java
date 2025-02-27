package com.zj.eatout.dao;

import com.zj.eatout.dto_DataTransferObject.RestaurantRequest;
import com.zj.eatout.model.Restaurant;

public interface RestaurantDao {

    Restaurant getRestaurantById(Integer restaurantId);
    Integer createRestaurant(RestaurantRequest restaurantsRequest);
    void deleteRestaurant(Integer restaurantId);
    void updateRestaurant(Integer restaurantId, RestaurantRequest restaurantsRequest);
}
