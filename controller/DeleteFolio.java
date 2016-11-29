package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import api.IModel;
import gui.IFrame;

public class DeleteFolio implements ActionListener{
	
	private IFrame frame;
	private IModel model;
	
	public DeleteFolio(IFrame f, IModel m){
		frame = f;
		model = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String folioName = frame.getCurrentTab().getName();
		model.deleteFolio(folioName);
		File file = new File("src/folios/" + folioName + ".sur");
		file.delete();
		
	}

}
