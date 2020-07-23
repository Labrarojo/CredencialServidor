/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ImageIcon;

/**
 *
 * @author adria
 */
public class MenuSecretaria extends javax.swing.JFrame {

    public int idFacultad;

    /**
     * Creates new form MenuSecretariaa
     */
    public MenuSecretaria(int idFacultad) {
        initComponents();
        this.idFacultad = idFacultad;
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

        alumnosRegistradosButton = new javax.swing.JButton();
        tramitesButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alumnosRegistradosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/registrados.png"))); // NOI18N
        alumnosRegistradosButton.setBorder(null);
        alumnosRegistradosButton.setContentAreaFilled(false);
        alumnosRegistradosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnosRegistradosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alumnosRegistradosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 380, 250));

        tramitesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/tram.png"))); // NOI18N
        tramitesButton.setBorder(null);
        tramitesButton.setContentAreaFilled(false);
        tramitesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tramitesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(tramitesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 380, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Menú Secre – 4.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alumnosRegistradosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnosRegistradosButtonActionPerformed
        AlumnosRegistrados registroAlumno = new AlumnosRegistrados(idFacultad);
        this.setVisible(false);
        registroAlumno.setVisible(true);
    }//GEN-LAST:event_alumnosRegistradosButtonActionPerformed

    private void tramitesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tramitesButtonActionPerformed
        Tramite tramite = new Tramite(idFacultad);
        this.setVisible(false);
        tramite.setVisible(true);
    }//GEN-LAST:event_tramitesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alumnosRegistradosButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton tramitesButton;
    // End of variables declaration//GEN-END:variables
}