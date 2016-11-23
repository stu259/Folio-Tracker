package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import gui.IFrame;
import gui.ITable;

public class EditRow implements MouseListener{
	
	IFrame frame;
	/* Need an interface of the API here probably */
	
	
	/* Need an interface of the API here probably */
	public EditRow(IFrame f){
		frame = f;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			ITable t = frame.getITable();
			if(t.getTable().getSelectedRow() != -1){
				
				Object[] row = t.getRow(t.getTable().getSelectedRow());
				
				JOptionPane.showInputDialog(null,customPanel(row),"TO DO: CHANGE THIS NAME AND OPTIONS",JOptionPane.OK_CANCEL_OPTION);
				
				
				
				frame.updateTotalLabel();
			  }
		}
		
	}
	
	private JPanel customPanel(Object[] row){
		JPanel info = new JPanel();
		
		int currNumOfShares = (int) row[2];
		double currInitialValue = (double) row[4];
		double currentValue = (double) row[3];
		String tickerSymbol = (String) row[0];
		String stockName = (String) row[1];
		
		
		/* Calculate this so its actually accurate*/
		double gain = 0;
		
		JLabel editing = new JLabel("Editing portfolio:" + frame.getCurrentTab().getName());
		JLabel tSymbol = new JLabel(tickerSymbol);
		JLabel sName = new JLabel(stockName);
		JLabel currVal = new JLabel("Current value:" + currentValue);
		JLabel dChange = new JLabel("Daily change - I dont know this... Probably getChange from API");
		JLabel nOfShares = new JLabel("Number of Shares:");
		JTextField numOfShares = new JTextField(Integer.toString(currNumOfShares));
		JLabel initValue = new JLabel("Initial Value:");
		JTextField initialValue = new JTextField(Double.toString(currInitialValue));
		JLabel totalGain = new JLabel("Total gain:" + gain);

		info.add(editing);
		info.add(tSymbol);
		info.add(sName);
		info.add(currVal);
		info.add(dChange);
		info.add(nOfShares);
		info.add(numOfShares);
		info.add(initValue);
		info.add(initialValue);
		info.add(totalGain);
		
		
		return info;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
