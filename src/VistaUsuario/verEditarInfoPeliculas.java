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
public class verEditarInfoPeliculas extends javax.swing.JFrame {

    /**
     * Creates new form verEditarInfoPeliculas
     */
    String nombre, nombrePelicula,nombreMovie;
    String nombreP,autor,categoria,precio,cantidad;
    ArrayList editarPelicula = new ArrayList();
    public verEditarInfoPeliculas() {
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setTitle("Vista de Datos y Edicion");
        this.setBounds(0, 0,600, 330);
        setLocationRelativeTo(null);
        editarPeliculas();
    }
    public void editarPeliculas(){
        verificarDatos datosPelicula = new verificarDatos();
        editarPelicula = datosPelicula.eidtarPeliculas();
        optionComboBox();
    }
    public void optionComboBox(){
        jcbNombrePeliculas.addItem("Seleccionar");
        for(int x = 0; x < editarPelicula.size(); x = x + 6){
            nombre = (String) editarPelicula.get(x);
            jcbNombrePeliculas.addItem(nombre);
        }
    }
    public void mostrarInfoPelicula(){
        nombrePelicula = jcbNombrePeliculas.getSelectedItem().toString();
        
        for(int y = 0; y < editarPelicula.size(); y = y + 6){
            if(editarPelicula.get(y).equals(nombrePelicula)){
                txtNombre.setText(editarPelicula.get(y).toString());
                txtAutor.setText(editarPelicula.get(y + 1).toString());
                txtCategoria.setText(editarPelicula.get(y + 2).toString());
                txtPrecio.setText(editarPelicula.get(y + 3).toString());
                txtCantidad.setText(editarPelicula.get(y + 4).toString());
                break;
            }
            else if(nombrePelicula.equals("Seleccionar")){
                txtNombre.setText("");
                txtAutor.setText("");
                txtCategoria.setText("");
                txtPrecio.setText("");
                txtCantidad.setText("");
            }
        }
    }
    public void editarInfoPelicula(){
        //Comedia,Terror,Romantias,Accion,Suspenso
        nombreP = txtNombre.getText();
        autor = txtAutor.getText();
        categoria = txtCategoria.getText();
        precio = txtPrecio.getText();
        cantidad = txtCantidad.getText();
        if (nombreP.equals("") || autor.equals("") || categoria.equals("") || precio.equals("") || cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "No puede dejar ningun espacio en blanco");
        }else{
           if (categoria.equals("Comedia") || categoria.equals("Terror") || categoria.equals("Romantias") || categoria.equals("Accion") || categoria.equals("Suspenso")) {
                for (int x = 0; x < editarPelicula.size(); x = x + 6) {
                    if (editarPelicula.get(x).equals(nombrePelicula)) {
                        int Y = editarPelicula.indexOf(nombrePelicula);
                        int cont = 0;
                        while (cont != 6) {
                            editarPelicula.remove(Y);
                            cont++;
                        }
                        editarPelicula.add(nombreP);
                        editarPelicula.add(autor);
                        editarPelicula.add(categoria);
                        editarPelicula.add(precio);
                        editarPelicula.add(cantidad);
                        editarPelicula.add("*");

                        verificarDatos editar = new verificarDatos();
                        editar.guardarPeliculaEditada(editarPelicula);
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esa Genero de pelicula no se encuentra registrado");
            } 
        }
        txtNombre.setEditable(false);
        txtAutor.setEditable(false);
        txtCategoria.setEditable(false);
        txtPrecio.setEditable(false);
        txtCantidad.setEditable(false);
        btnGuardar.setEnabled(false);
    }
    public void eliminarInfoMovie(){
        nombreMovie = jcbNombrePeliculas.getSelectedItem().toString();
        if (nombreMovie.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Primero debe Seleccionar el nombre de una pelicula para que la pueda eliminar");
        }else{
            for (int x = 0; x < editarPelicula.size(); x = x + 6) {
                if (editarPelicula.get(x).equals(nombreMovie)) {

                    int y = editarPelicula.indexOf(nombreMovie);
                    int cont = 0;
                    while (cont != 6) {
                        editarPelicula.remove(y);
                        cont++;
                    }
                    verificarDatos eliminar = new verificarDatos();
                    eliminar.eliminarPelicula(editarPelicula);
                    jcbNombrePeliculas.removeItem(nombreMovie);
                    break;
                }
            }
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
        btnEditar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegrresar = new javax.swing.JButton();
        jcbNombrePeliculas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de Pelicula");

        btnEditar.setBackground(new java.awt.Color(51, 204, 0));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Autor");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Categoria");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        txtAutor.setEditable(false);
        txtAutor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAutor.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        txtCategoria.setEditable(false);
        txtCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCategoria.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecio.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        txtCantidad.setEditable(false);
        txtCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCantidad.setDisabledTextColor(new java.awt.Color(255, 255, 255));

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

        btnEliminar.setBackground(new java.awt.Color(51, 204, 0));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegrresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegrresar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegrresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegrresar.setText("Regresar");
        btnRegrresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegrresarActionPerformed(evt);
            }
        });

        jcbNombrePeliculas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbNombrePeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNombrePeliculasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbNombrePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(txtAutor)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCantidad)
                                            .addComponent(txtPrecio)))))
                            .addComponent(btnEditar))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegrresar)
                            .addComponent(btnGuardar)
                            .addComponent(btnEliminar)))
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbNombrePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnRegrresar))
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbNombrePeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNombrePeliculasActionPerformed
        mostrarInfoPelicula();
    }//GEN-LAST:event_jcbNombrePeliculasActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtNombre.setEditable(true);
        txtAutor.setEditable(true);
        txtCategoria.setEditable(true);
        txtPrecio.setEditable(true);
        txtCantidad.setEditable(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        editarInfoPelicula();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegrresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegrresarActionPerformed
        accesoAdminstrador regresar = new accesoAdminstrador();
        regresar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegrresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarInfoMovie();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(verEditarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verEditarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verEditarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verEditarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verEditarInfoPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegrresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jcbNombrePeliculas;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
