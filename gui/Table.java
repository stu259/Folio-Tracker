package gui;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import api.IModel;
import controller.EditRow;

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
	
	private IFrame frame;
	private IModel model;
	
	private JTable table;

	
	public Table(String name, IFrame f, IModel m){
		this.setName(name);
		frame = f;
		model = m;
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setPreferredSize(new Dimension(870, 430));
		table.addMouseListener(new EditRow(f/*Probably need information from the back-end here*/));
		
		
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
		return table.getRowCount();
	}
	
	public JTable getTable(){
		return table;
	}
	
	@Override
	public Object[] getRow(int index){
		Object[] row = new Object[5];
		row[0] = tModel.getValueAt(index, 0);
		row[1] = tModel.getValueAt(index, 1);
		row[2] = tModel.getValueAt(index, 2);
		row[3] = tModel.getValueAt(index, 3);
		row[4] = tModel.getValueAt(index, 4);
		
		return row;
	}
	
	@Override
	public void addRow(String symbol, int nShares){
		Object[] row = new Object[5];
		
		row[0] = symbol;
		row[1] = "Stock Name";
		row[2] = nShares;
		row[3] = 1.0;
		row[4] = 100.0;
		
		tModel.addRow(row);
		
		frame.updateTotalLabel();
		
		//int current number of rows = something
		/* sName = insert api interface here.GETSHRE NAME SOMEHOW */
		/* price = insert api interface here.GETPRICE  SOMEHOW */
		/* value = insert api interface here.GETVALUE SOMEHOW */
	}

	@Override
	public Object[] getRow(String tSymbol) {
		for(int i = 0; i < tModel.getRowCount(); ++i){
			if(tSymbol.equals(((String) getRow(i)[0]))){
				return getRow(i);
			}
		}
		return null;
	}

	@Override
	public void updateRow(int amount, String tSymbol) {
		// model . update shares info
		// update table information from calling the back end
	}
	
}
