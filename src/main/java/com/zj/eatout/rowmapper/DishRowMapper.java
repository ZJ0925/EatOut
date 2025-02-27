package com.zj.eatout.rowmapper;

import com.zj.eatout.model.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishRowMapper implements RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dish dish = new Dish();
        dish.setDishId(rs.getInt("dish_id"));
        dish.setDishName(rs.getString("dish_name"));
        dish.setRestaurantId(rs.getInt("restaurant_id"));
        dish.setDescription(rs.getString("description"));
        dish.setDishPrice(rs.getInt("price"));
        dish.setDishImageUrl(rs.getString("dish_image_url"));
        return dish;
    }
}
