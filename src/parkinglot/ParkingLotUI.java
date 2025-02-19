package parkinglot;

import java.util.InputMismatchException;
import java.util.Scanner;



public class ParkingLotUI {
    private final ParkingLotOperations parkingLot;
    private final Scanner scanner;

    public ParkingLotUI(ParkingLotOperations parkingLot) {
        this.parkingLot = parkingLot;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getValidChoice();
            if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }
            processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Parking Lot System ---");
        System.out.println("1. Park Vehicle");
        System.out.println("2. Leave Vehicle");
        System.out.println("3. Check Available Spots on a Floor");
        System.out.println("4. Check if Parking Lot is Full");
        System.out.println("5. Find Vehicle Location");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getValidChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
                System.out.println("Please enter a number between 1 and 6");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private void processChoice(int choice) {
        try {
            switch (choice) {
                case 1:
                    handleParkVehicle();
                    break;
                case 2:
                    handleLeaveVehicle();
                    break;
                case 3:
                    handleCheckAvailableSpots();
                    break;
                case 4:
                    handleCheckIfFull();
                    break;
                case 5:
                    handleFindVehicle();
                    break;
            }
        } catch (ParkingLotException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleParkVehicle() {
        System.out.print("Enter license plate: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Enter vehicle type (Car/Bike/Truck): ");
        String vehicleType = scanner.nextLine();
        Vehicle vehicle = VehicleFactory.createVehicle(licensePlate, vehicleType);
        String result = parkingLot.parkVehicle(vehicle);
        System.out.println(result);
    }

    private void handleLeaveVehicle() {
        System.out.print("Enter license plate: ");
        String licensePlate = scanner.nextLine();
        boolean success = parkingLot.leaveVehicle(licensePlate);
        System.out.println(success ? "Vehicle left successfully" : "Vehicle not found");
    }

    private void handleCheckAvailableSpots() {
        System.out.print("Enter floor number: ");
        int floor = scanner.nextInt();
        int spots = parkingLot.getAvailableSpots(floor);
        System.out.println("Available spots on floor " + floor + ": " + spots);
    }

    private void handleCheckIfFull() {
        System.out.println(parkingLot.isFull() ? "Parking lot is full" : "Parking lot is not full");
    }

    private void handleFindVehicle() {
        System.out.print("Enter license plate: ");
        String licensePlate = scanner.nextLine();
        System.out.println(parkingLot.getVehicleLocation(licensePlate));
    }
}

