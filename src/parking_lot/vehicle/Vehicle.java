package parking_lot.vehicle;

import parking_lot.enums.VehicleType;

public class Vehicle {
    String license_no;
    VehicleType vehicleType;

    Vehicle(String no, VehicleType type){
        this.license_no = no;
        this.vehicleType = type;
    }

    public String getLicense_no() {
        return license_no;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
