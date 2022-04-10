package com.company;

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
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

        for(KitchenAppliance i: kitchenAppliances) {
            System.out.println(i.show());
        } ;
        System.out.println(" ----------------------------------------- " + "\n");
        System.out.println("Please enter the name of the dish: ");
        String typeDish = br.readLine();

        var output =  kitchenAppliances.stream()
                .filter(k -> k.types.contains(typeDish))
                .sorted(Comparator.comparing(KitchenAppliance::getPower))
                .collect(Collectors.toList());;

       System.out.println("----Ascending by power----");
       for(KitchenAppliance item: output) {
           System.out.println(item.show());
       }

        System.out.println("----Descending by power----");
        output =  kitchenAppliances.stream()
                .sorted(Comparator.comparing(KitchenAppliance::getPower).reversed())
                .collect(Collectors.toList());
        for(KitchenAppliance item: output){
            System.out.println(item.show());
        }

        System.out.println("------------");
        System.out.println("----Sorting by price ascend----");
        var sortAscByPrice =  kitchenAppliances.stream()
                .sorted(Comparator.comparing(KitchenAppliance::getPrice))
                .collect(Collectors.toList());
        for(KitchenAppliance i: sortAscByPrice) {
            System.out.println(i.show());
        }

        System.out.println("------------");
        System.out.println("----Sorting by price descend----");
        var sortDescByPrice =  kitchenAppliances.stream()
                .sorted(Comparator.comparing(KitchenAppliance::getPrice).reversed())
                .collect(Collectors.toList());
        for(KitchenAppliance i: sortDescByPrice) {
            System.out.println(i.show());
        }
    }
}
