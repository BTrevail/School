
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
 * The parent Item that has the fields and behaviors common to all Items.
 * 
 * @author Byron
 *
 */
public class Item {
	/**
	 * The unique code to identify the Item.
	 */
	private int itemCode;
	/**
	 * The Item's name.
	 */
	private String itemName;
	/**
	 * The quantity of the Item in the inventory[].
	 */
	private int itemQuantity;
	/**
	 * The price of the item.
	 */
	private float itemPrice;

	/**
	 * The constructor initializes the instance variable.
	 */
	public Item() {

		itemCode = 0;
		itemName = null;
		itemQuantity = 0;
		itemPrice = 0;
	}

	/**
	 * Prompts the user and adds information to the fields of the Class.
	 * 
	 * @param in
	 *            The Keyboard input.
	 * @return False... currently unused...
	 */
	public boolean addItem(Scanner in) {

		while (!inputCode(in)) {
		}

		System.out.print("Enter the name for the item: ");
		itemName = in.nextLine();

		System.out.print("Enter the quantity for the item: ");
		while (itemQuantity <= 0) {
			if (in.hasNextInt()) {
				itemQuantity = in.nextInt();
			}
			if (itemQuantity <= 0) {
				System.out.println("Invalid quantity...please enter integer greater than 0");
				System.out.print("Enter the quantity for the item: ");
			}
			in.nextLine();
		}

		System.out.print("Enter the price for the item: ");
		while (itemPrice <= 0) {
			if (in.hasNextFloat()) {
				itemPrice = in.nextFloat();
			}
			if (itemPrice <= 0) {
				System.out.println("Invalid price...please enter float greater than 0");
				System.out.print("Enter the price for the item: ");
			}
			in.nextLine();
		}

		return false;
	}

	/**
	 * Returns the fields of Item as a message.
	 * 
	 * @return The fields of Item as a message.
	 */
	public String toString() {
		return String.format("%d %s %d price: $%.1f ", itemCode, itemName, itemQuantity, itemPrice);
	}

	/**
	 * Updates the quantity of the Item if bought or sold.
	 * 
	 * @param amount
	 *            How much the quantity is updated by.
	 * @return True if successful.
	 */
	public boolean updateItem(int amount) {
		if (-amount > itemQuantity) {
			return false;
		} else {
			itemQuantity += amount;
		}
		if (itemQuantity < 0) {
			itemQuantity -= amount;
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if the input Item has the same itemCode as this object.
	 * 
	 * @param it
	 *            The Item being checked.
	 * @return True if equal; otherwise false.
	 */
	public boolean isEqual(Item it) {
		if (it.itemCode == itemCode) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prompts the user and assigns the keyboard input to the itemCode.
	 * 
	 * @param in
	 *            The keyboard input.
	 * @return True if successful; otherwise false.
	 */
	public boolean inputCode(Scanner in) {
		System.out.print("Enter valid item code: ");
		if (in.hasNextInt()) {
			itemCode = in.nextInt();
			if (itemCode > 0) {
				in.nextLine();
				return true;
			}
		}
		System.out.println("Invalid code...please enter integer greater than 0");
		in.nextLine();
		return false;
	}
}
