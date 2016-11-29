package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import api.IFolio;
import api.Folio;
import api.IModel;
import gui.IFrame;

public class Load implements ActionListener{
	
	private IModel model;
	private IFrame frame;
	
	public Load(IFrame f,IModel m){
		frame = f;
		model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		List<String> tabArr = new ArrayList<String>();
		tabArr = frame.getAllTabs();
		
		File folder = new File("src/folios");
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length > 0){
			File fileName = (File) JOptionPane.showInputDialog(null, "Please choose a folio to load...", "Folio Loader", JOptionPane.QUESTION_MESSAGE, null,
					listOfFiles,listOfFiles[0].getName());
			
			String temp = fileName.getName().replace(".sur", "");
			
			if(fileName != null && fileName.length() > 0 && !tabArr.contains(temp)){
				String name = fileName.getName();
				name = name.substring(0, name.lastIndexOf('.'));
				try{
				
				
				FileInputStream fileIn = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fileIn);
	
				IFolio loadedFolio = (Folio) in.readObject();
				in.close();
				
				if(loadedFolio == null)
					return;
				
				model.addFolio(loadedFolio, temp);
			
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
		
}



