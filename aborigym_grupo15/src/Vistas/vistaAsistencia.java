
package Vistas;

import Modelo.Asistencia;
import Modelo.ClaseGym;
import Modelo.Socio;
import Persistencia.AsistenciaData;
import Persistencia.ClaseGymData;
import Persistencia.SocioData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class vistaAsistencia extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
 
    public vistaAsistencia() {
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
        jTFid.setEditable(false);

        cargarComboSocios();
        cargarClases();
        cargarOpcionesBuscar();
        limpiarCampos();
        cargarTabla(new AsistenciaData().listarAsistencias());

        ((javax.swing.JComponent) this.getContentPane()).setOpaque(false);
        jDesktopPane1.setOpaque(false);
        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 0, 0));

        this.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.getRootPane().setOpaque(false);
        ((javax.swing.JComponent) this.getContentPane()).setOpaque(false);
        jDesktopPane1.setOpaque(false);
    }

    private void cargarComboSocios() {
        jCBsocio.removeAllItems();
        SocioData sd = new SocioData();
        ArrayList<Socio> lista = sd.listarSocios();

        for (Socio socio : lista) {
            jCBsocio.addItem(socio);
        }
    }

    private void limpiarCampos() {
        jTFid.setText("");
        jCBsocio.setSelectedIndex(-1);
        jCBclaseG.setSelectedIndex(-1);
        jTFfecha.setText("");
        jCBopcion.setSelectedIndex(-1);
    }

    private void cargarClases() {
        jCBclaseG.removeAllItems();
        ClaseGymData cd = new ClaseGymData();
        List<ClaseGym> lista = cd.listarClasesDisponibles();

        for (ClaseGym clase : lista) {
            jCBclaseG.addItem(clase);
        }
    }

    private void cargarOpcionesBuscar() {
        jCBopcion.removeAllItems();
        jCBopcion.addItem("Todas");
        jCBopcion.addItem("Por Socio");
        jCBopcion.addItem("Por Clase");
        jCBopcion.addItem("Por Fecha");
    }
     
    private void cargarTabla(List<Asistencia> lista) {
        modelo.setRowCount(0);
        for (Asistencia a : lista) {
            modelo.addRow(new Object[]{
                a.getIdAsistencia(),
                a.getSocio(),
                a.getClaseGym(),
                a.getFechaAsistencia()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jlDatos = new javax.swing.JLabel();
        jLid = new javax.swing.JLabel();
        jlSocio = new javax.swing.JLabel();
        jlClaseGym = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jTFid = new javax.swing.JTextField();
        jCBsocio = new javax.swing.JComboBox<>();
        jCBclaseG = new javax.swing.JComboBox<>();
        jTFfecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbNuevo = new javax.swing.JButton();
        jlBuscarPor = new javax.swing.JLabel();
        jCBopcion = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jlDatos1 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(669, 501));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(669, 501));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlDatos.setBackground(new java.awt.Color(255, 255, 255));
        jlDatos.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jlDatos.setForeground(new java.awt.Color(255, 255, 255));
        jlDatos.setText("Datos de la Asistencia");
        jDesktopPane1.add(jlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLid.setBackground(new java.awt.Color(255, 255, 255));
        jLid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLid.setForeground(new java.awt.Color(255, 255, 255));
        jLid.setText("ID Asistencia:");
        jDesktopPane1.add(jLid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jlSocio.setBackground(new java.awt.Color(255, 255, 255));
        jlSocio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlSocio.setForeground(new java.awt.Color(255, 255, 255));
        jlSocio.setText("Socio:");
        jDesktopPane1.add(jlSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jlClaseGym.setBackground(new java.awt.Color(255, 255, 255));
        jlClaseGym.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlClaseGym.setForeground(new java.awt.Color(255, 255, 255));
        jlClaseGym.setText("Clase Gym:");
        jDesktopPane1.add(jlClaseGym, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jlFecha.setBackground(new java.awt.Color(255, 255, 255));
        jlFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setText("Fecha Asistencia:");
        jDesktopPane1.add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jTFid.addActionListener(this::jTFidActionPerformed);
        jDesktopPane1.add(jTFid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 77, -1));

        jCBsocio.addActionListener(this::jCBsocioActionPerformed);
        jDesktopPane1.add(jCBsocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 139, -1));

        jCBclaseG.addActionListener(this::jCBclaseGActionPerformed);
        jDesktopPane1.add(jCBclaseG, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 139, -1));

        jTFfecha.setText("AAAA-MM-DD");
        jTFfecha.setToolTipText("");
        jDesktopPane1.add(jTFfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 139, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Asistencia", "Socio", "Clase Gym", "Fecha Asistencia"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 480, 470));

        jbNuevo.setText("Nuevo");
        jbNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbNuevo.addActionListener(this::jbNuevoActionPerformed);
        jDesktopPane1.add(jbNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 269, -1));

        jlBuscarPor.setBackground(new java.awt.Color(255, 255, 255));
        jlBuscarPor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlBuscarPor.setForeground(new java.awt.Color(255, 255, 255));
        jlBuscarPor.setText("Buscar por:");
        jDesktopPane1.add(jlBuscarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jCBopcion.addActionListener(this::jCBopcionActionPerformed);
        jDesktopPane1.add(jCBopcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 139, -1));

        jbBuscar.setText("Buscar");
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbBuscar.addActionListener(this::jbBuscarActionPerformed);
        jDesktopPane1.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 269, -1));

        jbModificar.setText("Modificar");
        jbModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbModificar.addActionListener(this::jbModificarActionPerformed);
        jDesktopPane1.add(jbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 269, -1));

        jbEliminar.setText("Eliminar");
        jbEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbEliminar.addActionListener(this::jbEliminarActionPerformed);
        jDesktopPane1.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 269, -1));

        jbGuardar.setText("Guardar");
        jbGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbGuardar.addActionListener(this::jbGuardarActionPerformed);
        jDesktopPane1.add(jbGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 269, -1));

        jbLimpiar.setText("Limpiar");
        jbLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbLimpiar.addActionListener(this::jbLimpiarActionPerformed);
        jDesktopPane1.add(jbLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 269, -1));

        jlDatos1.setBackground(new java.awt.Color(255, 255, 255));
        jlDatos1.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jlDatos1.setForeground(new java.awt.Color(255, 255, 255));
        jlDatos1.setText("Lista de la Asistencia");
        jDesktopPane1.add(jlDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBsocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBsocioActionPerformed

    }//GEN-LAST:event_jCBsocioActionPerformed

    private void jTFidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFidActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        if (jTFid.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione una asistencia de la tabla.");
            return;
        }
        try {
            int id = Integer.parseInt(jTFid.getText());
            Socio socio = (Socio) jCBsocio.getSelectedItem();
            ClaseGym clase = (ClaseGym) jCBclaseG.getSelectedItem();
            LocalDate fecha = LocalDate.parse(jTFfecha.getText());

            Asistencia asistencia = new Asistencia();
            asistencia.setIdAsistencia(id);
            asistencia.setSocio(socio);
            asistencia.setClaseGym(clase);
            asistencia.setFechaAsistencia(fecha);

            AsistenciaData ad = new AsistenciaData();
            ad.modificarAsistencia(asistencia);
            limpiarCampos();
            cargarTabla(ad.listarAsistencias());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fecha invalida. Use el formato AAAA-MM-DD.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (jTFid.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione una asistencia de la tabla.");
            return;
        }
        int id = Integer.parseInt(jTFid.getText());
        AsistenciaData ad = new AsistenciaData();
        ad.eliminarAsistencia(id);
        limpiarCampos();
        cargarTabla(ad.listarAsistencias());

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
        cargarTabla(new AsistenciaData().listarAsistencias());
    
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jCBopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBopcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBopcionActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        if (jCBsocio.getSelectedItem() == null || jCBclaseG.getSelectedItem() == null || jTFfecha.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }
        try {
            Socio socio = (Socio) jCBsocio.getSelectedItem();
            ClaseGym clase = (ClaseGym) jCBclaseG.getSelectedItem();
            LocalDate fecha = LocalDate.parse(jTFfecha.getText());

            Asistencia asistencia = new Asistencia();
            asistencia.setSocio(socio);
            asistencia.setClaseGym(clase);
            asistencia.setFechaAsistencia(fecha);

            AsistenciaData ad = new AsistenciaData();
            ad.registrarAsistencia(asistencia);
            limpiarCampos();
            cargarTabla(ad.listarAsistencias());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fecha invalida. Use el formato AAAA-MM-DD.");
    
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        String opcion = (String) jCBopcion.getSelectedItem();
        AsistenciaData ad = new AsistenciaData();

        if (opcion == null || opcion.equals("Todas")) {
            cargarTabla(ad.listarAsistencias());
        } else if (opcion.equals("Por Socio")) {
            Socio s = (Socio) jCBsocio.getSelectedItem();
            if (s != null) {
                cargarTabla(ad.listarPorSocio(s.getIdSocio()));
            }
        } else if (opcion.equals("Por Clase")) {
            ClaseGym c = (ClaseGym) jCBclaseG.getSelectedItem();
            if (c != null) {
                cargarTabla(ad.listarPorClase(c.getIdClase()));
            }
        } else if (opcion.equals("Por Fecha")) {
            try {
                LocalDate fecha = LocalDate.parse(jTFfecha.getText());
                cargarTabla(ad.listarPorFecha(fecha));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Fecha invalida (AAAA-MM-DD).");
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            jTFid.setText(jTable1.getValueAt(fila, 0).toString());

            Socio socioTabla = (Socio) jTable1.getValueAt(fila, 1);
            for (int i = 0; i < jCBsocio.getItemCount(); i++) {
                if (jCBsocio.getItemAt(i).getIdSocio() == socioTabla.getIdSocio()) {
                    jCBsocio.setSelectedIndex(i);
                    break;
                }
            }

            ClaseGym claseTabla = (ClaseGym) jTable1.getValueAt(fila, 2);
            for (int i = 0; i < jCBclaseG.getItemCount(); i++) {
                if (jCBclaseG.getItemAt(i).getIdClase() == claseTabla.getIdClase()) {
                    jCBclaseG.setSelectedIndex(i);
                    break;
                }
            }

            jTFfecha.setText(jTable1.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jCBclaseGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBclaseGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBclaseGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ClaseGym> jCBclaseG;
    private javax.swing.JComboBox<String> jCBopcion;
    private javax.swing.JComboBox<Socio> jCBsocio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFfecha;
    private javax.swing.JTextField jTFid;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JLabel jlBuscarPor;
    private javax.swing.JLabel jlClaseGym;
    private javax.swing.JLabel jlDatos;
    private javax.swing.JLabel jlDatos1;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlSocio;
    // End of variables declaration//GEN-END:variables
}
    
    
