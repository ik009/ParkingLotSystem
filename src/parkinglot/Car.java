package parkinglot;


//Class to create Car
public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }

    @Override
    public int getSpotsNeeded() {
        return VehicleType.CAR.getSpotsNeeded();
    }
}
