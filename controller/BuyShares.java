package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Frame;
import api.Model;

public class BuyShares implements ActionListener{
	private Frame frame;
	private Model model;
	
	
	public BuyShares(Frame f,Model m)
	{
		frame = f;
		model = m;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		model.buyShares(frame.getCurrentTab().getName(), frame.getTickerSymbol(), frame.getNShares());
	}

}
