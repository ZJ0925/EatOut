package com.zj.eatout.controller;

import com.zj.eatout.dao.FoodDao;
import com.zj.eatout.dto_DataTransferObject.FoodRequest;
import com.zj.eatout.model.Food;
import com.zj.eatout.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("food/{foodId}")
    public ResponseEntity<Food> getFoodById(@PathVariable  Integer foodId) {
        Food food = foodService.getFoodById(foodId);
        if (food == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(food);
        }
    }

    @PostMapping("/food")
    public ResponseEntity<Food> createFood(@RequestBody FoodRequest foodRequest) {
        Integer foodId = foodService.createFood(foodRequest);
        Food food = foodService.getFoodById(foodId);
        return ResponseEntity.status(HttpStatus.CREATED).body(food);

    }

    @PutMapping("food/{foodId}")
    public ResponseEntity<Food> updateFood(@PathVariable Integer foodId,@RequestBody @Valid FoodRequest foodRequest) {
       Food food = foodService.getFoodById(foodId);
       if(food == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }else{
           foodService.updateFood(foodId, foodRequest);
           Food foodUpdated = foodService.getFoodById(foodId);
           return ResponseEntity.status(HttpStatus.OK).body(foodUpdated);
       }
    }

    @DeleteMapping("food/{foodId}")
    public ResponseEntity<Food> deleteFood(Integer foodId){
        foodService.deleteFood(foodId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
