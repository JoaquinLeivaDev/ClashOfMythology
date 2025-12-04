package vista;
import controlador.PersonajeControlador;
import modelo.FabricaPersonajes;
import modelo.Personaje;

/**
 *
 * @author Joaquin & Cesar
 */
public class CrearPersonaje extends javax.swing.JInternalFrame {

    private final PersonajeControlador controlador = new PersonajeControlador();
    
    public CrearPersonaje() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblTipoPersonaje = new javax.swing.JLabel();
        lblCaracteristicas = new javax.swing.JLabel();
        btnIngresarPersonaje = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbTipoPersonaje = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCaracteristicas = new javax.swing.JList<>();
        lblImagenPersonaje = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(684, 559));

        lblNombre.setText("Nombre: ");

        lblTipoPersonaje.setText("Tipo de Personaje: ");

        lblCaracteristicas.setText("Caracteristicas: ");

        btnIngresarPersonaje.setText("Ingresar Personaje!");
        btnIngresarPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPersonajeActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar!");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

        jScrollPane1.setViewportView(listCaracteristicas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnIngresarPersonaje))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCaracteristicas)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoPersonaje)
                                    .addComponent(lblNombre))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(cbTipoPersonaje, 0, 140, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar)
                        .addContainerGap(225, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImagenPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoPersonaje)
                            .addComponent(cbTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(lblCaracteristicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblImagenPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarPersonaje)
                    .addComponent(btnCancelar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoPersonajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPersonajeItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        mostrarImagenSeleccionada();
        mostrarEstadisticas();
        }
    }//GEN-LAST:event_cbTipoPersonajeItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
   
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIngresarPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPersonajeActionPerformed

        String nombre = txtNombre.getText().trim();
        String tipo = (String) cbTipoPersonaje.getSelectedItem(); 

    if (nombre.isEmpty() || tipo == null || tipo.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe completar el nombre y seleccionar el tipo.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (controlador.guardarPersonaje(nombre, tipo)) {
        javax.swing.JOptionPane.showMessageDialog(this, "¡Personaje " + nombre + " creado con éxito!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar el personaje", "Fallo", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnIngresarPersonajeActionPerformed

    private void cbTipoPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoPersonajeActionPerformed


    private void mostrarEstadisticas() {
    String tipo = (String) cbTipoPersonaje.getSelectedItem();
    if (tipo == null) return;
    
    Personaje personaje = FabricaPersonajes.crearPorTipo(tipo, "TEMP");

    try {

        // Lista de características
        String[] stats = {
            "Salud: " + personaje.getSalud(),
            "Maná: " + personaje.getMana(),
            "Ataque: " + personaje.getAtaque(),
            "Defensa: " + personaje.getDefensa(),
            "Agilidad: " + personaje.getAgilidad()
        };

        listCaracteristicas.setListData(stats);

    } catch (Exception e) {
        listCaracteristicas.setListData(new String[]{"Error al cargar stats."});
        e.printStackTrace();
    }
}
    
    public void mostrarImagenSeleccionada(){
        String tipo = (String) cbTipoPersonaje.getSelectedItem();
        String rutaImagen = "";
        
        switch (tipo.toLowerCase()) {
        case "mago":
            rutaImagen = "/images/mago.png";
            break;
        case "asesino":
            rutaImagen = "/images/asesino.png";
            
            break;
        case "guerrero":
            rutaImagen = "/images/guerrero.png";
            break;
        case "sacerdote":
            rutaImagen = "/images/sacerdote.png";
            break;
        case "arquero":
            rutaImagen = "/images/arquero.png";
            break;
        default:
            rutaImagen = "/images/default.png";
            break;
        }
        try {
        java.net.URL url = getClass().getResource(rutaImagen);
        
        if (url != null) {
            javax.swing.ImageIcon icono = new javax.swing.ImageIcon(url);
            
            //escala de la imagen para que entre en el Label
            java.awt.Image imagen = icono.getImage();
            java.awt.Image imagenEscalada = imagen.getScaledInstance(
                lblImagenPersonaje.getWidth(), 
                lblImagenPersonaje.getHeight(), 
                java.awt.Image.SCALE_SMOOTH
            );
            
            lblImagenPersonaje.setIcon(new javax.swing.ImageIcon(imagenEscalada));
        } else {
            lblImagenPersonaje.setIcon(null);
            System.err.println("Imagen no encontrada: " + rutaImagen);
        }

        } catch (Exception e) {
            e.printStackTrace();
            lblImagenPersonaje.setIcon(null);
            }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresarPersonaje;
    private javax.swing.JComboBox<String> cbTipoPersonaje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCaracteristicas;
    private javax.swing.JLabel lblImagenPersonaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoPersonaje;
    private javax.swing.JList<String> listCaracteristicas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
