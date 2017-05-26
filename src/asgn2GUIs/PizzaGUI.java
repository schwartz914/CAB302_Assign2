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
	
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		restaurant = new PizzaRestaurant();
		//Create frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 699, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label Heading = new Label("WELCOME TO PIZZA GUI");
		Heading.setAlignment(Label.CENTER);
		Heading.setBounds(265, 10, 140, 22);
		contentPane.add(Heading);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 127, 258, 260);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCustomername = new JTextField();
		txtCustomername.setText("txtCustomername");
		txtCustomername.setToolTipText("");
		txtCustomername.setEditable(false);
		txtCustomername.setColumns(10);
		txtCustomername.setBounds(134, 11, 86, 20);
		panel.add(txtCustomername);
		
		txtMobilenumber = new JTextField();
		txtMobilenumber.setText("txtMobilenumber");
		txtMobilenumber.setEditable(false);
		txtMobilenumber.setColumns(10);
		txtMobilenumber.setBounds(134, 63, 86, 20);
		panel.add(txtMobilenumber);
		
		txtCustomertype = new JTextField();
		txtCustomertype.setText("txtCustomertype");
		txtCustomertype.setEditable(false);
		txtCustomertype.setColumns(10);
		txtCustomertype.setBounds(134, 113, 86, 20);
		panel.add(txtCustomertype);
		
		txtLocation = new JTextField();
		txtLocation.setText("txtLocation");
		txtLocation.setEditable(false);
		txtLocation.setColumns(10);
		txtLocation.setBounds(134, 169, 86, 20);
		panel.add(txtLocation);
		
		txtDistance = new JTextField();
		txtDistance.setText("txtDistance");
		txtDistance.setEditable(false);
		txtDistance.setColumns(10);
		txtDistance.setBounds(134, 221, 86, 20);
		panel.add(txtDistance);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(403, 127, 258, 260);
		contentPane.add(panel_1);
		
		txtType = new JTextField();
		txtType.setText("txtType");
		txtType.setEditable(false);
		txtType.setColumns(10);
		txtType.setBounds(134, 11, 86, 20);
		panel_1.add(txtType);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("txtQuantity");
		txtQuantity.setEditable(false);
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(134, 63, 86, 20);
		panel_1.add(txtQuantity);
		
		txtPrice = new JTextField();
		txtPrice.setText("txtPrice");
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(134, 113, 86, 20);
		panel_1.add(txtPrice);
		
		txtCost = new JTextField();
		txtCost.setText("txtCost");
		txtCost.setEditable(false);
		txtCost.setColumns(10);
		txtCost.setBounds(134, 169, 86, 20);
		panel_1.add(txtCost);
		
		txtProfit = new JTextField();
		txtProfit.setText("txtProfit");
		txtProfit.setEditable(false);
		txtProfit.setColumns(10);
		txtProfit.setBounds(134, 221, 86, 20);
		panel_1.add(txtProfit);
		
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
		
		JComboBox<String> customerComboBox = new JComboBox<String>();
		customerComboBox.setEnabled(false);
		customerComboBox.setBounds(297, 152, 100, 22);
		contentPane.add(customerComboBox);
		
		JLabel lblCustomerNumber = new JLabel("Select Customer:");
		lblCustomerNumber.setBounds(299, 127, 100, 14);
		contentPane.add(lblCustomerNumber);
		
		JLabel lblTotalCustomers = new JLabel("Total Customers:");
		lblTotalCustomers.setBounds(299, 197, 120, 14);
		contentPane.add(lblTotalCustomers);
		
		JLabel label = new JLabel("0");
		label.setEnabled(false);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(324, 222, 46, 14);
		contentPane.add(label);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 450, 252, 69);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTotalProfit = new JLabel("Total Profit:");
		lblTotalProfit.setBounds(10, 14, 84, 14);
		panel_2.add(lblTotalProfit);
		
		totalProfitF = new JTextField();
		totalProfitF.setEditable(false);
		totalProfitF.setColumns(10);
		totalProfitF.setBounds(151, 11, 86, 20);
		panel_2.add(totalProfitF);
		
		JLabel lblTotalDistance = new JLabel("Total Distance Travelled:");
		lblTotalDistance.setBounds(10, 41, 125, 14);
		panel_2.add(lblTotalDistance);
		
		totalDistanceF = new JTextField();
		totalDistanceF.setEditable(false);
		totalDistanceF.setColumns(10);
		totalDistanceF.setBounds(151, 38, 86, 20);
		panel_2.add(totalDistanceF);
		
		JButton btnCalculateTotals = new JButton("Calculate Totals");
		btnCalculateTotals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Change fields to correct values
				
				//Disable button
				btnCalculateTotals.setEnabled(false);
			}
		});
		btnCalculateTotals.setEnabled(false);
		btnCalculateTotals.setBounds(79, 530, 135, 23);
		contentPane.add(btnCalculateTotals);
		
		JLabel lblOrderCalculations = new JLabel("Order Calculations");
		lblOrderCalculations.setBounds(99, 431, 140, 14);
		contentPane.add(lblOrderCalculations);
		
		JTextArea txtrWelcomeToPizza = new JTextArea();
		txtrWelcomeToPizza.setEditable(false);
		txtrWelcomeToPizza.setText("Welcome to Pizza GUI");
		txtrWelcomeToPizza.setBounds(403, 462, 258, 90);
		contentPane.add(txtrWelcomeToPizza);
		
		JLabel lblTaskReport = new JLabel("Task Report");
		lblTaskReport.setBounds(511, 437, 90, 14);
		contentPane.add(lblTaskReport);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.setBounds(364, 33, 70, 23);
		contentPane.add(btnReset);
		
		JButton btnLoadOrderInfo = new JButton("Load Order Info");
		btnLoadOrderInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value = customerComboBox.getSelectedIndex();
				// Change values of fields to correct values
				try {
					txtType.setText(restaurant.getPizzaByIndex(value).getPizzaType());
					txtQuantity.setText(Integer.toString(restaurant.getPizzaByIndex(value).getQuantity()));
					txtPrice.setText(Double.toString(restaurant.getPizzaByIndex(value).getOrderPrice()));
					txtCost.setText(Double.toString(restaurant.getPizzaByIndex(value).getOrderCost()));
					txtProfit.setText(Double.toString(restaurant.getPizzaByIndex(value).getOrderProfit()));
					
				} catch(PizzaException pe) {
					
				}
				// TODO
				//If load correctly output:
				txtrWelcomeToPizza.setText("Successfully loaded order info! :)");
				//If error output:
				txtrWelcomeToPizza.setText("Error loading the order info! :(");
				
				//Activate other components
				
			}
		});
		btnLoadOrderInfo.setEnabled(false);
		btnLoadOrderInfo.setBounds(478, 392, 114, 23);
		contentPane.add(btnLoadOrderInfo);
		
		JButton btnLoadCustomerInfo = new JButton("Load Customer Info");
		btnLoadCustomerInfo.setBounds(79, 398, 135, 23);
		btnLoadCustomerInfo.setEnabled(false);
		contentPane.add(btnLoadCustomerInfo);
		btnLoadCustomerInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int value = customerComboBox.getSelectedIndex();
				//if(restaurant.getCustomerByIndex(value).getCustomerType() == )
				// Change values of fields to correct values
				
				try {
					txtCustomername.setText(restaurant.getCustomerByIndex(value).getName());
					txtMobilenumber.setText(restaurant.getCustomerByIndex(value).getMobileNumber());
					txtCustomertype.setText(restaurant.getCustomerByIndex(value).getCustomerType());
					txtLocation.setText(restaurant.getCustomerByIndex(value).getLocationX() + ", " + restaurant.getCustomerByIndex(value).getLocationY());
					txtDistance.setText(Double.toString(restaurant.getCustomerByIndex(value).getDeliveryDistance()));
				} catch (CustomerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Change the customer number selector to values
				
				//Change the total customers to values
				// TODO
				//If load correctly output:
				txtrWelcomeToPizza.setText("Successfully loaded customer info! :)");
				//If error output:
				txtrWelcomeToPizza.setText("Error loading the customer info! :(");
				
				//Activate other components
				
			}
		});
		
		JButton loadLogFileB = new JButton("Load Log File");
		loadLogFileB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String filename = openFileChooser(arg0);
				
			// Run program on the file if the user selects an option.
				if(filename != null) {
				try {
					restaurant.processLog(filename);
					//If load correctly output:
					txtrWelcomeToPizza.setText("Successfully loaded the log file! :)");
				} catch (CustomerException |  LogHandlerException e) {
					// TODO Auto-generated catch block
					//If error output:
					txtrWelcomeToPizza.setText("Error loading the log file! :(");
					e.printStackTrace();
				} catch(PizzaException e) {
					txtrWelcomeToPizza.setText(e.toString());
				}
				
				
				for(int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
						try {
							customerComboBox.addItem(restaurant.getCustomerByIndex(i).getName());
						} catch (CustomerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
				//Activate other components
				loadLogFileB.setEnabled(false);
				btnLoadCustomerInfo.setEnabled(true);
				btnLoadOrderInfo.setEnabled(true);
				btnReset.setEnabled(true);
				btnCalculateTotals.setEnabled(true);
				customerComboBox.setEnabled(true);
				
				} //end if
			}
		});
		loadLogFileB.setBounds(240, 33, 114, 23);
		contentPane.add(loadLogFileB);
		
		//Mouse Listeners
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