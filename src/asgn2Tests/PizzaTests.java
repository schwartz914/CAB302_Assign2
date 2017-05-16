package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	MeatLoversPizza mlPizza;
	MeatLoversPizza mlPizza2;
	
	@Before
	public void setup() throws PizzaException {
		mlPizza = new MeatLoversPizza(1, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
		mlPizza2 = new MeatLoversPizza(2, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
	}
	
	@Test(expected = PizzaException.class)
	public void throwsException() throws PizzaException {
		MeatLoversPizza mlPizza3;
		mlPizza3 = new MeatLoversPizza(11, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
	}
	

	@Test
	public void CalculateCost() {
		double expectedValue = 5.0;
		double getValue = mlPizza.getCostPerPizza();
		assertEquals(expectedValue, getValue, 0); //3rd value is the Delta ie the difference between the 2 double/float values.
	}
	
	@Test
	public void CustomerCost() {
		double expectedValue = 12.0;
		double getValue = mlPizza.getPricePerPizza();
		assertEquals(expectedValue, getValue, 0);
	}
	
	@Test
	public void totalOrderCost() {
		double expectedValue = 24.0;
		double getValue = mlPizza2.getOrderCost();
		assertEquals(expectedValue, getValue, 0);
	}
	
	@Test
	public void totalOrderProfit() {
		double expectedValue = 14.0;
		double getValue = mlPizza2.getOrderProfit();
		assertEquals(expectedValue, getValue, 0);
	}
	
	@Test
	public void containsBacon() {
		assertTrue(mlPizza2.containsTopping(PizzaTopping.BACON));
	}
	
	@Test
	public void doesNotContainEvilMushroom() {
		assertFalse(mlPizza.containsTopping(PizzaTopping.MUSHROOM));
	}
	
	@Test
	public void returnString() {
		String expected = "Meat Lovers";
		assertEquals(expected, mlPizza.getPizzaType());
	}
	@Test
	public void getQuantity() {
		int expectedValue = 2;
		assertEquals(expectedValue, mlPizza2.getQuantity());
	}
}
