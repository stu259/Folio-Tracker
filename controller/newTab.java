package controller;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class newTab implements ActionListener{
	
	// For double-click for editing use different listener instead of ActionListener
	
	//Shouldnt be done directly as reference but with some interface of the frame!
	//Otherwise correct decoupling :) YAS
	
	IFrame frame;
	
	public newTab(IFrame f)
	{
		frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tabname = JOptionPane.showInputDialog("Please name your tab");
		
		boolean invalidName = true;
		
		while(invalidName){
			if(tabname != null)
				tabname = tabname.trim();
			else
				return;
			if(!((tabname == null) || tabname.equals(""))){
				frame.addTab(tabname);
				invalidName = false;
				break;
			}
			tabname = JOptionPane.showInputDialog("You Entered nothing, Please retry");
		}
		
	}

}
