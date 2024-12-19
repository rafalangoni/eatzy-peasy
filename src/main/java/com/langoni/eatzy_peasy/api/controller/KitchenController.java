package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.model.Kitchen;
import com.langoni.eatzy_peasy.model.KitchenXmlWrapper;
import com.langoni.eatzy_peasy.repository.implementation.KitchenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/kitchens")
public class KitchenController {

    @Autowired
    private KitchenRepositoryImpl kitchenRepository;

    @GetMapping
    public List<Kitchen> listAll(){
        return kitchenRepository.listAllKitchens();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchenXmlWrapper listAllXml(){
        return new KitchenXmlWrapper(kitchenRepository.listAllKitchens());
    }

    @GetMapping(value = "/{kitchenId}")
    public Kitchen findKitchenById(@PathVariable(value = "kitchenId") Long id){
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
