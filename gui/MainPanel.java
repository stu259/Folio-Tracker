package gui;
import java.awt.*;

import javax.swing.*;

import api.IShare;
import api.Model;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	
	private Table table;
	private JLabel folioTotal;
	private Model model;
	private Frame frame;
	
	public MainPanel(Frame f, Model m){
		model = m;
		frame = f;
		folioTotal = new JLabel("Empty Label");
		table = new Table("Stocks",frame,model);
		
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
		IShare[] s =  model.getFolio(frame.getCurrentTab().getName()).getShares();
		int nShares = s.length;
		for(int i = 0; i < nShares ; ++i){
			val += s[i].getValueHolding();
		}
		folioTotal.setText("Total value for '" + tabname + "' is " + val + ".");
	}
	
	
}
