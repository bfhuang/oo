package measurement;

import measurement.Unit.LengthUnit;
import measurement.Unit.VolumeUnit;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static measurement.Unit.LengthUnit.*;
import static measurement.Unit.VolumeUnit.OZ;
import static measurement.Unit.VolumeUnit.TBSP;
import static measurement.Unit.VolumeUnit.TSP;
import static measurement.LengthFactory.*;
import static measurement.VolumeFactory.oz;
import static measurement.VolumeFactory.tbsp;
import static measurement.VolumeFactory.tsp;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashTest {
	private Map<Measurement, String> length = new HashMap<Measurement, String>();

	@Test
	public void hashCodeTest() {
		Measurement mile = mile(1);
		length.put(mile, "Chengdu");

		assertThat(length.get(mile(1)), is("Chengdu"));
		assertThat(length.get(yard(1760)), is("Chengdu"));
	}

	public static class LengthFactoryTest {

		@Test
		public void should_create_mile() {
			assertThat((LengthUnit) mile(1).getUnit(), is(MILE));
		}

		@Test
		 public void should_create_yard() {
			assertThat((LengthUnit) yard(1).getUnit(), is(YARD));
		}

		@Test
		public void should_create_feet() {
			assertThat((LengthUnit) feet(1).getUnit(), is(FEET));
		}

		@Test
		public void should_create_inch() {
			assertThat((LengthUnit) inch(1).getUnit(), is(INCH));
		}
	}

	public static class VolumeFactoryTest {

		@Test
		public void should_create_mile() {
			assertThat((VolumeUnit) tsp(1).getUnit(), is(TSP));
		}

		@Test
		public void should_create_tbsp() {
			assertThat((VolumeUnit) tbsp(1).getUnit(), is(TBSP));
		}

		@Test
		public void should_create_oz() {
			assertThat((VolumeUnit) oz(1).getUnit(), is(OZ));
		}
	}
}
