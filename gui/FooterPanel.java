package gui;

import java.awt.BorderLayout;
import javax.swing.*;

import api.IModel;
import controller.CloseFolio;
import controller.DeleteFolio;

@SuppressWarnings("serial")
public class FooterPanel extends JPanel{

	private JButton footer_close;
	private JButton footer_delete;
		
	public FooterPanel(IFrame f, IModel m){
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		footer_close = new JButton("Close");
		footer_delete = new JButton("Delete");
		
		footer_close.addActionListener(new CloseFolio(f));
		footer_delete.addActionListener(new DeleteFolio(f,m));
		
		buttonPanel.add(footer_close);
		buttonPanel.add(footer_delete);
		
		this.setLayout(new BorderLayout());
		this.add(labelPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void changeCloseButtonName(String name){
		footer_close.setName(name);
	}
	
	public void changeDeleteButtonName(String name){
		footer_delete.setName(name);
	}
	
		
}
