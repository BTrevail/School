import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BicycleTest {
	Bicycle bicycle = new Bicycle();
@Test
	public void test() {
		assertNotNull(bicycle);
		assertTrue(bicycle.makeNoise().equals("sigh"));
		assertTrue(bicycle.speed==0);
		bicycle.pushPedal();
		assertTrue(bicycle.makeNoise().equals("grunt"));
		assertTrue(bicycle.speed==4);
	}
}
