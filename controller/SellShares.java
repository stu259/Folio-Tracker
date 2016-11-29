package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import api.IModel;
import gui.IFrame;

public class SellShares implements ActionListener{
	
	private IFrame frame;
	private IModel model;
	
	public SellShares(IFrame f, IModel m){
		frame = f;
		model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(frame.getTickerSymbol() != null && frame.getTickerSymbol().length() > 0 && frame.getNShares() > 0){
			String folioName = frame.getCurrentTab().getName();
			String tSymbol = frame.getTickerSymbol();
			int amount = frame.getNShares();
			
			model.sellShares(folioName,tSymbol,amount);
		}
	}

}
