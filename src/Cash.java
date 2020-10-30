import java.util.Scanner;

public class Cash extends PaymentType{
	public String cash; 
	static Scanner scnr = new Scanner(System.in);
	
	//cash getter
	public String getCash() {
		return cash;
	}
	//cash setter
	public void setCash(String cash) {
		this.cash = cash;
	}

	public Cash() {
	}
	//cash toString
	@Override
	public String toString() {
		return "Cash [cash=" + cash + "]";
	}
	
	//Calculates change when the user pays with cash
	public static double getChange(double total) {
		System.out.println("How much money are you giving us?");
		double moneyIn = scnr.nextDouble();
		double change = total - moneyIn;
		return change;
		
		
	}
	
	
}
