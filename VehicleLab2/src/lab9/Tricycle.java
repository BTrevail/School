package lab9;

/**
 * Extends the Vehicle Class and performs the behaviors unique to a Bicycle.
 * 
 * @author Byron
 */
public class Tricycle extends Vehicle {
	/**
	 * The constructor passes it's name and number of wheels to Vehicles
	 * constructor.
	 */
	public Tricycle() {
		super("Tricycle", 3);
	}

	/**
	 * If the current speed is less than 10, this method adds 2 to the current
	 * speed.
	 */
	public void pushPedal() {
		if (speed < 10)
			speed += 2;
	}

	/**
	 * Returns a sound depending on the speed.
	 * 
	 * @return Returns "drool" if speed is 0. Otherwise it will return "squeak"
	 */
	public String makeNoise() {
		return speed == 0 ? "drool" : "squeak";
	}

}
