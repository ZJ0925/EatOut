package com.zj.eatout.rowmapper;


import com.zj.eatout.model.Restaurants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//get裡要接住的是資料庫裡的欄位
//要import RowMapper並且要轉型的是model裡的Restaurants這個class
public class RestaurantRowMapper implements RowMapper<Restaurants> {
    @Override
    public Restaurants mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurants restaurants = new Restaurants();
        restaurants.setRestaurantId(rs.getInt("restaurant_id"));
        restaurants.setRestaurantName(rs.getString("restaurant_name"));
        restaurants.setAdress(rs.getString("address"));
        restaurants.setPhone(rs.getString("phone"));
        restaurants.setCuisineType(rs.getString("cuisine_type"));
        restaurants.setOpeningHours(rs.getTime("opening_hours"));
        restaurants.setClosingHours(rs.getTime("closing_hours"));
        restaurants.setRestaurantImageUrl(rs.getString("restaurant_image_url"));
        return restaurants;
    }
}
