package gui;
import controller.*;
import java.awt.*;
import javax.swing.*;



@SuppressWarnings("serial")
public class Frame extends JFrame{

	Menu menu;
	TabbedPane pane;
	
	public Frame(String name){
		super(name);
		
		menu = new Menu("Folio");   
		pane = new TabbedPane("FolioTracker TabbedPane");
		
		this.add(pane);
		this.setSize(900, 700);
		this.setResizable(false);
		this.setJMenuBar(menu.getMenuBar());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		addListeners();
	}
	
	
	private void addListeners(){
		JMenu folio = menu.getMenuBar().getMenu(0);
		JMenuItem add = folio.getItem(0);
		//Add all other menuitems of folio here
		
		//Add other menus here
		//Add other menus' menuitems here
		
		add.addActionListener(new newTab(this));
		//Add other actionlisteners or whatever listeners here.
	}
	
	
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
	
	public Component getTabAt(int index){
		return pane.getComponentAt(index);
	}
	
	public void addTab(String name){
		pane.addTabb(name);
	}
}
