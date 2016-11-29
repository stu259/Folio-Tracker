package api;

import java.util.Set;


public interface IModel {
	
	public Set<String> getFolioNames();
	
	public String getLastFolio();
	
	public void createFolio(String name);
	
	public void addFolio(IFolio f);
	
	public IFolio getFolio(String name);
	
	public void deleteFolio(String name);
	
	public void refresh(String name);

	public void buyShares(String folioName, String tSymbol, int nShares);
	
	public void sellShares(String folioName, String tSymbol, int amount);
	
	public void addObserver(java.util.Observer o);
	
	public void updateShare(String folioName, String tSymbol, String newName);

	public void addFolio(IFolio f, String name);
	
	
	
}
