package api;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import javax.swing.JOptionPane;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;

public class Model extends java.util.Observable implements IModel{
	private Map<String,IFolio> folios;
	
	public Model(){
		folios = new HashMap<String,IFolio>();
		
	}
	
	@Override
	public Set<String> getFolioNames(){
		return folios.keySet();
	}
	
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
	
	@Override
	public void createFolio(String name){
		folios.put(name, new Folio());
		update();
	}
	
	@Override
	public void addFolio(IFolio f){
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
		update();
	} 
	
	@Override
	public void sellShares(String folioName, String tSymbol, int amount){
		try {
			folios.get(folioName).removeShare(tSymbol, amount);
		}
		catch(InvalidNumberOfSharesException ex) {
			showMessageDialog(null, "You don't have that many shares for ticker: " + tSymbol, "Can't sell that many",
					JOptionPane.ERROR_MESSAGE);
		}
		catch(InvalidStockException e) {
			showMessageDialog(null, "You can not sell a stock you don't have for ticker: " + tSymbol, "Invalid Stock",
					JOptionPane.ERROR_MESSAGE);
		}
		update();
	}
	
}
