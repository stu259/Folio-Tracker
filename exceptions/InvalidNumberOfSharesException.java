package exceptions;

@SuppressWarnings("serial")
public class InvalidNumberOfSharesException extends Exception {
	
	public InvalidNumberOfSharesException(String Ticker) {
		super("You have less than the number of shares attempting to be sold for Ticker: " + Ticker);

	}

}
