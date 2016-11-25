package gui;

import javax.swing.*;

import api.Model;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{
	private Frame frame;
	private Model model;

	public TabbedPane(String name, Frame f, Model m){
		this.setName(name);
		model = m;
		frame = f;
	}
	
	public void addTabb(String name){
		TabContainer a = new TabContainer(name,frame,model);
		this.addTab(name,a);
	}
}
