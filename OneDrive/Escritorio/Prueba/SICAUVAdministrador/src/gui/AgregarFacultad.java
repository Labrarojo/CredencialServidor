package gui;

import Iniciador.RMI;
import Interfaces.IFacultad;
import Interfaces.IFacultadController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class AgregarFacultad extends javax.swing.JFrame {

    private JDialog dialogParent;
    
    public AgregarFacultad() {
        initComponents();
        this.dialogParent = dialogParent;
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

        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
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

        aceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/aceptar.png"))); // NOI18N
        aceptarButton.setBorder(null);
        aceptarButton.setContentAreaFilled(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 200, 50));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Agregar facultad – 1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        FacultadesRegistradas facultades = new FacultadesRegistradas();
        this.setVisible(false);
        facultades.setVisible(true);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {
            String nombre = facultadTextField.getText();
            
            IFacultad facultad = RMI.getIFacultadController().newInstance();

            if ( nombre.length() == 0 ){
                JOptionPane.showMessageDialog(this, "Ingrese el nombre de la facultad.", "Validación", JOptionPane.ERROR_MESSAGE );
                facultadTextField.requestFocus();
                return;
            }
            else{
                facultad.setFacultad(nombre);
            }
            int respuesta = RMI.getIFacultadController().add(facultad);
            if ( respuesta == IFacultadController.ADD_EXITO ){
                JOptionPane.showMessageDialog(this, "Facultad agregada con éxito.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
               // dialogParent.dispose();
            }
            else if ( respuesta == IFacultadController.ADD_SIN_EXITO){
                JOptionPane.showMessageDialog(this, "No fue posible completar la operación.", "Operación incompleta", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacultadesRegistradas facultades = new FacultadesRegistradas();
        this.setVisible(false);
        facultades.setVisible(true);
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void facultadTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultadTextFieldActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        FacultadesRegistradas facultades = new FacultadesRegistradas();
        this.setVisible(false);
        facultades.setVisible(true);
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarFacultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarFacultad().setVisible(true);
            }
            
            public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField facultadTextField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}