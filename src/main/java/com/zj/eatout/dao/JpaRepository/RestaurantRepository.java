package com.zj.eatout.dao.JpaRepository;

import com.zj.eatout.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Optional<Restaurant> findByRestaurantId(Integer RestaurantId);
}
