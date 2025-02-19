package parkinglot;



public interface ParkingLotOperations {
	String parkVehicle(Vehicle vehicle);
    boolean leaveVehicle(String licensePlate);
    int getAvailableSpots(int floorNumber);
    boolean isFull();
    String getVehicleLocation(String licensePlate);
}
