package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.IFrame;
import api.IModel;

public class BuyShares implements ActionListener{
	private IFrame frame;
	private IModel model;
	
	
	public BuyShares(IFrame f,IModel m)
	{
		frame = f;
		model = m;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = frame.getTickerSymbol();
		int amount = frame.getNShares();
		model.buyShares(frame.getCurrentTab().getName(),name, amount);
	}

}
