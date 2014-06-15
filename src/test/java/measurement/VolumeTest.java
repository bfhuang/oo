package measurement;

import org.junit.Test;

import static measurement.VolumeFactory.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class VolumeTest {

	@Test
	public void threeOzShouldEqualThreeOz() {
		assertThat(oz(3), is(oz(3)));
	}

	@Test
	public void threeOzsShouldNotEqualTwoOzs() {
		assertThat(oz(3), not(oz(2)));
	}

	@Test
	public void threeOzsShouldNotEqualFourOzs() {
		assertThat(oz(3), not(oz(4)));
	}

	@Test
	public void threeTbspShouldEqualThreeTbsp() {
		assertThat(tbsp(3), is(tbsp(3)));
	}

	@Test
	public void threeTbspShouldNotEqualTwoTbsp() {
		assertThat(tbsp(3), not(tbsp(2)));
	}

	@Test
	public void threeTbspShouldNotEqualFourTbsp() {
		assertThat(tbsp(3), not(tbsp(4)));
	}

	@Test
	public void oneOzShouldEquals2Tbsp() {
		assertThat(oz(1), is(tbsp(2)));
	}

	@Test
	public void oneOzShouldNotEqual3Tbsp() {
		assertThat(oz(1), not(tbsp(3)));
	}

	@Test
	public void threeTspShouldEqualsThreeTsp() {
		assertThat(tsp(3), is(tsp(3)));
	}

	@Test
	public void treeTspShouldNotEqualFourTsp() {
		assertThat(tsp(3), not(tbsp(4)));
	}

	@Test
	public void treeTspShouldNotEqualTwoTsp() {
		assertThat(tsp(3), not(tsp(2)));
	}

	@Test
	public void oneTbspShouldEqual3Tsp() {
		assertThat(tbsp(1), is(tsp(3)));
	}

	@Test
	public void oneTbspShouldNotEqual4Tsp() {
		assertThat(tbsp(1), not(tsp(4)));
	}
}
