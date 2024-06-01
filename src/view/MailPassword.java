/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class MailPassword extends javax.swing.JFrame {
    private String email;
    private final String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    
    public MailPassword() {
        initComponents();
        btnUpdate.setEnabled(false);
        btnSend.setEnabled(false);
    }
    
    public void clear() {
        btnUpdate.setEnabled(false);
        btnSend.setEnabled(false);
        txtEmail.setEditable(true);
        txtEmail.setText("");
        txtOtp.setText("");
        txtPass.setText("");
    }
    
    public void validateEmail() {
        email = txtEmail.getText();
        if(email.matches(emailPattern))
            btnSend.setEnabled(true);
        else
            btnSend.setEnabled(false);
    }
    
    public void validateFields() {
        String password = new String(txtPass.getPassword());
        String answer = txtOtp.getText();

        if (!password.equals("") && !answer.equals("")) {
            btnUpdate.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtOtp = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Forgot Password?");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 60, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("OTP :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Enter New Password :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 490, 30));

        txtOtp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOtp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtpKeyReleased(evt);
            }
        });
        getContentPane().add(txtOtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 490, 30));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnUpdate.setText("Update");
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, 30));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, 30));

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit small.png"))); // NOI18N
        btnExit.setText("Exit");
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 420, -1, 30));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        btnLogin.setText("Login");
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 100, 30));

        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignUp.setText("SignUp");
        getContentPane().add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 100, 30));

        btnSend.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnSend.setText("Send");
        getContentPane().add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 180, -1, -1));

        txtPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 490, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logincafe (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        validateEmail();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtOtpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtpKeyReleased
        validateFields();
    }//GEN-LAST:event_txtOtpKeyReleased

    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
        validateFields();
    }//GEN-LAST:event_txtPassKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       clear();
    }//GEN-LAST:event_btnClearActionPerformed

    public void addExitListener(ActionListener listener){
        btnExit.addActionListener(listener);
    }
    
    public void addUpdateListener(ActionListener listener){
        btnUpdate.addActionListener(listener);
    }
    
    public void addSendListener(ActionListener listener){
        btnSend.addActionListener(listener);
    }
    
    public void addSignUpListener(ActionListener listener){
        btnSignUp.addActionListener(listener);
    }
    
    public void addLoginListener(ActionListener listener){
        btnLogin.addActionListener(listener);
    }
    
    public String getEmail(){
        return txtEmail.getText();
    }
    
    public String getOtp(){
        return txtOtp.getText();
    }
    
    public String getNewPassword(){
        return new String(txtPass.getPassword());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtOtp;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
