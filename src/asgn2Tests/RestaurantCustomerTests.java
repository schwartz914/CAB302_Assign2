package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	// TO DO
	PizzaRestaurant restaurant1;
	PizzaRestaurant restaurant2;
	
	//Setup
	@Before
	public void setup() throws CustomerException {
		restaurant1 = new PizzaRestaurant();
		restaurant2 = new PizzaRestaurant();
	}
	
	// PizzaRestaurant.java Tests
		// --- PizzaResturant() Tests ---
		// Creates correct pizza restaurant object
		@Test
		public void correctObject() throws CustomerException {
			assertEquals(restaurant1.getClass(), PizzaRestaurant.class);
		}
		// Sets customer fields to initial state (empty state)
		@Test(expected = CustomerException.class)
		public void initialState() throws CustomerException {
			assertEquals(restaurant1.getNumCustomerOrders(), 0);
		}
		
		// --- processLog() Tests ---
		// Return true if file correctly processed
		@Test
		public void processedCorrectly() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("20170101.txt"));
		}
		// Return false if not
		// Throw LogHandlerException if problem with the log file not related to above
		@Test(expected = LogHandlerException.class)
		public void processedIncorrectly() throws CustomerException, PizzaException, LogHandlerException {
			assertFalse(restaurant2.processLog("notRealFile.txt"));
		}
		// Throw CustomerException if contains semantic errors violate 5.3:
		// Takes correct form (order-time, delivery-time, ...)
		// If order-time & delivery time incorrect format hh:mm:ss
		@Test(expected = CustomerException.class)
		public void deliveryTimeCorrectForm() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("delivery-timeWrongFormat.txt"));
		}
		@Test(expected = CustomerException.class)
		public void orderTimeCorrectForm() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("order-timeWrongFormat.txt"));
		}
		// Customer name doesn't contain a name
		//		Not just white spaces
		@Test(expected = CustomerException.class)
		public void nameNotSpaces() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-nameWrongFormat1.txt"));
		}
		//		No numbers
		@Test(expected = CustomerException.class)
		public void nameNotNumber() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-nameWrongFormat2.txt"));
		}
		// customer-number doesn't contain numbers
		//		Only Numbers
		@Test(expected = CustomerException.class)
		public void numberOnlyNumber() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-numberWrongFormat1.txt"));
		}
		//		No White spaces
		@Test(expected = CustomerException.class)
		public void numberNotSpaces() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-numberWrongFormat2.txt"));
		}
		// Customer code incorrect
		@Test(expected = CustomerException.class)
		public void incorrectCustomerCode() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-codeWrongFormat.txt"));
		}
		// x location don't represent blocks from restaurant
		@Test(expected = CustomerException.class)
		public void xLocationNotBlocks() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-x-locationWrongFormat1.txt"));
		}
		// y location don't represent blocks from restaurant
		@Test(expected = CustomerException.class)
		public void yLocationsNotBlocks() throws CustomerException, PizzaException, LogHandlerException {
			assertTrue(restaurant2.processLog("customer-y-locationWrongFormat1.txt"));
		}

		// --- getCustomerByIndex() Tests ---
		// Index the same as in the log file & Returns correct customer
		@Test
		public void sameCustomerIndexing() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101");
			assertEquals(restaurant2.getCustomerByIndex(0).getName(), "Casey Jones");
			assertEquals(restaurant2.getCustomerByIndex(1).getName(), "April O'Neal");
			assertEquals(restaurant2.getCustomerByIndex(2).getName(), "Oroku Saki");
		}
		// Throws CustomerException if the index is invalid
		@Test(expected = CustomerException.class)
		public void indexInvalid() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101.txt");
			assertEquals(restaurant2.getCustomerByIndex(6), 0);
		}
		
		// --- getNumCustomerOrders() Tests ---
		// Return the correct number of objects in customer field
		@Test
		public void numCustomerOrders() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101.txt");
			assertEquals(restaurant2.getNumCustomerOrders(), 3);
		}
		// Test same value as getNumPizzaOrders()
		@Test
		public void numPizzaCustomerSame() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101.txt");
			assertEquals(restaurant2.getNumCustomerOrders(), restaurant2.getNumPizzaOrders());
		}
	
		// --- getTotalDeliveryDistance() Tests ---
		// Return correct total delivery distance for all customers
		@Test
		public void correctTotalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101.txt");
			double expectedValue = restaurant2.getCustomerByIndex(0).getDeliveryDistance() + restaurant2.getCustomerByIndex(1).getDeliveryDistance() + restaurant2.getCustomerByIndex(2).getDeliveryDistance();
			assertEquals(restaurant2.getTotalDeliveryDistance(), expectedValue, 0);
		}
		
		
		// --- resetDetails() Tests ---
		// Correctly resets customer field to initial empty state
		@Test(expected = CustomerException.class)
		public void resetDetails() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.resetDetails();
			restaurant2.processLog("20170101.txt");
			restaurant2.resetDetails();
			assertEquals(restaurant2.getNumCustomerOrders(), 0);
		}
}
