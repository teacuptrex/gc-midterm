import java.util.ArrayList;
import java.util.Scanner;

public class MidTerm {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = true;
		do {
			System.out.println("Welcome to BurgerFi! Please take a look at our menu and place an order.");
			// displayMenu();
			// int order = scnr.nextInt();
			System.out.println("Would you like to place another order?");
		} while (flag);
		System.out.println("How will you be paying for that? Cash, credit, or check?");
		// printReciept();
		// String paymentMethod = scnr.next();
		// getChange()
		if (Validator.getYesNo(scnr, "Would you like to keep adding to the order? yes or no")) {

		} else {
			flag = false;
		}
	}

	public static ArrayList<Meal> createMeals() {
		
		return null;

	}
	
	public static void displayMenu(ArrayList<Meal> meals) {

	}

	public static void takeOrder() {
		
	}
	
	public static void printReceipt() {
		
	}
	
	public static void getChange() {
		
	}
	
	
	
}
