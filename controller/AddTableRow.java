package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.IFrame;

public class AddTableRow implements ActionListener{
	IFrame frame;
	/* API INTERFACE GOES HERE */
	
	/* API INTERFACE IS PASSED HERE*/
	public AddTableRow(IFrame f)
	{
		frame = f;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		/*						Ticker Symbol		  Number of Shares   */
		frame.getITable().addRow(frame.getTickerSymbol(),frame.getNShares());
	}

}
