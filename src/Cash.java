
public class Cash extends PaymentType{

	public Cash() {
	}

	public Cash(double amtGiven) {
		super(amtGiven);
	}
	//cash toString
	@Override
	public String toString() {
		return "Cash [toString()=" + super.toString() + "]";
	}
	

	
	
}
