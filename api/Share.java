package api;

import java.io.IOException;
import java.io.Serializable;

import exceptions.MethodException;
import exceptions.NoSuchTickerException;
import exceptions.WebsiteDataException;

@SuppressWarnings("serial")
public class Share implements IShare, Serializable {

	private String tickerSymbol;
	private String shareName;
	private int numShares;
	private double pricePerShare;
	private double valueHolding;
	private IQuote quote;
	private IModel model;
	
	public Share(String tickerSymbol, String shareName, int numShares, IModel m){
		this.tickerSymbol = tickerSymbol;
		this.shareName = shareName;
		this.numShares = numShares;
		
		quote = new Quote(false);
		model = m;
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
			
			pricePerShare = (quote.getLatest() != null) ? quote.getLatest() : 0;
		} catch (IOException | MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/* TRY TO CATCH'EM ALL*/
			
			//model.setMessage("Error message goes here");
			//model.setStatus("Error");
		}
		catch (NoSuchTickerException e) {
			model.setMessage("Please insert a valid ticker value");
			model.setStatus("Error");
		}
		catch (WebsiteDataException e) {
			model.setMessage("Ticker is not valid");
			model.setStatus("Error");
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
