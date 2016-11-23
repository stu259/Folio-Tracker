package gui;

import controller.*;
import javax.swing.*;
//import API.IFolio;



@SuppressWarnings("serial")
public class Frame extends JFrame implements IFrame{

	Menu menu;
	TabbedPane pane;
	//IFolio folio;
	
	public Frame(String name/*, IFolio fol*/){
		this.setName(name);
		
		//folio = fol;
		
		menu = new Menu("Folio");   
		pane = new TabbedPane("FolioTracker TabbedPane", this/*,folio*/);
		
		this.add(pane);
		this.setSize(900, 700);
		this.setResizable(false);
		this.setJMenuBar(menu.getMenuBar());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		addListeners();
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
		//JMenuItem open = folio.getItem(1);
		//JMenuItem save= folio.getItem(2);
		//JMenuItem comingSoon = ((JMenu) folio.getItem(4)).getItem(0); 
		JMenuItem exit = folio.getItem(5);
		
		
		//Add other menus here
		//Add other menus' menuitems here
		
		create.addActionListener(new NewTab(this));
		exit.addActionListener(new ExitFrame(this));	
		
	}
	
	@Override
	public void updateTotalLabel(){
		((TabContainer) getCurrentTab()).getMain().updateTotal(getCurrentTab().getName());
	}
	
	@Override
	public void closeTab(){
		/* Consider writing to file before closing the panel */
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
	
	@Override
	public void addTab(String name){
		pane.addTabb(name);
	}
	
	@Override
	public TabContainer getCurrentTab(){
		return (TabContainer) pane.getSelectedComponent();
	}
	
	
	public TabbedPane getPane(){
		return pane;
	}

	@Override
	public ITable getITable(){
		return getCurrentTab().getMain().getTable();
	}

	
	/* Some methods that holds the information that the user inputed so we can use it */
	
	@Override
	public String getTickerSymbol() {
		return getCurrentTab().getHeader().getTickerSymbol();
	}


	@Override
	public int getNShares() {
		
		return (getCurrentTab().getHeader().getNumShares() == "") ? 0 : Integer.parseInt(getCurrentTab().getHeader().getNumShares());
	}


	@Override
	public void exit() {
		/*Add code for saving or other functions to be executed before actually exiting the program*/
		System.exit(0);
	}

	
	
}
