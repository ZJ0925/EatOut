package com.zj.eatout.controller;


import com.zj.eatout.dao.DishDao;
import com.zj.eatout.dto_DataTransferObject.DishRequest;
import com.zj.eatout.model.Dish;
import com.zj.eatout.service.DishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DisheController {
    @Autowired
    private DishService dishService;

    @GetMapping("/dish/{dishId}")
    public ResponseEntity<Dish> getDishById(@PathVariable Integer dishId) {
        Dish dish = dishService.getDishById(dishId);
        if(dish != null) {
            return ResponseEntity.status(200).body(dish);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/dishes")
    public ResponseEntity<Dish> createDish(@RequestBody @Valid DishRequest dishRequest) {
        //先將body裡的數據創建出來後，抓取該數據的dishId
        Integer dishId = dishService.createDish(dishRequest);
        //藉由dishId回傳整個剛剛建立的數據
        Dish dish = dishService.getDishById(dishId);
        //回傳Http狀態碼(創建成功)，body則是剛剛建立的數據
        return ResponseEntity.status(HttpStatus.CREATED).body(dish);
    }

    @DeleteMapping("/dish/{dishId}")
    public ResponseEntity<Dish> deleteDish(@PathVariable Integer dishId) {
        dishService.deleteDish(dishId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/dish/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Integer dishId, @RequestBody @Valid DishRequest dishRequest) {
        Dish dish = dishService.getDishById(dishId);
        if(dish == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            dishService.updateDish(dishId, dishRequest);
            Dish dishUpdated = dishService.getDishById(dishId);
            return ResponseEntity.status(HttpStatus.OK).body(dishUpdated);
        }
    }

}
