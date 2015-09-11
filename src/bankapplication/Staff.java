/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Staff {
    
    
    String name;
    String national_id_num;
    
    Date dob;
    String rank;
    String sex;
    String password;
    int staff_id;
    Image image;

    public Staff(String name, String national_id_num,int staff_id,String rank) {
        this.name = name;
        this.national_id_num = national_id_num;
        this.rank = rank;
        this.staff_id = staff_id;        
    }
    
    
    

    public Staff(String name, String national_id_num, Date dob, String rank, String sex, String password, int staff_id, Image image) {
        this.name = name;
        this.national_id_num = national_id_num;
        this.dob = dob;
        this.rank = rank;
        this.sex = sex;
        this.password = password;
        this.staff_id = staff_id;
        this.image = image;
    }

    

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNational_id_num(String national_id_num) {
        this.national_id_num = national_id_num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public String getSex() {
        return sex;
    }

    public String getRank() {
        return rank;
    }

    public String getPassword() {
        return password;
    }

    public String getNational_id_num() {
        return national_id_num;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Date getDob() {
        return dob;
    }

    
    
   

 

    

    @Override
    public String toString() {
        return ""+name+"  "+staff_id+" "+sex+" "+password+" "+" "+national_id_num+" "+dob+" "+rank; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
