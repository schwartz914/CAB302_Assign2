package asgn2Tests;


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
	
	// Customer.java Tests (Using DriverDeliveryCustomer)
		// --- Customer() Tests	---
		// Test name, mobile number, locationx, locationy & type is assigned correctly	
		// Test CustomerException thrown if one of above not correct
		// Type isn't “Pick Up”, “Driver Delivery” or “Drone Delivery”
		// Customer name between 1 & 20
		// Customer name not white spcaces
		// Mobile 10 digits long 
		// Mobile begins 0
		// Location 0,0 if pickup
		// Location not 0,0 if not pickup
		// Correct x location (east,west)
		// Correct y location (north, south)
		// Not deliver if more 10 blocks in any direction
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
