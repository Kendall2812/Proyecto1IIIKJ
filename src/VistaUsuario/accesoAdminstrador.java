/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class accesoAdminstrador extends javax.swing.JFrame {

    /**
     * Creates new form accesoAdminstrador
     */
    String Catalogo;
    public accesoAdminstrador() {
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Acceso Administrador");
        setLocationRelativeTo(null);
        //Desactiva las Opciones de Musica
        jrbRegistroDisco.setEnabled(false);
        jRbModificarDisco.setEnabled(false);
        //Desactiva las Opciones de Pelicula
        jrbRegistroPelicula.setEnabled(false);
        jRbModificarPelicula.setEnabled(false);
        //Desactiva el boton
        btnIr.setEnabled(false);
    }
    public void opcionCatalogo(){
        Catalogo = MenuCatalogos.getSelectedItem().toString();
        if (Catalogo.equals("Musica")) {
            //activa las Opciones de musica
            bG1CatalogoPeliculas.clearSelection();//limpia las opcion seleciona en pelicula
            //Desactiva las Opciones de Pelicula
            jrbRegistroDisco.setEnabled(true);
            jRbModificarDisco.setEnabled(true);
          
            //Desactiva las Opciones de Pelicula
            jrbRegistroPelicula.setEnabled(false);
            jRbModificarPelicula.setEnabled(false);
            btnIr.setEnabled(true);
                       
        } else if (Catalogo.equals("Peliculas")) {
            bG1CatalogoMusica.clearSelection();//limpia las opcion seleciona en musica
            //Desactiva las Opciones de Musica
            jrbRegistroDisco.setEnabled(false);
            jRbModificarDisco.setEnabled(false);
           
            //activa las Opciones de Pelicula
            jrbRegistroPelicula.setEnabled(true);
            jRbModificarPelicula.setEnabled(true);
            btnIr.setEnabled(true);
            
        }else if(Catalogo.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null, "Item no Valido");
            bG1CatalogoPeliculas.clearSelection();
            bG1CatalogoMusica.clearSelection();
        } 
        else {
            JOptionPane.showMessageDialog(null, "Error de Seleccion");
        }
    }
    public void opcionesMusica(){
       
        if(jrbRegistroDisco.isSelected()){
            registroDiscoMusica registroM = new registroDiscoMusica();
            registroM.setVisible(true);
            dispose();
                    
        }else if(jRbModificarDisco.isSelected()){
            verEditarInfoMusica editar = new verEditarInfoMusica();
            editar.setVisible(true);
            dispose();
            
        }
    }
    public void opcionesPeliculas(){
        
        if(jrbRegistroPelicula.isSelected()){
            registroPeliculas registroP = new registroPeliculas();
            registroP.setVisible(true);
            dispose();
            
        }else if(jRbModificarPelicula.isSelected()){
            verEditarInfoPeliculas editar = new verEditarInfoPeliculas();
            editar.setVisible(true);
            dispose();
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

        bG1CatalogoMusica = new javax.swing.ButtonGroup();
        bG1CatalogoPeliculas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        MenuCatalogos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jrbRegistroDisco = new javax.swing.JRadioButton();
        jRbModificarDisco = new javax.swing.JRadioButton();
        jrbRegistroPelicula = new javax.swing.JRadioButton();
        jRbModificarPelicula = new javax.swing.JRadioButton();
        btnIr = new javax.swing.JButton();
        btnCerrarCesión = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuDiscosMusica = new javax.swing.JMenuItem();
        menuPeliculas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Catalogos");

        MenuCatalogos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Musica", "Peliculas" }));
        MenuCatalogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCatalogosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Catalogo Musica");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Catalogo Peliculas");

        jrbRegistroDisco.setBackground(java.awt.Color.gray);
        bG1CatalogoMusica.add(jrbRegistroDisco);
        jrbRegistroDisco.setForeground(new java.awt.Color(255, 255, 255));
        jrbRegistroDisco.setText("Registrar Disco");

        jRbModificarDisco.setBackground(java.awt.Color.gray);
        bG1CatalogoMusica.add(jRbModificarDisco);
        jRbModificarDisco.setForeground(new java.awt.Color(255, 255, 255));
        jRbModificarDisco.setText("Modificar/Eliminar Disco");
        jRbModificarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbModificarDiscoActionPerformed(evt);
            }
        });

        jrbRegistroPelicula.setBackground(java.awt.Color.gray);
        bG1CatalogoPeliculas.add(jrbRegistroPelicula);
        jrbRegistroPelicula.setForeground(new java.awt.Color(255, 255, 255));
        jrbRegistroPelicula.setText("Registrar Pelicula");

        jRbModificarPelicula.setBackground(java.awt.Color.gray);
        bG1CatalogoPeliculas.add(jRbModificarPelicula);
        jRbModificarPelicula.setForeground(new java.awt.Color(255, 255, 255));
        jRbModificarPelicula.setText("Modificar/Eliminar Informacion");

        btnIr.setBackground(new java.awt.Color(51, 204, 0));
        btnIr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnIr.setForeground(new java.awt.Color(255, 255, 255));
        btnIr.setText("Ir");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        btnCerrarCesión.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarCesión.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCerrarCesión.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarCesión.setText("Cerrar Sesión");
        btnCerrarCesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCesiónActionPerformed(evt);
            }
        });

        jMenu1.setText("Reportes");

        jMenuItem3.setText("Reportes de Discos de Musica");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Reportes de Discos de Pelicula");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compras Usuarios");

        menuDiscosMusica.setText("Discos Musica");
        menuDiscosMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDiscosMusicaActionPerformed(evt);
            }
        });
        jMenu2.add(menuDiscosMusica);

        menuPeliculas.setText("Discos Peliculas");
        jMenu2.add(menuPeliculas);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Lista Pre Ordenes");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuCatalogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbRegistroDisco)
                            .addComponent(jLabel2)
                            .addComponent(jRbModificarDisco)
                            .addComponent(btnIr, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbRegistroPelicula)
                            .addComponent(jLabel3)
                            .addComponent(jRbModificarPelicula))))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrarCesión))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCerrarCesión)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuCatalogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbRegistroPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRbModificarPelicula))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbRegistroDisco)
                        .addGap(6, 6, 6)
                        .addComponent(jRbModificarDisco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnIr)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCatalogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCatalogosActionPerformed
        opcionCatalogo();
    }//GEN-LAST:event_MenuCatalogosActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
        opcionCatalogo();
        opcionesMusica();
        opcionesPeliculas();
    }//GEN-LAST:event_btnIrActionPerformed

    private void btnCerrarCesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCesiónActionPerformed
        loginAdminUsuario login = new loginAdminUsuario();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarCesiónActionPerformed

    private void jRbModificarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbModificarDiscoActionPerformed
        
    }//GEN-LAST:event_jRbModificarDiscoActionPerformed

    private void menuDiscosMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDiscosMusicaActionPerformed
       controlComprasUserMusica ver= new controlComprasUserMusica();
       ver.setVisible(true);
       dispose();
    }//GEN-LAST:event_menuDiscosMusicaActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        verPreOrdenes ver = new verPreOrdenes();
        ver.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

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
            java.util.logging.Logger.getLogger(accesoAdminstrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accesoAdminstrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accesoAdminstrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accesoAdminstrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accesoAdminstrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MenuCatalogos;
    private javax.swing.ButtonGroup bG1CatalogoMusica;
    private javax.swing.ButtonGroup bG1CatalogoPeliculas;
    private javax.swing.JButton btnCerrarCesión;
    private javax.swing.JButton btnIr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JRadioButton jRbModificarDisco;
    private javax.swing.JRadioButton jRbModificarPelicula;
    private javax.swing.JRadioButton jrbRegistroDisco;
    private javax.swing.JRadioButton jrbRegistroPelicula;
    private javax.swing.JMenuItem menuDiscosMusica;
    private javax.swing.JMenuItem menuPeliculas;
    // End of variables declaration//GEN-END:variables
}
