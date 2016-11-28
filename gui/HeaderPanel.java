package gui;
import javax.swing.*;

import api.IModel;
import controller.BuyShares;
import controller.SellShares;

@SuppressWarnings("serial")
public class HeaderPanel extends JPanel{

	private JButton header_buy;
	private JButton header_sell;
	
	private JLabel header_tickerlabel;
	private JLabel header_numlabel;
	
	private JTextField header_tickerSymbol;
	private JTextField header_numShares;
	
	public HeaderPanel(IFrame f, IModel m){
		
		header_buy = new JButton("Buy");
		header_sell = new JButton("Sell");
		
		header_buy.addActionListener(new BuyShares(f,m));
		header_sell.addActionListener(new SellShares(f,m));
		
		header_tickerlabel = new JLabel("Ticker Symbol:");
		header_numlabel = new JLabel("Number of Shares");
		
		header_tickerSymbol = new JTextField(15);
		header_numShares = new JTextField(15);
		
		this.add(header_tickerlabel);
		this.add(header_tickerSymbol);
		this.add(header_numlabel);
		this.add(header_numShares);
		this.add(header_buy);
		this.add(header_sell);
	}
	
	public JButton getBuyButton(){
		return header_buy;
	}
	
	public String getTickerSymbol(){
		return header_tickerSymbol.getText();
	}
	
	public String getNumShares(){
		return header_numShares.getText();
	}
	
}
