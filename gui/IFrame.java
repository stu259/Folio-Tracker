package gui;

import java.awt.Component;
public interface IFrame {
	
	/* Get selected tab's component*/
	Component getCurrentTab();
	
	/* Get table for the selected tab*/
	ITable getITable();
	
	/* Get the ticker symbol from user input*/
	String getTickerSymbol();
	
	/* Get the number of shares from user input*/
	int getNShares();

	/* Tries to add tab to the frame with the specified name*/
	void addTab(String tabname);
	
	/* Closes the selected tab*/
	void closeTab();
	
	/* Close the frame and exit the program*/
	void exit();
	
}
