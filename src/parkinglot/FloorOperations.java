package parkinglot;


public interface FloorOperations {
	int getAvailableSpots();
    ParkingSpot findAvailableSpot(String vehicleType);
}
