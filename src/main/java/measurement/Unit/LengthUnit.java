package measurement.Unit;

public enum LengthUnit implements Unit {
	INCH(1),
	FEET(12 * INCH.multiple),
	YARD(3 * FEET.multiple),
	MILE(1760 * YARD.multiple);

	private final int multiple;

	private LengthUnit(int multiple) {
		this.multiple = multiple;
	}

	@Override
	public int getMultiple() {
		return multiple;
	}

	@Override
	public Unit getBaseUnit() {
		return INCH;
	}

}
