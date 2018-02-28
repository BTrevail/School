
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
 * Main class for running inventory program.
 * 
 * @author Byron
 *
 */
public class Assign1Main {
	/**
	 * Main method for running inventory program. Contains the menu.
	 * 
	 * @param args
	 *            Arguments
	 */
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		Scanner in = new Scanner(System.in);
		String choice = null;

		do {
			System.out.println("Enter 1 to add an item to inventory");
			System.out.println("2 to display current inventory");
			System.out.println("3 buy some of an item");
			System.out.println("4 sell some of an item");
			System.out.println("5 to quit");

			choice = in.nextLine();

			switch (choice.charAt(0)) {
			case '1':
				inventory.addItem(in);
				break;
			case '2':
				System.out.println(inventory);
				break;
			case '3':
				inventory.updateQuantity(in, false);
				break;
			case '4':
				inventory.updateQuantity(in, true);
				break;
			case '5':
				break;
			default:
				System.out.println("Invalid choice...");
			}

			System.out.println();

		} while (choice.charAt(0) != '5');

		in.close();
	}
}
