package com.langoni.eatzy_peasy;

import com.langoni.eatzy_peasy.domain.model.Restaurant;

public class Main {
    public static void main(String[] args) {
        Restaurant res = new Restaurant();
        res.setName("teste");
        System.out.println("Res: "+ res.getName());
    }
}
