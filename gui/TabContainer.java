package gui;

import java.awt.*;
import javax.swing.*;

import api.IModel;


@SuppressWarnings("serial")
public class TabContainer extends JPanel{
	
	private FooterPanel footer;
	private MainPanel main;
	private HeaderPanel header;

	public TabContainer(String name, IFrame f, IModel m){
		this.setName(name);
		
		header = new HeaderPanel(f,m);
		main = new MainPanel(f,m);
		footer = new FooterPanel(f,m);
		
		header.setPreferredSize(new Dimension(900, 50));
		main.setPreferredSize(new Dimension(900, 480));
		footer.setPreferredSize(new Dimension(900, 70));
		
		main.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.add(header, BorderLayout.PAGE_START );
		this.add(main, BorderLayout.CENTER);
		this.add(footer, BorderLayout.PAGE_END );
	}
	
	public HeaderPanel getHeader(){
		return header;
	}
	public MainPanel getMain(){
		return main;
	}
	public FooterPanel getFooter(){
		return footer;
	}
	
}
