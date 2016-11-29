package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import api.Folio;
import api.IFolio;
import api.IModel;
import gui.Frame;
import gui.IFrame;

public class Load implements ActionListener{
	

	private IFrame frame;
	private IModel model;
	
	public Load(Frame f, IModel m){
		frame = f;
		model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		File folder = new File("folios");
		File[] listOfFiles = folder.listFiles();
		
		File fileName = (File) JOptionPane.showInputDialog(null, "Please choose a folio to load...", "Folio Loader", JOptionPane.QUESTION_MESSAGE, null,
				listOfFiles,listOfFiles[1].getName());		
		
		String name = fileName.getName();
		name = name.substring(0, name.lastIndexOf('.'));
		try{
		
		
		FileInputStream fileIn = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(fileIn);

		IFolio loadedFolio = (Folio) in.readObject();
		in.close();
		
		frame.setFolioName(name);
		model.addFolio(loadedFolio, name);

		
		
	
		}
		catch(IOException exception){
			exception.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
}



