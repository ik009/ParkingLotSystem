package parkinglot;


public interface ParkingSpotManager {
	void occupySpot(Vehicle vehicle);
    void vacateSpot();
    boolean isOccupied();
}
