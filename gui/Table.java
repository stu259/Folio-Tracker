package gui;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import api.IFolio;
import api.IModel;
import api.IShare;
import controller.EditShare;
//import controller.EditRow;

@SuppressWarnings("serial")
public class Table extends JPanel implements ITable{

	private String[] columnames = {
			"Ticker Symbol",
			"Share Name",
			"Number of Shares",
			"Price per Share",
			"Value of Holding"
	};
	
	private Object[][] data;
	
	private DefaultTableModel tModel;
	
	private IFrame frame;
	
	private JTable table;

	
	public Table(String name, IFrame f, IModel m){
		this.setName(name);
		frame = f;
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setPreferredSize(new Dimension(870, 430));
		
		
		tModel = new DefaultTableModel(data, columnames) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		table.addMouseListener(new EditShare(f, m));
		
		table.setModel(tModel);
		
		JScrollPane p = new JScrollPane(table);
		p.setPreferredSize(new Dimension(870,430));
		
		this.add(table.getTableHeader());
		this.add(p);
	}
	
	public int rows(){
		return tModel.getRowCount();
	}
	
	public JTable getTable(){
		return table;
	}
	
	/*
	    row[0] = ticker symbol
		row[1] = stock name
		row[2] = number of shares
		row[3] = price per share
		row[4] = holding value
	*/
	@Override
	public void update(IFolio f) {
		clearTable();
		
		
		DecimalFormat Currency = new DecimalFormat("#0.00");
		for(IShare s : f.getShares()){
			
			Object[] row = new Object[5];
			row[0] = (String) s.getTickerSymbol();
			row[1] = (String) s.getShareName();
			row[2] = (int) s.getNumShares();
			row[3] = Currency.format((double) s.getPricePerShare());
			row[4] = Currency.format((double) s.getValueHolding());
			
			
			tModel.addRow(row);
			
		}
		frame.updateTotalLabel();
	}
	
	private void clearTable(){
		tModel.setRowCount(0);
	}

	@Override
	public String getSelectedTicker() {
		int selected = table.getSelectedRow();
		if(selected >= 0){
			return (String) tModel.getValueAt(selected, 0);
		}
		
		return "";
	}
	
}
