package park.stratege;

import park.ParkingResource;
import park.exception.NoSeatException;

import java.util.List;

class ChooseParkWithMostEmptySeatsStrategy implements Strategy {

	@Override
	public ParkingResource choosePark(List<ParkingResource> parkingResources) throws NoSeatException {
		if (parkingResources.size() > 0) {
			ParkingResource tmp = parkingResources.get(0);
			for (ParkingResource parkingResource : parkingResources) {
				tmp = (tmp.getLeftSeats() >= parkingResource.getLeftSeats()) ? tmp : parkingResource;
			}
			return tmp;
		}
		throw new NoSeatException();
	}

}
