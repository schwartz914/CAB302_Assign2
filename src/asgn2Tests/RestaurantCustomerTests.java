package asgn2Tests;


/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	// TO DO
	
	// PizzaRestaurant.java Tests
		// --- PizzaResturant() Tests ---
		// Creates correct pizza restaurant object
		// Sets customer fields to initial state (empty state)
	
		// --- processLog() Tests ---
		//	Return true if file correctly processed
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
		// Returns the correct customer
		// Index the same as in the log file
		// Throws CustomerException if the index is invalid
		
		// --- getNumCustomerOrders() Tests ---
		// Return the correct number of objects in customer field
		// Test same value as getNumPizzaOrders()
	
		// --- getTotalDeliveryDistance() Tests ---
		// Return correct total delivery distance for all customers

		// --- resetDetails() Tests ---
		// Correctly resets customer field to initial empty state
}
