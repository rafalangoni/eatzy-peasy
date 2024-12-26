package com.langoni.eatzy_peasy.domain.service;

import com.langoni.eatzy_peasy.domain.model.Kitchen;
import com.langoni.eatzy_peasy.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public void removeKitchen(Long id) {
        kitchenRepository.deleteById(id);
    }

    public Optional<Kitchen> findKitchenById(Long id) {
        return kitchenRepository.findById(id);
    }

    public Kitchen addKitchen(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public List<Kitchen> listAllKitchen() {
        return kitchenRepository.findAll();
    }
//
//    public List<Kitchen> listAllByName(String name){
//        return kitchenRepository.listAllByName(name);
//    }

}
