package ua.lviv.iot;

import java.util.List;

public class Mixer extends KitchenAppliance {
    public Mixer(String name, int price, int power, int speed, List<String> types) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.speed = speed;
        this.types = types;
    }

    int speed;

    @Override
    public String show() {
        var typesStr =  String.join(", ", types);
        return  "Name - " + name + "\n" +
                "Price - " + price + "\n" +
                "Power - " + power + "\n" +
                "Speed - " + speed + "\n" +
                "Dish types - " + typesStr + "\n";
    }
}
