package parkinglot;

public enum VehicleType {
	CAR(1),
    BIKE(1),
    TRUCK(2);

    private final int spotsNeeded;

    VehicleType(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}
