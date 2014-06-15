package measurement;


import static measurement.Unit.LengthUnit.*;

public class LengthFactory {

	public static Length mile(int value) {
		return new Length(value, MILE);
	}

	public static Length yard(int value) {
		return new Length(value, YARD);
	}

	public static Length feet(int value) {
		return new Length(value, FEET);
	}

	public static Length inch(int value) {
		return new Length(value, INCH);
	}

}
