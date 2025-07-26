package parking_lot.fees;

import parking_lot.ParkingTicket;
import parking_lot.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleType, Double> hourlyRates = new HashMap() {{
        put(VehicleType.CAR, 20.0);
        put(VehicleType.BIKE, 10.0);
    }};

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * hourlyRates.get(parkingTicket.getVehicle().getVehicleType());
    }
}
