package parkinglot;


//Checks if entered vehicle type is valid or not
public class DefaultVehicleValidator implements VehicleValidator {
    @Override
    public boolean isValidVehicleType(String vehicleType) {
        try {
            VehicleType.valueOf(vehicleType.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean isValidLicensePlate(String licensePlate) {
//    	System.out.println("plate validator");
        return licensePlate != null && !licensePlate.trim().isEmpty();
    }
}
