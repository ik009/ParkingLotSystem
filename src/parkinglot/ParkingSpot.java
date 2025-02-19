package parkinglot;



public class ParkingSpot implements ParkingSpotManager {
    private int spotId;
    private int floor;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, int floor) {
        this.spotId = spotId;
        this.floor = floor;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public int getSpotId() {
        return spotId;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public void occupySpot(Vehicle vehicle) {
        this.isOccupied = true;
        this.vehicle = vehicle;
    }

    @Override
    public void vacateSpot() {
        this.isOccupied = false;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
