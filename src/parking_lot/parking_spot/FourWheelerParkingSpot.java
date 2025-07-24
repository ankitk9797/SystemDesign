package parking_lot.parking_spot;

import parking_lot.enums.ParkingSpotType;
import parking_lot.enums.VehicleType;
import parking_lot.vehicle.Vehicle;

public class FourWheelerParkingSpot extends ParkingSpot{
    FourWheelerParkingSpot(String spotId){
        super(spotId);
    }

    @Override
    public boolean canVehicleFit(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.CAR;
    }
}
