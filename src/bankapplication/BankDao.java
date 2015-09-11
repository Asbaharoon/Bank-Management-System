/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BankDao {

    private static Connection myConn = null;
    private static byte[]  byteArray  = null;
    public BankDao() throws SQLException {
        String userName="root";
        String password ="";
        String url="jdbc:mysql://localhost:3306/bankdb";

		myConn = DriverManager.getConnection(url, userName, password);

		System.out.println("Connection Successful with:" + url);
    }
    
    
    public boolean addCustomer(Customer customer,String accountNum,String path) throws SQLException, FileNotFoundException {
		PreparedStatement stat = null;
               
               boolean customerAdded=false;
		try {

			stat = myConn
					.prepareStatement("INSERT INTO `register_customer`(`Account_num`, `Name`, `password`, `National_id_num`, `Account_type`, `Sex`, `DOB`, `Occupation`, `Total Balance`, `picture`)VALUES(?,?,?,?,?,?,?,?,?,?)");

			stat.setString(1, accountNum);
                        stat.setString(2, customer.getName());
                        stat.setString(3, customer.getPassword());
			stat.setString(4, customer.national_id_num);
			stat.setString(5, customer.getAccount_type());
			stat.setString(6, customer.getSex());
                        stat.setDate(7, customer.getDob());
                        stat.setString(8, customer.getOccupation());
                        stat.setDouble(9, customer.getTotalBalance());
                        InputStream is=new FileInputStream(new File(path));
                        stat.setBlob(10, is);
                        
                        
                    int i= stat.executeUpdate();
                    
                    if(i==1){
                        customerAdded=true;
                    }

		} catch(Exception e) {
                     JOptionPane.showMessageDialog(null, "Proble Occur.Try Again ");
			// close(myConn, stat);
		}
                
                return customerAdded;

	}
    
    
    
    public boolean depositMoney(double amount,String  accountNumber,double currentBalance,int staff_id) throws SQLException{
        
        System.out.println("OK");
        
     PreparedStatement myStatement = null;
     boolean depositOccur=false;
		// System.out.println("UPDATE `register_customer` SET `Total Balance`=? WHERE `Account_num` ='"+accountNumber+"'");
		/*
		 * UPDATE employees SET first_name='Royal', last_name='Khan'
		 * ,email='royal@gmail.com', department='CSE', salary=1200 WHERE id=14
		 */
		try {
			
			double totalBaance=(currentBalance+amount);
                       
			
			myStatement = myConn.prepareStatement("UPDATE `register_customer` SET `Total Balance`=? WHERE `Account_num` ='"+accountNumber+"'" );
                        System.out.println(myStatement);
			
			myStatement.setDouble(1,totalBaance );
			
			
			int i=myStatement.executeUpdate();
                        if(i==1){
                            depositOccur=true;
                            
                            myStatement = myConn
					.prepareStatement("INSERT INTO `depositdetail`(`Account_num`, `Amount`, `Staff_id`, `DATE`)VALUES(?,?,?,?)");

			myStatement.setString(1, accountNumber);
                        myStatement.setDouble(2, amount);
                        myStatement.setInt(3, staff_id);
                        
                       java.util.Date utilDate = new java.util.Date();
                       java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                       
			myStatement.setDate(4,sqlDate);
                        
                        myStatement.executeUpdate();
                        }
			

		} catch(Exception e) {
			System.out.println("Error in update");
                        JOptionPane.showMessageDialog(null, "Proble Occur.Try Again ");
		}

        return depositOccur;
        
    }
    
    
    public static Customer getDepositChech(String accountNum)
			throws SQLException {
		
		// PreparedStatement preparedStatement=null;
		ResultSet rs = null;
		Statement stat = null;
                Customer customer=null;
		try {

			// preparedStatement=myConn.prepareStatement("SELECT * FROM employees WHERE last_name LIKE ?");
			// preparedStatement.setString(1, lastName);

			// rs=preparedStatement.executeQuery();

			stat = myConn.createStatement();
			rs = stat
					.executeQuery("SELECT * FROM register_customer WHERE Account_num ='"
							+ accountNum+"'");

			while (rs.next()) {
				System.out.println("OK");
				 customer = convertToEmployee(rs);
				

			}

		} catch(Exception e) {
			// close(rs, stat);
                    JOptionPane.showMessageDialog(null, "Proble Occur.Try Again ");
		}

		return customer;
	}
    
    
    
    
    
    
    
    public boolean withdrawtMoney(double amount,String  accountNumber,double currentBalance,int staff_id) throws SQLException{
        
        System.out.println("OK");
        
     PreparedStatement myStatement = null;
     boolean depositOccur=false;
		// System.out.println("UPDATE `register_customer` SET `Total Balance`=? WHERE `Account_num` ='"+accountNumber+"'");
		/*
		 * UPDATE employees SET first_name='Royal', last_name='Khan'
		 * ,email='royal@gmail.com', department='CSE', salary=1200 WHERE id=14
		 */
		try {
			
			double totalBaance=(currentBalance-amount);
                       
			
			myStatement = myConn.prepareStatement("UPDATE `register_customer` SET `Total Balance`=? WHERE `Account_num` ='"+accountNumber+"'" );
                        System.out.println(myStatement);
			
			myStatement.setDouble(1,totalBaance );
			
			
			int i=myStatement.executeUpdate();
                        if(i==1){
                            depositOccur=true;
                          
			myStatement = myConn
					.prepareStatement("INSERT INTO `withdrawdetail`(`Account_num`, `Amount`, `Staff_id`, `DATE`)VALUES(?,?,?,?)");

			myStatement.setString(1, accountNumber);
                        myStatement.setDouble(2, amount);
                        myStatement.setInt(3, staff_id);
                        
                       java.util.Date utilDate = new java.util.Date();
                       java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                       
			myStatement.setDate(4,sqlDate);
                        
                        
			
                        
                        
                     myStatement.executeUpdate();
                        }
			

		} catch(Exception e) {
			System.out.println("Error in update");
                        JOptionPane.showMessageDialog(null, "Proble Occur.Try Again ");
		}

        return depositOccur;
        
    }
    
    
   public static java.util.List<Customer> getAllCustomer()
			throws SQLException {

		java.util.List<Customer> list = new ArrayList<>();
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = myConn.createStatement();
			rs = stat.executeQuery("SELECT * FROM register_customer");

			while (rs.next()) {
				Customer employee = convertToEmployee(rs);
				list.add(employee);
			}
			return list;

		} finally {
			// close(rs, stat);
		}

	}
	
    public static java.util.List<Withdraw> getAllWithdrawDetail()
			throws SQLException {

		java.util.List<Withdraw> list = new ArrayList<>();
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = myConn.createStatement();
			rs = stat.executeQuery("SELECT * FROM withdrawdetail");
                        
			while (rs.next()) {
                            System.out.println("OK");
				Withdraw employee = convertToWithdraw(rs);
				list.add(employee);
			}
			return list;

		} finally {
			// close(rs, stat);
		}

	}
	
    
    
    
     public static java.util.List<Deposit> getAllDepositDetail()
			throws SQLException {

		java.util.List<Deposit> list = new ArrayList<>();
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = myConn.createStatement();
			rs = stat.executeQuery("SELECT * FROM depositdetail");
                        
			while (rs.next()) {
                            System.out.println("OK");
				Deposit  employee = convertToDeposit(rs);
				list.add(employee);
			}
			return list;

		} finally {
			// close(rs, stat)
		}

	}
	
   
   public static List<Staff> getAllStaff()
			throws SQLException {

		java.util.List<Staff> list = new ArrayList<>();
		ResultSet rs = null;
		Statement stat = null;
		try {
			stat = myConn.createStatement();
			rs = stat.executeQuery("SELECT * FROM staff_registration");

			while (rs.next()) {
				Staff employee = convertToStaff(rs);
				list.add(employee);
			}
			return list;

		} finally {
			// close(rs, stat);
		}

	}
   
    
    public static Customer withdrawCheck(String accountNum)
			throws SQLException {
		
		// PreparedStatement preparedStatement=null;
		ResultSet rs = null;
		Statement stat = null;
                Customer customer=null;
		try {

			// preparedStatement=myConn.prepareStatement("SELECT * FROM employees WHERE last_name LIKE ?");
			// preparedStatement.setString(1, lastName);

			// rs=preparedStatement.executeQuery();

			stat = myConn.createStatement();
			rs = stat
					.executeQuery("SELECT * FROM register_customer WHERE Account_num ='"
							+ accountNum+"'");

			while (rs.next()) {
				System.out.println("OK");
				 customer = convertToEmployee(rs);
				

			}

		} finally {
			// close(rs, stat);
		}

		return customer;
	}
    
    
    
    public static Customer convertToEmployee(ResultSet rs) throws SQLException {

		String national_id = rs.getString("National_id_num");
		String name = rs.getString("name");
                String account_num = rs.getString("Account_num");
                
		Date dob=rs.getDate("DOB");
                String account_type=rs.getString("Account_type");
                String sex=rs.getString("Sex");
                String occupation=rs.getString("Occupation");
                String password=rs.getString("password");
                double initial_balance=rs.getDouble("Total Balance");
                byteArray = rs.getBytes("picture");
                Image image;
                image = Toolkit.getDefaultToolkit().createImage(byteArray);
                ImageIcon imageIcon;
                imageIcon = new ImageIcon(image);
                
		Customer customer=new Customer( name,  account_num,  national_id,  dob,  account_type,  sex,  occupation,  password,  image,  initial_balance) ;

		return customer;

	}
	
     public static Withdraw convertToWithdraw(ResultSet rs) throws SQLException {

               
                
		int serial_no=rs.getInt("SL_NO");
                String account_num=rs.getString("SL_NO");
                double amount=rs.getDouble("Amount");
                int staff_id=rs.getInt("Staff_id");
                Date date=rs.getDate("DATE");
		
                Withdraw w=new Withdraw(serial_no, account_num, amount, staff_id, date);

		return w;

	}
	public static Deposit convertToDeposit(ResultSet rs) throws SQLException {

               
                
		int serial_no=rs.getInt("SL_NO.");
                String account_num=rs.getString("Account_num");
                double amount=rs.getDouble("Amount");
                int staff_id=rs.getInt("Staff_id");
                Date date=rs.getDate("DATE");
		
                Deposit w=new Deposit(serial_no, account_num, amount, staff_id, date);

		return w;

	}
	
    
    public static Staff convertToStaff(ResultSet rs) throws SQLException {

		String national_id = rs.getString("National_id_num");
		String name = rs.getString("name");
                int staff_id = rs.getInt("Staff_id");
                String rank = rs.getString("Rank");
                
		Staff staff=new Staff( name,  national_id, staff_id,rank);

		return staff;

	}
	
    
    public boolean addStaff(Staff staff,String path) throws SQLException, FileNotFoundException {
		PreparedStatement stat = null;
               boolean staffAdded=false;

		try {

			stat = myConn
					.prepareStatement("INSERT INTO `staff_registration`( `Name`, `National_id_num`, `Staff_id`, `Sex`, `DOB`, `Rank`, `Password`, `Picture`)VALUES(?,?,?,?,?,?,?,?)");

			
                        stat.setString(1, staff.getName());
			stat.setString(2, staff.national_id_num);
                        stat.setInt(3, staff.getStaff_id());
			stat.setString(4, staff.getSex());
			 stat.setDate(5, staff.getDob());
                        stat.setString(6, staff.getRank());
                        stat.setString(7, staff.getPassword());
                        InputStream is=new FileInputStream(new File(path));
                        stat.setBlob(8, is);
                        
                        
                     int i=stat.executeUpdate();
                     
                     if(i==1){
                        staffAdded=true; 
                     }

		} finally {

			// close(myConn, stat);
		}
                return staffAdded;

	}

    
    
    
    public static void main(String[] args) throws FileNotFoundException,
			IOException, SQLException {
		BankDao employeeDao = new BankDao();

		

	}
    
    
}
