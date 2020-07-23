package gui;

import Iniciador.RMI;
import Interfaces.ICarrera;
import Interfaces.IEstudiante;
import Interfaces.IEstudianteController;
import Interfaces.IFacultad;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EditarAlumno extends javax.swing.JFrame {

    public int idFacultad;
    public int rutaAnterior;
    public String matriculaAnterior;
    private IEstudiante estudiante;
    private List<IFacultad> listaFacultad;
    private List<ICarrera> listaCarrera;

    public int ALUMNOS = 1;
    public int TRAMITES = 2;

    public EditarAlumno(IEstudiante estudiante, int idFacultad, int rutaAnterior) {
        try {
            initComponents();
            this.idFacultad = idFacultad;
            this.estudiante = estudiante;
            this.rutaAnterior = rutaAnterior;
            this.matriculaAnterior = estudiante.getMatricula();

            listaFacultad = RMI.getIFacultadController().list();
            try {
                listaFacultad = RMI.getIFacultadController().list();
                for (IFacultad nombreFacultad : listaFacultad) {
                    if (nombreFacultad.getId() == idFacultad) {
                        facultadComboBox.addItem(nombreFacultad.getFacultad());
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(AgregarAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                listaCarrera = RMI.getICarreraController().list();
                for (ICarrera nombreCarrera : listaCarrera) {
                    if (nombreCarrera.getIdFacultad() == idFacultad) {
                        carreraComboBox.addItem(nombreCarrera.getNombreCarrera());
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(AgregarAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
            matriculaTextField.setText(estudiante.getMatricula());
            nombreTextField.setText(estudiante.getNombres());
            paternoTextField.setText(estudiante.getApellidoPaterno());
            maternoTextField.setText(estudiante.getApellidoMaterno());

            for (IFacultad iFacultad : listaFacultad) {
                if (iFacultad.getId() == estudiante.getIdFacultad()) {
                    facultadComboBox.setSelectedItem(iFacultad.getFacultad());
                }
            }

            for (ICarrera iCarrera : listaCarrera) {
                if (iCarrera.getIdCarrera() == estudiante.getIdCarrera()) {
                    carreraComboBox.setSelectedItem(iCarrera.getNombreCarrera());
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(EditarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
    }

    public EditarAlumno() {
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

        maternoTextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        matriculaTextField = new javax.swing.JTextField();
        paternoTextField = new javax.swing.JTextField();
        carreraComboBox = new javax.swing.JComboBox<>();
        aceptarButton = new javax.swing.JButton();
        facultadComboBox = new javax.swing.JComboBox<>();
        cancelarButton = new javax.swing.JButton();
        selecFotoButton1 = new javax.swing.JButton();
        selecFotoButton = new javax.swing.JButton();
        atrasButton = new javax.swing.JButton();
        fotoLabel = new javax.swing.JLabel();
        firmaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        maternoTextField.setBackground(new java.awt.Color(220, 236, 246));
        maternoTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        maternoTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        maternoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maternoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(maternoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 460, 60));

        nombreTextField.setBackground(new java.awt.Color(220, 236, 246));
        nombreTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        nombreTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 950, 60));

        matriculaTextField.setBackground(new java.awt.Color(220, 236, 246));
        matriculaTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        matriculaTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(matriculaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 460, 60));

        paternoTextField.setBackground(new java.awt.Color(220, 236, 246));
        paternoTextField.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        paternoTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 236, 246), 3, true));
        getContentPane().add(paternoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 460, 60));

        carreraComboBox.setBackground(new java.awt.Color(220, 236, 246));
        carreraComboBox.setFont(new java.awt.Font("Tw Cen MT", 0, 28)); // NOI18N
        carreraComboBox.setBorder(null);
        carreraComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(carreraComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 460, 60));

        aceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/aceptar.png"))); // NOI18N
        aceptarButton.setBorder(null);
        aceptarButton.setContentAreaFilled(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 610, 200, 50));

        facultadComboBox.setBackground(new java.awt.Color(220, 236, 246));
        facultadComboBox.setFont(new java.awt.Font("Tw Cen MT", 0, 28)); // NOI18N
        facultadComboBox.setBorder(null);
        facultadComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(facultadComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 960, 60));

        cancelarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cancelar.png"))); // NOI18N
        cancelarButton.setBorder(null);
        cancelarButton.setContentAreaFilled(false);
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 610, 200, 50));

        selecFotoButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Grupo 178.png"))); // NOI18N
        selecFotoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecFotoButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(selecFotoButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 520, 180, 50));

        selecFotoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Grupo 6.png"))); // NOI18N
        selecFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecFotoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(selecFotoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 280, 180, 50));

        atrasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/atras.png"))); // NOI18N
        atrasButton.setBorder(null);
        atrasButton.setContentAreaFilled(false);
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(atrasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 50, -1));

        fotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/redes-sociales.png"))); // NOI18N
        getContentPane().add(fotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 120, 160, 150));

        firmaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Rectángulo 46.png"))); // NOI18N
        getContentPane().add(firmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 390, -1, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/editar alumno – 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maternoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maternoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maternoTextFieldActionPerformed

    private void selecFotoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecFotoButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecFotoButton1ActionPerformed

    private void selecFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecFotoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecFotoButtonActionPerformed

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        AlumnosRegistrados alumnos = new AlumnosRegistrados(idFacultad);
        this.setVisible(false);
        alumnos.setVisible(true);
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {
            String nombre = nombreTextField.getText();
            String apellidoPaterno = paternoTextField.getText();
            String apellidoMaterno = maternoTextField.getText();
            String matricula = matriculaTextField.getText().toUpperCase();
            String nombreFacultad = (String) facultadComboBox.getSelectedItem();
            String nombreCarrera = (String) carreraComboBox.getSelectedItem();

            IEstudiante estudiante = RMI.getIEstudianteController().newInstance();

            if (nombre.length() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese nombre.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                nombreTextField.requestFocus();
                return;
            } else {
                estudiante.setNombres(nombre);
            }

            if (apellidoPaterno.length() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese el apellido paterno.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                paternoTextField.requestFocus();
                return;
            } else {
                estudiante.setApellidoPaterno(apellidoPaterno);
            }

            if (apellidoMaterno.length() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese el apellido materno.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                maternoTextField.requestFocus();
                return;
            } else {
                estudiante.setApellidoMaterno(apellidoMaterno);
            }

            if (matricula.length() != 9) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese la matrícula.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                matriculaTextField.requestFocus();
                return;
            } else {
                estudiante.setMatricula(matricula);
            }

            if (nombreCarrera.length() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione una carrera.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE);
                carreraComboBox.requestFocus();
                return;
            } else {
                for (ICarrera iCarrera : listaCarrera) {
                    if (iCarrera.getNombreCarrera().equals(nombreCarrera)) {
                        estudiante.setIdCarrera(iCarrera.getIdCarrera());
                    }
                }
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
                        estudiante.setIdFacultad(iFacultad.getId());
                    }
                }
            }

            int respuesta = RMI.getIEstudianteController().update(estudiante, matriculaAnterior);

            if (respuesta == IEstudianteController.UPDATE_EXITO) {
                JOptionPane.showMessageDialog(
                        this,
                        "El alumno ha sido modificado exitosamente.",
                        "Operación exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                if (rutaAnterior == ALUMNOS) {
                    AlumnosRegistrados alumnos = new AlumnosRegistrados(idFacultad);
                    this.setVisible(false);
                    alumnos.setVisible(true);
                } else if (rutaAnterior == TRAMITES) {
                    Tramite tramite = new Tramite(idFacultad);
                    this.setVisible(false);
                    tramite.setVisible(true);
                }

            } else if (respuesta == IEstudianteController.UPDATE_SIN_EXITO) {
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible completar la operación.",
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);

            } else if (respuesta == IEstudianteController.UPDATE_ESTUDIANTE_INEXISTE) {
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible completar la operación.\n" + "La matrícula ingresada no se encuentra registrada.\n",
                        "Operación no exitosa",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(EditarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        if (rutaAnterior == ALUMNOS) {
            AlumnosRegistrados alumnos = new AlumnosRegistrados(idFacultad);
            this.setVisible(false);
            alumnos.setVisible(true);
        } else if (rutaAnterior == TRAMITES) {
            Tramite tramite = new Tramite(idFacultad);
            this.setVisible(false);
            tramite.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JComboBox<String> carreraComboBox;
    private javax.swing.JComboBox<String> facultadComboBox;
    private javax.swing.JLabel firmaLabel;
    private javax.swing.JLabel fotoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField maternoTextField;
    private javax.swing.JTextField matriculaTextField;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField paternoTextField;
    private javax.swing.JButton selecFotoButton;
    private javax.swing.JButton selecFotoButton1;
    // End of variables declaration//GEN-END:variables
}