/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.awt.Image;
import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author DELL
 */
public class Customer {
    
    
    String name;
    String account_num;
    String national_id_num;
    Date dob;
    String account_type;
    String sex;
    String occupation;
    String password;
    Image image;
    double totalBalance;

    public Customer() {
    }
   

    public Customer(String name, String national_id_num, Date dob, String account_type, String sex, String occupation, String password, Image image, double totalBalance) {
        this.name = name;
        this.national_id_num = national_id_num;
        this.dob = dob;
        this.account_type = account_type;
        this.sex = sex;
        this.occupation = occupation;
        this.password = password;
        this.image = image;
        this.totalBalance = totalBalance;
    }

    

    public String getAccount_type() {
        return account_type;
    }

    public Customer(String name, String account_num, String national_id_num, Date dob, String account_type, String sex, String occupation, String password, Image image, double totalBalance) {
        this.name = name;
        this.account_num = account_num;
        this.national_id_num = national_id_num;
        this.dob = dob;
        this.account_type = account_type;
        this.sex = sex;
        this.occupation = occupation;
        this.password = password;
        this.image = image;
        this.totalBalance = totalBalance;
    }

    public Date getDob() {
        return dob;
    }

    public Image getImage() {
        return image;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public String getAccount_num() {
        return account_num;
    }

    public String getName() {
        return name;
    }

    public String getNational_id_num() {
        return national_id_num;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNational_id_num(String national_id_num) {
        this.national_id_num = national_id_num;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return ""+name+"  "+totalBalance+" "+sex+" "+password+" "+occupation+" "+national_id_num+" "+dob+" "+account_type; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
}
