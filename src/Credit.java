import java.util.InputMismatchException;
import java.util.Scanner;

public class Credit extends PaymentType{

	public static void main(String[] args) {

	}
	
	static Scanner scnr = new Scanner(System.in);
	public String number; 
	public String cardholder;
	public int cvv;
	
	public Credit(String credit) {
		super();
		this.credit = credit;
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
			creditCardFinal = creditCardFirst4 + "-" + creditCardSecond4 + "-" + creditCardThird4 + "-" + creditCardLast4;
			if (isNumberValid(creditCardFinal)) {
				flag = false;
			}else{
				System.out.println("That was not a valid credit card number");
			}
	
		}catch (InputMismatchException e) {
			System.out.println("That is not a valid credit card number");
			scnr.nextLine();
		}
		}while(flag);
		return creditCardFinal;
	}
	
	public static boolean isNumberValid(String creditCardNumber) {
		
		if (creditCardNumber.matches("([1-9]{4})-([1-9]{4})-([1-9]{4})-([1-9]{4})")) {
			return true; 
		}
		else {
			return false;
		}
	}
	
}
