package parkinglot;

//to create truck object
public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }

    @Override
    public int getSpotsNeeded() {
        return VehicleType.TRUCK.getSpotsNeeded();
    }
}