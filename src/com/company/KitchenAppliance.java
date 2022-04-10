package com.company;

import java.util.List;

public class KitchenAppliance {
    public KitchenAppliance() {
    }

    String name;
    int price;
    int power;
    List<String> types;

    public List<String> getTypes() {
        return types;
    }

    public int getPower() {
        return power;
    }

    public int getPrice() {
        return price;
    }

    public String show() {
        var typesStr =  String.join(", ", types);

        return  "Name - " + name + "\n" +
                "Price - " + price + "\n" +
                "Power - " + power + "\n" +
                "Dish types - " + typesStr + "\n";
    }
}
