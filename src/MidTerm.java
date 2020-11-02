import java.awt.EventQueue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import start.MidTermSwingApp;


public class MidTerm {
	// private static List<Order> orderedProduct = new ArrayList<>();
	private static Map<Integer, Meal> mealList = new TreeMap<>();
	private static Path filePath = Paths.get("meals.txt");
	
	static Scanner scnr = new Scanner(System.in);
	static ArrayList<Meal> menu;
	static ArrayList<PaymentType> payments;

	public static void main(String[] args) {


		
		menu = createMeals();
		//sets up menu from file
		
		System.out.println("Welcome to BurgerFi! Please take a look at our menu and place an order.");

		// displayMenu();
		displayMenu(menu);
		
		// place order, prompt until order is completed (store order and quantities in variables)
		Map<Integer,Integer> orderItems = new HashMap<>();
		orderItems = takeOrder(scnr);
		
		//calculate total and print merchant receipt for customer
		double total = printReceipt(orderItems);
		
		//variable for change amount for later use
		double amtChange = 0;
		
		// printReciept();
		// String paymentMethod = scnr.next();
		// getChange()
		do {
			System.out.println("How will you be paying for that? Cash, credit, or check?");
			String paymentOption = scnr.nextLine().toLowerCase();

			double paymentAmount = Validator.getDouble(scnr,"How much would you like to pay with " + paymentOption + "? (enter a dollar amount");
			
			if(paymentOption.equals("cash")) {	
				//if cash, create new Cash obj. and add to payments
				PaymentType payment = new Cash(paymentAmount);
				payments.add(payment);
				
			} else if (paymentOption.equals("credit")) {
				//if credit, get credit card info (and validate user inputs) and add obj. to payments
				String name = Validator.checkCardholderName();
				String cardNum = Validator.getCreditCardNumber();
				int cvv = Validator.checkCVV();
				PaymentType payment = new Credit(cardNum,name,cvv,paymentAmount);
				payments.add(payment);
				
			} else if (paymentOption.equals("check")) {
				//if check, get check number (and validate user inputs) and add obj. to payments
				String check = Validator.checkNumber();
				PaymentType payment = new Check(check,paymentAmount);
				payments.add(payment);
				
			} else {
				//validate user selection and retry
				System.out.println("Invalid selection, please try again.");
			}
			
			if(total - paymentAmount == 0) {
				//if payment is complete, exit
				break;
			} else if(total - paymentAmount > 0) {
				//if payment is incomplete, print remaining and ask for another payment method
				total = total - paymentAmount;
				System.out.printf("Remaining: %.2f\r\n", total);				
			} else if(paymentOption.equals("cash")) {
				//if payment is more than the total & the payment type was cash, give change and exit
				amtChange = getChange(total);
				System.out.printf("Your change: %.2f\r\n", amtChange);
				break;
			}
				
		} while(true);
		
		//print out customer receipt including payment types and applied amounts
		printReceipt(orderItems);
		System.out.println("Payments applied: ");
		for(int i = 0; i < payments.size(); i++) {
			if(payments.get(i) instanceof Cash) {
				if(amtChange != 0) {
					System.out.printf("Cash paid: %.2f\r\n", payments.get(i).getAmtGiven());
					System.out.printf("Change given: %.2f\r\n",amtChange);
				} else {
					System.out.printf("Cash paid: %.2f\r\n", payments.get(i).getAmtGiven());
				}
			} else if (payments.get(i) instanceof Check) {
				System.out.printf("Check number %4s for: %.2f\r\n", ((Check) payments.get(i)).getCheck(),payments.get(i).getAmtGiven());
			} else if (payments.get(i) instanceof Credit) {
				
				System.out.printf("Credit %16s for: %.2f\r\n", "************" + ((Credit) payments.get(i)).getCreditCardNumber().substring(11),payments.get(i).getAmtGiven());
			} else {
				
			}
		}
		System.out.println("Thank you for visiting BurgerFi");

		
	}


	public static ArrayList<Meal> createMeals() {
		//store file path for use in reading meals .txt file		
		String fileName = "meals.txt"; //add file name here after creation
		Path filePath = Paths.get(fileName);
		try {
			//keep this in a try/catch because file methods throw IOExceptions which must be handled
			//read file of meals
			List<String> entries = Files.readAllLines(filePath);
			ArrayList<Meal> meals = new ArrayList<>();
			
			for(String entry : entries) {
				String[] ln = entry.split("~~~");//split on delimiter in file, keep in mind any regex-reserved characters which will need to be escaped out using //
				meals.add(new Meal(ln[0],ln[1],ln[2],Integer.parseInt(ln[3]),Double.parseDouble(ln[4])));//add specific parsers at specified indices to match the variable types for Meal class based on expected file input
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
				quantity = quantity + orderItems.get(key);
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
			System.out.print("\r\n" + pr.getName() + " " + entry.getValue() + " at $" + pr.getPrice() + " each.");//print out meal variables like name and price and orderItem variables like quantity
			double itemTotal = entry.getValue() * pr.getPrice(); // * meal pr.getPrice();
			System.out.println();// print out individual item total	
			subtotal += itemTotal;
		}//String category, String name, String description, int calories, double price
		
		finalTotal = subtotal * salesTax;
		System.out.printf("Subtotal: %.2f\r\n", subtotal);
		System.out.printf("SalesTax: %s\r\n", "6.0%");
		System.out.printf("FinalTotal: %.2f\r\n", finalTotal);
		
		return finalTotal;
	}
	
	//Calculates change when the user pays with cash
	public static double getChange(double total) {
		System.out.println("How much money are you giving us?");
		double moneyIn = scnr.nextDouble();
		double change = total - moneyIn;
		return change;
		
		
	}
	
	 public static void appendToFile(Meal meals) throws IOException {
	        if (Files.notExists(filePath)) {
	            try {
	                Files.createFile(filePath);
	            } catch (IOException e) {
	                System.out.println("Something went wrong.");
	                // e.printStackTrace();
	            }
	        }
	        List<String> mealList = Arrays.asList(meals.toString());
	        
	        Files.write(filePath, mealList, StandardOpenOption.APPEND);
	
	

	

		

	}
}
	
	

