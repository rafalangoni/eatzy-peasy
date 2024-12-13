package com.langoni.eatzy_peasy.controller;

import com.langoni.eatzy_peasy.model.Restaurant;
import com.langoni.eatzy_peasy.repository.RestaurantJPAEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantJPAEntityManager entityManager;

    @GetMapping
    public List<Restaurant> getAll(){
        return entityManager.listAllRestaurant();
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant){
        return entityManager.updateRestaurant(id, restaurant);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant){
        entityManager.addRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id){
        return entityManager.findById(id);
    }

    @DeleteMapping("/{id}")
    public void removeRestaurant(@PathVariable Long id){
        entityManager.deleteRestaurant(id);
    }
}
