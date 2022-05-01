package ua.lviv.iot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OvenTest {
     Oven oven;
    @BeforeEach
    void setUp() {
        var ovenDishes = new ArrayList<String>();
        ovenDishes.add("Cookie");
        ovenDishes.add("Cake");
        ovenDishes.add("Chicken");
        oven = new Oven("Oven 4000", 6500, 1000, ovenDishes);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTypes() {
        var ovenDishes = new ArrayList<String>();
        ovenDishes.add("Cookie");
        ovenDishes.add("Cake");
        ovenDishes.add("Chicken");
        Assertions.assertEquals(ovenDishes, oven.getTypes());
    }

    @Test
    void getPower() {
        Assertions.assertEquals(1000, oven.getPower());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(6500, oven.getPrice());
    }

    @Test
    void show() {
        var typeStr = "Cookie, Cake, Chicken";
        String showStr = "Name - Oven 4000"  + "\n" +
                "Price - " + 6500 + "\n" +
                "Power - " + 1000 + "\n" +
                "Dish types - " + typeStr + "\n";

        Assertions.assertEquals(showStr, oven.show());
    }
}