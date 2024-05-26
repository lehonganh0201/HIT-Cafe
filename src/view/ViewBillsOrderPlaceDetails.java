/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JTable;
import model.Bill;
import tables.BillTable;

/**
 *
 * @author admin
 */
public class ViewBillsOrderPlaceDetails extends javax.swing.JFrame {

    /**
     * Creates new form ViewBillsOrderPlaceDetails
     */
    public ViewBillsOrderPlaceDetails() {
        initComponents();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dFormat.format(date);
        txtDateFilter.setText(todayDate);
    }
    
    public void reloadTable(List<Bill> bills){
        billTable.setModel(new BillTable(bills));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDateFilter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/View Bills & Order Placed Details.png"))); // NOI18N
        jLabel1.setText("View Bills & Order Placed Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1312, 23, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Filter By Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 138, -1, -1));

        txtDateFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDateFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDateFilterKeyReleased(evt);
            }
        });
        getContentPane().add(txtDateFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 134, 320, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Change Order By ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 138, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESC", "DESC", "" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 134, 310, -1));

        billTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Number", "Email", "Date", "Total", "CreateBy"
            }
        ));
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 195, 1354, -1));

        jLabel4.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel4.setText("*Click on row open bill");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 670, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/front (2).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtDateFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateFilterKeyReleased
       
    }//GEN-LAST:event_txtDateFilterKeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
//        int index = billTable.getSelectedRow();
//        TableModel model = billTable.getModel();
//        String id = model.getValueAt(index, 0).toString();
//        OpenPdf.openById(id);`
    }//GEN-LAST:event_billTableMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
      
    }//GEN-LAST:event_formComponentShown

    public boolean getOrderStatus(){
        String incDec = (String) jComboBox1.getSelectedItem();
        return (incDec.equals("ESC"));
    }
    
    public JTable getTable(){
        return billTable;
    }
    
    public String getDate(){
        return txtDateFilter.getText();
    }
    
    public void addExitListener(ActionListener listener){
        btnExit.addActionListener(listener);
    }
    
    public void addDateFilterListener(KeyAdapter adapter){
        txtDateFilter.addKeyListener(adapter);
    }
    
    public void addComboBoxActionListener(ActionListener listener) {
        jComboBox1.addActionListener(listener);
    }
    
    public void addBillTableMouseListener(MouseAdapter adapter) {
        billTable.addMouseListener(adapter);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billTable;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDateFilter;
    // End of variables declaration//GEN-END:variables
}
