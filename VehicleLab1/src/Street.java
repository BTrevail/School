import java.util.Random;

/**
 * Street creates instances of vehicles, and runs a simulation on the street.
 * 
 * @author Byron
 *
 */
public class Street {
	private static final Random RANDOM_NUM = new Random();
	private Vehicle[] vehicles;

	/**
	 * Constructor of Street. Initializes and Instantiates an array of Vehicles.
	 */
	public Street() {
		vehicles = new Vehicle[4];

		for (int i = 0; i < vehicles.length; i += 2) {
			vehicles[i] = new Car();
			vehicles[i + 1] = new Bicycle();
		}
	}

	/**
	 * Simulates randomly pushing the pedal of Vehicles on the Street, and outputs
	 * the results.
	 */
	public void simulate() {
		Vehicle random;

		for (int i = 0; i < 6; i++) {
			System.out.println("Update on the street:");

			for (int j = 0; j < vehicles.length; j++) {
				System.out.println(vehicles[j].name + ", speed: " + vehicles[j].speed);
			}
			for (int j = 0; j < vehicles.length; j++) {
				System.out.println(vehicles[j].name + ", noise: " + vehicles[j].makeNoise());
			}
			random = vehicles[RANDOM_NUM.nextInt(vehicles.length)];
			random.pushPedal();
			System.out.println("Pedal of " + random.name + " was pushed\n");
		}
	}

	/**
	 * The program main method. Runs the program by creating a new instance of
	 * Street and calling it's simulate method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Street thestreet = new Street();
		thestreet.simulate();
	}
}
