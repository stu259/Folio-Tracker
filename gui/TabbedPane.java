package gui;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{

	public TabbedPane(String name){
		this.setName(name);
	}
	
	public void addTabb(String name){
		
		JPanel mainContainer;
		JPanel con;
		
		FooterPanel footer = new FooterPanel();
		HeaderPanel header = new HeaderPanel();
		
		con = new JPanel();
		con.setLayout(new BoxLayout(con,BoxLayout.PAGE_AXIS));
		
		mainContainer = new JPanel();
		Table table = new Table("Stocks");
		
		mainContainer.add(table);
		
		con.add(header);
		con.add(mainContainer);
		con.add(footer);
		
		this.addTab(name, con);
	}
}
