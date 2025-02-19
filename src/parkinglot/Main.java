package parkinglot;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numFloors = 0;
        int spotsPerFloor = 0;

        // Input for number of floors
        while (true) {
            try {
                System.out.print("Enter number of floors: ");
                numFloors = scanner.nextInt();
                if (numFloors <= 0) {
                    System.out.println("Please enter a positive number.");
                } else {
                    break; // Exit loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Input for spots per floor
        while (true) {
            try {
                System.out.print("Enter spots per floor: ");
                spotsPerFloor = scanner.nextInt();
                if (spotsPerFloor <= 0) {
                    System.out.println("Please enter a positive number.");
                } else {
                    break; // Exit loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Initialize parking lot
        ParkingStrategy strategy = new DefaultParkingStrategy();
        VehicleValidator validator = new DefaultVehicleValidator();
        ParkingLotOperations parkingLot = new ParkingLot(numFloors, spotsPerFloor, strategy, validator);

        // Start UI
        ParkingLotUI ui = new ParkingLotUI(parkingLot);
        ui.start();

        scanner.close();
    }
}