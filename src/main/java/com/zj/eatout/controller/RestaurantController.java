package com.zj.eatout.controller;

import com.zj.eatout.dao.RestaurantsDao;
import com.zj.eatout.dto_DataTransferObject.RestaurantsRequest;
import com.zj.eatout.model.Restaurants;
import com.zj.eatout.rowmapper.RestaurantRowMapper;
import com.zj.eatout.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurants> getRestaurant(@PathVariable Integer restaurantId) {
        Restaurants restaurants = restaurantService.getRestaurantById(restaurantId);
        if(restaurants != null) {
            return ResponseEntity.status(HttpStatus.OK).body(restaurants);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    //用@RequestBody去接住RestaurantsRequest這個class裡的數據
    //如果沒有加上@Valid註解，即使RestaurantsRequest這個class裡有設定NotNull也沒有用
    @PostMapping("/restaurants")
    public ResponseEntity<Restaurants> createRestaurant(@RequestBody @Valid RestaurantsRequest restaurantsRequest) {
        //創建餐廳方法
        Integer restaurantId =  restaurantService.creatRestaurant(restaurantsRequest);
        //成功建立回取得餐聽名稱
        Restaurants restaurants = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurants);
    }
    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurants> deleteRestaurant(@PathVariable  Integer restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurants> updateRestaurant(@PathVariable Integer restaurantId,
                                                        @RequestBody  @Valid RestaurantsRequest restaurantsRequest) {
       //先抓取ID，如果資料庫沒有就回傳http狀態馬not found
        Restaurants restaurants = restaurantService.getRestaurantById(restaurantId);
        if(restaurants == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        restaurantService.updateRestaurant(restaurantId ,restaurantsRequest);
        //將更新好的數據依照ID找出來後建立回覆
        Restaurants updaterestaurants = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(updaterestaurants);
    }
}
