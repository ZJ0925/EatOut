package com.zj.eatout.dao.impl;

import com.zj.eatout.dao.RestaurantsDao;
import com.zj.eatout.dto_DataTransferObject.RestaurantsRequest;
import com.zj.eatout.model.Restaurants;
import com.zj.eatout.rowmapper.RestaurantRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestaurantsDaoImpl implements RestaurantsDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Restaurants getRestaurantById(Integer restaurantId) {
        String sql = "SELECT restaurant_id, restaurant_name, address, phone, cuisine_type, opening_hours, closing_hours, restaurant_image_url FROM restaurants WHERE restaurant_id = :restaurantId ";

        Map<String, Object> map = new HashMap<>();
        map.put("restaurantId", restaurantId);

        List<Restaurants> restaurantsList = namedParameterJdbcTemplate.query(sql, map,new RestaurantRowMapper());
        if (restaurantsList != null && restaurantsList.size() > 0) {
            return restaurantsList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createRestaurant(RestaurantsRequest restaurantsRequest) {
        String sql ="INSERT INTO restaurants(restaurant_name, address, phone, cuisine_type, opening_hours, closing_hours, " +
                "restaurant_image_url) VALUE (:restaurantName, :address, :phone, :cuisineType, " +
                ":openingHours, :closingHours, :restaurantImageUrl) ";
        HashMap<String, Object> map = new HashMap<>();
        map.put("restaurantName", restaurantsRequest.getRestaurantName());
        map.put("address", restaurantsRequest.getAddress());
        map.put("phone", restaurantsRequest.getPhone());
        map.put("cuisineType", restaurantsRequest.getCuisineType());
        map.put("restaurantImageUrl", restaurantsRequest.getRestaurantImageUrl());

        Time openingHours = restaurantsRequest.getOpeningHours();
        Time closingHours = restaurantsRequest.getClosingHours();
        map.put("openingHours", restaurantsRequest.getOpeningHours());
        map.put("closingHours", restaurantsRequest.getClosingHours());
        //用於存儲由資料庫自動生成的主鍵值（如自增 ID）。
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //執行SQL語法，將 map 封裝成 MapSqlParameterSource 類型
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int restaurantId = keyHolder.getKey().intValue();
        return restaurantId;
    }

    @Override
    public void deleteRestaurant(Integer restaurantId) {
        String sql = "DELETE FROM restaurants WHERE restaurant_id = :restaurantId ";
        Map<String, Object> map = new HashMap<>();
        map.put("restaurantId", restaurantId);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateRestaurant(Integer restaurantId, RestaurantsRequest restaurantsRequest) {
        String sql = "UPDATE  restaurants SET restaurant_name = :restaurantName, address = :address, phone = :phone, " +
                "cuisine_type = :cuisineType, opening_hours = :openingHours, closing_hours = :closingHours, " +
                "restaurant_image_url = :restaurantImageUrl WHERE restaurant_id = :restaurantId ";
        Map<String, Object> map = new HashMap<>();
        map.put("restaurantId", restaurantId);
        map.put("restaurantName", restaurantsRequest.getRestaurantName());
        map.put("address", restaurantsRequest.getAddress());
        map.put("phone", restaurantsRequest.getPhone());
        map.put("cuisineType", restaurantsRequest.getCuisineType());
        map.put("openingHours", restaurantsRequest.getOpeningHours());
        map.put("closingHours", restaurantsRequest.getClosingHours());
        map.put("restaurantImageUrl", restaurantsRequest.getRestaurantImageUrl());
        namedParameterJdbcTemplate.update(sql, map);
    }
}
