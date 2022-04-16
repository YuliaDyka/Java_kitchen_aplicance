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
        System.out.println("-----Lab2------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        var mixerDishes = new ArrayList<String>();
        mixerDishes.add("Cookie");
        mixerDishes.add("Cake");
        var foodProcessorDishes = new ArrayList<String>();
        foodProcessorDishes.add("Cookie");
        foodProcessorDishes.add("Cake");
        foodProcessorDishes.add("Meet");
        Mixer mixer = new Mixer("Mixer-2000", 1200, 500, 1000, mixerDishes);
        Mixer mixer_2 = new Mixer("Mixer_home-235", 1000, 700, 1000, mixerDishes);
        FoodProcessor foodProcessor = new FoodProcessor("Food processor-3000", 2000, 600, foodProcessorDishes);
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

        for(KitchenAppliance i: kitchenAppliances){
            System.out.println(i.show());
        } ;

        Manager manager = new Manager();

        System.out.println(" ----------------------------------------- " + "\n");
        System.out.println("Please enter the name of the dish: ");
        String typeDish = br.readLine();

        List<KitchenAppliance> newSearchByName = manager.searchByNameSortedPawerAsc(kitchenAppliances, typeDish);
        System.out.println("----Ascending by power----");
        for(KitchenAppliance item: newSearchByName){
            System.out.println(item.show());
        }

        System.out.println("----Descending by power----");
        List<KitchenAppliance> sortByPowerDesc = manager.searchByNameSortedPowerDesc(kitchenAppliances, typeDish);
        for(KitchenAppliance item: sortByPowerDesc){
            System.out.println(item.show());
        }

        System.out.println("------------");
        System.out.println("----Sorting by price ascend----");
        List<KitchenAppliance> sortByPriceAscList = manager.sortingByPriceAsc(kitchenAppliances);

        for(KitchenAppliance i: sortByPriceAscList) {
            System.out.println(i.show());
        }

        System.out.println("------------");
        System.out.println("----Sorting by price descend----");
        List<KitchenAppliance> sortByPriceDesc = manager.sortingByPriceDesc(kitchenAppliances);
        for(KitchenAppliance i: sortByPriceDesc) {
            System.out.println(i.show());}
    }
}
