package api;

public class Share implements IShare {

	private String tickerSymbol;
	private String stockName;
	private int numShares;
	private double pricePerShare;
	private double valueHolding;
	private IQuote quote;
	
	public Share(String tickerSymbol, String stockName, int numShares){
		this.tickerSymbol = tickerSymbol;
		this.stockName = stockName;
		this.numShares = numShares;
		quote = new Quote(true);
		//catch exceptions when calling methods!
		updatePricePerShare();
		updateValueHolding();
		
	}
	
	@Override
	public void incrementShares(int value){
		this.numShares += value;
	}
	
	@Override
	public void decrementShares(int value){
		this.numShares -= value;
	}
	
	@Override
	public String getTickerSymbol(){
		return tickerSymbol;
	}
	@Override
	public String getStockName() {
		return stockName;
	}
	@Override
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	@Override
	public int getNumShares() {
		return numShares;
	}
	@Override
	public void setNumShares(int numShares) {
		this.numShares = numShares;
	}
	@Override
	public double getPricePerShare() {
		updatePricePerShare();
		return pricePerShare;
	}
	@Override
	public void updatePricePerShare() {
		// call a method here that sets the updated value for price per share
	}
	@Override
	public double getValueHolding() {
		updatePricePerShare();
		updateValueHolding();
		return valueHolding;
	}
	@Override
	public void updateValueHolding() {
		// call a method here that sets the updated value for 
	}
}
