
/*********************************************************************************************
 * 
 * Student Name: Byron Trevail
 * Student Number: 040 684 109  
 * Course: 18W CST8130 - Data Structures
 * Date: February 9,2018
 * Assignment 1
 * 
 * 
 */
import java.util.Scanner;

/**
 * A child of the Item Class. Contains fields and behaviors unique to
 * manufactured Items.
 * 
 * @author Byron
 *
 */
public class ManufacturedItem extends Item {
	/**
	 * An array of Items that are used to manufacture the current Item.
	 */
	private int[] itemsUsed;
	/**
	 * The number of Items used to manufacture the current Item.
	 */
	private int numItems;

	/**
	 * The constructor initializes the instance variables.
	 */
	public ManufacturedItem() {
		numItems = 0;
		itemsUsed = new int[10];
	}

	/**
	 * Adds the values to the fields unique to manufactured items.
	 * 
	 * @param in
	 *            The keyboard input.
	 * @return True... currently unused.
	 */
	public boolean addItem(Scanner in) {
		super.addItem(in);

		System.out.println("Enter up to 10 codes used in this item (-1 to quit)\n");
		int check = 0;

		while (numItems < itemsUsed.length) {
			if (in.hasNextInt()) {
				check = in.nextInt();
			}
			if (check == -1) {
				in.nextLine();
				break;
			}
			if (check > 0) {
				itemsUsed[numItems] = check;
				numItems++;
			} else {
				System.out.println("Invalid code...please enter integer greater than 0");
			}
			check = 0;
			in.nextLine();
		}
		return true;
	}

	/**
	 * Gets the message from the parent class and adds the itemsUsed[] in the
	 * ManufacturedItem.
	 * 
	 * @return The itemCodes of all the Items used to manufacture the current Item
	 *         as well as the message from the parent Class.
	 */
	public String toString() {
		String message = "";

		for (int i = 0; i < numItems; i++) {
			message += String.format("%d, ", itemsUsed[i]);
		}
		return super.toString() + "Codes used: " + message;
	}
}
