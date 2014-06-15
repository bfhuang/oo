package park;

import park.domain.Ticket;
import park.domain.Vehicle;
import park.exception.NoSeatException;

public interface ParkingResource {

	Ticket park(Vehicle vehicle) throws NoSeatException;

	int getLeftSeats();
}
