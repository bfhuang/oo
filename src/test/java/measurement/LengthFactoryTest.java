package measurement;

import measurement.Unit.LengthUnit;
import org.junit.Test;

import static measurement.Unit.LengthUnit.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LengthFactoryTest {

	@Test
	public void shouldCreateMile() {
		assertThat((LengthUnit) LengthFactory.mile(1).getUnit(), is(MILE));
	}

	@Test
	public void shouldCreateYard() {
		assertThat((LengthUnit) LengthFactory.yard(1).getUnit(), is(YARD));
	}

	@Test
	public void shouldCreateFeet() {
		assertThat((LengthUnit) LengthFactory.feet(1).getUnit(), is(FEET));
	}

	@Test
	public void shouldCreateInch() {
		assertThat((LengthUnit) LengthFactory.inch(1).getUnit(), is(INCH));
	}
}
