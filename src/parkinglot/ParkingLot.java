package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ParkingLot implements ParkingLotOperations {
    private final List<Floor> floors;
    private final Map<String, ParkingSpot> parkedVehicles;
    private final ParkingStrategy parkingStrategy;
    private final VehicleValidator vehicleValidator;
    private final Lock lock;

    public ParkingLot(int numFloors, int spotsPerFloor, 
                      ParkingStrategy strategy, 
                      VehicleValidator validator) {
        this.floors = new ArrayList<>();
        this.parkedVehicles = new HashMap<>();
        this.parkingStrategy = strategy;
        this.vehicleValidator = validator;
        this.lock = new ReentrantLock();
        
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i, spotsPerFloor));
        }
    }

    
 // In ParkingLot.java (parkVehicle method)
    @Override
    public String parkVehicle(Vehicle vehicle) {
        lock.lock();
        try {
            // Existing license plate validation
            if (!vehicleValidator.isValidLicensePlate(vehicle.getLicensePlate())) {
                throw new InvalidVehicleException("Invalid license plate");
            }

            // New: Check if vehicle is already parked
            if (parkedVehicles.containsKey(vehicle.getLicensePlate())) {
                throw new InvalidVehicleException("Vehicle with license plate " 
                    + vehicle.getLicensePlate() + " is already parked.");
            }

            ParkingSpot spot = parkingStrategy.findSpot(floors, vehicle.getType().toString());
            if (spot == null) {
                return "No available spots for this vehicle type.";
            }

            spot.occupySpot(vehicle);
            if (vehicle.getType() == VehicleType.TRUCK) {
                floors.get(spot.getFloor() - 1).getSpots().get(spot.getSpotId()).occupySpot(vehicle);
            }
            parkedVehicles.put(vehicle.getLicensePlate(), spot);
            return "Vehicle parked at Floor: " + spot.getFloor() + ", Spot: " + spot.getSpotId();
        } finally {
            lock.unlock();
        }
    }
    

    @Override
    public boolean leaveVehicle(String licensePlate) {
        lock.lock();
        try {
            ParkingSpot spot = parkedVehicles.get(licensePlate);
            if (spot != null) {
                Vehicle vehicle = spot.getVehicle();
                if (vehicle != null) {
                    spot.vacateSpot();
                    if (vehicle.getType() == VehicleType.TRUCK) {
                        floors.get(spot.getFloor() - 1).getSpots().get(spot.getSpotId()).vacateSpot();
                    }
                    parkedVehicles.remove(licensePlate);
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getAvailableSpots(int floorNumber) {
        if (floorNumber < 1 || floorNumber > floors.size()) {
//        	System.out.print("sdf");
            return -1;
        }
        return floors.get(floorNumber - 1).getAvailableSpots();
    }

    @Override
    public boolean isFull() {
        return floors.stream().noneMatch(floor -> floor.getAvailableSpots() > 0);
    }

    @Override
    public String getVehicleLocation(String licensePlate) {
        ParkingSpot spot = parkedVehicles.get(licensePlate);
        if (spot != null) {
            return "Vehicle is at Floor: " + spot.getFloor() + ", Spot: " + spot.getSpotId();
        }
        return "Vehicle not found.";
    }
}