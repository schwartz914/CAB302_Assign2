package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCustomername;
	private JTextField txtMobilenumber;
	private JTextField txtCustomertype;
	private JTextField txtLocation;
	private JTextField txtDistance;
	private JTextField txtType;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtCost;
	private JTextField txtProfit;
	private JTextField totalProfitF;
	private JTextField totalDistanceF;
	private JTextArea txtrWelcomeToPizza;
	private JComboBox<Integer> customerComboBox;
	private PizzaRestaurant restaurant;
	private boolean pizzaLoaded;
	
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TODO
		restaurant = new PizzaRestaurant();
		pizzaLoaded = false;
		
		
		// ----- Create JFrame ----- 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 699, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//--------------------------------------------------
		
		
		// ----- Create JPanel's To Hold Pizza and Customer Data ----- 
		JPanel panel = new JPanel();
		panel.setBounds(24, 127, 258, 260);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(403, 127, 258, 260);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 450, 252, 69);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		//--------------------------------------------------
		
		
		// ----- Create and Add Labels ----- 		
		Label Heading = new Label("WELCOME TO PIZZA GUI");
		Heading.setAlignment(Label.CENTER);
		Heading.setBounds(265, 10, 140, 22);
		contentPane.add(Heading);
		//--------------------------------------------------
		
		
		// ----- Create and Add JLabels -----
		JLabel customerNameL = new JLabel("Customer Name:");
		customerNameL.setBounds(40, 14, 100, 14);
		panel.add(customerNameL);
		
		JLabel mobileNumberL = new JLabel("Mobile Number:");
		mobileNumberL.setBounds(40, 66, 90, 14);
		panel.add(mobileNumberL);
		
		JLabel CustomerTypeL = new JLabel("Customer Type:");
		CustomerTypeL.setBounds(40, 116, 90, 14);
		panel.add(CustomerTypeL);
		
		JLabel xyLocL = new JLabel("X and Y Location:");
		xyLocL.setBounds(20, 172, 150, 14);
		panel.add(xyLocL);
		
		JLabel distRestL = new JLabel("Distance (restaurant):");
		distRestL.setBounds(10, 216, 150, 30);
		panel.add(distRestL);
		
		JLabel pizzaTypeL = new JLabel("Pizza Type:");
		pizzaTypeL.setBounds(56, 15, 80, 14);
		panel_1.add(pizzaTypeL);
		
		JLabel Quantity = new JLabel("Quantity:");
		Quantity.setBounds(65, 67, 80, 14);
		panel_1.add(Quantity);
		
		JLabel lblOrderPrice = new JLabel("Order Price:");
		lblOrderPrice.setBounds(55, 117, 80, 14);
		panel_1.add(lblOrderPrice);
		
		JLabel lblOrdercost = new JLabel("OrderCost:");
		lblOrdercost.setBounds(59, 172, 80, 14);
		panel_1.add(lblOrdercost);
		
		JLabel lblOrderProfit = new JLabel("Order Profit:");
		lblOrderProfit.setBounds(52, 220, 80, 23);
		panel_1.add(lblOrderProfit);
		
		JLabel customerHeadingL = new JLabel("Customer Information");
		customerHeadingL.setBounds(99, 107, 130, 14);
		contentPane.add(customerHeadingL);
		
		JLabel orderHeadingL = new JLabel("Order Information");
		orderHeadingL.setBounds(489, 107, 120, 14);
		contentPane.add(orderHeadingL);
		
		JLabel lblCustomerNumber = new JLabel("Select Customer:");
		lblCustomerNumber.setBounds(299, 127, 100, 14);
		contentPane.add(lblCustomerNumber);
		
		JLabel lblTotalCustomers = new JLabel("Total Customers:");
		lblTotalCustomers.setBounds(299, 197, 120, 14);
		contentPane.add(lblTotalCustomers);
		
		JLabel lblCustomerTot = new JLabel("0");
		lblCustomerTot.setEnabled(false);
		lblCustomerTot.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerTot.setBounds(324, 222, 46, 14);
		contentPane.add(lblCustomerTot);		
		
		JLabel lblTotalProfit = new JLabel("Total Profit:");
		lblTotalProfit.setBounds(10, 14, 84, 14);
		panel_2.add(lblTotalProfit);
		
		JLabel lblTotalDistance = new JLabel("Total Distance Travelled:");
		lblTotalDistance.setBounds(10, 41, 125, 14);
		panel_2.add(lblTotalDistance);
		
		JLabel lblOrderCalculations = new JLabel("Order Calculations");
		lblOrderCalculations.setBounds(99, 431, 140, 14);
		contentPane.add(lblOrderCalculations);
		
		JLabel lblTaskReport = new JLabel("Task Report");
		lblTaskReport.setBounds(511, 437, 90, 14);
		contentPane.add(lblTaskReport);
		//--------------------------------------------------
		
		
		// ----- Create and Add JComboBox -----
		customerComboBox = new JComboBox<Integer>();
		customerComboBox.setEnabled(false);
		customerComboBox.setBounds(297, 152, 100, 22);
		contentPane.add(customerComboBox);
		//--------------------------------------------------
		
		
		// ----- Create and Add JTextArea -----		
		JTextArea txtrWelcomeToPizza = new JTextArea();
		txtrWelcomeToPizza.setEditable(false);
		txtrWelcomeToPizza.setText("Welcome to Pizza GUI");
		txtrWelcomeToPizza.setBounds(403, 462, 258, 90);
		contentPane.add(txtrWelcomeToPizza);
		//--------------------------------------------------
		
		
		// ----- Create and Add TextFields ----- 		
		txtCustomername = new JTextField();
		txtCustomername.setText("Name");
		txtCustomername.setToolTipText("");
		txtCustomername.setEditable(false);
		txtCustomername.setColumns(10);
		txtCustomername.setBounds(134, 11, 86, 20);
		panel.add(txtCustomername);
		
		txtMobilenumber = new JTextField();
		txtMobilenumber.setText("Number");
		txtMobilenumber.setEditable(false);
		txtMobilenumber.setColumns(10);
		txtMobilenumber.setBounds(134, 63, 86, 20);
		panel.add(txtMobilenumber);
		
		txtCustomertype = new JTextField();
		txtCustomertype.setText("CustomerType");
		txtCustomertype.setEditable(false);
		txtCustomertype.setColumns(10);
		txtCustomertype.setBounds(134, 113, 86, 20);
		panel.add(txtCustomertype);
		
		txtLocation = new JTextField();
		txtLocation.setText("Location");
		txtLocation.setEditable(false);
		txtLocation.setColumns(10);
		txtLocation.setBounds(134, 169, 86, 20);
		panel.add(txtLocation);
		
		txtDistance = new JTextField();
		txtDistance.setText("Distance");
		txtDistance.setEditable(false);
		txtDistance.setColumns(10);
		txtDistance.setBounds(134, 221, 86, 20);
		panel.add(txtDistance);		
			
		txtType = new JTextField();
		txtType.setText("Type");
		txtType.setEditable(false);
		txtType.setColumns(10);
		txtType.setBounds(134, 11, 86, 20);
		panel_1.add(txtType);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity");
		txtQuantity.setEditable(false);
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(134, 63, 86, 20);
		panel_1.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setText("Price");
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(134, 113, 86, 20);
		panel_1.add(txtPrice);
		
		txtCost = new JTextField();
		txtCost.setText("Cost");
		txtCost.setEditable(false);
		txtCost.setColumns(10);
		txtCost.setBounds(134, 169, 86, 20);
		panel_1.add(txtCost);
		
		txtProfit = new JTextField();
		txtProfit.setText("Profit");
		txtProfit.setEditable(false);
		txtProfit.setColumns(10);
		txtProfit.setBounds(134, 221, 86, 20);
		panel_1.add(txtProfit);		
		
		totalProfitF = new JTextField();
		totalProfitF.setEditable(false);
		totalProfitF.setColumns(10);
		totalProfitF.setBounds(151, 11, 86, 20);
		panel_2.add(totalProfitF);		
		
		totalDistanceF = new JTextField();
		totalDistanceF.setEditable(false);
		totalDistanceF.setColumns(10);
		totalDistanceF.setBounds(151, 38, 86, 20);
		panel_2.add(totalDistanceF);
		//--------------------------------------------------
		
		
		// ----- Add buttons and click events ----- 		
		JButton btnCalculateTotals = new JButton("Calculate Totals");
		btnCalculateTotals.setEnabled(false);
		btnCalculateTotals.setBounds(79, 530, 135, 23);
		contentPane.add(btnCalculateTotals);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.setBounds(364, 33, 70, 23);
		contentPane.add(btnReset);
		
		JButton btnLoadOrderInfo = new JButton("Load Order Info");
		btnLoadOrderInfo.setEnabled(false);
		btnLoadOrderInfo.setBounds(478, 392, 114, 23);
		contentPane.add(btnLoadOrderInfo);
		
		JButton btnLoadCustomerInfo = new JButton("Load Customer Info");
		btnLoadCustomerInfo.setBounds(79, 398, 135, 23);
		btnLoadCustomerInfo.setEnabled(false);
		contentPane.add(btnLoadCustomerInfo);
		
		JButton loadLogFileB = new JButton("Load Log File");
		loadLogFileB.setBounds(240, 33, 114, 23);
		contentPane.add(loadLogFileB);
		//--------------------------------------------------
		
		
		// ----- Add Button Listeners -----		
		btnCalculateTotals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Change fields to correct values
				totalProfitF.setText(Double.toString(restaurant.getTotalProfit()));
				totalDistanceF.setText(Double.toString(restaurant.getTotalDeliveryDistance()));
				
				//Disable button
				btnCalculateTotals.setEnabled(false);
			}
		});		
		
		btnLoadOrderInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Change values of fields to correct values
				
				// TODO
				//If load correctly output:
				txtrWelcomeToPizza.setText("Successfully loaded order info! :)");
				//If error output:
				txtrWelcomeToPizza.setText("Error loading the order info! :(");
				
				//Activate other components
				btnLoadOrderInfo.setEnabled(false);
				pizzaLoaded = true;
			}
		});		
		
		btnLoadCustomerInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Customer currentCustomer = null;
				int customerIndex;
				
				// Add every index to ComboBox
				int numberCustomers = restaurant.getNumCustomerOrders();
				lblCustomerTot.setText(Integer.toString(numberCustomers));
				for(int i = 1; i <= numberCustomers; i++){
					customerComboBox.addItem(i);
				}
				
				// Get the current selected customer
				customerIndex = customerComboBox.getSelectedIndex();
				try {
					currentCustomer = restaurant.getCustomerByIndex(customerIndex);

					// Change values of fields to correct values
					txtCustomername.setText(currentCustomer.getName());
					txtMobilenumber.setText(currentCustomer.getMobileNumber());
					txtCustomertype.setText(currentCustomer.getCustomerType());
					txtLocation.setText(Integer.toString(currentCustomer.getLocationX()) + ", " + Integer.toString(currentCustomer.getLocationY()));
					txtDistance.setText(Double.toString(currentCustomer.getDeliveryDistance()));
					//If load correctly output:
					txtrWelcomeToPizza.setText("Successfully loaded customer info! :)");
					
				} catch (CustomerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//If error output:
					txtrWelcomeToPizza.setText("Error loading the customer info! :(");
				}					
								
				//Activate other components
				btnLoadCustomerInfo.setEnabled(false);
				customerComboBox.setEnabled(true);
			}
		});
		
		customerComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// Update Customer Fields
				updateCustomerField();
				
				// Update Order fields IF LOADED
				if (pizzaLoaded){
					updateOrderField();
				}
			}
		});
		
		loadLogFileB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String filename = openFileChooser(arg0);
				
			// Run program on the file
				// TODO
				try {
					restaurant.processLog(filename);
					//If load correctly output:
					txtrWelcomeToPizza.setText("Successfully loaded the log file! :)");
				} catch (CustomerException | PizzaException | LogHandlerException e) {
					// TODO Auto-generated catch block
					//If error output:
					txtrWelcomeToPizza.setText("Error loading the log file! :(");
					e.printStackTrace();
				}
				
			//Activate other components
			loadLogFileB.setEnabled(false);
			btnLoadCustomerInfo.setEnabled(true);
			btnLoadOrderInfo.setEnabled(true);
			btnReset.setEnabled(true);
			btnCalculateTotals.setEnabled(true);
			}
		});
		
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Reset all the values to original
				txtCustomername.setText("Name");
				txtMobilenumber.setText("Number");
				txtCustomertype.setText("Type");
				txtDistance.setText("Distance");
				txtLocation.setText("Location");
				
				txtType.setText("Type");
				txtQuantity.setText("Quantity");
				txtPrice.setText("Price");
				txtCost.setText("Cost");
				txtProfit.setText("Proft");
				txtrWelcomeToPizza.setText("Welcome to Pizza GUI");
				
				//Disable all the buttons
				btnLoadCustomerInfo.setEnabled(false);
				btnLoadOrderInfo.setEnabled(false);
				btnReset.setEnabled(false);
				btnCalculateTotals.setEnabled(false);
				customerComboBox.setEnabled(false);
				//Enable load log file
				loadLogFileB.setEnabled(true);
				
				pizzaLoaded = false;
			}
		});
		//--------------------------------------------------
		
	}
	
	// Main Function, Creates the JFrame and GUI
	public static void main(String[] args) {
		try {
			PizzaGUI frame = new PizzaGUI("Pizza Gui");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// DONT KNOW WHEN OR WHY SHOULD USE THIS/ INCORPERATE WITH MAIN
	/*@Override
	public void run() {
		// TO DO
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaGUI frame = new PizzaGUI("Pizza Gui");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	// Method that updates Customer fields
	private void updateCustomerField(){
		
		Customer currentCustomer = null;
		int customerIndex;
		// Get the current selected customer
		customerIndex = customerComboBox.getSelectedIndex();
		try {
			currentCustomer = restaurant.getCustomerByIndex(customerIndex);
			// Change values of fields to correct values
			txtCustomername.setText(currentCustomer.getName());
			txtMobilenumber.setText(currentCustomer.getMobileNumber());
			txtCustomertype.setText(currentCustomer.getCustomerType());
			txtLocation.setText(Integer.toString(currentCustomer.getLocationX()) + ", " + Integer.toString(currentCustomer.getLocationY()));
			txtDistance.setText(Double.toString(currentCustomer.getDeliveryDistance()));
			//If load correctly output:
			txtrWelcomeToPizza.setText("Successfully loaded customer info! :)");
			
		} catch (CustomerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//If error output:
			txtrWelcomeToPizza.setText("Error loading the customer info! :(");
		}
	}
	
	// Method that updates Order Fields
	private void updateOrderField(){
		Pizza currentPizza = null;
		int pizzaIndex;
		// Get the current selected customer
		pizzaIndex = customerComboBox.getSelectedIndex();
		
		try {
			currentPizza = restaurant.getPizzaByIndex(pizzaIndex);
			// Change values of fields to correct values
			txtType.setText(currentPizza.getPizzaType());
			txtQuantity.setText(Integer.toString(currentPizza.getQuantity()));
			txtPrice.setText(Double.toString(currentPizza.getOrderPrice()));
			txtCost.setText(Double.toString(currentPizza.getOrderCost()));
			txtProfit.setText(Double.toString(currentPizza.getOrderProfit()));
			//If load correctly output:
			txtrWelcomeToPizza.setText("Successfully loaded customer info! :)");
			
		} catch (PizzaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//If error output:
			txtrWelcomeToPizza.setText("Error loading the customer info! :(");
		}
	}
	
	
	// Method that creates/opens file chooser
	private String openFileChooser(ActionEvent arg0) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		String filename = "";
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			filename = file.getAbsolutePath();
		}else if(returnVal==JFileChooser.CANCEL_OPTION) {
		}
		
		return filename;		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}