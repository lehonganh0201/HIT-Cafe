/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;


/**
 *
 * @author admin
 */
public class ChangePassword extends javax.swing.JFrame {

    public ChangePassword() {
        initComponents();
        btnUpdate.setEnabled(false);

    }

    public void validateField() {
        String oldPassword = new String(txtOldPassword.getPassword());
        String newPassword = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        btnUpdate.setEnabled(!oldPassword.equals("") && !newPassword.equals("") && !confirmPassword.equals("") && !newPassword.equals(oldPassword) && newPassword.equals(confirmPassword));


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 134));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change Password.png"))); // NOI18N
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 17, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Old Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 99, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("New Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 145, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 191, -1, -1));

        txtOldPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOldPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 95, 272, -1));

        txtNewPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 141, 272, -1));

        txtConfirmPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 187, 272, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 233, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 233, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/front (1).png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOldPasswordKeyReleased
        validateField();
    }//GEN-LAST:event_txtOldPasswordKeyReleased

    private void txtNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPasswordKeyReleased
        validateField();
    }//GEN-LAST:event_txtNewPasswordKeyReleased

    private void txtConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPasswordKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtConfirmPasswordKeyReleased

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    public void clear(){
        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtConfirmPassword.setText("");
    }   
    
    public void addExitListener(ActionListener listener){
        btnExit.addActionListener(listener);
    }
    
    public void addUpdateListener(ActionListener listener){
        btnUpdate.addActionListener(listener);
    }
    
    public String getOldPassword(){
        return new String(txtOldPassword.getPassword());
    }
    
    public String getNewPassword(){
        return new String(txtNewPassword.getPassword());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables
}