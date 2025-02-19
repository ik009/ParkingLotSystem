package parkinglot;

//interface for floorOperations
public interface FloorOperations {
	int getAvailableSpots();
    ParkingSpot findAvailableSpot(String vehicleType);
}
