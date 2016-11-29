package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.IFrame;

public class ExitFrame implements ActionListener{

	private IFrame frame;
	
	public ExitFrame(IFrame f){
		frame = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.exit();
	}

}
