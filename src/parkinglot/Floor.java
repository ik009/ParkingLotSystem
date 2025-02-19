package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Floor  implements FloorOperations {
    private int floorNumber;
    private List<ParkingSpot> spots;
    //adds parking spots on the floor
    public Floor(int floorNumber, int numSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        for (int i = 1; i <= numSpots; i++) {
            spots.add(new ParkingSpot(i, floorNumber));
        }
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    @Override
    public int getAvailableSpots() {
        return (int) spots.stream().filter(spot -> !spot.isOccupied()).count();
    }

    @Override
    public ParkingSpot findAvailableSpot(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("TRUCK")) {
            for (int i = 0; i < spots.size() - 1; i++) {
                if (!spots.get(i).isOccupied() && !spots.get(i + 1).isOccupied()) {
                    return spots.get(i);
                }
            }
        } else {
            return spots.stream()
                    .filter(spot -> !spot.isOccupied())
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}
