package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;


import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;



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
	private PizzaRestaurant restaurant;
	private JTextArea txtrWelcomeToPizza;
	private JButton btnPreviousRecord;
	private JButton btnNextRecord;
	private JButton btnReset;
	private JButton btnCalculateTotals;
	private JButton loadLogFileB;
	private JComboBox<String> customerComboBox;
	private JLabel numCustomers;
	private JLabel customerNumber;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		restaurant = new PizzaRestaurant();
		
		// ---- Create the Frame and main JPanel ----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 699, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//--------------------------------------------------
		
		// ---- Create JPanel's ----
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
		
		// ---- Create Label's/JLabel's ----		
		Label Heading = new Label("WELCOME TO PIZZA GUI");
		Heading.setAlignment(Label.CENTER);
		Heading.setBounds(265, 10, 140, 22);
		contentPane.add(Heading);
		
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
		
		JLabel lblRecordNumber = new JLabel("Record Number:");
		lblRecordNumber.setBounds(299,250,120,14);
		contentPane.add(lblRecordNumber);
		
		JLabel lblTotalProfit = new JLabel("Total Profit:");
		lblTotalProfit.setBounds(10, 14, 84, 14);
		panel_2.add(lblTotalProfit);
		
		JLabel lblTotalDistance = new JLabel("Total Distance Travelled:");
		lblTotalDistance.setBounds(10, 41, 125, 14);
		panel_2.add(lblTotalDistance);
		
		numCustomers = new JLabel("0");
		numCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		numCustomers.setBounds(324, 222, 46, 14);
		contentPane.add(numCustomers);
		
		customerNumber = new JLabel("0");
		customerNumber.setHorizontalAlignment(SwingConstants.CENTER);
		customerNumber.setBounds(324, 275, 46, 14);
		contentPane.add(customerNumber);
		
		JLabel lblOrderCalculations = new JLabel("Order Calculations");
		lblOrderCalculations.setBounds(99, 431, 140, 14);
		contentPane.add(lblOrderCalculations);
		
		JLabel lblTaskReport = new JLabel("Task Report");
		lblTaskReport.setBounds(511, 437, 90, 14);
		contentPane.add(lblTaskReport);
		//--------------------------------------------------
		
		// ---- Create JTextField's ----
		txtCustomername = new JTextField();
		txtCustomername.setText("Customername");
		txtCustomername.setToolTipText("");
		txtCustomername.setEditable(false);
		txtCustomername.setColumns(10);
		txtCustomername.setBounds(134, 11, 86, 20);
		panel.add(txtCustomername);
		
		txtMobilenumber = new JTextField();
		txtMobilenumber.setText("Mobilenumber");
		txtMobilenumber.setEditable(false);
		txtMobilenumber.setColumns(10);
		txtMobilenumber.setBounds(134, 63, 86, 20);
		panel.add(txtMobilenumber);
		
		txtCustomertype = new JTextField();
		txtCustomertype.setText("Customertype");
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
		totalProfitF.setText("0");
		totalProfitF.setBounds(151, 11, 86, 20);
		panel_2.add(totalProfitF);
		
		totalDistanceF = new JTextField();
		totalDistanceF.setEditable(false);
		totalDistanceF.setColumns(10);
		totalDistanceF.setText("0");
		totalDistanceF.setBounds(151, 38, 86, 20);
		panel_2.add(totalDistanceF);
		//--------------------------------------------------
		
		// ---- Create JComboBox ----
		customerComboBox = new JComboBox<String>();
		customerComboBox.setEnabled(false);
		customerComboBox.setBounds(297, 152, 100, 22);
		contentPane.add(customerComboBox);
		customerComboBox.addActionListener(this);
		//--------------------------------------------------
		
		// ---- Create JTextArea ----
		txtrWelcomeToPizza = new JTextArea();
		txtrWelcomeToPizza.setEditable(false);
		txtrWelcomeToPizza.setLineWrap(true);
		txtrWelcomeToPizza.setText("Welcome to Pizza GUI");
		txtrWelcomeToPizza.setBounds(403, 462, 258, 90);
		contentPane.add(txtrWelcomeToPizza);
		//--------------------------------------------------
		
		// ---- Create JButton's ----
		btnCalculateTotals = new JButton("Calculate Totals");
		btnCalculateTotals.addActionListener(this);
		btnCalculateTotals.setEnabled(false);
		btnCalculateTotals.setBounds(79, 530, 135, 23);
		contentPane.add(btnCalculateTotals);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setEnabled(false);
		btnReset.setBounds(364, 33, 70, 23);
		contentPane.add(btnReset);
		
		btnNextRecord = new JButton("Next >>");
		btnNextRecord.addActionListener(this);
		btnNextRecord.setEnabled(false);
		btnNextRecord.setBounds(478, 392, 114, 23);
		contentPane.add(btnNextRecord);
		
		btnPreviousRecord = new JButton("<< Previous");
		btnPreviousRecord.setBounds(79, 392, 135, 23);
		btnPreviousRecord.setEnabled(false);
		contentPane.add(btnPreviousRecord);
		btnPreviousRecord.addActionListener(this);
		
		loadLogFileB = new JButton("Load Log File");
		loadLogFileB.addActionListener(this);
		loadLogFileB.setEnabled(true);
		loadLogFileB.setBounds(240, 33, 114, 23);
		contentPane.add(loadLogFileB);
		

		//--------------------------------------------------	
				
		
		// ---- Make the GUI Visible ----
		setVisible(true);
		//--------------------------------------------------
	}	
	
	// Method that creates/opens file chooser
	private String openFileChooser(ActionEvent arg0) {
		String myPath = ".\\logs\\";
		final JFileChooser fc = new JFileChooser(myPath);
		int returnVal = fc.showOpenDialog(this);
		String filename = "";
		if(returnVal==JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			filename = file.getAbsolutePath();
		}else {
			filename = null;
		}
		
		return filename;		
	}



	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if(command == "Reset") {
			resetGUI();
		} else if(command == "Load Log File") {
			loadLogFileButton(arg0);
		} else if(command == "<< Previous" || command == "Next >>" || command == "comboBoxChanged") {
			processRecord(command);
		} else if(command == "Calculate Totals") {
			calculateTotalsButton();
		}

	}
	
	private void loadLogFileButton(ActionEvent arg0) {
		try {
			String filename = openFileChooser(arg0);
			
		// Run program on the file if the user selects an option.
			if(filename != null) {
				restaurant.processLog(filename);
				//If load correctly output:
				txtrWelcomeToPizza.setText("Successfully loaded the log file! :)");
				numCustomers.setText(Integer.toString(restaurant.getNumCustomerOrders()));
		
				customerComboBox.removeAllItems();
						
				for(int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
					customerComboBox.addItem(restaurant.getCustomerByIndex(i).getName());
				}
				
				//Activate other components
				loadLogFileB.setEnabled(false);
				btnPreviousRecord.setEnabled(true);
				btnNextRecord.setEnabled(true);
				btnReset.setEnabled(true);
				btnCalculateTotals.setEnabled(true);
				customerComboBox.setEnabled(true);
			
			} //end if
		
		} catch (LogHandlerException | CustomerException | PizzaException e) {
			txtrWelcomeToPizza.setText(e.getMessage());
		}
	}
	
	
	private void processRecord(String buttonPress) {
		int value;
		if(buttonPress.equals("<< Previous")) {
			if(customerComboBox.getSelectedIndex() == 0) {
				value = customerComboBox.getItemCount()-1;
			} else {
				value = customerComboBox.getSelectedIndex()-1;
			}
			customerComboBox.setSelectedIndex(value);
		} else if(buttonPress.equals("Next >>")) {
			if(customerComboBox.getSelectedIndex() == customerComboBox.getItemCount()-1) {
				value = 0;
			} else {
				value = customerComboBox.getSelectedIndex()+1;
			}
			customerComboBox.setSelectedIndex(value);
		} else {
			value = customerComboBox.getSelectedIndex();
		}
		
		
		try {
			txtCustomername.setText(restaurant.getCustomerByIndex(value).getName());
			txtMobilenumber.setText(restaurant.getCustomerByIndex(value).getMobileNumber());
			txtCustomertype.setText(restaurant.getCustomerByIndex(value).getCustomerType());
			txtLocation.setText(restaurant.getCustomerByIndex(value).getLocationX() + ", " + restaurant.getCustomerByIndex(value).getLocationY());
			txtDistance.setText(Double.toString(restaurant.getCustomerByIndex(value).getDeliveryDistance()));
			txtType.setText(restaurant.getPizzaByIndex(value).getPizzaType());
			txtQuantity.setText(Integer.toString(restaurant.getPizzaByIndex(value).getQuantity()));
			txtPrice.setText(Double.toString(restaurant.getPizzaByIndex(value).getOrderPrice()));
			txtCost.setText(Double.toString(restaurant.getPizzaByIndex(value).getOrderCost()));
			txtProfit.setText(Double.toString(restaurant.getPizzaByIndex(value).getOrderProfit()));
			txtrWelcomeToPizza.setText("Successfully loaded Record info! :)");
			customerNumber.setText(Integer.toString(value));
		} catch(PizzaException | CustomerException e) {
			txtrWelcomeToPizza.setText("Error loading the Records info! :( :" + e.getMessage());
		}


	}
	
	private void calculateTotalsButton() {

		BigDecimal profit = new BigDecimal(restaurant.getTotalProfit());
		BigDecimal distance = new BigDecimal(restaurant.getTotalDeliveryDistance());
		profit = profit.setScale(2, RoundingMode.HALF_UP);
		distance = distance.setScale(2, RoundingMode.HALF_UP);
		totalProfitF.setText(profit.toString());
		totalDistanceF.setText(distance.toString());

		}
	
	private void resetGUI() {
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
		
		totalProfitF.setText("0");
		totalDistanceF.setText("0");
		
		//Disable all the buttons
		btnPreviousRecord.setEnabled(false);
		btnNextRecord.setEnabled(false);
		btnReset.setEnabled(false);
		btnCalculateTotals.setEnabled(false);
		customerComboBox.setEnabled(false);
		//Enable load log file
		loadLogFileB.setEnabled(true);
		restaurant.resetDetails();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}