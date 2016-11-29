package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		model.deleteFolio(frame.getCurrentTab().getName());
	}

}
