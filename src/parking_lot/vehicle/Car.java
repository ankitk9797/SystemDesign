package parking_lot.vehicle;

import parking_lot.enums.VehicleType;

public class Car extends Vehicle{
    Car(String no){
        super(no, VehicleType.CAR);
    }
}
