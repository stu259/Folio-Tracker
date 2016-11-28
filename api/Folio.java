package api;

import java.util.HashMap;

import java.util.Map;

import javax.swing.JOptionPane;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

public class Folio implements IFolio{
	Map<String,IShare> shares;
	int count;
	public Folio(){
		shares = new HashMap<String, IShare>();
		count = 0;
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
	 * 			 stockName != null 	  || stockName != ""	||
	 * modifies: this
	 * effects: adds given share to the shares collection
	 */
	@Override
	public void addShare(String tickerSymbol, String stockName, int numShares ) {
		if(shares.containsKey(tickerSymbol)){
			shares.get(tickerSymbol).incrementShares(numShares);
			return;
		}
			
		IShare tempShare = new Share(tickerSymbol, stockName, numShares); 
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
