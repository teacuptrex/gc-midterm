

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Validator {

	static Scanner scnr = new Scanner(System.in);
			
	public static String getString(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String input = scnr.nextLine();
		return input;
	}

	/**
	 * Prompt the user until they enter a valid integer.
	 */
	public static int getInt(Scanner scnr, String prompt) {
		boolean inputIsInvalid = true;
		int input = 0; // <-- we have to put something here to make Java happy.

		do {
			System.out.print(prompt);
			if (scnr.hasNextInt()) {
				input = scnr.nextInt();
				scnr.nextLine(); // <-- clear remainder of line.
				inputIsInvalid = false;
			} else {
				scnr.nextLine(); // <-- clear out bad input
				System.out.println("You must enter a valid integer. Try again");
			}
		} while (inputIsInvalid);
		return input;
	}

	/**
	 * Prompt the user until they enter a valid double.
	 */
	public static double getDouble(Scanner scnr, String prompt) {
		System.out.print(prompt);
		
		do {
			if(scnr.hasNextDouble()) {
				double input = scnr.nextDouble();
				scnr.nextLine(); // <-- clear remainder of line.
				return input;
			}else {
				System.out.println("You must enter a valid number. Try again");
				System.out.print(prompt);
				scnr.nextLine(); // <-- clear bad input
			}
		} while (true);
	}
	
	public static double getDouble2(Scanner scnr, String prompt) {
		System.out.print(prompt);
		
		do {
			try {
				double input = scnr.nextDouble();
				scnr.nextLine(); // <-- clear remainder of line.
				return input;
			} catch (InputMismatchException e) {
				System.out.println("You must enter a valid number. Try again");
				System.out.print(prompt);
				scnr.nextLine(); // <-- clear bad input
			}
		} while (true);
	}

	/**
	 * Prompt the user until they enter a valid integer between min and max
	 * inclusive.
	 */
	public static int getIntInRange(Scanner scnr, String prompt, int min,
			int max) {
		boolean withIn = false;
		int input = getInt(scnr, prompt);

		while (withIn == false) {

			if (input <= max && input >= min) {
				withIn = true;
			} else {
				withIn = false;
				System.out.println("Your number was not within the range " + min + " to " + max + ". Try again.");
				input = getInt(scnr, prompt);
			}
		}
		return input;
	}

	/**
	 * Prompt the user until they enter a valid integer equal to or greater than
	 * min.
	 */
	public static int getIntAtOrAbove(Scanner scnr, String prompt, int min) {
		boolean flag = true;
		int input = 0;
		while (flag) {
			input = getInt(scnr, prompt);
			if (input >= min) {
				flag = false;
			} else {
				System.out.println("Your number must not be less than " + min + ". Try again.");
			}
		}
		return input;
	}
	
	private static final Set<String> VALID_YES = new HashSet<>(
			Arrays.asList("yes", "y", "yeah", "ok", "sure"));
	private static final Set<String> VALID_NO = new HashSet<>(
			Arrays.asList("no", "n", "nope"));

	public static boolean getYesNo(Scanner scnr, String prompt) {
		while (true) {
			String userInput = getString(scnr, prompt).toLowerCase();
			if (VALID_YES.contains(userInput)) {
				return true;
			} else if (VALID_NO.contains(userInput)) {
				return false;
			} else {
				System.out.println("Your answer must be yes or no.");
			}
		}
	}
	public static boolean creditCard() {
		getCreditCardNumber();
		checkCardholderName();
		checkCVV();
		return true;
	}
	//Function that obtains the credit card number and validates it with the credit card validator
		public static String getCreditCardNumber() {

			String creditCardFinal = "";
			boolean flag = true;

			do {
				try {
					System.out.println("Please enter the first four digits of your credit card");
					int creditCardFirst4 = scnr.nextInt();
					System.out.println("Please enter the second four digits of your credit card");
					int creditCardSecond4 = scnr.nextInt();
					System.out.println("Please enter the third four digits of your credit card");
					int creditCardThird4 = scnr.nextInt();
					System.out.println("Please enter the fourth four digits of your credit card");
					int creditCardLast4 = scnr.nextInt();
					creditCardFinal = creditCardFirst4 + "-" + creditCardSecond4 + "-" + creditCardThird4 + "-"
							+ creditCardLast4;
					if (isNumberValid(creditCardFinal)) {
						flag = false;
					} else {
						System.out.println("That was not a valid credit card number");
					}

				} catch (InputMismatchException e) {
					System.out.println("That is not a valid credit card number");
					scnr.nextLine();
				}
			} while (flag);
			scnr.nextLine();
			return creditCardFinal;
		}
		//credit cardvalidator
		public static boolean isNumberValid(String creditCardNumber) {

			if (creditCardNumber.matches("([1-9]{4})-([1-9]{4})-([1-9]{4})-([1-9]{4})")) {
				return true;
			} else {
				return false;
			}
		}
		//Checks if the cardholder name is a valid name. First and last name with optional middle initial.
		public static String checkCardholderName() {
			boolean flag = true;
			String name = "";
			do {
				try {
					System.out.println("Please enter your cardholder name");
					name = scnr.nextLine();

					if (name.matches("[a-zA-Z]+ ([A-Za-z] )?([A-Za-z][A-Za-z]+) ?")) {
						flag = false;
					} else {
						System.out.println("That name was not valid");
					}
				} catch (InputMismatchException e) {
					System.out.println("That name was not valid");
				}
			} while (flag);

			return name;
		}
		//Checks if the inputed CVV is valid
		public static int checkCVV() {
			boolean flag = true;
			Integer CVV = 0;
			do {
				try {
					System.out.println("Please enter you credit card CVV");
					CVV = scnr.nextInt();
					if (String.valueOf(CVV).length() == 3) {
						flag = false;
					} else {
						System.out.println("That was not a valid CVV");
					}

				} catch (InputMismatchException e) {
					System.out.println("That was not a valid CVV");
					scnr.nextLine();
				}
			} while (flag);
			return CVV;
		}
		// check number input + validator
		public static String checkNumber() {
		boolean flag = true;
		String checkNumber = "";
		do {
			try {
				System.out.println("Please enter your check number.");
				checkNumber = scnr.next();
				if (checkNumber.matches("[0-9]{4}")) {
					System.out.println("Thanky you");
					flag = false;
				}
				else {
					System.out.println("That was not a valid input");
				}
			}catch(InputMismatchException e) {
			System.out.println("That was not a valid input");
				}
			}
		while(flag);
		return checkNumber;
		}


}