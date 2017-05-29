package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	
	private static ArrayList<Pizza> pizzas;
	private static ArrayList<Customer> customers;

	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * @throws  
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		// TO DO
		customers = new ArrayList<Customer>();
		String path = filename;
		try {
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
			String line = null;
			while((line = reader.readLine()) != null) {
				customers.add(createCustomer(line));
			}
			reader.close();
		} catch (CustomerException e) {
			throw new CustomerException(e.getMessage());
			
		} catch(LogHandlerException | IOException e) {
			throw new LogHandlerException(e.getMessage());
		}
		
		return customers;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		// TO DO
		pizzas = new ArrayList<Pizza>();
		
		String filePath = filename;
		Path path = Paths.get(filePath);
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	pizzas.add(LogHandler.createPizza(line));
		       // System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		    //throw new LogHandlerException("LogHandler Exception: Error trying to read file."); IDK HOW TO Throw LogHandler Exception
		}
		return pizzas;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		// TO DO
		
		String[] lineArray = line.split(",");

		String customerCode = lineArray[4];
		String name = lineArray[2];
		String mobileNumber = lineArray[3];
		int locX = Integer.parseInt(lineArray[5]);
		int locY = Integer.parseInt(lineArray[6]);
		
		try{
		return CustomerFactory.getCustomer(customerCode, name, mobileNumber, locX, locY);
		} catch(CustomerException e) {
			throw new CustomerException(e);
		}
		
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		// TO DO
		String lineArray[] = line.split(",");
		String pizzaCode = lineArray[7];
		int quantity = Integer.parseInt(lineArray[8]);
		LocalTime  orderTime = LocalTime.parse(lineArray[0]);
		LocalTime deliveryTime = LocalTime.parse(lineArray[1]);
		
		/*String pizzaCode;
		LocalTime orderTime, deliveryTime;
		int quantity;
		int numberCommas = 8;
		int[] breakIndexes = new int[numberCommas];
		int previousComma = 0;
		for (int i = 0; i < breakIndexes.length; i++){
			breakIndexes[i] = line.indexOf(",", previousComma + 1);
			if(i != 0){
				previousComma = breakIndexes[i-1];
			}
		}
		
		orderTime = LocalTime.parse(line.substring(0, breakIndexes[0] - 1));
		deliveryTime = LocalTime.parse(line.substring(breakIndexes[0] + 1, breakIndexes[1] - 1));
		pizzaCode = line.substring(breakIndexes[6] + 1, breakIndexes[7] - 1);
		quantity = Integer.parseInt(line.substring(breakIndexes[7] + 1));		
		*/
		return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
	}

}
