package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.artman.MathAdd;

class MathAddTest {

	@Test
	void testHandleIt() {
		
		MathAdd addValues = new MathAdd();
		float result = addValues.handleIt(10, 10);
		assertEquals(20, result);
	}

}
