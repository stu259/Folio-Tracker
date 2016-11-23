package gui;

import javax.swing.*;

//import API.IFolio;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{
	private IFrame frame;
	//private IFolio folio;

	public TabbedPane(String name, IFrame f/*, IFolio fol*/){
		this.setName(name);
		//folio = fol;
		frame = f;
	}
	
	public void addTabb(String name){
		TabContainer a = new TabContainer(name,frame/*,folio*/);
		this.addTab(name,a);
	}
}
