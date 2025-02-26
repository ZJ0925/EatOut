package com.zj.eatout.service.impl;


import com.zj.eatout.dao.RestaurantsDao;
import com.zj.eatout.dao.impl.RestaurantsDaoImpl;
import com.zj.eatout.dto_DataTransferObject.RestaurantsRequest;
import com.zj.eatout.model.Restaurants;
import com.zj.eatout.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantsDao restaurantsDao = new RestaurantsDaoImpl();

    @Override
    public Restaurants getRestaurantById(Integer restaurantId) {
        return restaurantsDao.getRestaurantById(restaurantId);
    }

    @Override
    public Integer creatRestaurant(RestaurantsRequest restaurantsRequest) {
        return restaurantsDao.createRestaurant(restaurantsRequest);
    }

    @Override
    public void deleteRestaurant(Integer restaurantId) {
        restaurantsDao.deleteRestaurant(restaurantId);
    }

    @Override
    public void updateRestaurant(Integer restaurantId, RestaurantsRequest restaurantsRequest) {
        restaurantsDao.updateRestaurant(restaurantId, restaurantsRequest);
    }
}
