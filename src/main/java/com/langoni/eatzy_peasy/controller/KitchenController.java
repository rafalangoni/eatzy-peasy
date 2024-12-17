package com.langoni.eatzy_peasy.controller;

import com.langoni.eatzy_peasy.model.Kitchen;
import com.langoni.eatzy_peasy.repository.implementation.KitchenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private KitchenRepositoryImpl kitchenRepository;

    @GetMapping
    public List<Kitchen> listAllKitchen(){
        return kitchenRepository.listAllKitchens();
    }

    @GetMapping("/{id}")
    public Kitchen findKitchenById(@PathVariable Long id){
        return kitchenRepository.findKitchenById(id);
    }

    @DeleteMapping("/{id}")
    public void removeKitchen(@PathVariable Long id){
        kitchenRepository.removeKitchen(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen addKitchen(@RequestBody Kitchen kitchen){
        return kitchenRepository.addKitchen(kitchen);
    }
}
