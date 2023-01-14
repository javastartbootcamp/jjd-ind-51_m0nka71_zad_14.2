package pl.javastart.task;

import java.util.Scanner;

public class Main {

    private static final int EXIT = 0;
    private static final int CREATE_AND_ADD_VEHICLE = 1;
    private static final int NEXT_VEHICLE = 2;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int userInput;
        do {
            System.out.println("Wybierz opcję:");
            printOptions();
            userInput = scan.nextInt();
            scan.nextLine();

            switch (userInput) {
                case CREATE_AND_ADD_VEHICLE -> VehicleService.addVehicle();
                case NEXT_VEHICLE -> VehicleService.readNextVehicle();
                case EXIT -> VehicleService.checkQueue();
                default -> System.out.println("Spróbuj jeszcze raz");
            }
        } while (userInput != EXIT);
    }

    private static void printOptions() {
        System.out.println(CREATE_AND_ADD_VEHICLE + " - Dodanie pojazdu");
        System.out.println(NEXT_VEHICLE + " - Wczytaj następny pojazd");
        System.out.println(EXIT + " - Wyjście z programu");
    }
}
