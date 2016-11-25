package api;

public abstract interface IShare {
	public void incrementShares(int value);
	
	public void decrementShares(int value);
	
	public String getTickerSymbol();
	
	public String getStockName();

	public void setStockName(String stockName);

	public int getNumShares();
	
	public void setNumShares(int numShares);

	public double getPricePerShare();

	public void updatePricePerShare();

	public double getValueHolding();

	public void updateValueHolding();
}
