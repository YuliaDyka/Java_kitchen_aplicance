package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cookie");
        mixerDishes.add("Cake");
        var foodProcessorDishes = new ArrayList<String>();
        foodProcessorDishes.add("Cookie");
        foodProcessorDishes.add("Cake");
        foodProcessorDishes.add("Meet");
        Mixer mixer = new Mixer("Mixer-2000", 1200, 500, 1000, mixerDishes);
        Mixer mixer_2 = new Mixer("Mixer_home-235", 1000, 700, 1000, mixerDishes);
        FoodProcessor foodProcessor = new FoodProcessor("Food processor-3000", 2000, 600,
                foodProcessorDishes);
        var ovenDishes = new ArrayList<String>();
        ovenDishes.add("Cookie");
        ovenDishes.add("Cake");
        ovenDishes.add("Chicken");
        Oven oven = new Oven("Oven 4000", 6500, 1000, ovenDishes);

        ArrayList<KitchenAppliance> kitchenAppliances = new ArrayList<KitchenAppliance>();
        kitchenAppliances.add(mixer);
        kitchenAppliances.add(mixer_2);
        kitchenAppliances.add(foodProcessor);
        kitchenAppliances.add(oven);

        // -------------- WriterManager -----------------
        System.out.println("-----Lab6------");
        WriterManager writerManager = new WriterManager();
        writerManager.writeCSV(kitchenAppliances);
        System.out.println("----- Write to CSV done!!! ------");
    }
}
