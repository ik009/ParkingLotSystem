package parkinglot;

import java.util.List;



public interface ParkingStrategy {
	ParkingSpot findSpot(List<Floor> floors, String vehicleType);
}
