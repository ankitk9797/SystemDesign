package parking_lot.fees;

import parking_lot.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
