package lab9;

/**
 * This Class is a parent class to the other Vehicle types.
 * 
 * @author Byron
 *
 */
public abstract class Vehicle {
	/**
	 * The final name of the Vehicle.
	 */
	protected final String VEHICLE_NAME;
	/**
	 * The current speed of the Vehicle.
	 */
	public int speed;
	/**
	 * The Number of wheels the vehicle has.
	 */
	protected int wheels;
	private static int index = 0;

	/**
	 * The constructor sets the initial speed, amount of wheels, and the vehicle's
	 * name.
	 * 
	 * @param n
	 *            The vehicles name before the index is added to it.
	 * @param w
	 *            The number of wheels the vehicle has.
	 */
	public Vehicle(String n, int w) {
		speed = 0;
		wheels = w;
		this.VEHICLE_NAME = n + index++;
	}

	/**
	 * This abstract method adds a number depending on the Vehicle type to the
	 * current speed.
	 */
	public abstract void pushPedal();

	/**
	 * This abstract method returns a sound depending on the speed.
	 * 
	 * @return The sound returned depends on the Vehicle type.
	 */
	public abstract String makeNoise();

}
