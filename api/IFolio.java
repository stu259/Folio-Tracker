package api;


//should abstract be here?
public abstract interface IFolio {
	public IShare[] getShares();
	public IShare getShareAt(String ticker);
	public boolean removeShare(String tickerSymbol, int numShares);
	public void addShare(String tickerSymbol, String stockName, int numShares );
	
}
