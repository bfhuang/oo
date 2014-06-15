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

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingManagerTest {

	private ParkingManager parkingManager;
	private ParkingBoy parkingBoy;
	private Park parkOfManager;
	private Car car = new Car("parkName");
	private String managerName;
	private ChooseFirsParkWithEmptySeatsStrategy chooseFirsParkWithEmptySeatsStrategy = new ChooseFirsParkWithEmptySeatsStrategy();
	private String parkName = "parkName";

	@Test(expected = NoSeatException.class)
	public void should_get_no_seat_exception_if_there_is_no_any_seat() throws NoSeatException {
		parkOfManager = new Park(parkName, 0);
		parkingBoy = new ParkingBoy(asList(new Park(parkName, 0)), new ChooseFirsParkWithEmptySeatsStrategy());
		parkingManager = new ParkingManager(managerName, asList(parkingBoy, parkOfManager), chooseFirsParkWithEmptySeatsStrategy);

		parkingManager.park(car);
	}

	@Test(expected = NoSeatException.class)
	public void should_get_no_seat_exception_if_there_is_no_resource() throws NoSeatException {
		parkingManager = new ParkingManager(managerName, new ArrayList<ParkingResource>(), new ChooseFirsParkWithEmptySeatsStrategy());

		parkingManager.park(car);
	}

	@Test
	public void should_park_successfully_if_there_is_empty_seat() throws NoSeatException, IllegalTicketException {
		parkOfManager = new Park(parkName, 1);
		parkingBoy = new ParkingBoy(asList(new Park(parkName, 1)), new ChooseFirsParkWithEmptySeatsStrategy());
		parkingManager = new ParkingManager(managerName, asList(parkingBoy, parkOfManager), chooseFirsParkWithEmptySeatsStrategy);

		Ticket ticket = parkingManager.park(car);

		assertThat(ticket, is(Ticket.class));
	}

	@Test
	public void should_get_corresponding_car_with_right_ticket() throws NoSeatException, IllegalTicketException {
		parkOfManager = new Park(parkName, 1);
		parkingBoy = new ParkingBoy(asList(new Park(parkName, 1)), new ChooseFirsParkWithEmptySeatsStrategy());
		parkingManager = new ParkingManager(managerName, asList(parkingBoy, parkOfManager), chooseFirsParkWithEmptySeatsStrategy);

		Ticket ticket = parkingManager.park(car);

		assertThat(parkingManager.getVehicle(ticket), is((Vehicle) car));
	}

	@Test
	public void should_print_manager_name_and_empty_park_and_empty_parking_boy() {
		managerName = "managerName";
		parkingManager = new ParkingManager(managerName, new ArrayList<ParkingResource>(), chooseFirsParkWithEmptySeatsStrategy);

		String expectedInfo = "{name:managerName,parking lots:[],parking boys:[]}";

		assertThat(parkingManager.print(), is(expectedInfo));
	}

	@Test
	public void should_print_manager_name_and_park_name_when_the_manager_has_only_one_park() throws NoSeatException {
		parkOfManager = new Park(parkName, 3);
		Park parkOfManagerAgain = new Park(parkName, 4);
		managerName = "managerName";
		parkingManager = new ParkingManager(managerName,
				Arrays.<ParkingResource>asList(parkOfManager, parkOfManagerAgain),
				chooseFirsParkWithEmptySeatsStrategy);

		String expectedInfo = "{name:managerName,parking lots:[{name:parkName,cars:[],empty spaces:3}," +
				"{name:parkName,cars:[],empty spaces:4}],parking boys:[]}";

		assertThat(parkingManager.print(), is(expectedInfo));
	}

}
