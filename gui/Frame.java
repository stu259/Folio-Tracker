package gui;

import controller.*;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import api.IFolio;
import api.IModel;



@SuppressWarnings("serial")
public class Frame extends JFrame implements Observer, IFrame{

	private Menu menu;
	private TabbedPane pane;
	private String lastInput;
	
	private IModel model;
	
	
	
	public Frame(String name, IModel m){
		this.setName(name);
		
		model = m;
		
		menu = new Menu("Folio");   
		pane = new TabbedPane("FolioTracker TabbedPane", this, model);
		
		this.model.addObserver((Observer) this);
		
		this.add(pane);
		this.setSize(900, 700);
		this.setResizable(false);
		this.setJMenuBar(menu.getMenuBar());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		addListeners();
	}
	
	
	@Override
	public void update(Observable o, Object arg){
		switch(model.getStatus()){
			case "Error":
				showMessage(null, model.getMessage());
				break;
			case "NewFolio":
				addTab(lastInput);
				break;
			case "DeleteFolio":
				closeTab();
				break;
			case "Load":
				addTab(model.getMessage());
				model.setStatus("Refresh");
				break;
			default:
				IFolio folio = model.getFolio(getCurrentTab().getName());
				ITable t = getITable();
				t.update(folio);
				break;
		}
	}
	
	
	public void addListeners(){
		/* MENU EVENT HANDLERS */
		/* Folio Menu
		 * Create (0)
		 * Open (1)
		 * Save (2)
		 * SEPARATOR (3)
		 * More (4) -> Commig Soon (0)
		 * Exit (5)
		*/
		JMenu folio = menu.getMenuBar().getMenu(0);
		JMenuItem create = folio.getItem(0); 
		JMenuItem open = folio.getItem(1);
		JMenuItem save= folio.getItem(2);
		JMenuItem refresh = ((JMenu) folio.getItem(4)).getItem(0); 
		JMenuItem exit = folio.getItem(5);
		
		
		//Add other menus here
		//Add other menus' menuitems here
		
		create.addActionListener(new NewFolio(this,model));
		save.addActionListener(new Save(this, model));
		open.addActionListener(new Load(model));
		refresh.addActionListener(new Refresh(this, model));
		exit.addActionListener(new ExitFrame(this));	
		
		
		
	}

	
	public void updateTotalLabel(){
		((TabContainer) getCurrentTab()).getMain().updateTotal(getCurrentTab().getName());
	}
	
	
	public void closeTab(){
		ActionListener save = this.getJMenuBar().getMenu(0).getItem(2).getActionListeners()[0];
		save.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		pane.remove(getCurrentTab());
	}
	
	/* Not really sure if this is still needed */
	public void addMenu(String name,String desc, JMenuItem[] items){
		JMenu m = new JMenu(name);
		m.getAccessibleContext().setAccessibleDescription(desc);
		if(!(items.length == 0)){
			for(JMenuItem item: items){
				m.add(item);
			}
		}
		
		menu.getMenuBar().add(m);
	}
	
	
	public void addTab(String name){
		pane.addTabb(name);
	}
	
	
	public TabContainer getCurrentTab(){
		return (pane.getSelectedComponent() == null) ? null : (TabContainer) pane.getSelectedComponent();
	}
	
	
	public TabbedPane getPane(){
		return pane;
	}

	
	public ITable getITable(){
		return getCurrentTab().getMain().getTable();
	}

	
	/* Some methods that holds the information that the user inputed so we can use it */
	
	
	public String getTickerSymbol() {
		return getCurrentTab().getHeader().getTickerSymbol();
	}


	
	public int getNShares() {
		try{
			return Integer.parseInt(getCurrentTab().getHeader().getNumShares());
		}catch(NumberFormatException e){
			System.out.println("Catched the exception so gonna return 0 and do nothing");
			return 0;
		}
	}


	
	public void exit() {
		/*Add code for saving or other functions to be executed before actually exiting the program*/
		System.exit(0);
	}

	@Override
	public int getNumTabs() {
		return pane.getComponentCount();
	}

	@Override
	public List<String> getAllTabs() {
		List<String> tabs = new ArrayList<String>();
		for(int i = 0; i < getNumTabs(); ++i){
			tabs.add(((TabContainer) pane.getComponent(i)).getName());
		}
		return tabs;
	}

	@Override
	public void showMessage(Component parentComponent, String message) {
		showMessageDialog(parentComponent, message);
	}

	@Override
	public String getuserInput(String message) {
		lastInput = JOptionPane.showInputDialog(message);
		return lastInput;
	}

	
	
}
