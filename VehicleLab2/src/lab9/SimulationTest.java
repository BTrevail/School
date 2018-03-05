package lab9;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test Class for JUnit Testing.
 * 
 * @author Byron
 *
 */
public class SimulationTest {
	private Street street = new Street();
	private String[] test1 = { "car", "car", "car", "bicycle", "bicycle" };

	/**
	 * Method to test that the pedal is pushed and speed is increased 6 times.
	 */
	@Test
	public void test() {

		street.parse(test1);
		street.simulate();
		assertTrue(street.getSumCarSpeeds() / 10 + street.getSumBicyleSpeeds() / 4 == 6);

	}
}
