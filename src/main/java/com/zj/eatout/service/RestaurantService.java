package com.zj.eatout.service;

import com.zj.eatout.Entity.Restaurant;

import java.util.Optional;

public interface RestaurantService {
    Restaurant getRestaurantById(Integer restaurantId);

}
