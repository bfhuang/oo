package measurement;

import measurement.Unit.VolumeUnit;
import org.junit.Test;

import static measurement.Unit.VolumeUnit.*;
import static measurement.VolumeFactory.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VolumeFactoryTest {

	@Test
	public void shouldCreateOz() {
		assertThat((VolumeUnit) oz(1).getUnit(), is(OZ));
	}

	@Test
	public void shouldCreateTbsp() {
		assertThat((VolumeUnit) tbsp(1).getUnit(), is(TBSP));
	}

	@Test
	public void shouldCreateTsp() {
		assertThat((VolumeUnit) tsp(1).getUnit(), is(TSP));
	}
}
