package park.domain;

public class Car implements Vehicle {
	private final String name;

	public Car(String carName) {
		this.name = carName;
	}

	@Override
	public String toString() {
		return "{name:" + name + "}";
	}
}
