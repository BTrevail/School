package lab9;

import java.util.Comparator;

/**
 * Implements the Comparator interface of Vehicle type and overrides the compare
 * method.
 * 
 * @author Byron 
 *
 */
public class VehicleComparator implements Comparator<Vehicle> {
	/**
	 * This method compares 2 vehicles and returns -1,0,or 1.
	 * 
	 * @param v1
	 *            Vehicle 1 is the vehicle that is being moved.
	 * @param v2
	 *            Vehicle 2 is what Vehicle 1 is being compared too.
	 * @return Returns -1 or 1 depending on whether the vehicle should move up or
	 *         down the list. 0 if it should stay where it is.
	 */
	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		if (v1.speed > v2.speed) {
			return -1;
		} else if (v1.speed < v2.speed) {
			return 1;
		} else {
			if ((v1 instanceof Bicycle && (v2 instanceof Car || v2 instanceof Tricycle))
					|| ((v1 instanceof Car) && v2 instanceof Tricycle))
				return -1;
			else if ((v1 instanceof Tricycle && (v2 instanceof Car || v2 instanceof Bicycle))
					|| ((v1 instanceof Car) && v2 instanceof Bicycle))
				return 1;
			else
				return 0;
		}
	}

}
