package gui;

import java.awt.Dimension;
import javax.swing.*;

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
	
	private Object[][] data = {
			{"Ticker Symbol",
				"Stock Name",
				100,
				1.0,
				100.0},
			{"Ticker Symbol",
					"Stock Name",
					200,
					2.0,
					200.0}
	};
	
	private JTable table;
	/* Consider passing an interface of the API so that we can use it to add rows and later when updating them to refresh */
	public Table(String name, IFrame f){
		this.setName(name);
		
		/* Set limit to 10 shares for testing purpose. Would be better if we can avoid this*/
		//data = new Object[10][5];
		
		table = new JTable(data,columnames);
		table.setFillsViewportHeight(true);
		table.setPreferredSize(new Dimension(870, 430));
		table.addMouseListener(new EditRow(f/*Probably need information from the back-end here*/));
		
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
		return data[index];
	}
	
	@Override
	public void addRow(String symbol, int nShares){
		//int current number of rows = something
		/* sName = insert api interface here.GETSHRE NAME SOMEHOW */
		/* price = insert api interface here.GETPRICE  SOMEHOW */
		/* value = insert api interface here.GETVALUE SOMEHOW */
		//data[current number of rows + 1][0] = symbol;
		//data[current number of rows + 1][1] = sName;
		//data[current number of rows + 1][2] = nShares;
		//data[current number of rows + 1][3] = price;
		//data[current number of rows + 1][4] = value;
	}
	
	//Add getters and setters for the data object as this will be
	//one of the main things that the controller will have to do
}
