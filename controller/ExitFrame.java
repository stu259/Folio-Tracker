package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Frame;

public class ExitFrame implements ActionListener{

	Frame frame;
	
	public ExitFrame(Frame f){
		frame = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.exit();
	}

}
