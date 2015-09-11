/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class WithdrawDetailTabelModel extends AbstractTableModel{
    
    public static final int OBJECT_COL = -1;

	private final int SL_NO=0;
	private final int ACCOOUNT_NUM=1;
	private final int AMOUNT=2;
	private final int STAFF_ID=3;
	private final int DATE=4;
	
	
	private ArrayList<Withdraw> employees;
	
	public WithdrawDetailTabelModel( List<Withdraw> employees) {
		this.employees=(ArrayList<Withdraw>) employees;
	}
	
	String[]  columnName={"SL No.","Account_num","Amount","Staff_id","DATE"};
	
	
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
		Withdraw employee=employees.get(row);
		
		switch (col) {
		
		case SL_NO:
			 return employee.getSl_no();
		case ACCOOUNT_NUM:
			 return employee.getAccount_num();
		case AMOUNT:
			 return employee.getAmount();
		case STAFF_ID:
			 return employee.getStaff_id();
		case DATE:
			 return employee.getDate();
		case OBJECT_COL:
			return employee;


		default:
			 return employee.getAccount_num();
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
