package park.stratege;

import park.ParkingResource;
import park.exception.NoSeatException;

import java.util.List;

public class ChooseFirsParkWithEmptySeatsStrategy implements Strategy {

	@Override
	public ParkingResource choosePark(List<ParkingResource> parkingResources) throws NoSeatException {
		for(ParkingResource parkingResource : parkingResources){
			if(parkingResource.getLeftSeats() > 0){
				return parkingResource;
			}
		}
		throw new NoSeatException();
	}
}
