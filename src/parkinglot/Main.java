package parkinglot;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of floors: ");
        int numFloors = scanner.nextInt();
        
        System.out.print("Enter spots per floor: ");
        int spotsPerFloor = scanner.nextInt();

        ParkingStrategy strategy = new DefaultParkingStrategy();
        VehicleValidator validator = new DefaultVehicleValidator();
        ParkingLotOperations parkingLot = new ParkingLot(numFloors, spotsPerFloor, strategy, validator);
        
        ParkingLotUI ui = new ParkingLotUI(parkingLot);
        ui.start();
        
        scanner.close();
    }
}