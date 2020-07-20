/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Iniciador.RMI;
import Interfaces.IEstudiante;
import Interfaces.ITramite;
import Interfaces.ITramiteController;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author adria
 */
public class AgregarTramite extends javax.swing.JFrame {

    /**
     * Creates new form AgregarTramite
     */
    public AgregarTramite() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
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

        atrasButton = new javax.swing.JButton();
        nombreTextField = new javax.swing.JTextField();
        matriculaTextField = new javax.swing.JTextField();
        folioTextField = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atrasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/atras.png"))); // NOI18N
        atrasButton.setBorder(null);
        atrasButton.setContentAreaFilled(false);
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(atrasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 50, -1));

        nombreTextField.setEditable(false);
        nombreTextField.setBackground(new java.awt.Color(220, 236, 246));
        nombreTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        nombreTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 800, 90));

        matriculaTextField.setBackground(new java.awt.Color(220, 236, 246));
        matriculaTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        matriculaTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(matriculaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 370, 90));

        folioTextField.setBackground(new java.awt.Color(220, 236, 246));
        folioTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        folioTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        folioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folioTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(folioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 370, 90));

        aceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/aceptar.png"))); // NOI18N
        aceptarButton.setBorder(null);
        aceptarButton.setContentAreaFilled(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 200, 50));

        cancelarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cancelar.png"))); // NOI18N
        cancelarButton.setBorder(null);
        cancelarButton.setContentAreaFilled(false);
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 200, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Agregar trámite – 1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        Tramite tramite = new Tramite();
        this.setVisible(false);
        tramite.setVisible(true);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {
            String folio = folioTextField.getText();
            String matricula = matriculaTextField.getText();
            
            ITramite tramite = RMI.getITramiteController().newInstance();
            
            if( folio.length() == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese número de folio.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                folioTextField.requestFocus();
                return;
            }else {
                tramite.setFolio(folio);
            }
            
            if(matricula.length() == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese la matrícula.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                matriculaTextField.requestFocus();
                return;
            }else{
                tramite.setMatricula(matricula);
                IEstudiante estudiante = RMI.getIEstudianteController().findOne(matricula);
                nombreTextField.setText(estudiante.getNombres());
            }
           
            int respuesta = RMI.getITramiteController().add(tramite);
            
            if(respuesta == ITramiteController.ADD_EXITO ){
                JOptionPane.showMessageDialog(
                        this,
                        "Tramite agregado con éxito.",
                        "Operación exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                
                SimpleDateFormat fechaActual = new SimpleDateFormat("dd-MM-aaaa");
                String fecha = fechaActual.format(new Date());
                tramite.setFecha(fecha);
                tramite.setEstado("Pendiente");
                /*
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String fechaComoCadena = sdf.format(new Date());
                System.out.println(fechaComoCadena);
                
                SimpleDateFormat fechaActual = new SimpleDateFormat(formatoFecha);
                String formatoFecha = "dd-MM-aaaa";
                Date fecha = new Date();
                */
                Tramite tramites = new Tramite();
                this.setVisible(false);
                tramites.setVisible(true);
      
            }else if (respuesta == ITramiteController.ADD_FOLIO_DUPLICADO){
                JOptionPane.showMessageDialog(
                        this,
                        "El folio ingresado ya se encuentra registrado.",
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);
                
            }else if (respuesta == ITramiteController.ADD_SIN_EXITO) {
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible realizar el registro.",
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);
            }
        
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarTramite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void folioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folioTextFieldActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        Tramite tramite = new Tramite();
        this.setVisible(false);
        tramite.setVisible(true);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        try {
            String matricula = matriculaTextField.getText();
            IEstudiante estudiante = RMI.getIEstudianteController().findOne(matricula);
            nombreTextField.setText(estudiante.getNombres());
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarTramite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_nombreTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarTramite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField folioTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField matriculaTextField;
    private javax.swing.JTextField nombreTextField;
    // End of variables declaration//GEN-END:variables
}
