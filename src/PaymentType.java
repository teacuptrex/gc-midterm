
public class PaymentType {
	private double amtGiven;
	
	public double getAmtGiven() {
		return amtGiven;
	}
	public void setAmtGiven(double amtGiven) {
		this.amtGiven = amtGiven;
	}
	public PaymentType() {

	}
	public PaymentType(double amtGiven) {
		this.amtGiven = amtGiven;
	}
	@Override
	public String toString() {
		return "PaymentType [amtGiven=" + amtGiven + "]";
	}
	
	
	
	
}
	
	

