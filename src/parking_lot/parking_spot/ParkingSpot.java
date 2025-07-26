package parking_lot.parking_spot;

import parking_lot.enums.ParkingSpotType;
import parking_lot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
        vehicle = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract boolean canVehicleFit(Vehicle vehicle);

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (isOccupied) {
            return false;
        }
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public synchronized void removeVehicle() {
        vehicle = null;
        isOccupied = false;
    }
}
