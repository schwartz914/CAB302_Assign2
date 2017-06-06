package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Peter Schwartz
 * 
 */
public class PizzaFactoryTests {
	String pizzaCode; 
	int quantity; 
	LocalTime orderTime; 
	LocalTime deliveryTime;
	
	@Before
	public void setup() {
		pizzaCode = "PZL";
		quantity = 2;
		orderTime = LocalTime.of(19, 00, 00);
		deliveryTime = LocalTime.of(19, 20, 00);
	}
	
	@Test(expected = PizzaException.class)
	public void wrongCode() throws PizzaException {
		pizzaCode = "PZ1";
		Pizza myPizza = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
	}
	
	@Test
	public void correctPizzaCode() throws PizzaException {
		Pizza myPizza = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
		assertEquals(myPizza.getPizzaType(), "Meat Lovers");
	}
	
	
	
	
	
	

	
	
}
