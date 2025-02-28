package com.zj.eatout.dao.impl;

import com.zj.eatout.dao.FoodDao;
import com.zj.eatout.dto_DataTransferObject.FoodRequest;
import com.zj.eatout.model.Food;
import com.zj.eatout.rowmapper.FoodRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class FoodDaoImpl implements FoodDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Food getFoodById(Integer dishId) {
        String sql = "SELECT food_id, food_name FROM foods WHERE food_id = :foodId ";
        HashMap map = new HashMap();
        map.put("foodId", dishId);
        List<Food> foodList = namedParameterJdbcTemplate.query(sql, map, new FoodRowMapper());

        if(foodList != null && foodList.size()>0){
            return foodList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createFood(FoodRequest foodRequest) {
        String sql = "INSERT INTO foods (food_name) VALUES (:foodName)";
        HashMap<String, Object> map = new HashMap<>();
        map.put("foodName", foodRequest.getFoodName());
        //自動創建ID
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void updateFood(Integer foodId, FoodRequest foodRequest) {
        String sql = "UPDATE foods SET food_name = :foodName WHERE  food_Id = :foodId ";
        HashMap<String, Object> map = new HashMap<>();
        map.put("foodName", foodRequest.getFoodName());
        map.put("foodId", foodId);

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void deleteFood(Integer foodId) {
        String sql = "DELETE FROM foods WHERE food_id = :foodId ";
        HashMap<String, Object> map = new HashMap<>();
        map.put("foodId", foodId);
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("foodId", foodId));
    }
}
