package gui;

import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	JMenuBar menubar;
	JMenu menu,submenu;
	
	public Menu(String menuName){
		
		menubar = new JMenuBar();
		menu = new JMenu(menuName);
		
		submenu = new JMenu("More");
		
		JMenuItem create = new JMenuItem("Create");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem refresh = new JMenuItem("Refresh");
		KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
		refresh.setAccelerator(f5);
		
		menu.add(create);
		menu.add(open);
		menu.add(save);
		menu.addSeparator();
		submenu.add(refresh);
		menu.add(submenu);
		menu.add(exit);
		menubar.add(menu);
		
	}
	
	public void addMenu(JMenu m){
		menubar.add(m);
	}
	
	public JMenuBar getMenuBar(){
		return menubar;
	}
	
	
}
