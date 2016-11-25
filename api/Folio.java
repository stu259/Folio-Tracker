package api;

import java.util.HashMap;
import java.util.Map;

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
	 * 
	 *shady first said dont give a shit about it returning a null :P
	 */
	public IShare getShareAt(String ticker){
		return shares.get(ticker);
	}
	
	public void addShare(String tickerSymbol, String stockName, int numShares ){
		if(shares.containsKey(tickerSymbol)){
			shares.get(tickerSymbol).incrementShares(numShares);
			return;
		}
			
		IShare tempShare = new Share(tickerSymbol, stockName, numShares); 
		shares.put(tickerSymbol, tempShare);
	}
	
	public boolean removeShare(String tickerSymbol, int numShares){
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
		}
		return false;
	}
	
	
}
