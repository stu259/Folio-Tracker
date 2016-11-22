package gui;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{
	private IFrame frame;

	public TabbedPane(String name, IFrame f){
		this.setName(name);
		frame = f;
	}
	
	public void addTabb(String name){
		TabContainer a = new TabContainer(name,frame);
		this.addTab(name,a);
	}
}
