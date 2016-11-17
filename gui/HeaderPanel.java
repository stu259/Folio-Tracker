package gui;
import javax.swing.*;

@SuppressWarnings("serial")
public class HeaderPanel extends JPanel{

	JButton header_add;
	JButton header_temp;
	
	JLabel header_tickerlabel;
	JLabel header_numlabel;
	
	JTextField header_tickerSymbol;
	JTextField header_numShares;
	
	public HeaderPanel(){
		
		header_add = new JButton("Add");
		header_temp = new JButton("Temp");
		
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
}
