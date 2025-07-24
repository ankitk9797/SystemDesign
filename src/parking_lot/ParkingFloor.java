package parking_lot;

import parking_lot.parking_spot.ParkingSpot;
import parking_lot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    int floor_no;
    List<ParkingSpot> parkingSpots;

    ParkingFloor(int no){
        this.floor_no = no;
        parkingSpots = new ArrayList<>();
    }

    public Optional<ParkingSpot> availableSpot(Vehicle vehicle){
        return parkingSpots.stream()
                .filter(parkingSpot -> !parkingSpot.isOccupied() && parkingSpot.canVehicleFit(vehicle))
                .findFirst();
    }
}
