package park.stratege;

import park.ParkingResource;
import park.exception.NoSeatException;

import java.util.List;

public interface Strategy {

	ParkingResource choosePark(List<ParkingResource> parkingResources) throws NoSeatException;
}
