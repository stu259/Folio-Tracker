package api;

import java.io.IOException;

import exceptions.MethodException;
import exceptions.NoSuchTickerException;
import exceptions.WebsiteDataException;

public class Share implements IShare {

	private String tickerSymbol;
	private String shareName;
	private int numShares;
	private double pricePerShare;
	private double valueHolding;
	private IQuote quote;
	
	public Share(String tickerSymbol, String shareName, int numShares){
		this.tickerSymbol = tickerSymbol;
		this.shareName = shareName;
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
	public String getShareName() {
		return shareName;
	}
	@Override
	public void setShareName(String shareName) {
		this.shareName = shareName;
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
	
	private void updatePricePerShare() {
		try {
			quote.setValues(tickerSymbol);
			pricePerShare= quote.getLatest();
		} catch (IOException | WebsiteDataException | NoSuchTickerException | MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/* TRY TO CATCH'EM ALL*/
		}
		
	}
	@Override
	public double getValueHolding() {
		updateValueHolding();
		return valueHolding;
	}
	
	private void updateValueHolding() {
		updatePricePerShare();
		valueHolding = pricePerShare * numShares;
	}
}
