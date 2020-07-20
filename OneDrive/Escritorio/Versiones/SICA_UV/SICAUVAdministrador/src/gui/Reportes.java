/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Iniciador.RMI;
import Interfaces.ICarrera;
import Interfaces.IEstudiante;
import Interfaces.IFacultad;
import Interfaces.ITramite;
import java.awt.Color;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adria
 */
public class Reportes extends javax.swing.JFrame {

    private static JLabel label;
    private static JCheckBox checkBox;

    /**
     * Creates new form SecretariasRegistradas
     */
    public Reportes() {
        initComponents();
        refrescarTabla();
        setIconImage(new ImageIcon(getClass().getResource("/media/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        reporteTable.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        reporteTable.getTableHeader().setOpaque(false);
        reporteTable.getTableHeader().setOpaque(false);
        reporteTable.getTableHeader().setForeground(new Color(47, 72, 90));
        reporteTable.setRowHeight(25);//scroll
    }

    public void refrescarTabla() {
        
        try {
            Vector<Vector> datos = new Vector<>();

            List<ITramite> listaTramite;
            listaTramite = RMI.getITramiteController().list();
            List<IEstudiante> listaEstudiante;
            listaEstudiante = RMI.getIEstudianteController().list();
            List<IFacultad> listaFacultad;
            listaFacultad = RMI.getIFacultadController().list();
            List<ICarrera> listaCarrera;
            listaCarrera = RMI.getICarreraController().list();

            for (ITramite tramite : listaTramite) {
                Vector registro = new Vector();
                registro.add(tramite.getFolio());
                registro.add(tramite.getMatricula());
                for (IEstudiante estudiante : listaEstudiante) {
                    if (tramite.getMatricula().equals(estudiante.getMatricula())) {
                        registro.add(estudiante.getNombres() + " " + estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
                        for (IFacultad facultad : listaFacultad) {
                            if (estudiante.getIdFacultad() == facultad.getId()) {
                                registro.add(facultad.getFacultad());
                            }
                        }
                        for (ICarrera carrera : listaCarrera) {
                            if (estudiante.getIdCarrera() == carrera.getIdCarrera()) {
                                registro.add(carrera.getNombreCarrera());
                            }
                        }
                    }
                }
                registro.add(label = new JLabel());
                registro.add(label = new JLabel());
                registro.add(checkBox = new JCheckBox());
                registro.add(checkBox = new JCheckBox());
                registro.add(checkBox = new JCheckBox());

                datos.add(registro);
            }

            Vector<String> columnas = new Vector<>();
            columnas.add("Folio");
            columnas.add("Matrícula");
            columnas.add("Nombre");
            columnas.add("Facultad");
            columnas.add("Programa educativo");
            columnas.add("Foto");
            columnas.add("Firma");
            columnas.add("Aceptar datos");
            columnas.add("Rechazar foto");
            columnas.add("Rechazar firma");
            reporteTable.setModel(new DefaultTableModel(datos, columnas));
        } catch (RemoteException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
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

        homeButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reporteTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/home.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.setContentAreaFilled(false);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 80));

        cancelarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cancelar.png"))); // NOI18N
        cancelarButton.setBorder(null);
        cancelarButton.setContentAreaFilled(false);
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 620, 200, 50));

        aceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/aceptar.png"))); // NOI18N
        aceptarButton.setBorder(null);
        aceptarButton.setContentAreaFilled(false);
        getContentPane().add(aceptarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 620, 200, 50));

        reporteTable.setBackground(new java.awt.Color(255, 255, 250));
        reporteTable.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        reporteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Reporte", "Folio", "Matrícula", "Nombre", "Facultad", "Programa educativo", "Foto", "Firma", "Aceptar datos", "Rechazar foto", "Rechazar firma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reporteTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1270, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Reporte – 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        MenuAdministrador MenuAdmin = new MenuAdministrador();
        this.setVisible(false);
        MenuAdmin.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reporteTable;
    // End of variables declaration//GEN-END:variables
}
