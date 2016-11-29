package api;

public abstract interface IShare {
	
	/**
	 * requires: value != null & value >= 0
	 * modifies: this
	 */
	public void incrementShares(int value);
	
	/**
	 * requires: value != null & value >= 0
	 * modifies: this
	 */
	public void decrementShares(int value);
	
	public String getTickerSymbol();
	
	public String getShareName();

	/**
	 * requires: shareName != null || shareName != ""
	 * modifies: this
	 */
	public void setShareName(String stockName);

	public int getNumShares();

	/**
	 * requires: numShares > 0 || numShares != ""
	 * modifies: this
	 */
	public void setNumShares(int numShares);

	/**
	 * modifies: retrieves the latest information from API's
	 * 			 and updates pricePerShare value 
	 * effects:  returns pricePerShare variable of this object
	 */
	public double getPricePerShare();

	/**
	 * modifies: retrieves the latest information from API's
	 * 			 and updates valueHolding value 
	 * effects:  returns valueHolding variable of this object
	 */
	public double getValueHolding();

}
