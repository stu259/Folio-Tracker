package api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class Model extends Observable{
	private Map<String,IFolio> folios;
	
	public Model(){
		folios = new HashMap<String,IFolio>();
		
	}

	public Set<String> getFolioNames(){
		return folios.keySet();
	}
	
	public String getLastFolio(){
		@SuppressWarnings("rawtypes")
		Iterator itr = folios.keySet().iterator();
	    String lastElement = (String) itr.next();
	    while(itr.hasNext()) {
	        lastElement = (String) itr.next();
	    }
	    return lastElement;
	}
	
	public void createFolio(String name){
		folios.put(name, new Folio());
		update();
	}
	
	public void addFolio(IFolio f){
		update();
	}
	
	public IFolio getFolio(String name){
		return folios.get(name);
	}
	
	private void update(){
		setChanged();
		notifyObservers();
	}

	public void buyShares(String folioName, String tSymbol, int nShares) {
		folios.get(folioName).addShare(tSymbol, "Default Share Name", nShares);
		update();
	}
	
	public void sellShares(String folioName, String tSymbol, int amount){
		folios.get(folioName).removeShare(tSymbol, amount);
		update();
	}
}
