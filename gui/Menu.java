package gui;

import javax.swing.*;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	JMenuBar menubar;
	JMenu menu,submenu;
	JMenuItem menuItem;
	
	public Menu(String menuName){
		menubar = new JMenuBar();
		
		menu = new JMenu(menuName);
		menubar.add(menu);
		
		menuItem = new JMenuItem("Create");
		menu.add(menuItem);
		
		//adding this to cover gui specs for submission1.
		//can edit / refactor afterwards
		JMenuItem x = new JMenuItem("Open");
		JMenuItem y = new JMenuItem("Save");
		menu.add(x);
		menu.add(y);
		////////////////
		
		menu.addSeparator();

		
		submenu = new JMenu("More");
		
		menuItem = new JMenuItem("Coming soon!");
		submenu.add(menuItem);
		
		menu.add(submenu);
		
		menubar.add(menu);
		
	}
	
	public void addMenu(JMenu m){
		menubar.add(m);
	}
	
	public void addSubMenu(String name){
		submenu = new JMenu(name);
		menubar.add(submenu);
	}
	
	public void addMenuItem(JMenu m, String name){
		menuItem = new JMenuItem(name);
		m.add(menuItem);
	}
	
	public JMenuBar getMenuBar(){
		return menubar;
	}
	
	
}
