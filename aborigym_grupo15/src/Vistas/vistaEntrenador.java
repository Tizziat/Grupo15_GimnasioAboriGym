/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Modelo.Entrenador;
import Persistencia.EntrenadorData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luly2
 */
public class vistaEntrenador extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private int idEntrenador = -1;
    private EntrenadorData entrenadorData = new EntrenadorData();

    public vistaEntrenador() {
        initComponents();
        armarCabecera();
        cargarEspecialidades();
        limpiarCampos();
    }

    private void armarCabecera() {
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Especialidad");
        modelo.addColumn("Estado");
        jTable1.setModel(modelo);
    }

    private void cargarEspecialidades() {
        jcbEspecialidad.removeAllItems();
        jcbEspecialidad.addItem("Seleccione..");
        jcbEspecialidad.addItem("Musculacion");
        jcbEspecialidad.addItem("CrossFit");
        jcbEspecialidad.addItem("Spinning");
        jcbEspecialidad.addItem("Pilates");
    }

    private void limpiarCampos() {
        idEntrenador = -1;
        jtfDNI.setText("");
        jtfNombre.setText("");
        jtfApellido.setText("");
        jcbEspecialidad.setSelectedIndex(0);
        jrbActivo.setSelected(true);
        jbGuardar.setEnabled(true);
        jbAltaBaja.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbActualizar.setEnabled(false);
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Entrenador e : entrenadorData.listarEntrenadores()) {
            modelo.addRow(new Object[]{
                e.getDni(),
                e.getNombre(),
                e.getApellido(),
                e.getEspecialidad(),
                e.isEstado() ? "Activo" : "Inactivo"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jlDatos = new javax.swing.JLabel();
        jlDNI = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jlEspecialidad = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jrbActivo = new javax.swing.JRadioButton();
        jrbInactivo = new javax.swing.JRadioButton();
        jlLista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcbEspecialidad = new javax.swing.JComboBox<>();
        jlEstado = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbAltaBaja = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(669, 501));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(669, 501));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlDatos.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jlDatos.setText("Datos del Entrenador");
        jDesktopPane1.add(jlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 6, -1, -1));

        jlDNI.setText("DNI:");
        jDesktopPane1.add(jlDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jlNombre.setText("Nombre:");
        jDesktopPane1.add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jlApellido.setText("Apellido:");
        jDesktopPane1.add(jlApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jlEspecialidad.setText("Especialidad:");
        jDesktopPane1.add(jlEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jDesktopPane1.add(jtfDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 140, -1));
        jDesktopPane1.add(jtfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, -1));
        jDesktopPane1.add(jtfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, -1));

        jrbActivo.setText("Activo");
        jDesktopPane1.add(jrbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jrbInactivo.setText("Inactivo");
        jrbInactivo.addActionListener(this::jrbInactivoActionPerformed);
        jDesktopPane1.add(jrbInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jlLista.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jlLista.setText("Lista de Entrenadores");
        jDesktopPane1.add(jlLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 6, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Entrenador", "DNI", "Nombre", "Apellido", "Especialidad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 394, 400));

        jcbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDesktopPane1.add(jcbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, -1));

        jlEstado.setText("Estado:");
        jDesktopPane1.add(jlEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(this::jbNuevoActionPerformed);
        jDesktopPane1.add(jbNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 232, -1));

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(this::jbGuardarActionPerformed);
        jDesktopPane1.add(jbGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 232, -1));

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(this::jbActualizarActionPerformed);
        jDesktopPane1.add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 232, -1));

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(this::jbEliminarActionPerformed);
        jDesktopPane1.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 232, -1));

        jbAltaBaja.setText("Alta/Baja");
        jbAltaBaja.addActionListener(this::jbAltaBajaActionPerformed);
        jDesktopPane1.add(jbAltaBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 232, -1));

        jbMostrar.setText("Mostrar Entrenadores");
        jbMostrar.addActionListener(this::jbMostrarActionPerformed);
        jDesktopPane1.add(jbMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 232, -1));

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(this::jbBuscarActionPerformed);
        jDesktopPane1.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 232, -1));

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbInactivoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        String dni = jtfDNI.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar.");
            return;
        }

        Entrenador e = entrenadorData.buscarEntrenador(dni);
        if (e != null) {
            idEntrenador = e.getIdEntrenador();
            jtfNombre.setText(e.getNombre());
            jtfApellido.setText(e.getApellido());
            jcbEspecialidad.setSelectedItem(e.getEspecialidad());

            if (e.isEstado()) {
                jrbActivo.setSelected(true);
            } else {
                jrbInactivo.setSelected(true);
            }

            jbGuardar.setEnabled(false);
            jbActualizar.setEnabled(true);
            jbEliminar.setEnabled(true);
            jbAltaBaja.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontro ningun entrenador con el DNI: " + dni);
            idEntrenador = -1;
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        try {
            String dni = jtfDNI.getText().trim();
            String nombre = jtfNombre.getText().trim();
            String apellido = jtfApellido.getText().trim();

            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || jcbEspecialidad.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos y elija una especialidad.");
                return;
            }

            String especialidad = jcbEspecialidad.getSelectedItem().toString();
            boolean estado = jrbActivo.isSelected();

            Entrenador nuevo = new Entrenador(dni, nombre, apellido, especialidad, estado);
            entrenadorData.guardarEntrenador(nuevo);

            idEntrenador = nuevo.getIdEntrenador();
            JOptionPane.showMessageDialog(this, "Entrenador guardado.");
            cargarTabla();

            jbGuardar.setEnabled(false);
            jbActualizar.setEnabled(true);
            jbEliminar.setEnabled(true);
            jbAltaBaja.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        if (idEntrenador == -1) {
            JOptionPane.showMessageDialog(this, "Debe buscar o seleccionar un entrenador primero.");
            return;
        }

        String dni = jtfDNI.getText().trim();
        String nombre = jtfNombre.getText().trim();
        String apellido = jtfApellido.getText().trim();

        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || jcbEspecialidad.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        String especialidad = jcbEspecialidad.getSelectedItem().toString();
        boolean estado = jrbActivo.isSelected();

        Entrenador e = new Entrenador(idEntrenador, dni, nombre, apellido, especialidad, estado);
        entrenadorData.actualizarEntrenador(e);

        JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
        cargarTabla();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbAltaBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaBajaActionPerformed
        // TODO add your handling code here:
        if (idEntrenador == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un entrenador de la tabla o busca por DNI.");
            return;
        }

        if (jrbActivo.isSelected()) {
            entrenadorData.bajaLogica(idEntrenador);
            jrbInactivo.setSelected(true);
            JOptionPane.showMessageDialog(this, "Entrenador dado de baja.");
        } else {
            entrenadorData.altaLogica(idEntrenador);
            jrbActivo.setSelected(true);
            JOptionPane.showMessageDialog(this, "Entrenador dado de alta.");
        }
        cargarTabla();
    }//GEN-LAST:event_jbAltaBajaActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        if (idEntrenador == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un entrenador para borrar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar físicamente al entrenador? Esta acción no se puede deshacer.",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            entrenadorData.borrarEntrenador(idEntrenador);
            limpiarCampos();
            cargarTabla();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jbMostrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            String dni = modelo.getValueAt(fila, 0).toString();

            Entrenador e = entrenadorData.buscarEntrenador(dni);
            if (e != null) {
                idEntrenador = e.getIdEntrenador();
                jtfDNI.setText(e.getDni());
                jtfNombre.setText(e.getNombre());
                jtfApellido.setText(e.getApellido());
                jcbEspecialidad.setSelectedItem(e.getEspecialidad());

                if (e.isEstado()) {
                    jrbActivo.setSelected(true);
                } else {
                    jrbInactivo.setSelected(true);
                }

                jbGuardar.setEnabled(false);
                jbActualizar.setEnabled(true);
                jbEliminar.setEnabled(true);
                jbAltaBaja.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAltaBaja;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JComboBox<String> jcbEspecialidad;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlDNI;
    private javax.swing.JLabel jlDatos;
    private javax.swing.JLabel jlEspecialidad;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlLista;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbInactivo;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
