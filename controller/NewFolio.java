package controller;
import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import api.IModel;

public class NewFolio implements ActionListener{
	
	private IFrame frame;
	private IModel model;
	
	public NewFolio(IFrame f, IModel m)
	{
		frame = f;
		model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String folioName = frame.getuserInput("Please name your tab");
		
		boolean invalidName = true;
		
		while(invalidName){
			if(folioName != null)
				folioName = folioName.trim();
			else
				return;
			if(!((folioName == null) || folioName.equals("") || model.getFolioNames().contains(folioName))){
				
				invalidName = false;
				model.createFolio(folioName);
				break;
			}
			folioName = frame.getuserInput("You Entered nothing or a duplicate, Please retry");
		}
		
	}

}
