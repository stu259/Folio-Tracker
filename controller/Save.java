package controller;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionListener;

import gui.Frame;
import gui.IFrame;
import gui.ITable;
import api.Folio;
import api.IFolio;
import api.Model;

public class Save implements ActionListener{

	private IFrame frame;
	private Model model;
	
	public Save(Frame frame, Model m){
		frame = frame;
		model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int numTabs = frame.getNumTabs();
		ArrayList<String> tabArr = new ArrayList<String>();
		tabArr = frame.getAllTabs();
		
		
		for(int i = 0; i<= numTabs; i++){
			try{
			IFolio currFolio = model.getFolio(tabArr.get(i));
			
			
				FileOutputStream fileOut = new FileOutputStream("/tmp/testing" );
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject((Folio)currFolio);
				out.close();
				fileOut.close();
				System.out.println("Saved as testing");
			}
			catch(IOException exception){
				exception.printStackTrace();
			}
			
		}
		
		}
	}
	


