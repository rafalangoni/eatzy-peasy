package com.langoni.eatzy_peasy.controller;

import com.langoni.eatzy_peasy.model.Restaurant;
import com.langoni.eatzy_peasy.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public List<Restaurant> getAll(){
        return service.listAllRestaurant();
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant){
        return service.updateRestaurant(id, restaurant);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant){
        service.addRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id){
        return service.findRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public void removeRestaurant(@PathVariable Long id){
        service.deleteRestaurant(id);
    }
}
