/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import NegocioVeficarDatos.verificarDatos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class verEditarInfoMusica extends javax.swing.JFrame {

    /**
     * Creates new form verEditarInfoMusica
     */
    String nombre, nombreDisco;
    String nombred, autor, categoria, precio, disponibles, cancion1, cancion2;
    int precio1 = 0, disponible1 = 0;
    ArrayList datosDisco = new ArrayList();
    boolean valor = false;

    public verEditarInfoMusica() {
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Vista de Datos y Edicion");
        this.setBounds(0, 0, 700, 410);
        setLocationRelativeTo(null);
        editarMusica();
    }

    public void editarMusica() {

        verificarDatos datosMusica = new verificarDatos();
        datosDisco = datosMusica.editarMusica();
        datos();
    }

    public void datos() {
        jCb1NombreDiscos.addItem("Seleccionar");
        for (int x = 0; x < datosDisco.size(); x = x + 8) {
            nombre = (String) datosDisco.get(x);
            jCb1NombreDiscos.addItem(nombre);
        }
    }

    public void VerInformacion() {
        nombreDisco = jCb1NombreDiscos.getSelectedItem().toString();
        btnGuardar.setEnabled(false);
        for (int y = 0; y < datosDisco.size(); y = y + 8) {
            if (datosDisco.get(y).equals(nombreDisco)) {
                txtNombre.setText(datosDisco.get(y).toString());
                txtAutor.setText(datosDisco.get(y + 1).toString());
                txtCategoria.setText(datosDisco.get(y + 2).toString());
                txtPrecio.setText(datosDisco.get(y + 3).toString());
                txtDisponibles.setText(datosDisco.get(y + 4).toString());
                txtCancion1.setText(datosDisco.get(y + 5).toString());
                txtCancion2.setText(datosDisco.get(y + 6).toString());
                txtNombre.setEditable(false);
                txtAutor.setEditable(false);
                txtCategoria.setEditable(false);
                txtPrecio.setEditable(false);
                txtDisponibles.setEditable(false);
                txtCancion1.setEditable(false);
                txtCancion2.setEditable(false);
                break;
            } else if (nombreDisco.equals("Seleccionar")) {
                txtNombre.setText("");
                txtAutor.setText("");
                txtCategoria.setText("");
                txtPrecio.setText("");
                txtDisponibles.setText("");
                txtCancion1.setText("");
                txtCancion2.setText("");
            }
        }
    }

    public void editarInformacion() {
        nombred = txtNombre.getText();
        autor = txtAutor.getText();
        categoria = txtCategoria.getText();
        precio = txtPrecio.getText();
        disponibles = txtDisponibles.getText();
        cancion1 = txtCancion1.getText();
        cancion2 = txtCancion2.getText();
        if (nombred.equals("") || autor.equals("") || categoria.equals("") || precio.equals("") || disponibles.equals("") || cancion1.equals("") || cancion2.equals("")) {
            JOptionPane.showMessageDialog(null, "No puede dejar ningun espacio en blanco");
        }
        if (categoria.equals("Merengue") || categoria.equals("Clasica") || categoria.equals("Salsa") || categoria.equals("PasoDoble") || categoria.equals("Cumbia")) {
            try {
                precio1 = Integer.parseInt(precio);
                disponible1 = Integer.parseInt(disponibles);

                for (int x = 0; x < datosDisco.size(); x = x + 8) {
                    if (datosDisco.get(x).equals(nombreDisco)) {
                        int y = datosDisco.indexOf(nombreDisco);
                        int cont = 0;
                        while (cont != 8) {
                            datosDisco.remove(y);
                            cont++;
                        }

                        datosDisco.add(nombred);
                        datosDisco.add(autor);
                        datosDisco.add(categoria);
                        datosDisco.add(precio1);
                        datosDisco.add(disponible1);
                        datosDisco.add(cancion1);
                        datosDisco.add(cancion2);
                        datosDisco.add("*");
                        verificarDatos editar = new verificarDatos();
                        editar.guardarMusicaEdidata(datosDisco);

                        txtNombre.setEditable(false);
                        txtAutor.setEditable(false);
                        txtCategoria.setEditable(false);
                        txtPrecio.setEditable(false);
                        txtDisponibles.setEditable(false);
                        txtCancion1.setEditable(false);
                        txtCancion2.setEditable(false);
                        btnGuardar.setEnabled(false);
                        break;
                    }
                }
            }catch(Exception e){
                btnGuardar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "El espacio es de valor numerico. " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esa Genero de musica no se encuentra registrado");
        }
        
        if (btnGuardar.isEnabled() == true) {
            verificarNombreCancion();
        } else if (btnGuardar.isEnabled() == false) {
            btnGuardar.setEnabled(false);
        }
    }

    public void eliminarDiscoMusica() {
        nombreDisco = jCb1NombreDiscos.getSelectedItem().toString();
        if (nombreDisco.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Primero debe Seleccionar el nombre de un disco para que lo pueda eliminar");
        } else if (!nombreDisco.equals("en vivo") & !nombreDisco.equals("guayacan")
                & !nombreDisco.equals("azul vivo") & !nombreDisco.equals("saturday night Fever")
                & !nombreDisco.equals("noches de fantasia")) {
            for (int x = 0; x < datosDisco.size(); x = x + 8) {
                if (datosDisco.get(x).equals(nombreDisco)) {

                    int y = datosDisco.indexOf(nombreDisco);
                    int cont = 0;
                    while (cont != 8) {
                        datosDisco.remove(y);
                        cont++;
                    }
                    verificarDatos editar = new verificarDatos();
                    editar.eliminarDisco(datosDisco);
                    jCb1NombreDiscos.removeItem(nombreDisco);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este disco no se puede eliminar");
        }
    }
    public void verificarNombreCancion(){
        if (nombreDisco.equals("en vivo") || nombreDisco.equals("guayacan")
                || nombreDisco.equals("azul vivo") || nombreDisco.equals("saturday night Fever")
                || nombreDisco.equals("noches de fantasia")) {
            txtNombre.setEditable(false);
            txtAutor.setEditable(false);
            txtCategoria.setEditable(false);
            txtPrecio.setEditable(true);
            txtDisponibles.setEditable(true);
            txtCancion1.setEditable(false);
            txtCancion2.setEditable(false);
        } else {

            txtNombre.setEditable(true);
            txtAutor.setEditable(true);
            txtCategoria.setEditable(true);
            txtPrecio.setEditable(true);
            txtDisponibles.setEditable(true);
            txtCancion1.setEditable(true);
            txtCancion2.setEditable(true);
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

        jLabel1 = new javax.swing.JLabel();
        jCb1NombreDiscos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCancion2 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDisponibles = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCancion1 = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre Disco");

        jCb1NombreDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCb1NombreDiscosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Canción 2");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre Disco");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Autor");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio");

        txtCancion2.setEditable(false);
        txtCancion2.setBackground(new java.awt.Color(255, 255, 255));
        txtCancion2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCancion2.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtCategoria.setEditable(false);
        txtCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCategoria.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Disponibles");

        txtDisponibles.setEditable(false);
        txtDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        txtDisponibles.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDisponibles.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Canción 1");

        txtCancion1.setEditable(false);
        txtCancion1.setBackground(new java.awt.Color(255, 255, 255));
        txtCancion1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCancion1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtAutor.setEditable(false);
        txtAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtAutor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAutor.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btnEditar.setBackground(new java.awt.Color(51, 204, 0));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 204, 0));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(51, 204, 0));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCb1NombreDiscos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCancion2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtCancion1))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar))
                    .addComponent(jCb1NombreDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCancion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCancion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar)
                    .addComponent(btnEditar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnGuardar.setEnabled(true);
        verificarNombreCancion();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        editarInformacion();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed

    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        accesoAdminstrador regresar = new accesoAdminstrador();
        regresar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarDiscoMusica();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jCb1NombreDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCb1NombreDiscosActionPerformed
        VerInformacion();
    }//GEN-LAST:event_jCb1NombreDiscosActionPerformed

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
            java.util.logging.Logger.getLogger(verEditarInfoMusica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verEditarInfoMusica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verEditarInfoMusica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verEditarInfoMusica.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verEditarInfoMusica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jCb1NombreDiscos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCancion1;
    private javax.swing.JTextField txtCancion2;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDisponibles;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
