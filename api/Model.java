package api;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;
import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

@SuppressWarnings("serial")
public class Model extends java.util.Observable implements IModel, Serializable{
	private Map<String,IFolio> folios;
	
	public Model(){
		folios = new HashMap<String,IFolio>();
		
	}
	
	/**
	 * effects: calls update() if folio has any shares
	 */
	@Override
	public void refresh(String name){
		if(folios.get(name).getShares().length > 0)
			update();
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
	 * effects: if a folio with the given name is present it is removed. 
	 *          Then calls update().
	 */
	@Override
	public void deleteFolio(String name){
		folios.remove(name);
		//update();
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
		folios.put(name, new Folio());
		update();
	}
	
	/**
	 * requires: name != null || name != "" ||
	 *           f    != null
	 * modifies: this
	 * effects: adds the folio to the collection of folios if
	 *          it isn't already there. Then update method is called. 
	 */
	@Override
	public void addFolio(IFolio f, String name){
		if(!(folios.containsKey(name))){
			folios.put(name, f);
		}
		update();
	}
	
	/**
	 * requires: name != null || name != "" 	
	 * effects: returns folio if name is a key.
	 *                  or null if not a key.
	 */
	@Override
	public IFolio getFolio(String name){
		return folios.get(name);
	}
	
	/**
	 * effects: shows that this(backend) has been changed and notifies
	 *          observers(gui) that this has been updated.
	 */
	private void update(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 * requires: tSymbol   != null    || tSymbol != "" ||
	 * 			 nShares > 0 	      || 
	 * 			 folioName != null 	  || folioName != ""	
	 * effects:  calls add shares for the folio specified. It then calls update
	 *           method
	 */
	@Override
	public void buyShares(String folioName, String tSymbol, int nShares) {
		folios.get(folioName).addShare(tSymbol, "Default Share Name", nShares);
		update();
	} 
	
	/**
	 * requires: tSymbol   != null || tSymbol   != "" ||
	 * 			 folioName != null || folioName != "" ||
	 * 			 amount > 0	
	 * effects: throws InvalidNumberOfSharesException if there aren't enough that share to be sold
	 *          throws InvalidStockException if there is no share with the same name as specified
	 *          calls removeShares for the folio specified. then calls update()
	 */
	@Override
	public void sellShares(String folioName, String tSymbol, int amount){
		try {
			folios.get(folioName).removeShare(tSymbol, amount);
			update();
		}
		catch(InvalidNumberOfSharesException ex) {
			showMessageDialog(null, "You don't have that many shares for ticker: " + tSymbol, "Can't sell that many",
					JOptionPane.ERROR_MESSAGE);
		}
		catch(InvalidStockException e) {
			showMessageDialog(null, "You can not sell a share you don't have for ticker: " + tSymbol, "Invalid Share",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * requires: tSymbol != null || tSymbol != "" ||
	 * 			 folioName    != null || folioName    != "" || 
	 * 			 newName      != null || newName      != ""	
	 * effects:  updates the name of the share by calling setShareName for the specific share.
	 *           update() is then called.
	 */
	@Override
	public void updateShare(String folioName, String tSymbol, String newName) {
		folios.get(folioName).getShareAt(tSymbol).setShareName(newName);
		update();
	}
	
}
