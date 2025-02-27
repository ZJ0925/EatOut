package com.zj.eatout.service.impl;


import com.zj.eatout.dao.RestaurantDao;
import com.zj.eatout.dao.impl.RestaurantDaoImpl;
import com.zj.eatout.dto_DataTransferObject.RestaurantRequest;
import com.zj.eatout.model.Restaurant;
import com.zj.eatout.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDao restaurantsDao = new RestaurantDaoImpl();

    @Override
    public Restaurant getRestaurantById(Integer restaurantId) {
        return restaurantsDao.getRestaurantById(restaurantId);
    }

    @Override
    public Integer creatRestaurant(RestaurantRequest restaurantsRequest) {
        return restaurantsDao.createRestaurant(restaurantsRequest);
    }

    @Override
    public void deleteRestaurant(Integer restaurantId) {
        restaurantsDao.deleteRestaurant(restaurantId);
    }

    @Override
    public void updateRestaurant(Integer restaurantId, RestaurantRequest restaurantsRequest) {
        restaurantsDao.updateRestaurant(restaurantId, restaurantsRequest);
    }
}
