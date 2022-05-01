package ua.lviv.iot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WriterManager {

    public void writeCSV(List<KitchenAppliance> kitchenAppliances) throws IOException {
        try(FileWriter writer = new FileWriter("result.csv")) {
            var sortedKitchenAppliances = kitchenAppliances.stream()
                    .sorted(Comparator.comparing(kA -> kA.getClass().getName()))
                    .collect(Collectors.toList());
            String previusClassName = "";

            for (KitchenAppliance ka: sortedKitchenAppliances) {
                if(!ka.getClass().equals(previusClassName)) {
                    writer.write(ka.getHeaders());
                    writer.write("\r\n");
                    previusClassName = ka.getClass().getSimpleName();
                }
                writer.write(ka.toCSV());
                writer.write("\r\n");
            }
        }
    }
}
