package gui;
import javax.swing.*;

@SuppressWarnings("serial")
public class Table extends JPanel{

	String[] columnames = {
			"Ticker Symbol",
			"Stock Name",
			"Number of Shares",
			"Price per Share",
			"Value of Holding"
	};
	
	Object[][] data = {
			{"Ticker Symbol","Stock Name", "Number of Shares", "Price per Share", "Value of Holding"},
			{"Ticker Symbol value","Stock name value", 2, 1.0, 100.0},
			{"Ticker Symbol value","Stock name value", 2, 1.0, 100.0},
	};
	
	JTable table;
	
	public Table(String name){
		this.setName(name);
		
		table = new JTable(data,columnames);
		
		this.add(table);
	}
}
