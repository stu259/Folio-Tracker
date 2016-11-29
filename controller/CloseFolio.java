package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.IFrame;

public class CloseFolio implements ActionListener{

	private IFrame frame;
	
	public CloseFolio(IFrame f){
		frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.closeTab();
	}
	
}
