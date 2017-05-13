package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	
	
	// LogHandler.java Tests
		// --- populateCustomerDataset() Tests ---
		// Test returns array list of customer objects from information log file
		// Returns customers in same order as log file
		
		// Throw CustomerException if contains semantic errors violate 5.3:
		// Takes correct form (order-time, delivery-time, ...)
		// If order-time & delivery time incorrect format hh:mm:ss
		@Test(expected = CustomerException.class)
		public void deliveryTimeCorrectForm() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("delivery-timeWrongFormat.txt"), Customer.class);
		}
		@Test(expected = CustomerException.class)
		public void orderTimeCorrectForm() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("order-timeWrongFormat.txt"), Customer.class);
		}
		// Customer name doesn't contain a name
		//		Not just white spaces
		@Test(expected = CustomerException.class)
		public void nameNotSpaces() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-nameWrongFormat1.txt"), Customer.class);
		}
		//		No numbers
		@Test(expected = CustomerException.class)
		public void nameNotNumber() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-nameWrongFormat2.txt"), Customer.class);
		}
		// customer-number doesn't contain numbers
		//		Only Numbers
		@Test(expected = CustomerException.class)
		public void numberOnlyNumber() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-numberWrongFormat1.txt"), Customer.class);
		}
		//		No White spaces
		@Test(expected = CustomerException.class)
		public void numberNotSpaces() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-numberWrongFormat2.txt"), Customer.class);
		}
		// Customer code incorrect
		@Test(expected = CustomerException.class)
		public void incorrectCustomerCode() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-codeWrongFormat.txt"), Customer.class);
		}
		// x location don't represent blocks from restaurant
		@Test(expected = CustomerException.class)
		public void xLocationNotBlocks() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-x-locationWrongFormat1.txt"), Customer.class);
		}
		// y location don't represent blocks from restaurant
		@Test(expected = CustomerException.class)
		public void yLocationsNotBlocks() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("customer-y-locationWrongFormat1.txt"), Customer.class);
		}
		// Throw LogHandlerException if problem with the log file not related to above
		@Test(expected = LogHandlerException.class)
		public void processedIncorrectly() throws CustomerException, PizzaException, LogHandlerException {
			assertEquals(LogHandler.populateCustomerDataset("notRealFile.txt"), Customer.class);
		}
		// Fields not of correct type (8.1.1)
		
		// --- createCustomer() Tests ---
		// Creates customer object from single line of log file
		public void createsCustomer() throws CustomerException, PizzaException, LogHandlerException {
			String lineFromLogFile = "20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1";
			assertEquals(LogHandler.createCustomer(lineFromLogFile), Customer.class);
		}
		// Returns customer object
		// Throws customer exception for same reason above (5.3)
		// Throws logHandlerException if problem parsing the line from log file
		@Test(expected = LogHandlerException.class)
		public void problemParsing() throws CustomerException, PizzaException, LogHandlerException {
			String lineFromLogFile = "20:00:00,20:25:00 April O'Neal,0987654321,DNC,3,4,PZM,1";
			assertEquals(LogHandler.createCustomer(lineFromLogFile), Customer.class);
		}

	
}
