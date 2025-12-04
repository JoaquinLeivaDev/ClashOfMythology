package vista;

/**
 *
 * @author Kinidread
 */
public class Inicio extends javax.swing.JFrame {
 
    private java.awt.Image imagenFondo;
    
    public Inicio() {
        cargarImagenFondo();
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    private void cargarImagenFondo() {
    try {
        String rutaImagen = "/images/inicio.png";        
        javax.swing.ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource(rutaImagen));
        imagenFondo = icono.getImage();
        
    } catch (Exception e) {
        System.err.println("❌ Error al cargar la imagen de fondo: " + e.getMessage());
        imagenFondo = null;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 
                        0, 0, 
                        getWidth(), getHeight(), 
                        this);
                }
            }
        };
        jMenuBar = new javax.swing.JMenuBar();
        mOpciones = new javax.swing.JMenu();
        miCrearPersonaje = new javax.swing.JMenuItem();
        miEditarPersonaje = new javax.swing.JMenuItem();
        miBuscarPersonaje = new javax.swing.JMenuItem();
        miEliminarPersonaje = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clash Of Mythology");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        mOpciones.setText("Opciones");

        miCrearPersonaje.setText("Crear Personaje");
        miCrearPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCrearPersonajeActionPerformed(evt);
            }
        });
        mOpciones.add(miCrearPersonaje);

        miEditarPersonaje.setText("Editar Personaje");
        miEditarPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditarPersonajeActionPerformed(evt);
            }
        });
        mOpciones.add(miEditarPersonaje);

        miBuscarPersonaje.setText("Buscar Personaje");
        miBuscarPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarPersonajeActionPerformed(evt);
            }
        });
        mOpciones.add(miBuscarPersonaje);

        miEliminarPersonaje.setText("Eliminar Personaje");
        mOpciones.add(miEliminarPersonaje);

        jMenuBar.add(mOpciones);

        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });

        miSalir.setText("SALIR");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mSalir.add(miSalir);

        jMenuBar.add(mSalir);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCrearPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCrearPersonajeActionPerformed
        CrearPersonaje crearPersonaje = new CrearPersonaje();
        escritorio.add(crearPersonaje);
        crearPersonaje.setVisible(true);
        
        try {
        crearPersonaje.setMaximum(true);
        crearPersonaje.setSelected(true);
        crearPersonaje.setLocation( (escritorio.getWidth() - crearPersonaje.getWidth()) / 2, 
                                    (escritorio.getHeight() - crearPersonaje.getHeight()) / 2 );
    } catch (java.beans.PropertyVetoException e) {
    }
    }//GEN-LAST:event_miCrearPersonajeActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSalirActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

    private void miEditarPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditarPersonajeActionPerformed

            EditarPersonaje editarPersonaje = new EditarPersonaje(); 
            escritorio.add(editarPersonaje);
            editarPersonaje.setVisible(true);   
    }//GEN-LAST:event_miEditarPersonajeActionPerformed

    private void miBuscarPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarPersonajeActionPerformed

            BuscarPersonaje buscarPersonaje = new BuscarPersonaje();
            escritorio.add(buscarPersonaje);
            buscarPersonaje.setVisible(true);  
    }//GEN-LAST:event_miBuscarPersonajeActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu mOpciones;
    private javax.swing.JMenu mSalir;
    private javax.swing.JMenuItem miBuscarPersonaje;
    private javax.swing.JMenuItem miCrearPersonaje;
    private javax.swing.JMenuItem miEditarPersonaje;
    private javax.swing.JMenuItem miEliminarPersonaje;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables
}
