package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.IFrame;

public class CloseTab implements ActionListener{

	IFrame frame;
	
	public CloseTab(IFrame f){
		frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.closeTab();
	}

	
}
