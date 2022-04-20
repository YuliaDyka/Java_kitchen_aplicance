package ua.lviv.iot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Manager {
    public List<KitchenAppliance> searchByNameSortedPowerAsc(List<KitchenAppliance> kitchenAppliances, String typeDish){
        List<KitchenAppliance> searchByNameList  = kitchenAppliances.stream()
                .filter(k -> k.types.contains(typeDish))
                .sorted(Comparator.comparing(KitchenAppliance::getPower))
                .collect(Collectors.toList());

        return searchByNameList;
    }

    public List<KitchenAppliance> searchByNameSortedPowerDesc(List<KitchenAppliance> kitchenAppliances, String typeDish){
        List<KitchenAppliance> searchByNameList  = kitchenAppliances.stream()
                .filter(apl -> apl.types.contains(typeDish))
                .sorted(Comparator.comparing(KitchenAppliance::getPower).reversed())
                .collect(Collectors.toList());

        return searchByNameList;
    }

    public List<KitchenAppliance> sortingByPriceAsc(List<KitchenAppliance> kitchenAppliances){
        List<KitchenAppliance> sortingByPrice = kitchenAppliances.stream()
                .sorted(Comparator.comparing(KitchenAppliance::getPrice))
                .collect(Collectors.toList());
        return sortingByPrice;
    }

    public List<KitchenAppliance> sortingByPriceDesc(List<KitchenAppliance> kitchenAppliances){
        List<KitchenAppliance> sortingByPrice = kitchenAppliances.stream()
                .sorted(Comparator.comparing(KitchenAppliance::getPrice).reversed())
                .collect(Collectors.toList());
        return sortingByPrice;
    }
}