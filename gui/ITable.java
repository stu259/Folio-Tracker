package gui;

import javax.swing.JTable;

import api.IFolio;

public interface ITable {
	
	JTable getTable();
	void update(IFolio f);
	String getSelectedTicker();
}
