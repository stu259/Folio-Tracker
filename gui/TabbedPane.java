package gui;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{

	public TabbedPane(String name){
		this.setName(name);
	}
	
	public void addTabb(String name){
		
		TabContainer a = new TabContainer();
		this.addTab(name,a);
	}
}
