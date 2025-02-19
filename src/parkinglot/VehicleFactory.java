package parkinglot;



public class VehicleFactory {

    public static Vehicle createVehicle(String licensePlate, String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car(licensePlate);
            case "truck":
                return new Truck(licensePlate);
            case "bike":
                return new Bike(licensePlate);
            default:
                throw new InvalidVehicleException("Invalid vehicle type: " + vehicleType);
        }
    }
}
