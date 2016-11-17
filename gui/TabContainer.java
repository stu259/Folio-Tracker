package gui;

import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class TabContainer extends JPanel{
	
	FooterPanel footer;
	MainPanel main;
	HeaderPanel header;

	public TabContainer(){
		header = new HeaderPanel();
		main = new MainPanel();
		footer = new FooterPanel();

		
		header.setPreferredSize(new Dimension(900, 50));
		main.setPreferredSize(new Dimension(900, 480));
		footer.setPreferredSize(new Dimension(900, 70));
		
		main.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.add(header, BorderLayout.PAGE_START );
		this.add(main, BorderLayout.CENTER);
		this.add(footer, BorderLayout.PAGE_END );
	}
	
	//Maybe add getters and setters
}
