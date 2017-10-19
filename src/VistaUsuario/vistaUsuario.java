/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import NegocioVeficarDatos.verificarDatos;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jenni
 */
public class vistaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form vistaUsuario
     */
    ArrayList nombreUser = new ArrayList();
    URL urlArchivoMusica;
    Player reproductor;
    String direccion = "";
    int precio1;
    int cantidad;
    int canti;
    String nombreUsuario;
    boolean bus;

    public vistaUsuario() {
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setTitle("Vista Usuario");
//        ComboxCateg.setEnabled(false);
        nombre.setEnabled(false);
        autor.setEnabled(false);
        precio.setEnabled(false);
        txtSeleccion.setEditable(false);
        btnBuscar.setEnabled(false);
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "", "", "", "", ""
                }
        ));

    }

    public void filtroBusqueda() throws NoPlayerException, CannotRealizeException {
        String selec = txtSeleccion.getText();
        String genero = ComboxCateg.getSelectedItem().toString();
        if (nombre.isSelected()) {
            String bus = "nom";
            valida(genero, selec, bus);
        } else if (autor.isSelected()) {
            String bus = "aut";
            valida(genero, selec, bus);
        }
    }

    public void valida(String genero, String dato, String bus) throws NoPlayerException, CannotRealizeException {
        DefaultTableModel tempo = (DefaultTableModel) table.getModel();;
        String temp = "";
        try {
            try (BufferedReader bf = new BufferedReader(new FileReader("archivoDiscosMusica.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(",");
                    if (bus.equals("nom")) {
                        if (lista1[2].equals(genero) && (lista1[5].equals(dato) || lista1[6].equals(dato))) {
                            tempo.setRowCount(0);
                            Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4], lista1[5], lista1[6]};
                            tempo.addRow(nuevo);
                            if (lista1[5].equals("Stayin Alive") || lista1[6].equals("Stayin Alive")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/Stayin-Alive.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("pasodobles") || lista1[6].equals("pasodobles")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/Pasodobles.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("como te voy a olvidar") || lista1[6].equals("como te voy a olvidar")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/como_te_voy_a_olvidar.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("lloraras") || lista1[6].equals("lloraras")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/lloraras.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("noche de fantasia") || lista1[6].equals("noche de fantasia")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/noche_de_fantasia.wav";
                                reproducirMusica(direccion);
                            }
                        }
                    } else if (bus.equals("aut")) {
                        if (lista1[1].equals(dato) & lista1[2].equals(genero)) {
                            tempo.setRowCount(0);
                            Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4], lista1[5], lista1[6]};
                            tempo.addRow(nuevo);
                            if (lista1[5].equals("stayin alive") || lista1[6].equals("stayin alive")) {
                                direccion = "src/canciones/Stayin-Alive.wav";//src\canciones
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("pasodobles") || lista1[6].equals("pasodobles")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/Pasodobles.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("como te voy a olvidar") || lista1[6].equals("como te voy a olvidar")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/como_te_voy_a_olvidar.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("lloraras") || lista1[6].equals("lloraras")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/lloraras.wav";
                                reproducirMusica(direccion);
                            } else if (lista1[5].equals("noche de fantasia") || lista1[6].equals("noche de fantasia")) {
                                direccion = "file:/C:/Users/jenni/Documents/GitHub/Proyecto1IIIKJ/src/canciones/noche_de_fantasia.wav";
                                reproducirMusica(direccion);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo" + e);
        }
    }

    public void reproducirMusica(String direccion) throws NoPlayerException, CannotRealizeException {
        try {
            urlArchivoMusica = new URL(direccion);

            reproductor = Manager.createRealizedPlayer(urlArchivoMusica);

            Component controles = reproductor.getControlPanelComponent();
            if (controles != null) {
                this.add(controles);
                controles.setLocation(50, 400);
                controles.setSize(150, 25);
            }
//            reproductor.start();
        } catch (IOException e) {
            System.out.println("Se encontro un error" + e);
        }
    }

    public void compraDiscosMusicaPeliculas(String nombreU, boolean valor) {
        nombreUser.add(nombreU);
        int row = 0;
        String numero;
        TableModel tablaModelo;
        tablaModelo = (TableModel) table.getModel();
        row = table.getSelectedRow();
        numero = String.valueOf(row);
        try {
            try {
                if (valor == false) {
                    System.out.println("hola");
                } else {

                    if (numero.equals("-1")) {//validad que se aya seleccionado una cancion en el Jtable
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un disco y la cantidad que desea comprar");
                        //falta ver como hacer para que se solicite la pre orden
                    } else {

                        String cantidadDisponible = tablaModelo.getValueAt(row, 4).toString();//obtiene la cantidad de los dicos disponibles
                        int disponible = Integer.parseInt(cantidadDisponible);//transforma la variable "cantidadDisponible" a Integer
                        canti = Integer.parseInt(txtCantidad.getText());

                        if (disponible == 0) {
                            JOptionPane.showMessageDialog(null, "En este momento se encuntra agotado");//verifica que si la cantidad del disco este en 0
                        } else if (canti > disponible) {
                            JOptionPane.showMessageDialog(null, "Esa cantidad no se encuentra disponible"); //verifica que la cantidad que se digito no sea mayor a la que esta en el archivo
                            txtCantidad.setText("");
                        } else if (canti == 0) {
                            JOptionPane.showMessageDialog(null, "La compra no puede ser 0 discos tiene que ser por lo menos 1 disco");
                        } else if (canti <= disponible) { //validad que la cantidad que se digito sea menor o igual a la wue se encuentra en el archivo
                            String User = (String) nombreUser.get(0);
                            String strResultado = tablaModelo.getValueAt(row, 0).toString();
                            String Precio = tablaModelo.getValueAt(row, 3).toString();

                            ventanaCompras compra = new ventanaCompras(); //llama ventana compra
                            compra.registrarCompra(strResultado, Precio, canti, User);
                            compra.setVisible(true);
                            dispose();
                        }
                    }
                }
            } catch (java.lang.NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Debe colocar la cantidad que desea comprar");
            }
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar la cantidad que desea comprar");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        ComboxCateg = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        nombre = new javax.swing.JRadioButton();
        autor = new javax.swing.JRadioButton();
        precio = new javax.swing.JRadioButton();
        txtSeleccion = new javax.swing.JTextField();
        btnCompra = new javax.swing.JButton();
        btnPrecompra = new javax.swing.JButton();
        btnCerrarCesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        menuItemMusica = new javax.swing.JMenuItem();
        menuItemPeliculas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComboxCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboxCategActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione la categoria:");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del disco", "Autor", "Categoria", "Precio", "Cantidad", "Cancion 1", "Cancion 2"
            }
        ));
        jScrollPane1.setViewportView(table);

        nombre.setBackground(java.awt.Color.gray);
        buttonGroup1.add(nombre);
        nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Nombre de la cancion");

        autor.setBackground(java.awt.Color.gray);
        buttonGroup1.add(autor);
        autor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        autor.setForeground(new java.awt.Color(255, 255, 255));
        autor.setText("Autor");

        precio.setBackground(java.awt.Color.gray);
        buttonGroup1.add(precio);
        precio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        precio.setForeground(new java.awt.Color(255, 255, 255));
        precio.setText("Precio");

        btnCompra.setBackground(new java.awt.Color(51, 204, 0));
        btnCompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCompra.setText("COMPRAR");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnPrecompra.setBackground(new java.awt.Color(51, 204, 0));
        btnPrecompra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnPrecompra.setForeground(new java.awt.Color(255, 255, 255));
        btnPrecompra.setText("PRE-ORDENAR");

        btnCerrarCesion.setBackground(new java.awt.Color(255, 0, 51));
        btnCerrarCesion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCerrarCesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarCesion.setText("Cerrar Sesión");
        btnCerrarCesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCesionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad de compra:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Monto Total:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        menuOpciones.setText("Opciones");

        menuItemMusica.setText("MUSICA");
        menuItemMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMusicaActionPerformed(evt);
            }
        });
        menuOpciones.add(menuItemMusica);

        menuItemPeliculas.setText("PELICULAS");
        menuItemPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPeliculasActionPerformed(evt);
            }
        });
        menuOpciones.add(menuItemPeliculas);

        jMenuBar2.add(menuOpciones);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(autor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(precio)
                                .addGap(104, 104, 104)
                                .addComponent(btnCompra)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnPrecompra))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ComboxCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarCesion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addComponent(btnCerrarCesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboxCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre)
                            .addComponent(txtSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autor)
                        .addGap(7, 7, 7)
                        .addComponent(precio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompra)
                    .addComponent(btnPrecompra))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCesionActionPerformed
        loginAdminUsuario login = new loginAdminUsuario();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarCesionActionPerformed

    private void ComboxCategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboxCategActionPerformed
        DefaultTableModel tempo = (DefaultTableModel) table.getModel();
        tempo.setRowCount(0);
        TableModel tabla = table.getModel();
        if (ComboxCateg.getSelectedIndex()!= -1){
            String texto = ComboxCateg.getSelectedItem().toString();
        verificarDatos verificar = new verificarDatos();
        verificar.buscarArchivo(texto, (DefaultTableModel) tabla,bus);
        nombre.setEnabled(true);
        autor.setEnabled(true);
        precio.setEnabled(true);
        txtSeleccion.setEditable(true);
        btnBuscar.setEnabled(true);
        }
    }//GEN-LAST:event_ComboxCategActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            filtroBusqueda();
        } catch (NoPlayerException ex) {
            Logger.getLogger(vistaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(vistaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void menuItemMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMusicaActionPerformed
        bus= true;
//        ComboxCateg.setEnabled(true);
        ComboxCateg.removeAllItems();
        ComboxCateg.addItem("Merengue");
        ComboxCateg.addItem("Clasica");
        ComboxCateg.addItem("Salsa");
        ComboxCateg.addItem("PasoDoble");
        ComboxCateg.addItem("Cumbia");
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "NOMBRE DISCO", "AUTOR", "GENERO", "PRECIO", "CANTIDAD","CANCION 1","CANCION 2"
                }
        ));
    }//GEN-LAST:event_menuItemMusicaActionPerformed

    private void menuItemPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPeliculasActionPerformed
        bus=false;
//        ComboxCateg.setEnabled(true);
        ComboxCateg.removeAllItems();
        ComboxCateg.addItem("Comedia");
        ComboxCateg.addItem("Terror");
        ComboxCateg.addItem("Romanticas");
        ComboxCateg.addItem("Accion");
        ComboxCateg.addItem("Suspenso");

        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "NOMBRE PELICULA", "AUTOR", "CATEGORIA", "PRECIO", "CANTIDAD"
                }
        ));
    }//GEN-LAST:event_menuItemPeliculasActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        String nombre = "";
        boolean valor1 = true;
        compraDiscosMusicaPeliculas(nombre, valor1);
    }//GEN-LAST:event_btnCompraActionPerformed

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
            java.util.logging.Logger.getLogger(vistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboxCateg;
    private javax.swing.JRadioButton autor;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrarCesion;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnPrecompra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuItemMusica;
    private javax.swing.JMenuItem menuItemPeliculas;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JRadioButton nombre;
    private javax.swing.JRadioButton precio;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtSeleccion;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
