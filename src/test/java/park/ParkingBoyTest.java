package park;

import org.junit.Test;
import park.domain.Car;
import park.domain.Ticket;
import park.domain.Vehicle;
import park.exception.IllegalTicketException;
import park.exception.NoSeatException;
import park.stratege.ChooseFirsParkWithEmptySeatsStrategy;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {

	private Car car = new Car("parkName");
	private Park firstPark;
	private Park secondPark;
	private ParkingBoy parkingBoy;
	private ChooseFirsParkWithEmptySeatsStrategy chooseFirsParkWithEmptySeatsStrategy = new ChooseFirsParkWithEmptySeatsStrategy();
	private String parkName = "parkName";

	@Test
	public void should_park_successfully_in_first_parking_if_it_not_full() throws IllegalTicketException, NoSeatException {
		firstPark = new Park(parkName, 2);
		secondPark = new Park(parkName, 3);
		parkingBoy = new ParkingBoy(Arrays.asList(firstPark, secondPark), chooseFirsParkWithEmptySeatsStrategy);

		Ticket ticket = parkingBoy.park(car);

		assertThat(firstPark.getVehicle(ticket), is((Vehicle) car));
	}

	@Test
	public void should_park_successfully_in_second_parking_if_it_is_not_full_and_the_first_parking_is_full() throws IllegalTicketException, NoSeatException {
		firstPark = new Park(parkName, 0);
		secondPark = new Park(parkName, 3);
		parkingBoy = new ParkingBoy(Arrays.asList(firstPark, secondPark), chooseFirsParkWithEmptySeatsStrategy);

		Ticket ticket = parkingBoy.park(car);

		assertThat(secondPark.getVehicle(ticket), is((Vehicle)car));
	}

	@Test(expected = NoSeatException.class)
	public void should_get_no_seat_exception_when_all_parkings_are_full() throws IllegalTicketException, NoSeatException {
		firstPark = new Park(parkName, 0);
		secondPark = new Park(parkName, 0);
		parkingBoy = new ParkingBoy(Arrays.asList(firstPark, secondPark), chooseFirsParkWithEmptySeatsStrategy);

		parkingBoy.park(car);
	}

	@Test(expected = NoSeatException.class)
	public void should_get_no_seat_exception_when_there_is_no_park() throws NoSeatException {
		parkingBoy = new ParkingBoy(new ArrayList<Park>(), chooseFirsParkWithEmptySeatsStrategy);

		parkingBoy.park(car);
	}

	@Test
	public void should_get_true_if_parking_boy_has_empty_seats() {
		parkingBoy = new ParkingBoy(Arrays.asList(new Park(parkName, 5)), chooseFirsParkWithEmptySeatsStrategy);

		assertThat(parkingBoy.getLeftSeats(), is(5));
	}
}
