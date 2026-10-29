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

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(641, 366));

        jlDatos.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jlDatos.setText("Datos del Entrenador");

        jlDNI.setText("DNI:");

        jlNombre.setText("Nombre:");

        jlApellido.setText("Apellido:");

        jlEspecialidad.setText("Especialidad:");

        jrbActivo.setText("Activo");

        jrbInactivo.setText("Inactivo");
        jrbInactivo.addActionListener(this::jrbInactivoActionPerformed);

        jlLista.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jlLista.setText("Lista de Entrenadores");

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

        jcbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlEstado.setText("Estado:");

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(this::jbNuevoActionPerformed);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(this::jbGuardarActionPerformed);

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(this::jbActualizarActionPerformed);

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(this::jbEliminarActionPerformed);

        jbAltaBaja.setText("Alta/Baja");
        jbAltaBaja.addActionListener(this::jbAltaBajaActionPerformed);

        jbMostrar.setText("Mostrar Entrenadores");
        jbMostrar.addActionListener(this::jbMostrarActionPerformed);

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(this::jbBuscarActionPerformed);

        jDesktopPane1.setLayer(jlDatos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlEspecialidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jrbActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jrbInactivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlLista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbEspecialidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jlEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbActualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbAltaBaja, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbMostrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jlDatos))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlEspecialidad)
                                    .addComponent(jlApellido)
                                    .addComponent(jlDNI))
                                .addGap(6, 6, 6)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfDNI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jlEstado)
                                .addGap(18, 18, 18)
                                .addComponent(jrbActivo)
                                .addGap(18, 18, 18)
                                .addComponent(jrbInactivo))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jlLista)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAltaBaja)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatos)
                    .addComponent(jlLista))
                .addGap(33, 33, 33)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDNI))
                        .addGap(10, 10, 10)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNombre)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlApellido)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEspecialidad)
                            .addComponent(jcbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbActivo)
                            .addComponent(jrbInactivo)
                            .addComponent(jlEstado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar)
                    .addComponent(jbAltaBaja)
                    .addComponent(jbMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

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
