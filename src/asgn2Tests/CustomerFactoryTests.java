package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	// TO DO

	int locationX, locationY;
	String customerCode, customerName, customerNumber;
	
	//Setup
	@Before
	public void setup() throws CustomerException {
		locationX = 6;
		locationY = -4;
		customerCode = "DVC";
		customerName = "Jimmy Recard";
		customerNumber = "0123456789";		
	}	
	
	// CustomerFactory.java Tests
		// --- getCustomer() Tests	---
		// CustomerException thrown if invalid customer code; not PUC, DNC or DVC
		@Test(expected = CustomerException.class)
		public void invalidCustomerCode() throws CustomerException {
			assertEquals(CustomerFactory.getCustomer("PNC", customerName, customerNumber, locationX, locationY), Customer.class);
		}
		// Returns correct PickUpCustomer, DriverDeliveryCustomer or DroneDeliveryCustomer
		@Test
		public void correctCustomer() throws CustomerException {
			assertEquals(CustomerFactory.getCustomer(customerCode, customerName, customerNumber, locationX, locationY), DriverDeliveryCustomer.class);
			assertEquals(CustomerFactory.getCustomer("DNC", customerName, customerNumber, locationX, locationY), DroneDeliveryCustomer.class);
			assertEquals(CustomerFactory.getCustomer("PUC", customerName, customerNumber, locationX, locationY), PickUpCustomer.class);
		}
}
