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

/*
 * Pizza Topping Price ($)
Margherita 		Tomato, Cheese 									1.50		8.00
Vegetarian 		Tomato, Cheese, Eggplant, Mushroom, Capsicum	5.50		10.00
Meat Lovers 	Tomato, Cheese, Bacon, Pepperoni, Salami		5.00		12.00
Pizzas, Ingredients and Prices
Topping Cost ($)
Cheese		1
Tomato		0.5
Bacon		1.5
Salami		1
Pepperoni	1
Capsicum	1.2
Mushroom	2
Eggplant	0.8
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
	public void negPizzasException() throws PizzaException {
		MeatLoversPizza mlPizza3;
		mlPizza3 = new MeatLoversPizza(-1, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
	}
	
	@Test
	public void edgePizzaQty() throws PizzaException {
		MeatLoversPizza mlPizza3;
		mlPizza3 = new MeatLoversPizza(10, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
		assertEquals(10, mlPizza3.getQuantity());
	}
	
	@Test(expected = PizzaException.class)
	public void excessPizzaException() throws PizzaException {
		MeatLoversPizza mlPizza3;
		mlPizza3 = new MeatLoversPizza(11, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
	}
	
	@Test
	public void validQuantity() throws PizzaException {
		MeatLoversPizza mlPizza3;
		mlPizza3 = new MeatLoversPizza(2, LocalTime.of(19, 00, 00), LocalTime.of(19, 20, 00));
		assertEquals(2, mlPizza3.getQuantity());
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
