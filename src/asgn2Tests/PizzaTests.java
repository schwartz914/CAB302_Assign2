package asgn2Tests;

import org.junit.Before;

import asgn2Pizzas.MeatLoversPizza;

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
	
	@Before
	public void setup() {
		mlPizza = new MeatLoversPizza(0, null, null)
		
	}
}
