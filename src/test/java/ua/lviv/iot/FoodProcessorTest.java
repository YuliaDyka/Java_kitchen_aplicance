package ua.lviv.iot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FoodProcessorTest {
    FoodProcessor foodProcessor;
    @BeforeEach
    void setUp() {
        var foodProcessorDishes = new ArrayList<String>();
        foodProcessorDishes.add("Cake");
        foodProcessorDishes.add("Cookie");
        foodProcessorDishes.add("Meet");

        foodProcessor = new FoodProcessor("Food processor-3000", 2000, 600,
                foodProcessorDishes);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTypes() {
        var foodProcessorDishes = new ArrayList<String>();
        foodProcessorDishes.add("Cake");
        foodProcessorDishes.add("Cookie");
        foodProcessorDishes.add("Meet");

        Assertions.assertEquals(foodProcessorDishes, foodProcessor.getTypes());
    }

    @Test
    void getPower() {
        Assertions.assertEquals(600, foodProcessor.getPower());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(2000, foodProcessor.getPrice());
    }

    @Test
    void show() {
        var typesStr =  "Cake, Cookie, Meet";
        String showStr = "Name - Food processor-3000"  + "\n" +
                "Price - " + 2000 + "\n" +
                "Power - " + 600 + "\n" +
                "Dish types - " + typesStr + "\n";
        Assertions.assertEquals(showStr, foodProcessor.show());
    }
}