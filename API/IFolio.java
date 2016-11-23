package API;

import java.awt.List;
import java.util.Map;

//should abstract be here?
public abstract interface IFolio {
	public Map<String, IShare> getFolioList();
	public IShare getShareAt(String ticker);
	public boolean removeShare(String tickerSymbol, int numShares);
	public void addShare(String tickerSymbol, String stockName, int numShares );
	
}
