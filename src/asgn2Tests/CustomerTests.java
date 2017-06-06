package asgn2Tests;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import static org.junit.Assert.*;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Brodie Birkett
 * 
 *
 */
public class CustomerTests {
	// TO DO
	DriverDeliveryCustomer dlCustomer;
	
	//Setup
	@Before
	public void setup() throws CustomerException {
		dlCustomer = new DriverDeliveryCustomer("John", "0412345678", 4, 5);
	}
	
	
	// Customer.java Tests (Using DriverDeliveryCustomer)
		// --- Customer() Tests	---
		

		// Customer name between 1 & 20
		@Test(expected = CustomerException.class)
		public void nameMax() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("abcdefghijklmnopqrstu", "0412345678", 4, 5);
		}
		@Test(expected = CustomerException.class)
		public void nameMin() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("", "04123456789", 4, 5);
		}
		// Customer name white spaces
		@Test(expected = CustomerException.class)
		public void nameWhiteSpaces() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("       ", "0412345678", 4, 5);
		}
		// Mobile is not 10 digits long
		@Test(expected = CustomerException.class)
		public void mobileNumberWrongSize() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("Jim", "041234567", 4, 5);
			DriverDeliveryCustomer dlCustomer4 = new DriverDeliveryCustomer("Jarred", "04123456789", 4, 5);
		}
		// Mobile begins 0
		@Test(expected = CustomerException.class)
		public void mobileNumberStartZero() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("Jim", "6412345678", 4, 5);
		}
				
		// --- getName() Tests ---	
		// Test correct name returned
		@Test
		public void nameCorrect() {
			assertEquals(dlCustomer.getName(), "John");
		}
		
		// --- getMobileNumber() Tests ---	
		// Test correct mobile number returned
		@Test
		public void mobileNumberCorrect() {
			assertEquals(dlCustomer.getMobileNumber(), "0412345678");
		}
		
		// --- getCustomerType() Tests ---	
		// Test correct type returned
		@Test
		public void customerTypeCorrect() {
			assertEquals(dlCustomer.getCustomerType(), "Driver Delivery");
		}
		
		// --- getLocationX() Tests ---	
		// Test correct location returned
		@Test
		public void LocationXCorrect() {
			assertEquals(dlCustomer.getLocationX(), 4);
		}
		
		// --- getLocationY() Tests ---	
		// Test correct location returned
		@Test
		public void locationYCorrect() {
			assertEquals(dlCustomer.getLocationY(), 5);
		}
		
		// --- getDeliveryDistance() Tests ---	
		// Test correct delivery distance returned
		@Test
		public void deliveryDistanceCorrect() {
			double storeLocationX = 0;
			double storeLocationY = 0;
			double expectedDeliveryDistance = Math.abs(storeLocationX - dlCustomer.getLocationX()) + Math.abs(storeLocationY - dlCustomer.getLocationY());
			assertEquals(dlCustomer.getDeliveryDistance(), expectedDeliveryDistance, 0);
		}
	
	// PickUpCustomer.java
		// --- PickUpDeliveryCustomer() Tests ---
		@Test(expected = CustomerException.class)
		public void locationPickupZeroZero() throws CustomerException {
			PickUpCustomer puCustomer = new PickUpCustomer("Josh", "0412345678", 4, 5);
		}
		// --- getDeliveryDistance() Tests ---
		// Test returns 0
		public void deliveryDistanceZero() throws CustomerException {
			PickUpCustomer puCustomer = new PickUpCustomer("Josh", "0412345678", 0, 0);
			assertEquals(puCustomer.getDeliveryDistance(), 0, 0);
		}
	
	// DriverDeliveryCustomer.java
		@Test(expected = CustomerException.class)
		public void deliveryGreaterTen() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("Jim", "0412345678", 11, 2);
			DriverDeliveryCustomer dlCustomer4 = new DriverDeliveryCustomer("James", "0412345678", 2, 11);
		}
		@Test
		public void deliveryDistanceTen() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("Jim", "0412345678", 10, 2);
			DriverDeliveryCustomer dlCustomer4 = new DriverDeliveryCustomer("James", "0412345678", 2, 10);
			assertEquals(dlCustomer3.getLocationX(), 10);
			assertEquals(dlCustomer4.getLocationY(), 10);
		}
	
	// DroneDeliveryCustomer.java
		// --- DroneDeliveryCustomer() Tests ---
		// Throws CustomerException if parameters are invalid 
		@Test(expected = CustomerException.class)
		public void locationPickupZeroZeroDD() throws CustomerException {
			DroneDeliveryCustomer ddCustomer = new DroneDeliveryCustomer("Josh", "0412345678", 0, 0);
		}
		// --- getDeliveryDistance() Tests ---
		// Tests Euclidean distance calculator used (correctly)
		@Test
		public void deliveryDistanceCorrectDD() throws CustomerException {
			double storeLocationX = 0;
			double storeLocationY = 0;
			DroneDeliveryCustomer ddCustomer = new DroneDeliveryCustomer("Jimmy", "0412345678", 10, 6);
			double expectedDeliveryDistance = Math.sqrt(Math.pow((storeLocationX + ddCustomer.getLocationX()), 2) + Math.pow((storeLocationY + ddCustomer.getLocationY()), 2));
			assertEquals(ddCustomer.getDeliveryDistance(), expectedDeliveryDistance, 0);
		}
}
