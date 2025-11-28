package vista;

import controlador.PersonajeControlador;

/**
 *
 * @author Kinidread
 */
public class EditarPersonaje extends javax.swing.JInternalFrame {
    private final PersonajeControlador controlador = new PersonajeControlador();
    
    public EditarPersonaje() {
        initComponents();
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

        jLabel1.setText("Ingrese ID del personaje");

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
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID)
                            .addComponent(txtNuevoNombre)
                            .addComponent(cbTipoPersonaje, 0, 153, Short.MAX_VALUE))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
        String nombre = txtNuevoNombre.getText().trim();
        String nuevoTipo = (String) cbTipoPersonaje.getSelectedItem();
        int idPersonajeAEditar = Integer.parseInt(txtID.getText().trim());
        
        if (nombre.isEmpty() || nuevoTipo == null || nuevoTipo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe completar el nombre y seleccionar el tipo.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Usamos una clase concreta (Mago) para poder instanciar, ya que Personaje es abstracta
        modelo.Personaje personajeEditado = new modelo.Mago(nombre); 
        
        personajeEditado.setId(idPersonajeAEditar); 
        personajeEditado.setNombre(nombre);         
        personajeEditado.setTipo(nuevoTipo);        
        
        if (controlador.editarPersonaje(personajeEditado)) { 
            
            javax.swing.JOptionPane.showMessageDialog(this, "¡Personaje '" + nombre + "' editado con éxito!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose(); 
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar los cambios del personaje. Revise los logs.", "Fallo", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbTipoPersonajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPersonajeItemStateChanged

    }//GEN-LAST:event_cbTipoPersonajeItemStateChanged

    private void cbTipoPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoPersonajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JComboBox<String> cbTipoPersonaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNuevoNombre;
    // End of variables declaration//GEN-END:variables
}
