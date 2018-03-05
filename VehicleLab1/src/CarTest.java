import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CarTest {
	Car car = new Car();
@Test
	public void test() {
		assertNotNull(car);
		assertTrue(car.makeNoise().equals("purr"));
		assertTrue(car.speed==0);
		car.pushPedal();
		assertTrue(car.makeNoise().equals("vroom"));
		assertTrue(car.speed==10);
	}
}
