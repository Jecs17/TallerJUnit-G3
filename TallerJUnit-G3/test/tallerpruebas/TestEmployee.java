package tallerpruebas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TestEmployee {
	
	private final Employee worker = new Employee(400,"USD", 0.2F, EmployeeType.Worker);
	private final Employee supervisor = new Employee(600,"WON", 0.3F, EmployeeType.Supervisor);
	private final Employee manager = new Employee(800,"USD", 0.4F, EmployeeType.Manager);
	private final int month = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
	

	@Test
	void testCSPairMonth() {
		assumeTrue(month % 2 == 0);
		assertAll(
				() -> assertEquals(400F, worker.cs()),
				() -> assertEquals(570.105F, supervisor.cs()),
				() -> assertEquals(800.28F, manager.cs())
		);
	}
	
	@Test
	void testCSOddMonth() {
		assumeFalse(month % 2 == 0);
		assertAll(
				() -> assertEquals(464.33334F,worker.cs()),
				() -> assertEquals(634.4383F,supervisor.cs()),
				() -> assertEquals(864.61334F,manager.cs())
		);
	}
	
	@Test
	void testCalculateYearBonus() {
		assertAll(
				() -> assertEquals(386F, worker.CalculateYearBonus()),
				() -> assertEquals(763F, supervisor.CalculateYearBonus()),
				() -> assertEquals(1186F, manager.CalculateYearBonus())
		);
	}

}
