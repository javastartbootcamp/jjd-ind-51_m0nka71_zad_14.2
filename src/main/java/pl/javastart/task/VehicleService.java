package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehicleService {
    static Queue<Vehicle> vehicles = new LinkedList<>();
    private static String fileName = "vehicles.txt";

    private static Vehicle createVehicle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj informacje o pojeździe: typ, marka, model, rocznik, przebieg i numer VIN");
        String type = scan.nextLine();
        String brand = scan.nextLine();
        String model = scan.nextLine();
        int year = scan.nextInt();
        int mileage = scan.nextInt();
        scan.nextLine();
        String vin = scan.nextLine();
        return new Vehicle(type, brand, model, year, mileage, vin);
    }

    static Queue<Vehicle> addVehicle() {
        if (!fileName.isEmpty()) {
            readSavedVehicles();
        }
        Vehicle vehicle = createVehicle();
        vehicles.add(vehicle);
        return vehicles;
    }

    static Vehicle readNextVehicle() {
        if (!fileName.isEmpty()) {
            readSavedVehicles();
        }
        Vehicle vehicle = vehicles.poll();
        System.out.println(vehicle);
        return vehicle;
    }

    static void checkQueue() {
        if (vehicles.isEmpty()) {
            System.out.println("Koniec");
        } else {
            VehicleFiles.saveVehicles(vehicles, fileName);
        }
    }

    static Queue<Vehicle> readSavedVehicles() {
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (!line.isEmpty()) {
                    String[] split = line.split(",");
                    int year = Integer.parseInt(split[3]);
                    int mileage = Integer.parseInt(split[4]);
                    Vehicle vehicle = new Vehicle(split[0], split[1], split[2], year, mileage, split[5]);
                    vehicles.offer(vehicle);
                }
            }
            return vehicles;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
