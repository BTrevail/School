
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
 * A child of the Item Class. Contains fields and behaviors unique to purchased
 * Items.
 * 
 * @author Byron
 *
 */
public class PurchasedItem extends Item {
	/**
	 * The name of the supplier of the PurchasedItem.
	 */
	private String supplierName;

	/**
	 * The constructor initializes the supplier name.
	 */
	public PurchasedItem() {
		supplierName = null;
	}

	/**
	 * Prompts the user and inputs the supplierName.
	 * 
	 * @param in
	 *            The keyboard input.
	 * @return True... currently unused
	 */
	public boolean addItem(Scanner in) {
		super.addItem(in);
		System.out.print("Enter the name of the supplier: ");
		supplierName = in.nextLine();
		return true;
	}

	/**
	 * Gets the message from the parent Class and returns it and the supplierName.
	 * 
	 * @return The message from the parent Class and the supplierName.
	 */
	public String toString() {
		return super.toString() + "Supplier: " + supplierName;

	}

}
