package exceptions;

@SuppressWarnings("serial")
public class InvalidStockException extends Exception{
	public InvalidStockException(String ticker) {
		super("Ticker is not valid for ticker symbol: " + ticker);

	}

}
