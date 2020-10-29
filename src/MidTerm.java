import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MidTerm {
	static Scanner scnr = new Scanner(System.in);
	static ArrayList<Meal> menu;

	public static void main(String[] args) {

		
		createMeals();
		//sets up menu from file
		
		System.out.println("Welcome to BurgerFi! Please take a look at our menu and place an order.");
		
		// displayMenu();
		displayMenu(menu);
		
		// place order, prompt until order is completed (store order and quantities in variables)
		Map<Integer,Integer> orderItems = new HashMap<>();
		orderItems = takeOrder(scnr);
		
		//calculate total and print merchant receipt for customer
		double total = printReceipt(orderItems);
		
		System.out.println("How will you be paying for that? Cash, credit, or check?");
		// printReciept();
		// String paymentMethod = scnr.next();
		// getChange()
		
	}

	public static ArrayList<Meal> createMeals() {
		//store file path for use in reading meals .txt file		
		String fileName = ""; //add file name here after creation
		Path filePath = Paths.get(fileName);
		try {
			//keep this in a try/catch because file methods throw IOExceptions which must be handled
			//read file of meals
			List<String> entries = Files.readAllLines(filePath);
			ArrayList<Meal> meals = new ArrayList<>();
			
			for(String entry : entries) {
				String[] ln = entry.split("");//split on delimiter in file, keep in mind any regex-reserved characters which will need to be escaped out using //
				meals.add(new Meal());//add specific parsers at specified indices to match the variable types for Meal class based on expected file input
			}
			return meals;
		}
		catch (NumberFormatException | IOException e){ //expected exceptions
			e.printStackTrace();
			return new ArrayList<>();//method must return an ArrayList<> even if it fails
		}
		

	}
	
	public static void displayMenu(ArrayList<Meal> meals) {
		//takes the ArrayList<Meal> meals and prints it out in a readable format
		//for loop
		int i = 1; 
			for (int j = 0; j < meals.size(); j++) {
		
				System.out.println(i++ + ". " + meals.get(j));//print each line formatted
			}
			

	}

	public static Map<Integer, Integer> takeOrder(Scanner scnr) {
		//asks the user to input which menu item they would like to order and the quantity of said item
		//should handle quantity updates if item is ordered more than once
		
		Map<Integer,Integer> orderItems = new HashMap<>();
		//this map will contain the order items and their quantities.  order item numbers (-1) correspond with the menu item index 
		
		while(true) {
			//continues to prompt the user to order until the user asks to exit
			//stop with a break
			int key = Validator.getIntInRange(scnr, "Please enter the item number of the meal you would like to order: ", 1, menu.size());
			//validates input, verifies that input is within index range for array of meals & adds item to variable for later mapping
			int quantity = Validator.getIntAtOrAbove(scnr, "How many would you like?", 0);
			//validates input, adds quantity to variable for later mapping
			
			if(orderItems.isEmpty() || orderItems.containsKey(key) == false) {
				orderItems.put(key, quantity);
			} else {
				orderItems.replace(key,quantity);
			} 
			
			if(Validator.getYesNo(scnr, "Would you like to order anything else? (yes or no)")) {
				//continue the while if yes
			} else {
				break;
			}		
		}
		return orderItems;
	}
	
	
	public static double printReceipt(Map<Integer,Integer> orderItems) {
		//calculates & prints out the subtotal, sales tax and total
		//returns total for use elsewhere (if payment is cash)
		double subtotal = 0.0;
		double salesTax = 1.06;
		double finalTotal = 0.0;
		
		for(Map.Entry<Integer,Integer> entry : orderItems.entrySet()) {
			Meal pr = new Meal();
			pr = menu.get(entry.getKey()-1); // order number to meal from menu static class list
			System.out.println();//print out meal variables like name and price and orderItem variables like quantity
			double itemTotal = entry.getValue(); // * meal pr.getPrice();
			System.out.println();// print out individual item total	
			subtotal += itemTotal;
		}
		
		finalTotal = subtotal * salesTax;
		System.out.printf("%14s $%-10s\r\n","Subtotal:", subtotal);
		System.out.printf("%14s $%-10s","SalesTax:", salesTax-1);
		System.out.printf("%14s $%-10s\r\n","Total:", finalTotal);
		
		return finalTotal;
	}
	
	public static void getChange() {
		//Logan
	}
	

	
	
}
