package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.IFrame;

public class SellShares implements ActionListener{
	
	IFrame frame;
	
	public SellShares(IFrame f){
		frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tSymbol = frame.getTickerSymbol();
		int amount = frame.getNShares();
		
		Object[] row = frame.getITable().getRow(tSymbol);
		
		if(row != null){
			frame.getITable().updateRow(amount,tSymbol);
		}
		frame.updateTotalLabel();
		
	}

}
