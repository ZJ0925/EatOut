package com.zj.eatout.service.impl;


import com.zj.eatout.dao.JpaRepository.RestaurantRepository;
import com.zj.eatout.Entity.Restaurant;
import com.zj.eatout.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    //初始化restaurantRepository
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // 透過 ID 查詢餐廳
    public Restaurant getRestaurantById(Integer restaurantId) {
        return restaurantRepository.findByRestaurantId(restaurantId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }


}
