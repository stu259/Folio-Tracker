package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

@SuppressWarnings("serial")
public class Folio implements IFolio, Serializable{
	Map<String,IShare> shares;
	
	public Folio(){
		shares = new HashMap<String, IShare>();
	}
	
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
	 * 			 numShares != null 	  || numShares != ""	||
	 * 			 shareName != null 	  || shareName != ""	||
	 * modifies: this
	 * effects: adds given share to the shares collection
	 */
	@Override
	public void addShare(String tickerSymbol, String shareName, int numShares ) {
		if(shares.containsKey(tickerSymbol)){
			shares.get(tickerSymbol).incrementShares(numShares);
			return;
		}
			
		IShare tempShare = new Share(tickerSymbol, shareName, numShares); 
		shares.put(tickerSymbol, tempShare);
	}
	
	/**
	 * requires: tickerSymbol != null || tickerSymbol != "" ||
	 * 			 numShares != null 	  || numShares != ""	||
	 * modifies: this
	 * effects: removes given share from the shares collection
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
