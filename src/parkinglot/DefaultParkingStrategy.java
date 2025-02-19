package parkinglot;

import java.util.List;


//Implementation of parking strategy, here implemented strategy allots first empty slot from 1st floor onwards
public class DefaultParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<Floor> floors, String vehicleType) {
        for (Floor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicleType);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }
}
