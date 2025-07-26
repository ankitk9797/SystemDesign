package parking_lot;

import parking_lot.fees.FeeStrategy;
import parking_lot.fees.FlatRateFeeStrategy;
import parking_lot.parking_spot.ParkingSpot;
import parking_lot.vehicle.Vehicle;

import java.util.*;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        feeStrategy = new FlatRateFeeStrategy();
    }

    public static synchronized ParkingLot getInstance() {
        return INSTANCE;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy (FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.availableSpot(vehicle);
            if (spotOpt.isPresent()) {
                ParkingSpot spot = spotOpt.get();
                if (spot.assignVehicle(vehicle)) {
                    ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                    activeTickets.put(vehicle.getLicense_no(), ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No available spot for " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String license) throws Exception {
        ParkingTicket ticket = activeTickets.remove(license);
        if (ticket == null) throw new Exception("Ticket not found");

        ticket.getSpot().removeVehicle();

        ticket.setExitTimestamp();
        return feeStrategy.calculateFee(ticket);
    }
}
