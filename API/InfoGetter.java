package API;

import java.io.IOException;

public class InfoGetter {
	
	Quote q;
	String ticker;
	double value = 0.0;
	int noOfShares;
	
	public InfoGetter(){
		q = new Quote(false);
		ticker = "lloy.l"; //will be the value from user input in the gui
		noOfShares = 0; //will be the value from user input in the gui
	}
	
	public void setValue(){
		try {
			q.setValues(ticker);
		} catch (Exception e) {

			System.err.println(e);

		}
	}
	
	public Double getLatestValue() throws MethodException{
		value = q.getLatest();
		return value;
	}

}
