package pl.javastart.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class VehicleFiles {

    static void saveVehicles(Queue<Vehicle> vehicles, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Vehicle vehicle : vehicles) {
                writer.write(String.valueOf(vehicle));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
