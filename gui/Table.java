package gui;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import api.IFolio;
import api.IShare;
import api.Model;
//import controller.EditRow;

@SuppressWarnings("serial")
public class Table extends JPanel implements ITable{

	private String[] columnames = {
			"Ticker Symbol",
			"Stock Name",
			"Number of Shares",
			"Price per Share",
			"Value of Holding"
	};
	
	private Object[][] data;
	
	private DefaultTableModel tModel;
	
	private Frame frame;
	//private Model model;
	
	private JTable table;

	
	public Table(String name, Frame f, Model m){
		this.setName(name);
		frame = f;
		//model = m;
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setPreferredSize(new Dimension(870, 430));
		//table.addMouseListener(new EditRow(f));
		
		
		tModel = new DefaultTableModel(data, columnames) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
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
		IShare[] shares = f.getShares();
		for(IShare s : shares){
			Object[] row = new Object[5];
			row[0] = (String) s.getTickerSymbol();
			row[1] = (String) s.getStockName();
			row[2] = (int) s.getNumShares();
			row[3] = (double) s.getPricePerShare();
			row[4] = (double) s.getValueHolding();
			
			tModel.addRow(row);
			frame.updateTotalLabel();
		}
	}
	
	private void clearTable(){
		for(int i = 0; i < tModel.getRowCount(); ++i){
			tModel.removeRow(i);
		}
	}
	
}
