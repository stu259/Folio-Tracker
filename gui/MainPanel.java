package gui;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	
	private Table table;
	private JLabel folioTotal;
	
	public MainPanel(IFrame f){
		folioTotal = new JLabel("Empty Label");
		table = new Table("Stocks",f);
		
		folioTotal.setForeground(Color.blue);
		
		this.add(table, BorderLayout.PAGE_START);
		this.add(folioTotal, BorderLayout.PAGE_END);
	}
	
	public Table getTable(){
		return table;
	}
	
	/*Call this method every time we add/remove row from the table*/
	public void updateTotal(String tabname){
		double val = 0;
		for(int i = 0; i < table.rows(); ++i){
			val += (double) table.getRow(i)[4];
		}
		folioTotal.setText("Total value for '" + tabname + "' is " + val + ".");
	}
	
	
}
