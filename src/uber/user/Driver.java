package uber.user;

import uber.Location;
import uber.Trip;
import uber.enums.DriverStatus;

public class Driver extends User {
    String licenseNo;
    Location location;
    Trip currentTrip;
    DriverStatus status;

    public Driver(String name, String contact, String licenseNo, Location location) {
        super(name, contact);
        this.licenseNo = licenseNo;
        this.location = location;
        this.status = DriverStatus.AVAILABLE;
        this.currentTrip = null;
    }

    public synchronized boolean isAvailable() {
        return status == DriverStatus.AVAILABLE;
    }

    public synchronized void assignTrip(Trip trip) {
        this.currentTrip = trip;
        this.status = DriverStatus.BUSY;
    }

    public synchronized void completeTrip() {
        this.currentTrip = null;
        this.status = DriverStatus.AVAILABLE;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public Location getLocation() {
        return location;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }
}
