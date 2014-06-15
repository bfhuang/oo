package measurement;

import static measurement.Unit.VolumeUnit.*;

public class VolumeFactory {
	public static Volume tsp(int value) {
		return new Volume(value, TSP);
	}

	public static Volume tbsp(int value) {
		return new Volume(value, TBSP);
	}

	public static Volume oz(int value) {
		return new Volume(value, OZ);
	}

}
