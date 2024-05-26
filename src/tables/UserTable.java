/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import response.UserResponse;

/**
 *
 * @author PC
 */
public class UserTable extends AbstractTableModel {

    private final List<UserResponse> usersReponse;
    private final String[] name = {"ID", "Name", "Email", "Phone Number", "Address", "Security Question", "Status"};
    private final Class[] classes = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};

    public UserTable(List<UserResponse> usersReponse) {
        this.usersReponse = usersReponse;
    }
    
    @Override
    public int getRowCount() {
        return usersReponse.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return usersReponse.get(rowIndex).getId();
            case 1:
                return usersReponse.get(rowIndex).getName();
            case 2:
                return usersReponse.get(rowIndex).getEmail();
            case 3:
                return usersReponse.get(rowIndex).getPhoneNumber();
            case 4:
                return usersReponse.get(rowIndex).getAddress();
            case 5:
                return usersReponse.get(rowIndex).getSecurityQuestion();
            case 6:
                return usersReponse.get(rowIndex).getStatus();
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
