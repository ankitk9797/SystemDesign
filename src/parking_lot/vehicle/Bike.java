package parking_lot.vehicle;

import parking_lot.enums.VehicleType;

public class Bike extends Vehicle{

    Bike(String no){
        super(no, VehicleType.BIKE);
    }
}
