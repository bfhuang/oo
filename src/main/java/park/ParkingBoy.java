package park;

import park.domain.Ticket;
import park.domain.Vehicle;
import park.exception.IllegalTicketException;
import park.exception.NoSeatException;
import park.stratege.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements ParkingResource {
	private final Strategy strategy;
	protected List<ParkingResource> parkingResources;

	public ParkingBoy(List<Park> parkingResources, Strategy strategy) {
		this.parkingResources = new ArrayList<ParkingResource>(parkingResources);
		this.strategy = strategy;
	}

	public Ticket park(Vehicle vehicle) throws NoSeatException {
		return choosePark().park(vehicle);
	}

	@Override
	public int getLeftSeats() {
		int tmp = 0;
		for(ParkingResource parkingResource : parkingResources){
			tmp += parkingResource.getLeftSeats();
		}
		return tmp;
	}

	protected Park choosePark() throws NoSeatException {
		return (Park) strategy.choosePark(parkingResources);
	}

	public Vehicle getVehicle(Ticket ticket) throws IllegalTicketException {
		return ticket.getPark().getVehicle(ticket);
	}
}