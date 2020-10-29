import java.util.InputMismatchException;
import java.util.Scanner;

public class Credit extends PaymentType {
	static Scanner scnr = new Scanner(System.in);

	@Override
	public String toString() {
		return "Credit [credit=" + credit + "]";
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String credit;
	public String cardholder;


	public static boolean creditCard() {
		getCreditCardNumber();
		checkCardholderName();
		checkCVV();
		return true;
	}

	public String getCardholder() {
		return cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public static String getCreditCardNumber() {

		String creditCardFinal = null;
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

	public static boolean isNumberValid(String creditCardNumber) {

		if (creditCardNumber.matches("([1-9]{4})-([1-9]{4})-([1-9]{4})-([1-9]{4})")) {
			return true;
		} else {
			return false;
		}
	}

	public static String checkCardholderName() {
		boolean flag = true;
		String name = null;
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

}
