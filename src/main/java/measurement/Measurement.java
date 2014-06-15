package measurement;

import measurement.Unit.Unit;

abstract class Measurement {

	private int value;
	private Unit unit;

	protected Measurement(int value, Unit unit) {
		this.value = value;
		this.unit = unit;
	}

	protected int convertToBaseLength() {
		return this.value * this.unit.getMultiple();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Measurement)) return false;

		Measurement that = (Measurement) o;

		return Double.compare(convertToBaseLength(), that.convertToBaseLength()) == 0;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(convertToBaseLength());
		result = (int) (temp ^ (temp >>> 32));
		return result;
	}

	public Unit getUnit() {
		return unit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
