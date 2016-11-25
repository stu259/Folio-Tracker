package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import api.Model;
import gui.Frame;

public class SellShares implements ActionListener{
	
	Frame frame;
	Model model;
	
	public SellShares(Frame f, Model m){
		frame = f;
		model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String tSymbol = frame.getTickerSymbol();
		int amount = frame.getNShares();
		
		model.sellShares(frame.getCurrentTab().getName(),tSymbol,amount);
	}

}
