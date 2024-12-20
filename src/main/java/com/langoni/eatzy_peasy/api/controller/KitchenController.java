package com.langoni.eatzy_peasy.api.controller;

import com.langoni.eatzy_peasy.model.Kitchen;
import com.langoni.eatzy_peasy.model.KitchenXmlWrapper;
import com.langoni.eatzy_peasy.repository.implementation.KitchenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/kitchens")
public class KitchenController {

    @Autowired
    private KitchenRepositoryImpl kitchenRepository;

    @GetMapping
    public List<Kitchen> listAll() {
        return kitchenRepository.listAllKitchens();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchenXmlWrapper listAllXml() {
        return new KitchenXmlWrapper(kitchenRepository.listAllKitchens());
    }

    @GetMapping(value = "/{kitchenId}")
    public ResponseEntity<Kitchen> findKitchenById(@PathVariable(value = "kitchenId") Long id) {
        //Implementing customized headers, just an example
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.LOCATION, "http://localhost:8080/kitchens");
//
//        return ResponseEntity
//                .status(HttpStatus.FOUND)
//                .headers(headers)
//                .build();
        var kitchen = kitchenRepository.findKitchenById(id);

        if (kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeKitchen(@PathVariable Long id) {
        kitchenRepository.removeKitchen(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen addKitchen(@RequestBody Kitchen kitchen) {
        return kitchenRepository.addKitchen(kitchen);
    }
}
