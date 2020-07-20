package gui;

import Iniciador.RMI;
import Interfaces.IFacultad;
import Interfaces.ISecretario;
import Interfaces.ISecretarioController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AgregarSecretaria extends javax.swing.JFrame {

    /**
     * Creates new form AgregarSecretaria
     */
    private List<IFacultad> listaFacultad;
    public AgregarSecretaria() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
        this.setLocationRelativeTo(null);
       
        try {
            listaFacultad = RMI.getIFacultadController().list();
            for (IFacultad nombreFacultad : listaFacultad) {
                facultadComboBox.addItem(nombreFacultad.getFacultad());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarSecretaria.class.getName()).log(Level.SEVERE, null, ex);
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

        atrasButton = new javax.swing.JButton();
        maternoTextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        matriculaTextField = new javax.swing.JTextField();
        facultadComboBox = new javax.swing.JComboBox<>();
        paternoTextField = new javax.swing.JTextField();
        mostrarContraseñaButton = new javax.swing.JToggleButton();
        contraseñaPasswordField = new javax.swing.JPasswordField();
        aceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 687));
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
        getContentPane().add(atrasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 50, -1));

        maternoTextField.setBackground(new java.awt.Color(220, 236, 246));
        maternoTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        maternoTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(maternoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 450, 60));

        nombreTextField.setBackground(new java.awt.Color(220, 236, 246));
        nombreTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        nombreTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(nombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 950, 60));

        matriculaTextField.setBackground(new java.awt.Color(220, 236, 246));
        matriculaTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        matriculaTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(matriculaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 450, 60));

        facultadComboBox.setBackground(new java.awt.Color(220, 236, 246));
        facultadComboBox.setFont(new java.awt.Font("Tw Cen MT", 0, 28)); // NOI18N
        facultadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facultad de Contaduria y Administración", "Facultad de Ingeniería" }));
        facultadComboBox.setBorder(null);
        facultadComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        facultadComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultadComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 950, 60));

        paternoTextField.setBackground(new java.awt.Color(220, 236, 246));
        paternoTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        paternoTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(paternoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 450, 60));

        mostrarContraseñaButton.setBackground(new java.awt.Color(220, 236, 246));
        mostrarContraseñaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/pass.png"))); // NOI18N
        mostrarContraseñaButton.setBorder(null);
        mostrarContraseñaButton.setContentAreaFilled(false);
        mostrarContraseñaButton.setMargin(null);
        mostrarContraseñaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarContraseñaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarContraseñaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, 50, 40));

        contraseñaPasswordField.setBackground(new java.awt.Color(220, 236, 246));
        contraseñaPasswordField.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        contraseñaPasswordField.setForeground(new java.awt.Color(47, 72, 90));
        contraseñaPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        contraseñaPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(contraseñaPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 460, 60));

        aceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/aceptar.png"))); // NOI18N
        aceptarButton.setBorder(null);
        aceptarButton.setContentAreaFilled(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 600, 200, 50));

        cancelarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cancelar.png"))); // NOI18N
        cancelarButton.setBorder(null);
        cancelarButton.setContentAreaFilled(false);
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 200, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Agregar secretaria – 1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraseñaPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaPasswordFieldActionPerformed

    private void mostrarContraseñaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarContraseñaButtonActionPerformed
        if (mostrarContraseñaButton.isSelected()) {
            contraseñaPasswordField.setEchoChar((char)0);
        }else{
            contraseñaPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_mostrarContraseñaButtonActionPerformed

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        SecretariasRegistradas secretarias = new SecretariasRegistradas();
        this.setVisible(false);
        secretarias.setVisible(true);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {
            String nombre = nombreTextField.getText();
            String apellidoPaterno = paternoTextField.getText();
            String apellidoMaterno = maternoTextField.getText();
            String nombreFacultad = (String) facultadComboBox.getSelectedItem();
            String matricula = matriculaTextField.getText();
            String contraseña = contraseñaPasswordField.getText();
            
            ISecretario secretaria = RMI.getISecretarioController().newInstance();
            
            if(nombre.length() == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese nombre.", 
                        "Validación", 
                        JOptionPane.ERROR_MESSAGE);
                nombreTextField.requestFocus();
                return;
            }else{
                secretaria.setNombres(nombre);
            }
            
            if(apellidoPaterno.length() == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese el apellido paterno.", 
                        "Validación", 
                        JOptionPane.ERROR_MESSAGE);
                paternoTextField.requestFocus();
                return;
            }else{
                secretaria.setApellidoPaterno(apellidoPaterno);
            }
            
            if(apellidoMaterno.length() == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese el apellido materno.", 
                        "Validación", 
                        JOptionPane.ERROR_MESSAGE);
                maternoTextField.requestFocus();
                return;
            }else{
                secretaria.setApellidoMaterno(apellidoMaterno);
            }
            
            if (nombreFacultad.length() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione una facultad.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                facultadComboBox.requestFocus();
                return;
            } else {
                for (IFacultad iFacultad : listaFacultad) {
                    if (iFacultad.getFacultad().equals(nombreFacultad)) {
                        
                        secretaria.setIdFacultad(iFacultad.getId());
                    }
                }
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
                secretaria.setMatriculaSecretario(matricula);
            }
            
            if(contraseña.length() == 0){
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese una contraseña.", 
                        "Validación", 
                        JOptionPane.ERROR_MESSAGE);
                contraseñaPasswordField.requestFocus();
                return;
            }else{
                secretaria.setContraseña(contraseña);
            }
            
            int respuesta = RMI.getISecretarioController().add(secretaria);
            if(respuesta == ISecretarioController.ADD_EXITO){
                JOptionPane.showMessageDialog(
                        this, 
                        "Secretaria agregada con éxito",
                        "Operación exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                SecretariasRegistradas secretarias = new SecretariasRegistradas();
                this.setVisible(false);
                secretarias.setVisible(true);
            }else if(respuesta == ISecretarioController.ADD_MATRICULA_DUPLICADA){
                JOptionPane.showMessageDialog(
                        this, 
                        "La matrícula ingresada ya se encuentra registrada", 
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);
            }else if(respuesta == ISecretarioController.ADD_SIN_EXITO){
                JOptionPane.showMessageDialog(
                        this, 
                        "No fue posible completar la operación", 
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(AgregarSecretaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        SecretariasRegistradas secretarias = new SecretariasRegistradas();
        this.setVisible(false);
        secretarias.setVisible(true);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void facultadComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultadComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarSecretaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JPasswordField contraseñaPasswordField;
    private javax.swing.JComboBox<String> facultadComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField maternoTextField;
    private javax.swing.JTextField matriculaTextField;
    private javax.swing.JToggleButton mostrarContraseñaButton;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField paternoTextField;
    // End of variables declaration//GEN-END:variables
}
