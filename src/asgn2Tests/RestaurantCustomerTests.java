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
		//Return true if file correctly processed
		// Return false if not
		// Throw CustomerException if contains semantic errors violate 5.3:
		// Takes correct form (order-time, delivery-time, ...)
		// If order-time & delivery time incorrect format hh:mm:ss
		// Customer name doesn't contain a name
		// customer-number doesn't contain a number
		// Customer code incorrect
		// X and y locations don't represent blocks from restaurant
		// Throw LogHandlerException if problem with the log file not related to above

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
			restaurant2.processLog("20170101");
			assertEquals(restaurant2.getCustomerByIndex(6), 0);
		}
		
		// --- getNumCustomerOrders() Tests ---
		// Return the correct number of objects in customer field
		@Test
		public void numCustomerOrders() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101");
			assertEquals(restaurant2.getNumCustomerOrders(), 3);
		}
		// Test same value as getNumPizzaOrders()
		@Test
		public void numPizzaCustomerSame() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101");
			assertEquals(restaurant2.getNumCustomerOrders(), restaurant2.getNumPizzaOrders());
		}
	
		// --- getTotalDeliveryDistance() Tests ---
		// Return correct total delivery distance for all customers
		@Test
		public void correctTotalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.processLog("20170101");
			double expectedValue = restaurant2.getCustomerByIndex(0).getDeliveryDistance() + restaurant2.getCustomerByIndex(1).getDeliveryDistance() + restaurant2.getCustomerByIndex(2).getDeliveryDistance();
			assertEquals(restaurant2.getTotalDeliveryDistance(), expectedValue, 0);
		}
		
		
		// --- resetDetails() Tests ---
		// Correctly resets customer field to initial empty state
		@Test(expected = CustomerException.class)
		public void resetDetails() throws CustomerException, PizzaException, LogHandlerException {
			restaurant2.resetDetails();
			restaurant2.processLog("20170101");
			restaurant2.resetDetails();
			assertEquals(restaurant2.getNumCustomerOrders(), 0);
		}
}
