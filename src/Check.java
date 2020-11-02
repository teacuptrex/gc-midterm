import java.util.InputMismatchException;
import java.util.Scanner;

public class Check extends PaymentType {
	
	
	public static Scanner scnr = new Scanner(System.in);

	private String check;

	// Checkconstructor
	public Check(String check) {
		super();
		this.check = check;
	}

	// check getter
	public String getCheck() {
		return check;
	}

	// check setter
	public void setCheck(String check) {
		this.check = check;
	}

	// check toString
	@Override
	public String toString() {
		return "Check [check=" + check + "]";
	}

	// check number input + validator
	public static boolean checkNumber() {
	boolean flag = true;
	do {
		try {
			System.out.println("Please enter your check number.");
			String checkNumber = scnr.next();
			if (checkNumber.matches("[0-9]{4}")) {
				System.out.println("Thanky you");
				flag = false;
				return true;
			}
			else {
				System.out.println("That was not a valid input");
			}
		}catch(InputMismatchException e) {
		System.out.println("That was not a valid input");
			}
		}
	while(flag);
	return false;
	}
}
