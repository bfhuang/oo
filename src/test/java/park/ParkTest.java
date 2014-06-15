package park;

import org.junit.Before;
import org.junit.Test;
import park.domain.Car;
import park.domain.Ticket;
import park.domain.Vehicle;
import park.exception.IllegalTicketException;
import park.exception.NoSeatException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

public class ParkTest {

	private Car car = new Car("carName");
	private Park park;
	private String parkName = "parkName";

	@Before
	public void before() {
		park = new Park(parkName, 100);
	}

	@Test
	public void should_return_true_if_there_are_enough_seats() throws NoSeatException {
		assertThat(park.park(car), isA(Ticket.class));
	}

	@Test(expected = NoSeatException.class)
	public void should_get_exception_if_there_is_no_seat() throws NoSeatException {
		park.setSeats(0);
		park.park(car);
	}

	@Test
	public void should_get_car_if_the_ticket_is_right() throws IllegalTicketException, NoSeatException {
		Ticket ticket = park.park(car);
		assertThat(park.getVehicle(ticket), is((Vehicle)car));
	}

	@Test(expected = IllegalTicketException.class)
	public void should_get_illegal_exception_if_the_ticket_is_wrong() throws IllegalTicketException, NoSeatException {
		park.park(car);

		park.getVehicle(new Ticket());
		park.getVehicle(new Ticket());
	}

	@Test(expected = IllegalTicketException.class)
	public void should_get_illegal_exception_if_the_ticket_has_been_used() throws IllegalTicketException {
		park.getVehicle(new Ticket());
	}

	@Test
	public void should_get_left_seats() {
	      park = new Park(parkName, 2);
		 assertThat(park.getLeftSeats(), is(2));
	}

	@Test
	public void should_get_park_name_and_empty_seat_when_park_is_empty() {
		park = new Park(parkName, 3);
		String expectedInfo = "{name:parkName,cars:[],empty spaces:3}";

		assertThat(park.toString(), is(expectedInfo));
	}

	@Test
	public void should_get_detailed_park_info_if_park_has_only_one_cars() throws NoSeatException {
		park = new Park(parkName, 3);
		park.park(car);
		park.park(car);
		String expectedInfo = "{name:parkName,cars:[{name:carName},{name:carName}],empty spaces:1}";

		assertThat(park.toString(), is(expectedInfo));
	}

}
