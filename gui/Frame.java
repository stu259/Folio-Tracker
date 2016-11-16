package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	Menu menu;
	JMenuBar menubar;
	TabbedPane pane;
	
	
	public Frame(String name){
		super(name);
		
		this.setSize(800, 600);
		
		menu = new Menu("Folio");   
		menubar = menu.getMenuBar();
		menubar.getMenu(0).getItem(0).addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addTab("Tab");
			}
			
		});
		
		pane = new TabbedPane("Home");
		
		this.setJMenuBar(menubar);
		
		this.add(pane);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public void addSomething(String name, String description){
		//this.add(comp);
	}
	
	public void addMenu(String name,String desc, JMenuItem[] items){
		JMenu m = new JMenu(name);
		m.getAccessibleContext().setAccessibleDescription(desc);
		if(!(items.length == 0)){
			for(JMenuItem item: items){
				m.add(item);
			}
		}
		
		menubar.add(m);
	}
	
	public void addTab(String name){
		pane.addTabb(name);
	}
}
