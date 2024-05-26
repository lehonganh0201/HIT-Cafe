/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Product;

/**
 *
 * @author PC
 */
public class ProductTable extends AbstractTableModel {
    private List<Product> products;
    private final String[] name = {"ID", "Name", "Category", "Price"};
    private final Class[] classes = {Integer.class, String.class, String.class, String.class};

    public ProductTable(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getCategory();
            case 3:
                return product.getPrice();
            default:
                throw new IndexOutOfBoundsException("Column index out of bounds");
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
