package com.zj.eatout.controller;

import com.zj.eatout.dto_DataTransferObject.RestaurantRequest;
import com.zj.eatout.model.Restaurant;
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
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Integer restaurantId) {
        Restaurant restaurants = restaurantService.getRestaurantById(restaurantId);
        if(restaurants != null) {
            return ResponseEntity.status(HttpStatus.OK).body(restaurants);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    //用@RequestBody去接住RestaurantsRequest這個class裡的數據
    //如果沒有加上@Valid註解，即使RestaurantsRequest這個class裡有設定NotNull也沒有用
    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody @Valid RestaurantRequest restaurantsRequest) {
        //創建餐廳方法
        Integer restaurantId =  restaurantService.creatRestaurant(restaurantsRequest);
        //成功建立回取得餐聽名稱
        Restaurant restaurants = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurants);
    }
    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable  Integer restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Integer restaurantId,
                                                       @RequestBody  @Valid RestaurantRequest restaurantsRequest) {
       //先抓取ID，如果資料庫沒有就回傳http狀態馬not found
        Restaurant restaurants = restaurantService.getRestaurantById(restaurantId);
        if(restaurants == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        restaurantService.updateRestaurant(restaurantId ,restaurantsRequest);
        //將更新好的數據依照ID找出來後建立回覆
        Restaurant updaterestaurants = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(updaterestaurants);
    }
}
