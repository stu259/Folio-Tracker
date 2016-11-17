package gui;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	
	Table table;
	
	public MainPanel(){
		
		table = new Table("Stocks");
		this.add(new JScrollPane(table));
	}
	
	
}
