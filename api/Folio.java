package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

@SuppressWarnings("serial")
public class Folio implements IFolio, Serializable{
	private Map<String,IShare> shares;
	private IModel model;
	
	public Folio(IModel m){
		shares = new HashMap<String, IShare>();
		model = m;
	}
	
	/**
	 * effects: returns the share collection
	 */
	@Override
	public IShare[] getShares(){
		IShare[] s = new Share[shares.size()];
		int i = 0;
		for(String k: shares.keySet()){
			s[i] = shares.get(k);
			++i;
		}
		return s;
	}
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != ""
	 * effects: returns from share collection if it exists
	 * 			else returns null
	 */
	@Override
	public IShare getShareAt(String ticker){
		return shares.get(ticker);
	}
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != "" ||
	 * 			 numShares > 0 	      || 
	 * 			 shareName != null 	  || shareName != ""	
	 * modifies: this
	 * effects: adds given share to the shares collection
	 */
	@Override
	public void addShare(String tickerSymbol, String shareName, int numShares ) {
		if(shares.containsKey(tickerSymbol)){
			shares.get(tickerSymbol).incrementShares(numShares);
			return;
		}
		
		
		/* check if ticker symbol is valid */
		
		IShare tempShare = new Share(tickerSymbol, shareName, numShares,model); 
		if(tempShare.getPricePerShare() != 0){
			shares.put(tickerSymbol, tempShare);
		}else{
			model.setMessage("Invalid Ticker Name");
			model.setStatus("Error");
		}
	}
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != "" ||
	 * 			 numShares > 0	
	 * modifies: this
	 * effects: removes given number of shares from the shares collection
	 */
	@Override
	public boolean removeShare(String tickerSymbol, int numShares) throws InvalidNumberOfSharesException, InvalidStockException{
		if(shares.containsKey(tickerSymbol)){
			IShare tempShare = shares.get(tickerSymbol);
			if(tempShare.getNumShares() > numShares){
				shares.get(tickerSymbol).decrementShares(numShares);
				return true;
			}
			else if(tempShare.getNumShares() == numShares){
				shares.remove(tickerSymbol);
				return true;
			}
			else if(tempShare.getNumShares() < numShares) {
				throw new InvalidNumberOfSharesException(tickerSymbol);
			}
		} else {
			throw new InvalidStockException(tickerSymbol);
		}
		return false;
	}
}
