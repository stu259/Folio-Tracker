package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.IFrame;
import gui.ITable;
import api.IModel;

public class EditShare implements MouseListener{
	
	private IFrame frame;
	private IModel model;
	
	public EditShare(IFrame f, IModel m){
		model = m;
		frame = f;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			String folioName = frame.getCurrentTab().getName();
			ITable t = frame.getITable();
			String selectedTickerSymbol = t.getSelectedTicker();
			
			if(!selectedTickerSymbol.equals("")){
			String shareName = frame.getuserInput("Enter a new name for your share");
			
				if(shareName != null && shareName.trim().length() > 0){
					shareName = shareName.trim();
					model.updateShare(folioName, selectedTickerSymbol, shareName);
					
				}
			}
			
		}
		
	}
	
	/*
	private JPanel customPanel(Object[] row){
		JPanel info = new JPanel();
		
		int currNumOfShares = (int) row[2];
		double currInitialValue = (double) row[4];
		double currentValue = (double) row[3];
		String tickerSymbol = (String) row[0];
		String stockName = (String) row[1];
		
		
		
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
	*/

	
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
