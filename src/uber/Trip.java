package uber;

import uber.enums.PaymentStatus;
import uber.enums.TripStatus;
import uber.user.Driver;
import uber.user.Rider;

import java.util.UUID;

public class Trip {
    String tripId;
    Rider rider;
    Driver driver;
    Location origin;
    Location destination;
    TripStatus status;
    double fare;
    PaymentStatus paymentStatus;

    public Trip(Rider rider, Location origin, Location destination) {
        this.tripId = UUID.randomUUID().toString();
        this.rider = rider;
        this.origin = origin;
        this.destination = destination;
        this.status = TripStatus.REQUESTED;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void complete() {
        this.status = TripStatus.COMPLETED;
    }

    public void markPayment() {
        this.paymentStatus = PaymentStatus.COMPLETED;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getId() {
        return tripId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public TripStatus getStatus() {
        return status;
    }

    public double getFare() {
        return fare;
    }
}
