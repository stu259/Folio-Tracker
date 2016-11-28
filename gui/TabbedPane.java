package gui;

import javax.swing.*;

import api.IModel;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{
	private IFrame frame;
	private IModel model;

	public TabbedPane(String name, IFrame f, IModel m){
		this.setName(name);
		model = m;
		frame = f;
	}
	
	public void addTabb(String name){
		TabContainer a = new TabContainer(name,frame,model);
		this.addTab(name,a);
	}
}
