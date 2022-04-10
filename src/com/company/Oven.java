package com.company;

import java.util.List;

public class Oven extends KitchenAppliance {
    public Oven (String name, int price, int power, List<String> types) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.types = types;
    }
}
