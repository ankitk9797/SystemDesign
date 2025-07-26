package uber.user;

import uber.Trip;

public class Rider extends User{
    Trip currentTrip;

    public Rider(String name, String contact) {
        super(name, contact);
        currentTrip = null;
    }

    public Trip getTrip() {
        return currentTrip;
    }

    public synchronized void assignTrip(Trip trip) {
        this.currentTrip = trip;
    }

    public void completeTrip(){
        this.currentTrip = null;
    }
}
