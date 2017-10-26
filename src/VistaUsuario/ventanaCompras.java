/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import NegocioVeficarDatos.verificarDatos;
import java.awt.Color;

/**
 *
 * @author Kendall
 */
public class ventanaCompras extends javax.swing.JFrame {

    /**
     * Creates new form ventanaCompras
     */
    int costoTotal = 0;
    String nombreUser;
    String preciofacturado,nombre,cantidad, verificar;
    public ventanaCompras() {
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana Compra");
    }
    
    public void registrarCompra(String nombre,String precio, int cantidadCompra, String nombreUsuario, String verifica){//String catalogo
       cantidad = String.valueOf(cantidadCompra);
       int costo = Integer.parseInt(precio);
       costoTotal = cantidadCompra* costo;
       preciofacturado = String.valueOf(costoTotal);
       txtNombreDisco.setText(nombre);
       txtPrecio.setText(preciofacturado);
       txtCantidadCompra.setText(cantidad);
       txtnombreUsuario.setText(nombreUsuario);
       verificar= verifica;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreDisco = new javax.swing.JTextField();
        txtCantidadCompra = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnConfirmarCompra = new javax.swing.JButton();
        btnCancelarCompra = new javax.swing.JButton();
        txtnombreUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre Disco");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Monto Total:");

        txtNombreDisco.setEditable(false);
        txtNombreDisco.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreDisco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtCantidadCompra.setEditable(false);
        txtCantidadCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidadCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnConfirmarCompra.setBackground(new java.awt.Color(51, 204, 0));
        btnConfirmarCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConfirmarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarCompra.setText("Confirmar Compra");
        btnConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCompraActionPerformed(evt);
            }
        });

        btnCancelarCompra.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelarCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCompra.setText("Cancelar Compra");
        btnCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompraActionPerformed(evt);
            }
        });

        txtnombreUsuario.setEditable(false);
        txtnombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtnombreUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Facturar a");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txtCantidadCompra)
                    .addComponent(txtNombreDisco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmarCompra)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnCancelarCompra)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCompraActionPerformed
        btnCancelarCompra.setEnabled(false);
        nombre = txtNombreDisco.getText();
        nombreUser = txtnombreUsuario.getText();
        String nombreuser = txtnombreUsuario.getText();
        verificarDatos confirmaCompra = new verificarDatos();
        confirmaCompra.controlCompras(nombre,preciofacturado,cantidad,nombreuser,verificar);

        btnCancelarCompra.setEnabled(true);
        txtNombreDisco.setText("");
        txtPrecio.setText("");
        txtCantidadCompra.setText("");
        txtnombreUsuario.setText("");
        vistaUsuario regresar = new vistaUsuario();
        regresar.setVisible(true);
        regresar.compraDiscosMusicaPeliculas(nombreUser, false,verificar);
        dispose();
        
    }//GEN-LAST:event_btnConfirmarCompraActionPerformed

    private void btnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompraActionPerformed
       nombreUser = txtnombreUsuario.getText();
       txtNombreDisco.setText("");
       txtPrecio.setText("");
       txtCantidadCompra.setText("");
       txtnombreUsuario.setText("");
       btnConfirmarCompra.setEnabled(false);
       vistaUsuario regresar = new vistaUsuario();
       regresar.setVisible(true);
       regresar.compraDiscosMusicaPeliculas(nombreUser, false,verificar);
       dispose();
    }//GEN-LAST:event_btnCancelarCompraActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCompra;
    private javax.swing.JButton btnConfirmarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCantidadCompra;
    private javax.swing.JTextField txtNombreDisco;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtnombreUsuario;
    // End of variables declaration//GEN-END:variables
}
