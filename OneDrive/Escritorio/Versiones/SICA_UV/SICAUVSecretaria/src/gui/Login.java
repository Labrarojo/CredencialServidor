/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Iniciador.RMI;
import Interfaces.ISecretario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class Login extends javax.swing.JFrame {

    MenuSecretariaa MenuSecre = new MenuSecretariaa();

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
        TextPrompt matricula = new TextPrompt("Matrícula", matriculaTextField);
        TextPrompt contraseña = new TextPrompt("Contraseña", jPasswordField1);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        matriculaTextField = new javax.swing.JTextField();
        iniciarButton = new javax.swing.JButton();
        encabezadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton1.setBackground(new java.awt.Color(220, 236, 246));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/pass.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setMargin(null);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 50, 40));

        jPasswordField1.setBackground(new java.awt.Color(220, 236, 246));
        jPasswordField1.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(47, 72, 90));
        jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 520, 80));

        matriculaTextField.setBackground(new java.awt.Color(220, 236, 246));
        matriculaTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        matriculaTextField.setForeground(new java.awt.Color(47, 72, 90));
        matriculaTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        matriculaTextField.setMinimumSize(new java.awt.Dimension(188, 319));
        matriculaTextField.setPreferredSize(new java.awt.Dimension(188, 319));
        matriculaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(matriculaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 520, 80));

        iniciarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/IniciarBoton.png"))); // NOI18N
        iniciarButton.setBorder(null);
        iniciarButton.setContentAreaFilled(false);
        iniciarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iniciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 250, 50));

        encabezadoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Iniciar sesión-Secretaria – 1.png"))); // NOI18N
        getContentPane().add(encabezadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton1.isSelected()) {
            jPasswordField1.setEchoChar((char) 0);
        } else {
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void matriculaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaTextFieldActionPerformed

    private void iniciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarButtonActionPerformed
        try {
            ISecretario secretario = RMI.getISecretarioController().findOne(matriculaTextField.getText());
            if (secretario.getContraseña().equals(jPasswordField1.getText())) {
                this.setVisible(false);
                MenuSecre.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "Matrícula o contraseña incorrecta",
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_iniciarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel encabezadoLabel;
    private javax.swing.JButton iniciarButton;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField matriculaTextField;
    // End of variables declaration//GEN-END:variables
}
