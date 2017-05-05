package asgn2Tests;

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
		// Customer name doesn't contain a name
		// customer-number doesn't contain a number
		// Customer code incorrect
		// X and y locations don't represent blocks from restaurant
		// Throw LogHandlerException if problem with log file not related to above conditions 
		// Fields not of correct type (8.1.1)
		
		// --- createCustomer() Tests ---
		// Creates customer object from single line of log file
		// Returns customer object
		// Throws customer exception for same reason above (5.3)
		// Throws logHandlerException if problem parsing the line from log file
	
}
