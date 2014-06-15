package measurement.Unit;

public enum VolumeUnit implements Unit {
	TSP(1),
	TBSP(3 * TSP.multiple),
	OZ(2 * TBSP.multiple);

	private final int multiple;

	private VolumeUnit(int multiple) {
		this.multiple = multiple;
	}

	@Override
	public int getMultiple() {
		return multiple;
	}

	@Override
	public Unit getBaseUnit() {
		return TSP;
	}
}
