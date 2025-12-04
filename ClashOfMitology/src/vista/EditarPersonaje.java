package vista;

import controlador.PersonajeControlador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Personaje;

/**
 *
 * @author Joaquin & Cesar
 */
public class EditarPersonaje extends javax.swing.JInternalFrame {
    
    
    private final PersonajeControlador controlador = new PersonajeControlador();
    private Personaje personajeActual;
    
    public EditarPersonaje() {
        initComponents();
        cargarTablaPersonajes(); 
        configurarEventosTabla();
        setCamposEdicionEnabled(false);
    }
    private void cargarTablaPersonajes() {
        
        //Definimos el modelo de como se vera la tabla
        String[] columnas = {"ID", "NOMBRE", "CLASE"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            //Se agregan los personajes y se guardan en una lista
            List<Personaje> lista = controlador.listarTodosLosPersonajes();

            for (Personaje p : lista) {
                Object[] fila = {
                    p.getId(),
                    p.getNombre(),
                    p.getTipo() 
                };
                modelo.addRow(fila);
            }

            jtPersonajes.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la lista de personajes: " + e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarDatosSeleccionadosEnFormulario() {
        int filaSeleccionada = jtPersonajes.getSelectedRow();
        if (filaSeleccionada == -1) return;

        try {
            int id = (int) jtPersonajes.getValueAt(filaSeleccionada, 0); 
            personajeActual = controlador.buscarPersonajePorId(id);
            
            if (personajeActual != null) {
                txtID.setText(String.valueOf(personajeActual.getId()));
                txtNuevoNombre.setText(personajeActual.getNombre());
                cbTipoPersonaje.setSelectedItem(personajeActual.getTipo());
            } else {
                JOptionPane.showMessageDialog(this, "Personaje no encontrado en la BD.", "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar la selección: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            personajeActual = null;
        }
    }
    
    // este metodo hace que cuando uno seleccione la tabla se agregen los datos a los campos correspondientes a editar
    private void configurarEventosTabla() {
        jtPersonajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && jtPersonajes.getSelectedRow() != -1) {
                    cargarDatosSeleccionadosEnFormulario();
                    setCamposEdicionEnabled(true);
                }
            }
        });
    }   
    
    private void setCamposEdicionEnabled(boolean enabled) {
        txtNuevoNombre.setEnabled(enabled);
        cbTipoPersonaje.setEnabled(enabled);
        btnGuardarCambios.setEnabled(enabled);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardarCambios = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNuevoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipoPersonaje = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersonajes = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(624, 408));

        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar!");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese ID del personaje a editar:");

        jLabel2.setText("Nuevo Nombre");

        jLabel3.setText("Nueva Clase");

        cbTipoPersonaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Mago", "Arquero", "Sacerdote", "Asesino" }));
        cbTipoPersonaje.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoPersonajeItemStateChanged(evt);
            }
        });
        cbTipoPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPersonajeActionPerformed(evt);
            }
        });

        jtPersonajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtPersonajes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnGuardarCambios)
                        .addGap(117, 117, 117)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed

        if (personajeActual == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un personaje de la tabla para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nuevoNombre = txtNuevoNombre.getText().trim();
        String nuevoTipo = (String) cbTipoPersonaje.getSelectedItem();
        
        if (nuevoNombre.isEmpty() || nuevoTipo == null || nuevoTipo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar el nombre y seleccionar el tipo.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            personajeActual.setNombre(nuevoNombre);
            personajeActual.setTipo(nuevoTipo);           
            
            if (controlador.editarPersonaje(personajeActual)) { 
                
                JOptionPane.showMessageDialog(this, "¡Personaje '" + nuevoNombre + "' editado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTablaPersonajes(); 
                txtID.setText("");
                txtNuevoNombre.setText("");
                personajeActual = null;
                setCamposEdicionEnabled(false);
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar los cambios del personaje. Puede que el ID no exista o la BD falló.", "Fallo", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Error inesperado al editar: " + e.getMessage(), "Fallo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbTipoPersonajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPersonajeItemStateChanged

    }//GEN-LAST:event_cbTipoPersonajeItemStateChanged

    private void cbTipoPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonajeActionPerformed
    }//GEN-LAST:event_cbTipoPersonajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JComboBox<String> cbTipoPersonaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPersonajes;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNuevoNombre;
    // End of variables declaration//GEN-END:variables
}
