package api;


import java.io.Serializable;
import java.util.*;
import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

@SuppressWarnings("serial")
public class Model extends java.util.Observable implements IModel, Serializable{
	private Map<String,IFolio> folios;
	private String status;
	private String message;
	
	public Model(){
		folios = new HashMap<String,IFolio>();
		
	}
	
	@Override
	public void refresh(String name){
		if(folios.get(name).getShares().length > 0){
			setStatus("Refresh");
		}
	}
	
	/**
	 * effects: returns all folio names as a set
	 */
	@Override
	public Set<String> getFolioNames(){
		return folios.keySet();
	}
	
	/**
	 * requires: name != null || name != "" 	
	 * modifies: this
	 * effects: if a folio with the given name is present it is removed. Then calls update().
	 */
	@Override
	public void deleteFolio(String name){
		folios.remove(name);
		setStatus("DeleteFolio");
	}
	
	/**
	 * effects: returns the last folio added to the model
	 */
	@Override
	public String getLastFolio(){
		@SuppressWarnings("rawtypes")
		Iterator itr = folios.keySet().iterator();
	    String lastElement = (String) itr.next();
	    while(itr.hasNext()) {
	        lastElement = (String) itr.next();
	    }
	    return lastElement;
	}
	
	/**
	 * requires: name != null || name != "" 
	 * modifies: this
	 * effects: creates or overwrites a folio with the given name 
	 *          and adds it to the collection of folios.
	 *          finally update method is called. 
	 */
	@Override
	public void createFolio(String name){
		folios.put(name, new Folio(this));
		setStatus("NewFolio");
	}
	
	@Override
	public void addFolio(IFolio f){
		update();
	}
	
	@Override
	public void addFolio(IFolio f, String name){
		if(folios.containsKey(name)){
			//error
		}
		else{
			folios.put(name, f);
		}
		update();
	}
	
	@Override
	public IFolio getFolio(String name){
		return folios.get(name);
	}
	
	
	private void update(){
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void buyShares(String folioName, String tSymbol, int nShares) {
		folios.get(folioName).addShare(tSymbol, "Default Share Name", nShares);
		setStatus("BuyShare");
	} 
	
	@Override
	public void sellShares(String folioName, String tSymbol, int amount){
		try {
			folios.get(folioName).removeShare(tSymbol, amount);
			setStatus("SellShare");
		}
		catch(InvalidNumberOfSharesException ex) {
			message = "You don't have that many shares for ticker: " + tSymbol;
			setStatus("Error");
		}
		catch(InvalidStockException e) {
			message = "You can not sell a share you don't have for ticker: " + tSymbol;
			setStatus("Error");
		}
	}

	@Override
	public void updateShare(String folioName, String tSymbol, String newName) {
		folios.get(folioName).getShareAt(tSymbol).setShareName(newName);
		setStatus("UpdateShare");
	}
	
	@Override
	public void setStatus(String msg){
		status = msg;
		update();
	}

	@Override
	public String getStatus() {
		return status;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
	
	@Override
	public void setMessage(String msg){
		message = msg;
	}
	
	
}
