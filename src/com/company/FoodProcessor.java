package com.company;

import java.util.List;

public class FoodProcessor extends KitchenAppliance {
    public FoodProcessor(String name, int price, int power, List<String> types) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.types = types;
    }
}
