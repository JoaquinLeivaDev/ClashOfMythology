
package vista;

import controlador.PersonajeControlador;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Personaje;

/**
 *
 * @author Joaquín & Cesar
 */
public class BuscarPersonaje extends javax.swing.JInternalFrame {

    private final PersonajeControlador controlador;
    private final DefaultListModel<String> listaModelo;
    
    
    public BuscarPersonaje() {
        controlador = new PersonajeControlador();
        listaModelo = new DefaultListModel<>();
        initComponents();
        listBuscarPersonajes.setModel(listaModelo);
        inicializarComponentes();
        cargarTodosLosPersonajesInicialmente();
    }
    
    private void inicializarComponentes() {
        
        String[] items = {"Todos", "Guerrero", "Mago", "Arquero", "Sacerdote", "Asesino"};
        cbTipoPersonaje.setModel(new javax.swing.DefaultComboBoxModel<>(items));
        cbTipoPersonaje.setSelectedItem("Todos");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listBuscarPersonajes = new javax.swing.JList<>();
        txtBuscarId = new javax.swing.JTextField();
        lBuscarPorId = new javax.swing.JLabel();
        lBuscarPorTipo = new javax.swing.JLabel();
        lBuscarPorNombre = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbTipoPersonaje = new javax.swing.JComboBox<>();
        btnEliminarId = new javax.swing.JButton();
        btnEliminarNombre = new javax.swing.JButton();
        btnEliminarTipo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listBuscarPersonajes);

        lBuscarPorId.setText("Buscar por ID: ");

        lBuscarPorTipo.setText("Buscar por TIPO: ");

        lBuscarPorNombre.setText("Buscar por NOMBRE:");

        btnBuscar.setText("BUSCAR!");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbTipoPersonaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Guerrero", "Mago", "Arquero", "Sacerdote", "Asesino" }));
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

        btnEliminarId.setText("Eliminar");
        btnEliminarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIdActionPerformed(evt);
            }
        });

        btnEliminarNombre.setText("Eliminar");
        btnEliminarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarNombreActionPerformed(evt);
            }
        });

        btnEliminarTipo.setText("Eliminar");
        btnEliminarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lBuscarPorId)
                            .addComponent(lBuscarPorTipo)
                            .addComponent(lBuscarPorNombre))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscarId)
                            .addComponent(txtBuscarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(cbTipoPersonaje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarId)
                            .addComponent(btnEliminarNombre)
                            .addComponent(btnEliminarTipo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBuscarPorId)
                    .addComponent(txtBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarId))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBuscarPorTipo)
                    .addComponent(cbTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarTipo))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBuscarPorNombre)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarNombre))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoPersonajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPersonajeItemStateChanged
    }//GEN-LAST:event_cbTipoPersonajeItemStateChanged

    private void cbTipoPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonajeActionPerformed
    }//GEN-LAST:event_cbTipoPersonajeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void mostrarResultados(List<Personaje> lista) {
        
        listaModelo.addElement(String.format("========================================================================================="));
        listaModelo.addElement(String.format("%-5s | %-15s | %-10s | %-8s | %-8s | %-8s | %-8s", 
                "ID", "NOMBRE", "CLASE", "SALUD", "MANA", "ATAQUE", "DEFENSA"));
        listaModelo.addElement(String.format("========================================================================================="));

        for (Personaje p : lista) {
            String linea = String.format("%-5d | %-15s | %-10s | %-8d | %-8d | %-8d | %-8d",
                    p.getId(), p.getNombre(), p.getTipo(), p.getSalud(), p.getMana(), p.getAtaque(), p.getDefensa());
            listaModelo.addElement(linea);
        }
    }
    
    private void cargarTodosLosPersonajesInicialmente() {
        try {
            List<Personaje> resultados = controlador.buscarPersonajes("", "Todos", "");

            if (resultados.isEmpty()) {
                listaModelo.addElement("Base de datos cargada. No hay personajes registrados.");
            } else {
                mostrarResultados(resultados);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la lista inicial: " + e.getMessage(), "Error de Conexión/BD", JOptionPane.ERROR_MESSAGE);
            listaModelo.addElement("ERROR: Fallo al conectar o cargar datos.");
        }
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      
        String id = txtBuscarId.getText().trim();
        String tipo = cbTipoPersonaje.getSelectedItem().toString();
        String nombre = txtBuscarNombre.getText().trim();
        
        listaModelo.clear(); 
        
        try {
            List<Personaje> resultados = controlador.buscarPersonajes(id, tipo, nombre);
            
            if (resultados.isEmpty()) {
                listaModelo.addElement("Búsqueda completada. No se encontraron personajes.");
            } else {
                mostrarResultados(resultados);
            }

        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            listaModelo.addElement("Error: ID inválido.");
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al ejecutar la búsqueda: " + e.getMessage(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            listaModelo.addElement("Error: Fallo en la conexión o la consulta.");
        }
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIdActionPerformed

        String idTexto = txtBuscarId.getText().trim();
    
    if (!idTexto.isEmpty()) {
        try {
            int id = Integer.parseInt(idTexto);
            if(controlador.eliminarPersonajePorId(id)) {
                JOptionPane.showMessageDialog(this, "Personaje Eliminado");
                cargarTodosLosPersonajesInicialmente(); 
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el personaje o el ID no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnEliminarIdActionPerformed

    private void btnEliminarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarNombreActionPerformed
        
        String nombreTexto = txtBuscarNombre.getText().trim();
        
        if (!nombreTexto.isEmpty()) {
            String nombre = nombreTexto;
            if(controlador.eliminarPersonajePorNombre(nombre)) {
                JOptionPane.showMessageDialog(this, "Personaje(s) Eliminado(s) por Nombre.");
                cargarTodosLosPersonajesInicialmente();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el personaje o el nombre no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
             JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarNombreActionPerformed

    private void btnEliminarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTipoActionPerformed

        String tipoTexto = cbTipoPersonaje.getSelectedItem().toString();
        
        if (!tipoTexto.isEmpty()) {
            String tipo = tipoTexto;
            
            if(tipo.equalsIgnoreCase("Todos")){
                int r = JOptionPane.showConfirmDialog(
                        this,
                        "¿Seguro que quieres eliminar a TODOS los personajes? Esta acción es irreversible.", 
                        "Confirmación de Eliminación Masiva",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (r == JOptionPane.YES_OPTION) {
                    try {
                        controlador.eliminarTodosLosPersonajes(); 
                        JOptionPane.showMessageDialog(this, "Todos los personajes fueron eliminados.");
                        cargarTodosLosPersonajesInicialmente();
                    } catch (SQLException ex) {
                        Logger.getLogger(BuscarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "Error de SQL al eliminar todos los personajes: " + ex.getMessage(), "Fallo Crítico", JOptionPane.ERROR_MESSAGE);
                    }
                }
                return;
            }
            if(controlador.eliminarPersonajePorTipo(tipo)) {
                JOptionPane.showMessageDialog(this, "Personajes de tipo '" + tipo + "' Eliminados.");
                cargarTodosLosPersonajesInicialmente();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar los personajes de tipo '" + tipo + "' o no existen.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarTipoActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPersonaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarId;
    private javax.swing.JButton btnEliminarNombre;
    private javax.swing.JButton btnEliminarTipo;
    private javax.swing.JComboBox<String> cbTipoPersonaje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lBuscarPorId;
    private javax.swing.JLabel lBuscarPorNombre;
    private javax.swing.JLabel lBuscarPorTipo;
    private javax.swing.JList<String> listBuscarPersonajes;
    private javax.swing.JTextField txtBuscarId;
    private javax.swing.JTextField txtBuscarNombre;
    // End of variables declaration//GEN-END:variables
}
