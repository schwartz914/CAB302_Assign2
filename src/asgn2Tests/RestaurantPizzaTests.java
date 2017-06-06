package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Peter Schwartz
 *
 */
public class RestaurantPizzaTests {
	
	PizzaRestaurant pr;
	
	@Before
	public void Setup(){
		pr = new PizzaRestaurant();
	}
	
	@Test
	public void initalState() {
		assertEquals(0, pr.getNumPizzaOrders());
	}
	@Test
	public void resetStats() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\20170101.txt");
		assertEquals(3, pr.getNumPizzaOrders());
		pr.resetDetails();
		assertEquals(0, pr.getNumPizzaOrders());
	}
	
	@Test
	public void numOrders() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\20170101.txt");
		assertEquals(3, pr.getNumPizzaOrders());
	}
	
	@Test(expected = PizzaException.class)
	public void logError() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\Pizza-invalidQtyZero.txt");
	}
	
	@Test(expected = LogHandlerException.class)
	public void logErrorFakeFile() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\FakeFile.txt");
	}
	
	@Test
	public void pizzaIndex() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\20170101.txt");
		assertEquals(2, pr.getPizzaByIndex(0).getQuantity());
	}
	
	@Test(expected = PizzaException.class)
	public void pizzaIndexException() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\20170101.txt");
		int myPizza = pr.getPizzaByIndex(4).getQuantity();
	}
	
	@Test
	public void pizzaOrders() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\20170101.txt");
		assertEquals(3, pr.getNumPizzaOrders());
	}
	
	@Test
	public void pizzaProfit() throws CustomerException, PizzaException, LogHandlerException {
		pr.processLog(".\\logs\\20170101.txt");
		assertEquals(36.5, pr.getTotalProfit(),0);
	}
	
	
	
	
}
