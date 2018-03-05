package lab9;

/**
 * Extends the Vehicle Class and performs the behaviors unique to a Car.
 * 
 * @author Byron
 *
 */
public class Car extends Vehicle {
	/**
	 * The constructor passes it's name and number of wheels to Vehicles constructor.
	 */
	public Car() {
		super("Car", 4);
	}

	/**
	 * This method adds 10 to the current speed.
	 */
	public void pushPedal() {
		speed += 10;
	}

	/**
	 * Returns a sound depending on the speed.
	 * 
	 * @return Returns "purr" if speed is 0. Otherwise it will return "vroom"
	 */
	public String makeNoise() {
		return speed == 0 ? "purr" : "vroom";
	}

}
