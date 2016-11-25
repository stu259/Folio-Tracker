package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Frame;

public class CloseTab implements ActionListener{

	Frame frame;
	
	public CloseTab(Frame f){
		frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.closeTab();
	}
	
}
