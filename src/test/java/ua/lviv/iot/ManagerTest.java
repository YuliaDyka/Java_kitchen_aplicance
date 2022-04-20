package ua.lviv.iot;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ManagerTest {
    List<KitchenAppliance> kitchenAppliances;
    private Manager manager;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        manager = new Manager();
        kitchenAppliances = new ArrayList<KitchenAppliance>();

        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cookie");
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
        List<KitchenAppliance> result = manager.searchByNameSortedPowerAsc(kitchenAppliances, "Cake");
        Assertions.assertEquals(true, result.get(0).getTypes().contains("Cake"));
        Assertions.assertEquals(true, result.get(1).getTypes().contains("Cake"));

        Assertions.assertEquals(600, result.get(0).getPower());
        Assertions.assertEquals(1000, result.get(1).getPower());
    }

    @org.junit.jupiter.api.Test
    void searchByNameSortedPowerDesc() {
        List<KitchenAppliance> result = manager.searchByNameSortedPowerDesc(kitchenAppliances, "Cake");
        Assertions.assertEquals(true, result.get(0).getTypes().contains("Cake"));
        Assertions.assertEquals(true, result.get(1).getTypes().contains("Cake"));

        Assertions.assertEquals(1000, result.get(0).getPower());
        Assertions.assertEquals(600, result.get(1).getPower());
    }

    @org.junit.jupiter.api.Test
    void sortingByPriceAsc() {
        List<KitchenAppliance> result = manager.sortingByPriceAsc(kitchenAppliances);
        Assertions.assertEquals(1200, result.get(0).getPrice());
        Assertions.assertEquals(2000, result.get(1).getPrice());
        Assertions.assertEquals(6500, result.get(2).getPrice());
    }

    @org.junit.jupiter.api.Test
    void sortingByPriceDesc() {

        var result = manager.sortingByPriceDesc(kitchenAppliances);
        Assertions.assertEquals(6500, result.get(0).getPrice());
        Assertions.assertEquals(2000, result.get(1).getPrice());
        Assertions.assertEquals(1200, result.get(2).getPrice());
    }
}