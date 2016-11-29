package api;

import java.util.Set;


public interface IModel {
	
	public Set<String> getFolioNames();
	
	/**
	 * effects: returns the last folio added to the model
	 */
	public String getLastFolio();
	
	/**
	 * requires: name != null || name != "" 
	 * modifies: this
	 * effects: creates or overwrites a folio with the given name 
	 *          and adds it to the collection of folios.
	 *          finally update method is called. 
	 */
	public void createFolio(String name);
	
	/**
	 * effects: returns the last folio added to the model
	 */
	public IFolio getFolio(String name);
	
	/**
	 * requires: name != null || name != "" 	
	 * modifies: this
	 * effects: if a folio with the given name is present it is removed. 
	 *          Then calls update().
	 */
	public void deleteFolio(String name);
	
	/**
	 * effects: calls update() if folio has any shares
	 */
	public void refresh(String name);
	
	/**
	 * requires: tSymbol   != null    || tSymbol != "" ||
	 * 			 nShares > 0 	      || 
	 * 			 folioName != null 	  || folioName != ""	
	 * effects:  calls add shares for the folio specified. It then calls update
	 *           method
	 */
	public void buyShares(String folioName, String tSymbol, int nShares);
	
	/**
	 * requires: tSymbol   != null || tSymbol   != "" ||
	 * 			 folioName != null || folioName != "" ||
	 * 			 amount > 0	
	 * effects: throws InvalidNumberOfSharesException if there aren't enough that share to be sold
	 *          throws InvalidStockException if there is no share with the same name as specified
	 *          calls removeShares for the folio specified. then calls update()
	 */
	public void sellShares(String folioName, String tSymbol, int amount);
	
	/**
	 * requires: tSymbol != null || tSymbol != "" ||
	 * 			 folioName    != null || folioName    != "" || 
	 * 			 newName      != null || newName      != ""	
	 * effects:  updates the name of the share by calling setShareName for the specific share.
	 *           update() is then called.
	 */
	public void updateShare(String folioName, String tSymbol, String newName);

	/**
	 * requires: name != null || name != "" ||
	 *           f    != null
	 * modifies: this
	 * effects: adds the folio to the collection of folios if
	 *          it isn't already there. Then update method is called. 
	 */
	public void addFolio(IFolio f, String name);
	
	/**
	 * requires: msg   != null    || msg != ""
	 * modifies: status
	 * effects:  changes status to msg and calls update()
	 */
	public void setStatus(String msg);
	
	/**
	 * effects: returns status
	 */
	public String getStatus();
	
	/**
	 * effects: returns message
	 */
	public String getMessage();
	
	/**
	 * requires: msg   != null    || msg != ""
	 * modifies: message
	 * effects:  changes message to msg and calls update()
	 */
	public void setMessage(String msg);
	
	public void addObserver(java.util.Observer o);
	
}
