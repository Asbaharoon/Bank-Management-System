/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class StaffTableModel extends AbstractTableModel{

   public static final int OBJECT_COL = -1;

	private final int NAME=0;
	private final int NATINAL_ID_NUM=1;
	private final int STAFF_ID=2;
	private final int RANK=3;
	
	
	
	private ArrayList<Staff> employees;
	
	public StaffTableModel( List<Staff> employees) {
		this.employees=(ArrayList<Staff>) employees;
	}
	
	String[]  columnName={"Name","National_id_num","Staff_id","Rank"};
	
	
	@Override
	public int getColumnCount() {
		
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		
		return employees.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Staff employee=employees.get(row);
		
		switch (col) {
		
		case NAME:
			 return employee.getName();
		case NATINAL_ID_NUM:
			 return employee.getNational_id_num();
		case STAFF_ID:
			 return employee.getStaff_id();
		case RANK:
			 return employee.getRank();
		
		case OBJECT_COL:
			return employee;


		default:
			 return employee.getName();
		}
		
		
		
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	@Override
	public String getColumnName(int col) {
		
		return columnName[col];
	}
	
	
    
}
