/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Category;

/**
 *
 * @author PC
 */
public class CategoryTable extends AbstractTableModel{
    private List<Category> categories;
    private final String[] name = {"ID","Name"};
    private final Class[] classes = {Integer.class, String.class};

    public CategoryTable(List<Category> categories) {
        this.categories = categories;
    }
    
    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return categories.get(rowIndex).getId();
            case 1:
                return categories.get(rowIndex).getName();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
    
    
}
