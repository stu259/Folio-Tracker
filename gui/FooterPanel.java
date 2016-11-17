package gui;

import java.awt.BorderLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class FooterPanel extends JPanel{

		JButton footer_close;
		JButton footer_delete;
		JLabel footer_label;
		
		public FooterPanel(){
		
			JPanel labelPanel = new JPanel();
			JPanel buttonPanel = new JPanel();
			footer_close = new JButton("Close");
			footer_delete = new JButton("Delete");
			footer_label = new JLabel("Footer Panel");
			labelPanel.add(footer_label);
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
