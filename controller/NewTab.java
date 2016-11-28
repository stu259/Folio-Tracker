package controller;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import api.IModel;

public class NewTab implements ActionListener{
	
	// For double-click for editing use different listener instead of ActionListener
	
	//Shouldnt be done directly as reference but with some interface of the frame!
	//Otherwise correct decoupling :) YAS
	
	private IFrame frame;
	private IModel model;
	
	public NewTab(IFrame f, IModel m)
	{
		frame = f;
		model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String folioName = JOptionPane.showInputDialog("Please name your tab");
		
		boolean invalidName = true;
		
		while(invalidName){
			if(folioName != null)
				folioName = folioName.trim();
			else
				return;
			if(!((folioName == null) || folioName.equals("") || model.getFolioNames().contains(folioName))){
				frame.setFolioName(folioName);
				invalidName = false;
				
				model.createFolio(frame.getFolioName());
				break;
			}
			folioName = JOptionPane.showInputDialog("You Entered nothing or a duplicate, Please retry");
		}
		
	}

}
