package api;


public class InfoGetter {
	
	Quote q;
	String ticker;
	double value = 0.0;
	int noOfShares;
	double valOfHolding;
	
	public InfoGetter(){
		q = new Quote(false);
		ticker = "0HIT.l"; //will be the value from user input in the gui
		noOfShares = 0; //will be the value from user input in the gui
	}
	
	public void setValue(){
		try {
			q.setValues(ticker);
		} catch (Exception e) {

			System.err.println(e);

		}
	}
	
	public double getLatestValue() throws MethodException{
		value = q.getLatest();
		return value;
	}


}
