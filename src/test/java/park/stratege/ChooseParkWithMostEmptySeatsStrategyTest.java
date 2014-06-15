package park.stratege;

import org.junit.Test;
import park.Park;
import park.ParkingBoy;
import park.ParkingResource;
import park.exception.NoSeatException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChooseParkWithMostEmptySeatsStrategyTest {


	private String parkName = "parkName";

	@Test
	public void should_choose_the_park_which_has_more_empty_seat() throws NoSeatException {
		ChooseParkWithMostEmptySeatsStrategy strategy = new ChooseParkWithMostEmptySeatsStrategy();
		ParkingResource parkWithMoreEmptySeats = new Park(parkName, 3);
		ParkingResource parkWithLessEmptySeats = new ParkingBoy(Arrays.asList(new Park(parkName, 2)), new ChooseParkWithMostEmptySeatsStrategy());

		ParkingResource parkingResource = strategy.choosePark(Arrays.asList(parkWithMoreEmptySeats, parkWithLessEmptySeats));
		assertThat(parkingResource, is(parkWithMoreEmptySeats));

		parkingResource = strategy.choosePark(Arrays.asList(parkWithLessEmptySeats, parkWithMoreEmptySeats));
		assertThat(parkingResource, is(parkWithMoreEmptySeats));
	}
}
