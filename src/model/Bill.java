/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Bill implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String date;
    private String total;
    private String createBy;
    
    private static int n = 1;

    public Bill(String name, String phoneNumber, String email, String date, String total, String createBy) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
        this.total = total;
        this.createBy = createBy;
    }

    public Bill(int id, String name, String phoneNumber, String email, String date, String total, String createBy) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
        this.total = total;
        this.createBy = createBy;
        n++;
    }

    public Bill() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "Bill{" + "name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", date=" + date + ", total=" + total + ", createBy=" + createBy + '}';
    }
    
     public boolean equalsWithoutId(Bill other) {
        if (this == other) return true;
        if (other == null) return false;
        return name.equals(other.name) &&
                phoneNumber.equals(other.phoneNumber) &&
                email.equals(other.email) &&
                date.equals(other.date) &&
                total.equals(other.total) &&
                createBy.equals(other.createBy);
    }
}
