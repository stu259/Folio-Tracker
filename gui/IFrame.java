package gui;

import java.awt.Component;
import java.util.Observable;
public interface IFrame extends java.util.Observer {
	
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
	
	/* Update the label information for the current tab */
	void updateTotalLabel();
	
	void update(Observable o, Object arg);
	
	void setFolioName(String name);
	
	String getFolioName();
	
}
