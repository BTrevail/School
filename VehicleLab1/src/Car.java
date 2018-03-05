/**
 * Car is a child Class of Vehicle that performs behaviors distinct to cars.
 * 
 * @author Byron
 *
 */
public class Car extends Vehicle {
	/**
	 * Constructor of Car. Passes vehicle type to Vehicle and sets wheel amount "4".
	 */
	public Car() {
		super("Car");
		numberOfWheels = 4;
	}

	/**
	 * Returns a noise depending on the speed.
	 * 
	 * @return The noise the car is making.
	 */
	public String makeNoise() {
		return speed == 0 ? "purr" : "vroom";

	}

	/**
	 * Increases the speed.
	 */
	public void pushPedal() {
		speed += 10;
	}

}
