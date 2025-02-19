package parkinglot;


public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }

    @Override
    public int getSpotsNeeded() {
        return VehicleType.BIKE.getSpotsNeeded();
    }
}
