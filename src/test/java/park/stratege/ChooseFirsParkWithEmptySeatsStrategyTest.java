package park.stratege;

import org.junit.Test;
import park.Park;
import park.ParkingBoy;
import park.ParkingResource;
import park.exception.NoSeatException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChooseFirsParkWithEmptySeatsStrategyTest {

	private String parkName = "parkName";

	@Test
	public void should_choose_the_first_park_which_has_empty_seat_for_resource() throws NoSeatException {
		ChooseFirsParkWithEmptySeatsStrategy chooseFirsParkWithEmptySeatsStrategy = new ChooseFirsParkWithEmptySeatsStrategy();
		ParkingResource park1 = new Park(parkName, 1);
		ParkingResource park2 = new ParkingBoy(Arrays.asList(new Park(parkName, 2)), new ChooseFirsParkWithEmptySeatsStrategy());

		ParkingResource park = chooseFirsParkWithEmptySeatsStrategy.choosePark(Arrays.<ParkingResource>asList(park1, park2));
		assertThat(park, is(park1));

		park1 = new Park(parkName, 0);
		park2 = new ParkingBoy(Arrays.asList(new Park(parkName, 2)), new ChooseFirsParkWithEmptySeatsStrategy());

		park = chooseFirsParkWithEmptySeatsStrategy.choosePark(Arrays.asList(park1, park2));
		assertThat(park, is(park2));
	}
}
