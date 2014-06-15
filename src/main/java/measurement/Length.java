package measurement;

import measurement.Unit.LengthUnit;

import java.util.Arrays;
import java.util.List;

public class Length extends Measurement {
	Length(int value, LengthUnit unit) {
		super(value, unit);
	}

	public Length add(Length that) {
		return new Length(that.convertToBaseLength() + this.convertToBaseLength(), (LengthUnit) this.getUnit().getBaseUnit());
	}


	public String print() {
		if (getValue() == 0)
			return "0 inch";
		Length tmp = this;
		StringBuilder result = new StringBuilder();
		while (tmp.canUpgrade()) {
			result.insert(0, tmp.convertToUpper());

		}
		result.insert(0, tmp.getValue() + " " + tmp.getUnit().toString().toLowerCase());
		return result.toString();
	}


	public String printToBaseUnit() {
		return convertToBaseLength() + " " + "inch";

	}

	private String convertToUpper() {
		String result = "";
		if (getValue() %  (getUpper().getMultiple() / getUnit().getMultiple()) > 0) {
			result = " " + getValue() % (getUpper().getMultiple() / getUnit().getMultiple())
					+ " " + getUnit().toString().toLowerCase();
		}
		this.setValue(getValue() / (getUpper().getMultiple() / getUnit().getMultiple()));
		this.setUnit(getUpper());
		return result;
	}

	private boolean canUpgrade() {
		if (getAllUnits().indexOf(getUnit()) + 1 == getAllUnits().size())
			return false;
		LengthUnit up = getUpper();
		return up.getMultiple() / getUnit().getMultiple() <= getValue() ? true : false;
	}

	private LengthUnit getUpper() {
		List<LengthUnit> units = getAllUnits();
		return units.get((units.indexOf(getUnit()) + 1) % units.size());
	}

	private List<LengthUnit> getAllUnits() {
		return Arrays.asList(LengthUnit.values());
	}

}
