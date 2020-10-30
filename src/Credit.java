import java.util.InputMismatchException;
import java.util.Scanner;

public class Credit extends PaymentType {
	static Scanner scnr = new Scanner(System.in);

	private int CVV;
	private String cardholder;
	private String creditCardNumber;
	//to String
	@Override
	public String toString() {
		return "Credit [CVV=" + CVV + ", cardholder=" + cardholder + ", creditCardNumber=" + creditCardNumber + "]";
	}
	//setter CVV
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	//getter credit card number
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	//setter credit card number
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	//cardHolder gettter
	public String getCardholder() {
		return cardholder;
	}
	//cardholder setter
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	
}
