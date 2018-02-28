
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
 * This Class has methods called from the main. It contains the inventory array
 * of items and its methods act upon them.
 * 
 * @author Byron
 *
 */
public class Inventory {
	/**
	 * Array of Item objects.
	 */
	private Item[] inventory;
	/**
	 * The number of items that are currently in the array.
	 */
	private int numItems;

	/**
	 * Inventory's constructor initializes variables.
	 */
	public Inventory() {
		numItems = 0;
		inventory = new Item[1000];
	}

	/**
	 * Adds items to the inventory[].
	 * 
	 * @param in
	 *            The keyboard input.
	 * @return Returns a boolean. True if the item is successfully added.
	 */
	public boolean addItem(Scanner in) {

		System.out.print("Do you wish to add a purchased item (enter P/p) or manufactured (enter anything else)? ");
		String choice = in.nextLine();

		if (choice.equals("p") || choice.equals("P")) {
			inventory[numItems] = new PurchasedItem();
		} else {
			inventory[numItems] = new ManufacturedItem();
		}

		if (!inventory[numItems].addItem(in) || alreadyExists(inventory[numItems]) != -1) {
			inventory[numItems] = null;
			System.out.println("Item code already exists!");// check statement
			return false;
		} else
			numItems++;
		return true;
	}

	/**
	 * Calls on the Items toString methods.
	 * 
	 * @return A message with information about the inventory.
	 */
	public String toString() {

		String message = "Inventory:";
		for (int i = 0; i < numItems; i++) {
			message += "\nItem: " + inventory[i];
		}
		return message;
	}

	/**
	 * Checks if the Item already exists in the inventory[] array
	 * 
	 * @param it
	 *            An Item object passed in to check if it exists in the inventory[]
	 *            array already.
	 * @return An index of the Item in the inventory[] array if it exists; otherwise
	 *         -1.
	 */
	public int alreadyExists(Item it) {

		if (numItems != 0) {
			for (int i = 0; i < numItems; i++) {
				if (inventory[i].isEqual(it)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Update the quantity of an existing Item in the inventory[] array.
	 * 
	 * @param in
	 *            The keyboard input.
	 * @param sell
	 *            True if selling the quantity, false if buying.
	 */
	public void updateQuantity(Scanner in, boolean sell) {
		String buy = "buy";
		if (sell)
			buy = "sell";
		Item temp = new Item();
		int check = 0;
		while (!temp.inputCode(in)) {
		}
		int index = alreadyExists(temp);
		temp = null;

		if (index == -1) {
			System.out.println("Code not found in inventory...");
			System.out.println("Error... could not " + buy + " item");
			return;
		}
		System.out.print("Enter valid quantity : ");
		while (!in.hasNextInt()) {
			System.out.println("Invalid quantity...please enter integer greater than or equal to 0");
			System.out.print("Enter valid quantity : ");
		}
		check = in.nextInt();
		in.nextLine();
		while (check < 0) {
			check = in.nextInt();
			System.out.println("Invalid quantity...please enter integer greater than or equal to 0");
			in.nextLine();
		}
		if (sell) {
			check = -check;
		}
		if (!inventory[index].updateItem(check)) {
			System.out.println("Error... could not " + buy + " item");
		}

	}
}
