package gui;
import javax.swing.*;

import controller.AddTableRow;

@SuppressWarnings("serial")
public class HeaderPanel extends JPanel{

	private JButton header_add;
	private JButton header_temp;
	
	private JLabel header_tickerlabel;
	private JLabel header_numlabel;
	
	private JTextField header_tickerSymbol;
	private JTextField header_numShares;
	
	public HeaderPanel(IFrame f){
		
		header_add = new JButton("Add");
		header_temp = new JButton("Temp");
		
		header_add.addActionListener(new AddTableRow(f));
		
		header_tickerlabel = new JLabel("Ticker Symbol:");
		header_numlabel = new JLabel("Number of Shares");
		
		header_tickerSymbol = new JTextField(15);
		header_numShares = new JTextField(15);
		
		this.add(header_tickerlabel);
		this.add(header_tickerSymbol);
		this.add(header_numlabel);
		this.add(header_numShares);
		this.add(header_add);
		this.add(header_temp);
	}
	
	public JButton getAdd(){
		return header_add;
	}
	
	public String getTickerSymbol(){
		return (header_tickerSymbol.getText() == null)? "" : header_tickerSymbol.getText();
	}
	
	public String getNumShares(){
		return (header_numShares.getText() == null)? "" : header_numShares.getText();
	}
	
}
