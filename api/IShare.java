package api;

public abstract interface IShare {
	public void incrementShares(int value);
	
	public void decrementShares(int value);
	
	public String getTickerSymbol();
	
	public String getShareName();

	public void setShareName(String stockName);

	public int getNumShares();
	
	public void setNumShares(int numShares);

	public double getPricePerShare();

	public double getValueHolding();

}
