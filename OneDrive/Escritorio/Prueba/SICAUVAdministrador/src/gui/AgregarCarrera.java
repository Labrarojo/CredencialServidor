/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Iniciador.RMI;
import Interfaces.ICarrera;
import Interfaces.ICarreraController;
import Interfaces.IFacultad;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class AgregarCarrera extends javax.swing.JFrame {
    
    private List<IFacultad> listaFacultades;
    
    public AgregarCarrera() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        try {
            listaFacultades = RMI.getIFacultadController().list();
            for (IFacultad nombreFacultades : listaFacultades) {
                facultadComboBox.addItem(nombreFacultades.getFacultad());
            }
            facultadComboBox.setSelectedItem(null);
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarCarrera.class.getName()).log(Level.SEVERE, null, ex);
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
        aceptarButton = new javax.swing.JButton();
        facultadComboBox = new javax.swing.JComboBox<>();
        carreraTextField = new javax.swing.JTextField();
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

        aceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/aceptar.png"))); // NOI18N
        aceptarButton.setBorder(null);
        aceptarButton.setContentAreaFilled(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 200, 50));

        facultadComboBox.setBackground(new java.awt.Color(220, 236, 246));
        facultadComboBox.setFont(new java.awt.Font("Tw Cen MT", 0, 28)); // NOI18N
        facultadComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        facultadComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultadComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 800, 90));

        carreraTextField.setBackground(new java.awt.Color(220, 236, 246));
        carreraTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        carreraTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        carreraTextField.setPreferredSize(new java.awt.Dimension(428, 31));
        getContentPane().add(carreraTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 800, 90));

        atrasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/atras.png"))); // NOI18N
        atrasButton.setBorder(null);
        atrasButton.setContentAreaFilled(false);
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(atrasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 50, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Agregar carrera 01.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        CarrerasRegistradas carreras = new CarrerasRegistradas();
        this.setVisible(false);
        carreras.setVisible(true);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {
            String facultad = (String) facultadComboBox.getSelectedItem();
            String nombre = carreraTextField.getText();
            
            ICarrera carrera = RMI.getICarreraController().newInstance();
            
            if (facultad == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione una facultad.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                facultadComboBox.requestFocus();
                return;
            }
            
            if (nombre.length() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese nombre de la carrera.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                carreraTextField.requestFocus();
                return;
            } else {
                carrera.setNombreCarrera(nombre);
                for (IFacultad facultades : listaFacultades) {
                    if (facultades.getFacultad().equals(facultad)) {
                        carrera.setIdFacultad(facultades.getId());
                    }
                }
            }
            int respuesta = RMI.getICarreraController().add(carrera);
            if (respuesta == ICarreraController.ADD_EXITO) {
                JOptionPane.showMessageDialog(this,
                        "Carrera agregada con éxito.",
                        "Operación éxitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                CarrerasRegistradas carreras = new CarrerasRegistradas();
                this.setVisible(false);
                carreras.setVisible(true);
            } else if (respuesta == ICarreraController.ADD_SIN_EXITO) {
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible completar el registro.",
                        "Registro no completado",
                        JOptionPane.ERROR_MESSAGE);
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void facultadComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultadComboBoxActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.setVisible(false);
        CarrerasRegistradas carrerasRegistradas = new CarrerasRegistradas();
        carrerasRegistradas.setVisible(true);
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
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCarrera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField carreraTextField;
    private javax.swing.JComboBox<String> facultadComboBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}