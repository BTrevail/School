/**
 * Bicycle is a child Class of Vehicle that performs behaviors distinct to
 * Bicycles.
 * 
 * @author Byron
 *
 */
public class Bicycle extends Vehicle {
	/**
	 * Constructor of Bicycle. Passes vehicle type to Vehicle and sets wheel amount
	 * "2".
	 */
	public Bicycle() {
		super("Bicycle");
		numberOfWheels = 2;
	}

	/**
	 * Returns a noise depending on the speed.
	 * 
	 * @return The noise the Bicycle is making.
	 */
	public String makeNoise() {
		return speed == 0 ? "sigh" : "grunt";

	}

	/**
	 * Increases the speed.
	 */
	public void pushPedal() {
		speed += speed < 40 ? 4 : 0;

	}

}
