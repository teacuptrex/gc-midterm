

public class Credit extends PaymentType {
	

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


	//cardHolder getter
	public String getCardholder() {
		return cardholder;
	}
	//cardHolder setter
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	
	//constructors
	public Credit() {
	}
	
	public Credit(String creditCardNumber, String cardholder, int CVV, double amtGiven) {
		super(amtGiven);
		this.creditCardNumber = creditCardNumber;
		this.cardholder = cardholder;
		this.CVV = CVV;

	}
}
