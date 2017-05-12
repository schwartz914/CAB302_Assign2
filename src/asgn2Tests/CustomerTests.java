package asgn2Tests;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MeatLoversPizza;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
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
		// Test name, mobile number, locationx, locationy & type is assigned correctly
		public void correctAssignment() {
			assertEquals(dlCustomer.getName(), "John");
			assertEquals(dlCustomer.getMobileNumber(), "0412345678");
			assertEquals(dlCustomer.getLocationX(), 4);
			assertEquals(dlCustomer.getLocationY(), 5);
		}
		// Test CustomerException thrown if one of above not correct
		// Type isn't “Pick Up”, “Driver Delivery” or “Drone Delivery”
		@Test(expected = CustomerException.class)
		public void incorrectType() throws CustomerException {
			assertEquals(dlCustomer.getCustomerType(), "Driver Delivery"); // NOT SURE HOW TO TEST THIS
		}
		// Customer name between 1 & 20
		@Test(expected = CustomerException.class)
		public void nameMax() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("abcdefghijklmnopqrstu", "0412345678", 4, 5);
		}
		@Test(expected = CustomerException.class)
		public void nameMin() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("", "04123456789", 4, 5);
		}
		// Customer name white spcaces
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
		// Correct x location (east,west)
		// Correct y location (north, south)
		// Not deliver if more 10 blocks in any direction
		@Test(expected = CustomerException.class)
		public void deliveryGreaterTen() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("Jim", "6412345678", 11, 2);
			DriverDeliveryCustomer dlCustomer4 = new DriverDeliveryCustomer("Jim", "6412345678", 2, 11);
		}
		// Deliver over 10 if distance > 10
		
		// --- getName() Tests ---	
		// Test correct name returned
	
		// --- getMobileNumber() Tests ---	
		// Test correct mobile number returned

		// --- getCustomerType() Tests ---	
		// Test correct type returned
		
		// --- getLocationX() Tests ---	
		// Test correct location returned
		
		// --- getLocationY() Tests ---	
		// Test correct location returned
		
		// --- getDeliveryDistance() Tests ---	
		// Test correct delivery distance returned
	
	// PickUpCustomer.java
		// --- PickUpDeliveryCustomer() Tests ---
		// Test name, mobilenumber, locationx & locationy are correct
		// Throws CustomerException if parameters are invalid 
		// Location 0,0 if pickup
		@Test(expected = CustomerException.class)
		public void locationPickupZeroZero() throws CustomerException {
			DriverDeliveryCustomer dlCustomer3 = new DriverDeliveryCustomer("Jim", "6412345678", 4, 5);
		}
				// Location not 0,0 if not pickup
		// --- getDeliveryDistance() Tests ---
		// Test returns 0
	
	// DriverDeliveryCustomer.java
		// --- DriverDeliveryCustomer() Tests ---
		// Test name, mobilenumber, locationx & locationy are correct
		// Throws CustomerException if parameters are invalid 
	
		// --- getDeliveryDistance() Tests ---
		// Test returns correct value
		// Tests manhattan distance calculator used (correctly)
	
	// DroneDeliveryCustomer.java
		// --- DroneDeliveryCustomer() Tests ---
		// Test name, mobilenumber, locationx & locationy are correct
		// Throws CustomerException if parameters are invalid 
	
		// --- getDeliveryDistance() Tests ---
		// Test returns correct value
		// Tests Euclidean distance calculator used (correctly)
}
