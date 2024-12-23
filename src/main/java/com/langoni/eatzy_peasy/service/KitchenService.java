package com.langoni.eatzy_peasy.service;

import com.langoni.eatzy_peasy.model.Kitchen;
import com.langoni.eatzy_peasy.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public void removeKitchen(Long id) {
        kitchenRepository.removeKitchen(id);
    }

    public Kitchen findKitchenById(Long id) {
        return kitchenRepository.findKitchenById(id);
    }

    public Kitchen addKitchen(Kitchen kitchen) {
        return kitchenRepository.addKitchen(kitchen);
    }

    public List<Kitchen> listAllKitchen() {
        return kitchenRepository.listAllKitchens();
    }

}
