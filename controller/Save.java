package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.IFrame;
import gui.ITable;

public class Save implements ActionListener{

	IFrame frame;
	
	public Save(IFrame f){
		frame = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ITable t = frame.getITable();
		for(int i = 0; i < t.getTable().getRowCount(); ++i){
			//Object[] row = t.getRow(i);
			//String tSymbol = (String) row[0];
			/*
			(String) row[0] - Ticker Symbol
			(String) row[1] - Share Name
			(int) row[2] - Number of Shares
			(double) row[3] - initial price
			(double) row[4] - holding value
			*/
			
			//String toBeWrittern = tSymbol + .. all the rest;
			
		}
	}
	

}
