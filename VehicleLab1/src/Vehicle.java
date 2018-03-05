/**
 * Vehicle is the parent class that has all the instance variables for the child
 * classes.
 * 
 * @author Byron
 *
 */
public abstract class Vehicle {
	/**
	 * The name of the vehicle.
	 */
	protected String name;
	/**
	 * The current speed of the vehicle.
	 */
	protected int speed;
	/**
	 * The number of wheels the vehicle has.
	 */
	protected int numberOfWheels;
	private static int number;

	/**
	 * Constructor of Vehicle. Sets the name of the vehicle by combining the vehicle
	 * type with an index number.
	 * 
	 * @param type
	 *            Type of vehicle depending on which child Class is instantiated.
	 */
	public Vehicle(String type) {
		name = type + number;
		number++;
	}

	/**
	 * Abstract method for making noise.
	 */
	public abstract String makeNoise();

	/**
	 * Abstract method for increasing speed.
	 */

	public abstract void pushPedal();
}
