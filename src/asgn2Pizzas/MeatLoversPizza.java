package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/**
 * 
 *  A class that represents a meat lovers pizza made at the Pizza Palace restaurant. 
 *  The meat lovers pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Brodie Birkett
 *
 */
public class MeatLoversPizza extends Pizza {

	/**
	 * 
	 *  This class represents a meat lovers pizza made at the  Pizza Palace restaurant. The meat lovers pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
 	 * <P> PRE: TRUE
 	 * <P> POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if Pizza Quantities are less than 0 or greater than 10, if the type of pizza is not one that exists,
	 * if the order time is between 23:00:01 and 06:59:59 and if the pizza delivery is 60minutes and 1 sec or more after the order time.
	 *
	 */
	public MeatLoversPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		// TO DO
		super(quantity, orderTime, deliveryTime, "Meat Lovers", 12);
	}

}
