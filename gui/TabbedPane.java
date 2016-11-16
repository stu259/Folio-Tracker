package gui;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabbedPane extends JTabbedPane{

	public TabbedPane(String name){
		this.setName(name);
	}
	
	public void addTabb(String name){
		
		JPanel header;
		JPanel mainContainer;
		JPanel footer;
		JPanel con;
		
		
		con = new JPanel();
		con.setLayout(new BoxLayout(con,BoxLayout.PAGE_AXIS));
		
		header = new JPanel();
		JLabel infoh = new JLabel("Header container");
		
		mainContainer = new JPanel();
		Table table = new Table("Stocks");
		
		
		footer = new JPanel();
		JLabel infof = new JLabel("Footer container");
		
		header.add(infoh);
		mainContainer.add(table);
		footer.add(infof);
		
		
		con.add(header);
		con.add(mainContainer);
		con.add(footer);
		
		this.addTab(name, con);
	}
}
