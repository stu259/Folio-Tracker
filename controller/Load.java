package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JOptionPane;

import api.IFolio;
import api.Folio;
import api.IModel;

public class Load implements ActionListener{
	
	private IModel model;
	
	public Load(IModel m){
		model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		File folder = new File("src/folios");
		File[] listOfFiles = folder.listFiles();
		
		File fileName = (File) JOptionPane.showInputDialog(null, "Please choose a folio to load...", "Folio Loader", JOptionPane.QUESTION_MESSAGE, null,
				listOfFiles,listOfFiles[0].getName());		
		
		if(fileName != null && fileName.length() > 0){
			String name = fileName.getName();
			name = name.substring(0, name.lastIndexOf('.'));
			try{
			
			
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			IFolio loadedFolio = (Folio) in.readObject();
			in.close();
			
			
			
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
		
}



