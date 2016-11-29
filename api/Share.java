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
	
	/**
	 *  -> constructor
	 *  requires:tickerSymbol != null || tickerSymbol != "" ||
	 * 			 numShares > 0 	      || numShares != ""	||
	 * 			 shareName != null 	  || shareName != ""	||
	 * 			 m != null
	 */
	public Share(String tickerSymbol, String shareName, int numShares, IModel m){
		this.tickerSymbol = tickerSymbol;
		this.shareName = shareName;
		this.numShares = numShares;
		
		quote = new Quote(false);
		model = m;
		updatePricePerShare();
		updateValueHolding();
	}
	
	/**
	 * requires: value != null & value >= 0
	 * modifies: this
	 */
	@Override
	public void incrementShares(int value){
		this.numShares += value;
	}
	
	/**
	 * requires: value != null & value >= 0
	 * modifies: this
	 */
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
	
	/**
	 * requires: shareName != null || shareName != ""
	 * modifies: this
	 */
	@Override
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	
	@Override
	public int getNumShares() {
		return numShares;
	}
	
	/**
	 * requires: numShares > 0 || numShares != ""
	 * modifies: this
	 */
	@Override
	public void setNumShares(int numShares) {
		this.numShares = numShares;
	}
	
	/**
	 * modifies: retrieves the latest information from API's
	 * 			 and updates pricePerShare value 
	 * effects:  returns pricePerShare variable of this object
	 */
	@Override
	public double getPricePerShare() {
		updatePricePerShare();
		return pricePerShare;
	}
	
	private void updatePricePerShare() {
		try {
			quote.setValues(tickerSymbol);
			
			pricePerShare = (quote.getLatest() != null) ? quote.getLatest() : 0;
		} catch (IOException | WebsiteDataException | NoSuchTickerException | MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/* TRY TO CATCH'EM ALL*/
			
			//model.setMessage("Error message goes here");
			//model.setStatus("Error");
		}
	}
	/**
	 * modifies: retrieves the latest information from API's
	 * 			 and updates valueHolding value 
	 * effects:  returns valueHolding variable of this object
	 */
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
