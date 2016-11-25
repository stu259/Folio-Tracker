package gui;

import java.awt.BorderLayout;
import javax.swing.*;

import api.Model;
import controller.CloseTab;

@SuppressWarnings("serial")
public class FooterPanel extends JPanel{

	private JButton footer_close;
	private JButton footer_delete;
		
	public FooterPanel(Frame f, Model m){
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		footer_close = new JButton("Close");
		footer_delete = new JButton("Delete");
		
		footer_close.addActionListener(new CloseTab(f));
		//footer_delete.addActionListener(new DeleteTab(f));
		
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
