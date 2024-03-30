package udea.edu.co.lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab2ApplicationTests {

	@Autowired
	DataController dataController;

	@Test
	void health() {
		assertEquals("APLICACION FUNCIONANDO OK!", dataController.healthCheck());
	}

	@Test
	void vertion() {
		assertEquals("La version Actual es 1.0.0", dataController.version());
	}

	@Test
	void nationsLength() {
		Integer nationsLength = dataController.getRandomNations().size();
		assertEquals(10, nationsLength);
	}

}
