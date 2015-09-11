/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Deposit {
    int sl_no;
    String account_num;
    double amount;
    int staff_id;
    Date date;

    public Deposit(int sl_no, String account_num, double amount, int staff_id, Date date) {
        this.sl_no = sl_no;
        this.account_num = account_num;
        this.amount = amount;
        this.staff_id = staff_id;
        this.date = date;
    }
    

    public String getAccount_num() {
        return account_num;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public int getSl_no() {
        return sl_no;
    }

    public int getStaff_id() {
        return staff_id;
    }

   
    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    
    
}
