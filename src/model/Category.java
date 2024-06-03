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
public class Category implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    private static int n = 1;
    
    public Category(String name) {
        this.id = n++;
        this.name = name;
    }
    
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        n++;
    }

    public Category() {
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

    @Override
    public String toString() {
        return "Category{" + "name=" + name + '}';
    }
}
