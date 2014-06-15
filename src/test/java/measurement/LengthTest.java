package measurement;

import org.junit.Test;

import static measurement.LengthFactory.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class LengthTest {

	@Test
	public void threeMilesShouldEqualThreeMiles() {
		assertThat(mile(3), is(mile(3)));
	}

	@Test
	public void threeMilesShouldNotEqualTwoMiles() {
		assertThat(mile(3), not(mile(2)));
	}

	@Test
	public void threeMilesShouldNotEqualFourMiles() {
		assertThat(mile(3), not(mile(4)));
	}

	@Test
	public void threeYardsShouldEqualThreeYards() {
		assertThat(yard(3), is(yard(3)));
	}

	@Test
	public void threeYardsShouldNotEqualTwoYards() {
		assertThat(yard(3), not(yard(2)));
	}

	@Test
	public void threeYardsShouldNotEqualFourYards() {
		assertThat(yard(3), not(yard(4)));
	}

	@Test
	public void oneMileShouldEquals1760Yards() {
		assertThat(mile(1), is(yard(1760)));
	}

	@Test
	public void oneMileShouldNotEqual1671Yards() {
		assertThat(mile(1), not(yard(1761)));
	}

	@Test
	public void threeFootShouldEqualsThreeFoot() {
		assertThat(feet(3), is(feet(3)));
	}

	@Test
	public void treeFootShouldNotEqualFourFoot() {
		assertThat(feet(3), not(feet(4)));
	}

	@Test
	public void treeFootShouldNotEqualTwoFoot() {
		assertThat(feet(3), not(feet(2)));
	}

	@Test
	public void oneYardShouldEqual3Foot() {
		assertThat(yard(1), is(feet(3)));
	}

	@Test
	public void oneYardShouldNotEqual4Foot() {
		assertThat(yard(1), not(feet(4)));
	}

	@Test
	public void threeInchesShouldEqualsThreeInches() {
		assertThat(inch(3), is(inch(3)));
	}

	@Test
	public void treeInchesShouldNotEqualFourInches() {
		assertThat(inch(3), not(inch(4)));
	}

	@Test
	public void treeInchesShouldNotEqualTwoInches() {
		assertThat(inch(3), not(inch(2)));
	}

	@Test
	public void oneFeetShouldEqual12Inches() {
		assertThat(feet(1), is(inch(12)));
	}

	@Test
	public void oneFeetShouldNotEqual13Inches() {
		assertThat(feet(1), not(inch(13)));
	}
	@Test
	public void oneMileAddOneMileShouldEqualsTwoMiles() {
		assertThat(mile(1).add(mile(1)), is(mile(2)));
	}

	@Test
	public void oneMileAddOneYardShouldEquals1761Yards() {
		assertThat(mile(1).add(yard(1)), is(yard(1761)));
	}

	@Test
	public void oneFeetAddOneYardShouldBeFourFeet() {
		assertThat(feet(1).add(yard(1)), is(feet(4)));
	}

	@Test
	public void oneInchAssOneYardShouldBe37Inch() {
		assertThat(inch(1).add(yard(1)), is(inch(37)));
	}

	@Test
	public void shouldPrint0InchWhenGivenUnitIs0Inch() {
		assertThat(inch(0).print(), is("0 inch"));
	}

	@Test
	 public void shouldPrint0InchWhenGivenUnitIs0Yard() {
		assertThat(yard(0).print(), is("0 inch"));
	}

	@Test
	public void shouldPrint1InchWhenGivenUnitIs1Inch() {
		assertThat(inch(1).print(), is("1 inch"));
	}

	@Test
	public void shouldPrint1YardWhenGivenUnitIs1Yard() {
		assertThat(yard(1).print(), is("1 yard"));
	}

	@Test
	public void shouldPrint1FeetWhenGivenUnitIs12Inch() {
		assertThat(inch(12).print(), is("1 feet"));
	}

	@Test
	 public void shouldPrint1YardWhenGivenUnitIs36Inch() {
		assertThat(inch(36).print(), is("1 yard"));
	}

	@Test
	public void shouldPrint1YardWhenGivenUnitIs36Multiple1760Inch() {
		assertThat(inch(12*3*1760).print(), is("1 mile"));
	}

	@Test
	public void shouldPrint1YardWhenGivenUnitIs3Feet() {
		assertThat(feet(3).print(), is("1 yard"));
	}

	@Test
	public void shouldPrint1MileWhenGivenUnitIs3Multiple1760Feet() {
		assertThat(feet(3*1760).print(), is("1 mile"));
	}

	@Test
	public void shouldPrint1MileWhenGivenUnitIs1760Yard() {
		assertThat(yard(1760).print(), is("1 mile"));
	}

	@Test
	public void shouldPrint1FeetAnd2InchWhenGiven14Inch() {
		assertThat(inch(14).print(), is("1 feet 2 inch"));
	}

	@Test
	public void shouldPrint1YardAnd2InchWhenGiven38Inch() {
		assertThat(inch(38).print(), is("1 yard 2 inch"));
	}

	@Test
	public void shouldPrint5YradAnd2FeetAnd2InchWhenGiven206Inch() {
		assertThat(inch(5*12*3+24+2).print(), is("5 yard 2 feet 2 inch"));
	}

	@Test
	public void shouldPrint1YardAnd1Feet() {
		assertThat(inch(1*12*3+12).print(), is("1 yard 1 feet"));
	}

	@Test
	public void shouldPrint1MileAnd1Feet() {
		assertThat(inch(1*12*3*1760+1).print(), is("1 mile 1 inch"));
	}

	@Test
	public void shouldPrint1MileAnd1Inch() {
		assertThat(inch(1*12*3*1760+1).print(), is("1 mile 1 inch"));
	}

	@Test
	public void shouldPrint2MileAnd1Feet() {
		assertThat(inch(2*12*3*1760+12).print(), is("2 mile 1 feet"));
	}

	@Test
	public void shouldPrint1Mile1Feet() {
		assertThat(feet(1*3*1760+1).print(), is("1 mile 1 feet"));
	}

	@Test
	public void shouldPrint1Mile1Yard() {
		assertThat(yard(1760+1).print(), is("1 mile 1 yard"));
	}

	@Test
	public void shouldPrint37InchWhenInputIs37Inch() {
		assertThat(inch(37).printToBaseUnit(), is("37 inch"));
	}

	@Test
	public void shouldPrint12InchWhenInputIs1Feet() {
		assertThat(feet(1).printToBaseUnit(), is("12 inch"));
	}

}
