package api;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

public interface IFolio {
	/**
	 * effects: returns the share collection
	 */
	public IShare[] getShares();
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != ""
	 * effects: returns from share collection if it exists
	 * 			else returns null
	 */
	public IShare getShareAt(String ticker);
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != "" ||
	 * 			 numShares > 0	
	 * modifies: this
	 * effects: removes given number of shares from the shares collection
	 */
	public boolean removeShare(String tickerSymbol, int numShares) throws InvalidNumberOfSharesException, InvalidStockException;
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != "" ||
	 * 			 numShares > 0	
	 * modifies: this
	 * effects: removes given number of shares from the shares collection
	 */
	public void addShare(String tickerSymbol, String stockName, int numShares );
	
}
