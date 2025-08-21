package tallerpruebas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestCalculation {

	@Test
	void testFindMax() {
		assertAll(
				() -> assertEquals(4,Calculation.findMax(new int[]{1,3,4,2})),
				() -> assertEquals(-1,Calculation.findMax(new int[]{-12,-1,-3,-4,-2})),
				() -> assertEquals(12,Calculation.findMax(new int[]{12,-1,-3,-4,-2})),
				() -> assertEquals(0,Calculation.findMax(new int[]{-1,-4,-2,0}))
		);
	}

}
