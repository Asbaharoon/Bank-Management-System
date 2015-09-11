/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class CustomerTableModel extends AbstractTableModel{

    
    
    
	private final int ACCOUNT_NUM=0;
	private final int  NAME =1;
	private final int TOTALBALANCE=2;
	private final int NATIONALID=3;
	public static final int OBJECT_COL = -1;
	
	
	private ArrayList<Customer> customer;
       String[]  columnName={"account_number","name","totalBalance","nationalId"};

    public CustomerTableModel(ArrayList<Customer> customer) {
        this.customer = customer;
    }
	
   
   
	
	@Override
	public int getColumnCount() {
		
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		
		return customer.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Customer employee=customer.get(row);
		
		switch (col) {
		
		case  ACCOUNT_NUM:
			 return employee.getAccount_num();
		case NAME:
			 return employee.getName();
		case TOTALBALANCE:
			 return employee.getTotalBalance();
		case NATIONALID:
			 return employee.getNational_id_num();
		
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
