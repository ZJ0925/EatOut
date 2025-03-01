package com.zj.eatout.service;

import com.zj.eatout.dto_DataTransferObject.RestaurantRequest;
import com.zj.eatout.model.Restaurant;

public interface RestaurantService {
    Restaurant getRestaurantById(Integer restaurantId);
    //返回類行為Integer是因為要透過創建後的dishID來去搜尋該ID的整筆資料
    Integer creatRestaurant(RestaurantRequest restaurantsRequest);
    void deleteRestaurant(Integer restaurantId);
    void updateRestaurant(Integer restaurantId, RestaurantRequest restaurantsRequest);
}
