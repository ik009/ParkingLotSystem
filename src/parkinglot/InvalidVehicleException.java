package parkinglot;


public class InvalidVehicleException extends ParkingLotException {
    public InvalidVehicleException(String message) {
        super(message);
    }
}