package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Person A
 *
 */
public abstract class Pizza  {
	private int quantity;
	private String type;
	private double price, cost;
	private LocalTime orderTime, deliveryTime;
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		// TO DO
		if(quantity > 0 && quantity < 10){
			this.quantity = quantity;
		}else{
			throw new PizzaException("Pizza Exception: Quantity of pizzas invalid; must order atleast 1 but no more than 10.");
		}
		
		if(type != "Margherita" || type != "Vegetarian" || type != "Meat Lovers�"){
			this.type = type;
		}else{
			throw new PizzaException("Pizza Exception: The type of pizza is invalid.");
		}
		if(LocalTime.of(23, 00, 00).isAfter(orderTime) && LocalTime.of(07, 00, 00).isBefore(orderTime)){
			this.orderTime = orderTime;
		}else{
			throw new PizzaException("Pizza Exception: Orders cannot be placed after 11:00pm.");
		}
		// MAY NEED TO EVALUATE deliveryTime
		
		// Assign values
		this.price = price; //Pretty sure this gets assigned in calculate cost
		this.deliveryTime = deliveryTime;
		
	}

	/**
	 * Calculates how much a pizza would could to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		// TO DO
		
		if (this.getPizzaType() == "Margherita"){
			this.cost = PizzaTopping.CHEESE.getCost() + PizzaTopping.TOMATO.getCost();			
		}else if(this.getPizzaType() == "Meat Lovers"){
			this.cost = PizzaTopping.CHEESE.getCost() + PizzaTopping.TOMATO.getCost() + PizzaTopping.BACON.getCost() + PizzaTopping.PEPPERONI.getCost() + PizzaTopping.SALAMI.getCost();
		}else{
			this.cost = PizzaTopping.CHEESE.getCost() + PizzaTopping.TOMATO.getCost() + PizzaTopping.EGGPLANT.getCost() + PizzaTopping.CAPSICUM.getCost() + PizzaTopping.MUSHROOM.getCost();
		}
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		// TO DO
		this.calculateCostPerPizza(); //MIGHT NOT NEED THIS LINE
		return this.cost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		// TO DO
		return this.price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		// TO DO
		return this.cost * this.quantity;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		// TO DO
		return this.price * this.quantity;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		// TO DO
		return this.getOrderPrice() - this.getOrderCost();
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		// TO DO
		if(this.getPizzaType() == "Margherita" && (topping == PizzaTopping.CHEESE || topping == PizzaTopping.TOMATO)){
			return true;
		}else if(this.getPizzaType() == "Meat Lovers" && (topping == PizzaTopping.CHEESE || topping == PizzaTopping.TOMATO || topping == PizzaTopping.BACON || topping == PizzaTopping.PEPPERONI || topping == PizzaTopping.SALAMI)){
			return true;
		}else if(this.getPizzaType() == "Vegetarian" && (topping == PizzaTopping.CHEESE || topping == PizzaTopping.TOMATO || topping == PizzaTopping.EGGPLANT || topping == PizzaTopping.MUSHROOM || topping == PizzaTopping.CAPSICUM)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		// TO DO
		return this.quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		// TO DO
		return this.type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
