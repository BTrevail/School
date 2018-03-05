package lab9;

/**
 * Extends the Vehicle Class and performs the behaviors unique to a Bicycle.
 * 
 * @author Byron
 *
 */
public class Bicycle extends Vehicle {
	/**
	 * The constructor passes it's name and number of wheels to Vehicles constructor.
	 */
	public Bicycle() {
		super("Bicycle", 2);
	}

	/**
	 * If the current speed is less than 40, this method adds 4 to the current
	 * speed.
	 */
	public void pushPedal() {
		if (speed < 40)
			speed += 4;
	}

	/**
	 * Returns a sound depending on the speed.
	 * 
	 * @return Returns "sigh" if speed is 0. Otherwise it will return "grunt"
	 */
	public String makeNoise() {
		return speed == 0 ? "sigh" : "grunt";
	}

}
