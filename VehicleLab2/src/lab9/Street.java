package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Byron
 *
 */
public class Street extends JFrame implements SimInterface {
	private static final long serialVersionUID = 1L;
	private JLabel promptJLabel;
	private JLabel messageJLabel;
	private JLabel vehiclesJLabel;
	private JButton addCarJButton;
	private JButton addBicycleJButton;
	private JButton addTricycleJButton;
	private JButton doneJButton;
	private Color background;
	private JPanel buttonPanel = new JPanel();
	private ButtonHandler buttonHandler = new ButtonHandler();
	private static final Random RANDOM_NUMBERS = new Random();
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private int carNum;
	private int bicycleNum;
	private int tricycleNum;

	/**
	 * A nested class which performs actions when a button is pushed.
	 * 
	 * @author Byron
	 *
	 */
	private class ButtonHandler implements ActionListener {
		// nested class
		/**
		 * This is a method of the nested Class ButtonHandler which listens for an event
		 * i.e. a button being pushed, and performs an action.
		 * 
		 * @param event
		 *            The button being clicked.
		 */
		public void actionPerformed(ActionEvent event) {
			String message = (" was added to the Street");

			if (event.getSource() == addCarJButton) {
				carNum++;
				Car c = new Car();// add a car
				vehicles.add(c);
				messageJLabel.setText(vehicles.get(vehicles.size() - 1).VEHICLE_NAME + message);// update message
																								// with car
				vehiclesJLabel.setText("<html>Cars: " + carNum + "<br/>Bicycles: " + bicycleNum + "<br/>Tricycles: "
						+ tricycleNum + "</html>");

				int red = carNum * 200 / vehicles.size() + 55;
				int green = bicycleNum * 200 / vehicles.size() + 55;
				int blue = tricycleNum * 200 / vehicles.size() + 55;

				background = new Color(red, green, blue);
				repaint();// repaint JFrame
			} else if (event.getSource() == addBicycleJButton) {
				bicycleNum++;
				Bicycle b = new Bicycle();// add a car
				vehicles.add(b);
				messageJLabel.setText(vehicles.get(vehicles.size() - 1).VEHICLE_NAME + message);// update message
																								// with car
				vehiclesJLabel.setText("<html>Cars: " + carNum + "<br/>Bicycles: " + bicycleNum + "<br/>Tricycles: "
						+ tricycleNum + "</html>");

				int red = carNum * 200 / vehicles.size() + 55;
				int green = bicycleNum * 200 / vehicles.size() + 55;
				int blue = tricycleNum * 200 / vehicles.size() + 55;

				background = new Color(red, green, blue);
				repaint();// repaint JFrame
			} else if (event.getSource() == addTricycleJButton) {
				tricycleNum++;
				Tricycle t = new Tricycle();// add a car
				vehicles.add(t);
				messageJLabel.setText(vehicles.get(vehicles.size() - 1).VEHICLE_NAME + message);// update message
																								// with car
				vehiclesJLabel.setText("<html>Cars: " + carNum + "<br/>Bicycles: " + bicycleNum + "<br/>Tricycles: "
						+ tricycleNum + "</html>");

				int red = carNum * 200 / vehicles.size() + 55;
				int green = bicycleNum * 200 / vehicles.size() + 55;
				int blue = tricycleNum * 200 / vehicles.size() + 55;

				background = new Color(red, green, blue);
				repaint();// repaint JFrame
			} else {
				// done clicked
				simulate();// simulate
				System.exit(0);// close jframe / end application.
			}
		}

	}

	/**
	 * The constructor sets the initial values of the instance variable.
	 */
	public Street() {

		/*
		 * Write a line of code that calls the superclass constructor and sets the title
		 * of this application
		 */
		super("Street");

		int width = 600;
		int labelHeight = 80;
		int buttonPanelHeight = 100;
		int totalHeight = buttonPanelHeight + 3 * labelHeight;

		setLayout(new FlowLayout());

		background =  Color.LIGHT_GRAY; // set background to defaults

		promptJLabel = new JLabel("Click a button to add a vehicle.", JLabel.CENTER); // describe game
		promptJLabel.setPreferredSize(new Dimension(width, labelHeight));
		add(promptJLabel);

		addCarJButton = new JButton("Add Car");
		addBicycleJButton = new JButton("Add Bicycle");
		addTricycleJButton = new JButton("Add Tricycle");
		doneJButton = new JButton("Done");
		addCarJButton.addActionListener(buttonHandler);
		addBicycleJButton.addActionListener(buttonHandler);
		addTricycleJButton.addActionListener(buttonHandler);
		doneJButton.addActionListener(buttonHandler);
		buttonPanel.setSize(width, buttonPanelHeight);
		buttonPanel.setLayout(new GridLayout(1, 3, 10, 0));
		buttonPanel.add(addCarJButton);
		buttonPanel.add(addBicycleJButton);
		buttonPanel.add(addTricycleJButton);
		buttonPanel.add(doneJButton);
		add(buttonPanel);

		messageJLabel = new JLabel("No vehicles yet.", JLabel.CENTER);
		messageJLabel.setPreferredSize(new Dimension(width, labelHeight));
		add(messageJLabel);
		vehiclesJLabel = new JLabel(
				"<html>Cars: " + carNum + "<br/>Bicycles: " + bicycleNum + "<br/>Tricycles: " + tricycleNum + "</html>",
				JLabel.CENTER);
		vehiclesJLabel.setPreferredSize(new Dimension(width, labelHeight));
		add(vehiclesJLabel);

		setSize(width, totalHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Prints out the speed and sound of the vehicles in sorted and shuffled order.
	 */
	public void simulate() {
		if (vehicles.size() == 0)
			System.out.println("No Vehicles added.");
		else {
			for (int i = 0; i < 6; i++) {
				Iterator<Vehicle> iterator;
				Vehicle rand = vehicles.get(RANDOM_NUMBERS.nextInt(vehicles.size()));
				System.out.println("Update on the street " + i + ":");

				Collections.sort(vehicles, new VehicleComparator());
				iterator = vehicles.iterator();
				System.out.println("--- sorted:");
				while (iterator.hasNext()) {
					Vehicle v = iterator.next();
					System.out.println(v.VEHICLE_NAME + ", speed: " + v.speed + ", noise: " + v.makeNoise());
				}

				Collections.shuffle(vehicles);
				iterator = vehicles.iterator();
				System.out.println("--- shuffled:");
				while (iterator.hasNext()) {
					Vehicle v = iterator.next();
					System.out.println(v.VEHICLE_NAME + ", speed: " + v.speed + ", noise: " + v.makeNoise());
				}

				rand.pushPedal();
				System.out.println("Pedal of " + rand.VEHICLE_NAME + " was pushed");
				System.out.println();
			}
		}
	}

	/**
	 * Sets the background color of the Panel.
	 * 
	 * @param g
	 *            Instance of the Graphic Class.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		buttonPanel.setBackground(background);
		getContentPane().setBackground(background);
	}

	/**
	 * Adds Vehicles from the String array input/
	 * 
	 * @param s
	 *            An array of strings of Vehicles to add to the street.
	 */
	@Override
	public void parse(String[] s) {
		for (String str : s)
			if (str.equals("car"))
				vehicles.add(new Car());
			else if (str.equals("bicycle"))
				vehicles.add(new Bicycle());
			else if (str.equals("tricycle"))
				vehicles.add(new Tricycle());

	}

	/**
	 * Gets the total speed of all the Vehicles of the same type.
	 * 
	 * @return Sum of the speed of all Tricycles.
	 */
	public int getSumTricycleSpeeds() {
		int sum = 0;
		for (Vehicle v : vehicles)
			if (v instanceof Tricycle) {
				sum += v.speed;

			}
		return sum;
	}

	/**
	 * Gets the total speed of all the Vehicles of the same type.
	 * 
	 * @return Sum of the speed of all Bicycles.
	 */
	@Override
	public int getSumBicyleSpeeds() {
		int sum = 0;
		for (Vehicle v : vehicles)
			if (v instanceof Bicycle) {
				sum += v.speed;

			}
		return sum;
	}

	/**
	 * Gets the total speed of all the Vehicles of the same type.
	 * 
	 * @return Sum of the speed of all Cars.
	 */
	@Override
	public int getSumCarSpeeds() {
		int sum = 0;
		for (Vehicle v : vehicles)
			if (v instanceof Car) {
				sum += v.speed;

			}
		return sum;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            Main
	 */
	public static void main(String[] args) {
		Street theStreet = new Street();
		theStreet.setVisible(true);
		theStreet.setLocationRelativeTo(null);
	}
}
