/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Bill;

/**
 *
 * @author PC
 */
public class BillTable extends AbstractTableModel{
    private List<Bill> bill;
    private final String[] name = {"ID","Name","Phone Number","Email","Date","Total","CreatedBy"};
    private final Class[] classes = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};

    public BillTable(List<Bill> bill) {
        this.bill = bill;
    }
    
    @Override
    public int getRowCount() {
        return bill.size();
    }

    @Override
    public int getColumnCount() {
        return name.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bill currentBill = bill.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return currentBill.getId();
            case 1:
                return currentBill.getName();
            case 2:
                return currentBill.getPhoneNumber();
            case 3:
                return currentBill.getEmail();
            case 4:
                return currentBill.getDate();
            case 5:
                return currentBill.getTotal();
            case 6:
                return currentBill.getCreateBy();
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
