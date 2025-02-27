package com.zj.eatout.dao.impl;

import com.zj.eatout.dao.DishDao;
import com.zj.eatout.dto_DataTransferObject.DishRequest;
import com.zj.eatout.model.Dish;
import com.zj.eatout.rowmapper.DishRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@Component
public class DishDaoImpl implements DishDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Dish getDishById(Integer dishId) {
        String sql = "SELECT dish_id, dish_name, restaurant_id, description, price, dish_image_url " +
                "FROM dishes WHERE dish_id = :dishId";

        HashMap<String, Object> map = new HashMap <>();
        map.put("dishId", dishId);

        List<Dish> dishList =  namedParameterJdbcTemplate.query(sql, map, new DishRowMapper());

        if(dishList != null && dishList.size() > 0){
            return dishList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createDish(DishRequest dishRequest) {
        String sqlId = "SELECT restaurant_id FROM restaurants WHERE restaurant_name = :restaurantName";
        Map<String, Object> mapId = new HashMap <>();
        mapId.put("restaurantName", dishRequest.getRestaurantName());
        Integer restaurantId = namedParameterJdbcTemplate.queryForObject(sqlId, mapId, Integer.class);

        String sql = "INSERT INTO dishes(dish_name, restaurant_id, description, price,dish_image_url) VALUE (:dishName, :restaurantId, " +
                ":description, :price, :dishImageUrl)";
        HashMap<String, Object> map = new HashMap <>();
        map.put("dishName", dishRequest.getDishName());
        map.put("restaurantId", restaurantId);
        map.put("description", dishRequest.getDescription());
        map.put("price", dishRequest.getPrice());
        map.put("dishImageUrl", dishRequest.getDishImageUrl());
        //創建後要使用KeyHolder自動產生ID
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int dishId = keyHolder.getKey().intValue();
        return dishId;
    }

    @Override
    public void deleteDish(Integer dishId) {
        String sql = "DELETE FROM dishes WHERE dish_id = :dishId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("dishId", dishId);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateDish(Integer dishId, DishRequest dishRequest) {
        String sqlId = "SELECT restaurant_id FROM restaurants WHERE restaurant_name = :restaurantName";
        Map<String, Object> mapId = new HashMap <>();
        mapId.put("restaurantName", dishRequest.getRestaurantName());
        Integer restaurantId = namedParameterJdbcTemplate.queryForObject(sqlId, mapId, Integer.class);

        String sql = "UPDATE dishes SET dish_name = :dishName, restaurant_id = :restaurantId, " +
                "description = :description, price = :price, dish_image_url = :dishImageUrl WHERE " +
                "dish_id = :dishId";
        HashMap<String, Object> map = new HashMap <>();
        map.put("dishId", dishId);
        map.put("dishName", dishRequest.getDishName());
        map.put("restaurantId", restaurantId);
        map.put("description", dishRequest.getDescription());
        map.put("price", dishRequest.getPrice());
        map.put("dishImageUrl", dishRequest.getDishImageUrl());
        namedParameterJdbcTemplate.update(sql, map);
    }

}
