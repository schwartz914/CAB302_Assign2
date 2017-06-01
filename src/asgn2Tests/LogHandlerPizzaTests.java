package asgn2Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	
	PizzaRestaurant pizzaPalace;
	
	@Before
	public void setup() {
		pizzaPalace = new PizzaRestaurant();
		
	}
	
	@Test
	public void workingPizzaTest() throws PizzaException, LogHandlerException {
		String myPizza = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		//pizzaPalace.
	}
	
	@Test
	public void workingFileTest() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog(".\\logs\\20170101.txt");
		assertTrue(result);
	}
	
	@Test
	public void workingCustomer() throws PizzaException, LogHandlerException, CustomerException {
		Customer expected = new DroneDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		pizzaPalace.processLog(".\\logs\\20170101.txt");
		String value = pizzaPalace.getCustomerByIndex(0).getName();
		assertEquals(expected.getName(), value);
	}
	
	@Test (expected = CustomerException.class)
	public void brokenFileTest() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog(".\\logs\\PizzaLogTests.txt");
		assertTrue(result);
	}
	
	@Test (expected = LogHandlerException.class)
	public void noFileTest() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog("FakeFile.txt");
	}
	
}
