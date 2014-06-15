package park.domain;

import park.Park;

public class Ticket {

	private Park park = new Park("parkName", 0);

	public Ticket(Park park) {
		this.park = park;
	}

	public Ticket() {
	}

	public Park getPark() {
		return park;
	}
}
