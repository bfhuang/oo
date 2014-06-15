package park;

import com.google.common.base.Predicate;
import park.domain.Car;
import park.domain.Ticket;
import park.domain.Vehicle;
import park.exception.IllegalTicketException;
import park.exception.NoSeatException;
import park.stratege.ChooseFirsParkWithEmptySeatsStrategy;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Collections2.filter;

public class ParkingManager {

	private final List<ParkingResource> parkingResource;
	private final ChooseFirsParkWithEmptySeatsStrategy chooseFirsParkWithEmptySeatsStrategy;
	private final String name;

	public ParkingManager(String managerName, List<ParkingResource> parkingResource, ChooseFirsParkWithEmptySeatsStrategy chooseFirsParkWithEmptySeatsStrategy) {
		this.name = managerName;
		this.parkingResource = parkingResource;
		this.chooseFirsParkWithEmptySeatsStrategy = chooseFirsParkWithEmptySeatsStrategy;
	}

	public Ticket park(Car car) throws NoSeatException {
		return chooseFirsParkWithEmptySeatsStrategy.choosePark(parkingResource).park(car);
	}

	public Vehicle getVehicle(Ticket ticket) throws IllegalTicketException {
		return ticket.getPark().getVehicle(ticket);
	}

	public String print() {
		String nameInfo = "{name:";
		String parkingLotsInfo = ",parking lots:[";
		String parkingBoyInfo = "],parking boys:[";
		String endInfo = "]}";
		StringBuffer result = new StringBuffer(nameInfo + name + parkingLotsInfo);
		getParksInfo(result);
		result.append(parkingBoyInfo);
		result.append(endInfo);
		return result.toString();
	}

	private void getParksInfo(StringBuffer result) {
		if (getParks().size() == 0)
			return;
		for (ParkingResource tmp : getParks()) {
			result.append(tmp.toString());
			result.append(",");
		}
		result.deleteCharAt(result.length()-1);
	}

	private List<ParkingResource> getParks() {
		return new ArrayList<ParkingResource>(filter(parkingResource, new Predicate<ParkingResource>() {
			@Override
			public boolean apply(ParkingResource park) {
				return (park instanceof Park);
			}
		}));
	}
}
