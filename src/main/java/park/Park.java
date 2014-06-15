package park;

import park.domain.Ticket;
import park.domain.Vehicle;
import park.exception.IllegalTicketException;
import park.exception.NoSeatException;

import java.util.HashMap;
import java.util.Map;

public class Park implements ParkingResource {

	private final String name;
	private int totalSeats;
	private int currentSeats = 0;
	private Map<Ticket, Vehicle> tickets = new HashMap<Ticket, Vehicle>();

	public Park(String name, int totalSeats) {
		this.name = name;
		this.totalSeats = totalSeats;
	}

	public Ticket park(Vehicle vehicle) throws NoSeatException {
		if (++currentSeats <= totalSeats) {
			Ticket ticket = new Ticket(this);
			tickets.put(ticket, vehicle);
			return ticket;
		} else {
			currentSeats--;
			throw new NoSeatException();
		}
	}

	public void setSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Vehicle getVehicle(Ticket ticket) throws IllegalTicketException {
		if (tickets.containsKey(ticket)) {
			return tickets.remove(ticket);
		}
		throw new IllegalTicketException();
	}

	public int getLeftSeats() {
		return totalSeats - currentSeats;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("{name:" + name + ",cars:[");
		getCarsInfo(result);
		return result + "],empty spaces:" + (totalSeats - currentSeats) + "}";
	}

	private void getCarsInfo(StringBuffer result) {
		if(tickets.size() == 0 )
			return;
		for (Vehicle vehicle : tickets.values()) {
			result.append(vehicle.toString());
			result.append( ",");
		}
		result.deleteCharAt(result.length()-1);
	}
}
