package controller;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;

import gui.IFrame;
import api.IFolio;
import api.IModel;

public class Save implements ActionListener{

	private IFrame frame;
	private IModel model;
	
	public Save(IFrame f, IModel m){
		frame = f;
		model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	int numTabs = frame.getNumTabs();
	List<String> tabArr = new ArrayList<String>();
	tabArr = frame.getAllTabs();
		
		
	for(int i = 0; i<= numTabs-1; i++){
		try{
			
			IFolio currFolio = model.getFolio(tabArr.get(i));
		
			FileOutputStream fileOut = new FileOutputStream("src/folios/" + tabArr.get(i) + ".sur");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject((IFolio)currFolio);
			out.close();
			fileOut.close();
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
			
	}
		
	}
}
	



