package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Peter Schwartz
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
	public void workingPizza() throws PizzaException, LogHandlerException, CustomerException {
		Customer expected = new DroneDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		pizzaPalace.processLog(".\\logs\\20170101.txt");
		String value = pizzaPalace.getCustomerByIndex(0).getName();
		assertEquals(expected.getName(), value);
	}
	
	@Test (expected = PizzaException.class)
	public void invalidOrderTime() throws PizzaException, LogHandlerException, CustomerException {
		ArrayList<Pizza> result = new ArrayList<Pizza>(); 
		result = LogHandler.populatePizzaDataset(".\\logs\\delivery-timeWrongFormat.txt");
	}
	
	@Test(expected = PizzaException.class)
	public void invalidQtyNeg() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog(".\\logs\\Pizza-invalidQtyNeg.txt");
	}
	
	@Test (expected = PizzaException.class)
	public void invalidQtyZero() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog(".\\logs\\pizza-invalidQtyZero.txt");
	}
	
	@Test
	public void qtyEdgeCase() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog(".\\logs\\Pizza-QtyEdge.txt");
		assertEquals(10, pizzaPalace.getPizzaByIndex(0).getQuantity());
	}
	
	@Test (expected = LogHandlerException.class)
	public void noFileTest() throws PizzaException, LogHandlerException, CustomerException {
		boolean result = pizzaPalace.processLog(".\\logs\\FakeFile.txt");
	}
	
}
