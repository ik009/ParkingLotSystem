package parkinglot;

//used for handling invalid vehicle exceptions
public class InvalidVehicleException extends ParkingLotException {
    public InvalidVehicleException(String message) {
        super(message);
    }
}