package api;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

public interface IFolio {
	public IShare[] getShares();
	public IShare getShareAt(String ticker);
	public boolean removeShare(String tickerSymbol, int numShares) throws InvalidNumberOfSharesException, InvalidStockException;
	public void addShare(String tickerSymbol, String stockName, int numShares );
	
}
