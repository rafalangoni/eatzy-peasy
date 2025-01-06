package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.domain.model.Restaurant;
import com.langoni.eatzy_peasy.domain.repository.RestaurantRepository;
import com.langoni.eatzy_peasy.domain.service.RestaurantService;
import com.langoni.eatzy_peasy.infra.repository.specification.RestaurantByNameSpec;
import com.langoni.eatzy_peasy.infra.repository.specification.RestaurantWithFreeDeliverySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants/test")
public class RestaurantTestController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/with-free-delivery")
    public List<Restaurant> specificationFreeDeliveryAndNameLike(@RequestParam String name){
        var withFreeDelivery = new RestaurantWithFreeDeliverySpec();
        var byNameLike = new RestaurantByNameSpec(name);

        return restaurantRepository.findAll(withFreeDelivery.and(byNameLike));
    }

    @GetMapping("/with-free-delivery-lambda")
    public List<Restaurant> freeDeliveryAndNameLikeLambda(@RequestParam String name){
        return restaurantRepository.byNameLike(name);
    }

    @GetMapping("/fetch-first")
    public Optional<Restaurant> fetchFirstRestaurante(){
        return restaurantRepository.findFirst();
    }

    @GetMapping("/all-by-name")
    public List<Restaurant> getAllByNameLike(String name){
        return restaurantRepository.findByNameSqlLike(name);
    }

    @GetMapping("/customized-interface")
    public List<Restaurant> listAllRestaurantCustomizedInterface(String name, BigDecimal initialDeliveryFee, BigDecimal finalDeliveryFee){
        return restaurantRepository.listAllRestaurantCustomizedInterface(name, initialDeliveryFee, finalDeliveryFee);
    }
}
