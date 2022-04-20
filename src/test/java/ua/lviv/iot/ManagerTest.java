package ua.lviv.iot;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ManagerTest {
    List<KitchenAppliance> kitchenAppliances;
    private Manager manager;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        manager = new Manager();
        kitchenAppliances = new ArrayList<KitchenAppliance>();

        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cookie");
        mixerDishes.add("Cake");
        var foodProcessorDishes = new ArrayList<String>();
        foodProcessorDishes.add("Cookie");
        foodProcessorDishes.add("Cake");
        foodProcessorDishes.add("Meet");

        Mixer mixer = new Mixer("Mixer-2000", 1200, 500, 1000, mixerDishes);
        FoodProcessor foodProcessor = new FoodProcessor("Food processor-3000", 2000, 600, foodProcessorDishes);

        var ovenDishes = new ArrayList<String>();
        ovenDishes.add("Cookie");
        ovenDishes.add("Cake");
        ovenDishes.add("Chicken");
        Oven oven = new Oven("Oven 4000", 6500, 1000, ovenDishes);

        kitchenAppliances.add(mixer);
        kitchenAppliances.add(foodProcessor);
        kitchenAppliances.add(oven);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void searchByNameSortedPowerAsc() {
        Iterable<KitchenAppliance> expected = new ArrayList<KitchenAppliance>();
        Iterable<KitchenAppliance> result = manager.searchByNameSortedPowerAsc(kitchenAppliances, "test");
        Assertions.assertIterableEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void searchByNameSortedPowerDesc() {
        var ovenDishes = new ArrayList<String>();
        ovenDishes.add("Cake");
        Oven oven = new Oven("Oven 4000", 6500, 1000, ovenDishes);

        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cookie");
        mixerDishes.add("Cake");
        Mixer mixer = new Mixer("Mixer-2000", 1200, 500, 1000, mixerDishes);

        var foodProcessorDishes = new ArrayList<String>();
        foodProcessorDishes.add("Cookie");
        foodProcessorDishes.add("Cake");

        FoodProcessor foodProcessor = new FoodProcessor("Food processor-3000", 2000, 600, foodProcessorDishes);

        var expected = new ArrayList<KitchenAppliance>();
        expected.add(oven);
        expected.add(foodProcessor);
        expected.add(mixer);

        Iterable<KitchenAppliance> result = manager.searchByNameSortedPowerDesc(kitchenAppliances, "Cake");
        Assertions.assertIterableEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void sortingByPriceAsc() {
        Iterable<KitchenAppliance> expected = new ArrayList<KitchenAppliance>();
        Iterable<KitchenAppliance> result = manager.sortingByPriceAsc(kitchenAppliances);
        Assertions.assertIterableEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void sortingByPriceDesc() {
        Iterable<KitchenAppliance> expected = new ArrayList<KitchenAppliance>();
        Iterable<KitchenAppliance> result = manager.sortingByPriceDesc(kitchenAppliances);
        Assertions.assertIterableEquals(expected, result);
    }
}