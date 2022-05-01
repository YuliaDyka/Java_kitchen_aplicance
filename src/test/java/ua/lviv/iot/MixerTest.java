package ua.lviv.iot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MixerTest {
    Mixer mixer;

    @BeforeEach
    void setUp() {
        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cake");
        mixerDishes.add("Cookie");
        mixer = new Mixer("Mixer-2000", 1200, 500, 1000, mixerDishes);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTypes() {
        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cake");
        mixerDishes.add("Cookie");
        Assertions.assertEquals(mixerDishes, mixer.getTypes());
    }

    @Test
    void getPower() {
        Assertions.assertEquals(500, mixer.getPower());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(1200, mixer.getPrice());
    }

    @Test
    void show() {
        var typeStr = "Cake, Cookie";
        String showStr = "Name - Mixer-2000" + "\n" +
                "Price - " + 1200 + "\n" +
                "Power - " + 500 + "\n" +
                "Speed - " + 1000 + "\n" +
                "Dish types - " + typeStr + "\n";

        Assertions.assertEquals(showStr, mixer.show());
    }

}