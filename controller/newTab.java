package controller;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class newTab implements ActionListener{
	
	// For double-click for editing use different listener instead of ActionListener
	
	//Shouldnt be done directly as reference but with some interface of the frame!
	//Otherwise correct decoupling :) YAS
	
	Frame frame;
	
	public newTab(Frame f)
	{
		frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tabname = JOptionPane.showInputDialog(frame, "Please name your tab");
		
		if((tabname == null))
			return;
		else if(tabname.equals("") || tabname.equals(" "))
			JOptionPane.showMessageDialog(frame, "You Entered nothing, Please retry");
		else
			frame.addTab(tabname);
	}

}
