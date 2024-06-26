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
public class IntermediateView extends javax.swing.JFrame {

    /**
     * Creates new form IntermediateView
     */
    public IntermediateView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnQuestions = new javax.swing.JButton();
        btnMail = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuestions.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuestions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change Security Question.png"))); // NOI18N
        btnQuestions.setText("Find your account with Questions");
        btnQuestions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestionsActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 320, 50));

        btnMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        btnMail.setText("Find your account with Mail");
        getContentPane().add(btnMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 320, 50));

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        btnBack.setText("Back");
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/front (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuestionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuestionsActionPerformed
    
    public void addBackLoginListener(ActionListener listener){
        btnBack.addActionListener(listener);
    }
    
    public void addQuestionListener(ActionListener listener){
        btnQuestions.addActionListener(listener);
    }
    
    public void addMailListener(ActionListener listener){
        btnMail.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMail;
    private javax.swing.JButton btnQuestions;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
