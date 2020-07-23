/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Iniciador.RMI;
import Interfaces.IFacultad;
import Interfaces.IFacultadController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class EditarFacultad extends javax.swing.JFrame {

    private IFacultad facultad;
   
    
    public EditarFacultad( IFacultad facultad ) {
        try {
            initComponents();
            
            
            this.facultad = facultad;
            setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
            
            this.setLocationRelativeTo(null);
            facultadTextField.setText(facultad.getFacultad());
        } catch (RemoteException ex) {
            Logger.getLogger(EditarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelarButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        facultadTextField = new javax.swing.JTextField();
        atrasButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cancelar.png"))); // NOI18N
        cancelarButton.setBorder(null);
        cancelarButton.setContentAreaFilled(false);
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 200, 50));

        guardarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Guardar.png"))); // NOI18N
        guardarButton.setBorder(null);
        guardarButton.setContentAreaFilled(false);
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(guardarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 200, 50));

        facultadTextField.setBackground(new java.awt.Color(220, 236, 246));
        facultadTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        facultadTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        facultadTextField.setPreferredSize(new java.awt.Dimension(428, 31));
        facultadTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(facultadTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 800, 90));

        atrasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/atras.png"))); // NOI18N
        atrasButton.setBorder(null);
        atrasButton.setContentAreaFilled(false);
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(atrasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Editar facultad – 1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        FacultadesRegistradas facultades = new FacultadesRegistradas();
        this.setVisible(false);
        facultades.setVisible(true);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        try {
            String nombre = facultadTextField.getText();
            

            if ( nombre.length() == 0 ){
                JOptionPane.showMessageDialog(this, "Ingrese el nombre de la facultad.", "Validación", JOptionPane.ERROR_MESSAGE );
                facultadTextField.requestFocus();
                return;
            }
            else{
                facultad.setFacultad(nombre);
            }
            
            int respuesta = RMI.getIFacultadController().update(facultad);
            if ( respuesta == IFacultadController.UPDATE_EXITO ){
                JOptionPane.showMessageDialog(this, "El nombre de la facultad ha sido modificado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
                
            }
            else if ( respuesta == IFacultadController.UPDATE_SIN_EXITO){
                JOptionPane.showMessageDialog(this, "No fue posible completar la operación.", "Operación incompleta", JOptionPane.ERROR_MESSAGE);
            }
            else if ( respuesta == IFacultadController.UPDATE_ID_INEXISTE ){
                JOptionPane.showMessageDialog(this, "No fue posible completar la operación.\n"+"Facultad no encontrada.\n" +"Es probable que la facultad haya sido eliminado anteriormente.", "Operación incompleta", JOptionPane.ERROR_MESSAGE);                
                this.setVisible(false);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(EditarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacultadesRegistradas facultades = new FacultadesRegistradas();
        this.setVisible(false);
        facultades.setVisible(true);
        
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void facultadTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultadTextFieldActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        FacultadesRegistradas facultades = new FacultadesRegistradas();
        this.setVisible(false);
        facultades.setVisible(true);
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EditarFacultad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField facultadTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}