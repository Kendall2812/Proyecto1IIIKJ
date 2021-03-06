/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import NegocioVeficarDatos.verificarDatos;
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String direccion = "";
    int precio1;
    int cantidad;
    int canti;
    String nombreUsuario, verificar;
    boolean bus;
    TableModel tablaModelo;
    ArrayList discoPrecio = new ArrayList();
    File path;

    public vistaUsuario() {
        initComponents();
        jLabel3pre.setVisible(false);
        jLabel4pre.setVisible(false);
        jLabelpre.setVisible(false);
        txtRangoPrecio.setBackground(Color.GRAY);
        txtPrecio2.setBackground(Color.GRAY);

        txtRangoPrecio.setEnabled(false);
        txtPrecio2.setEnabled(false);

        this.getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setTitle("Vista Usuario");
        btnPrecompra.setEnabled(false);
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
        btnRepro.setVisible(false);
    }

    public void filtroBusqueda() {
        String selec = txtSeleccion.getText();
        String genero = ComboxCateg.getSelectedItem().toString();
        ArrayList discosMostrar = new ArrayList();
        //String genero1 = menuItemMusica.getSelectedObjects().toString();

        if (nombre.isSelected()) {
            String bus1 = "nom";
            valida(genero, selec, bus1);
        } else if (autor.isSelected()) {
            String bus1 = "aut";
            valida(genero, selec, bus1);
        } else if (precio.isSelected()) {
            String numero = txtRangoPrecio.getText();
            String numero2 = txtPrecio2.getText();
            if (numero.equals("") || numero2.equals("")) {
                JOptionPane.showMessageDialog(null, "Ambas casillas deben estar llenas. No se puede buscar con un solo precio");
            } else {
                int precio = Integer.parseInt(numero);
                int precio2 = Integer.parseInt(numero2);

                if (precio < 0 || precio2 < 0) {
                    JOptionPane.showMessageDialog(null, "Los valores no deben ser negativos");
                } else {

                    if (precio == 0 || precio2 == 0) {
                        JOptionPane.showMessageDialog(null, "Ambas casillas deben estar llenas. No se puede buscar con un solo precio");
                    } else {
                        if (precio != precio2 && precio2 != precio) {
                            if (precio < precio2) {
                                verificarDatos datosPrecio = new verificarDatos();
                                discosMostrar = datosPrecio.datosMusicaPeliculasPrecio(verificar, genero, precio, precio2);

                                if (verificar.equals("Musica")) {

                                    if (discosMostrar.isEmpty() == false) {
                                        DefaultTableModel tempo = (DefaultTableModel) table.getModel();
                                        tempo.setRowCount(0);
                                        for (int x = 0; x < discosMostrar.size(); x++) {
                                            Object nuevo[] = {discosMostrar.get(x), discosMostrar.get(x + 1), discosMostrar.get(x + 2), discosMostrar.get(x + 3), discosMostrar.get(x + 4), discosMostrar.get(x + 5), discosMostrar.get(x + 6)};
                                            x = x + 6;
                                            tempo.addRow(nuevo);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se a encontrado discos que esten dentro de este rango");
                                    }
                                } else if (verificar.equals("Pelicula")) {

                                    if (discosMostrar.isEmpty() == false) {
                                        DefaultTableModel tempo = (DefaultTableModel) table.getModel();
                                        tempo.setRowCount(0);
                                        for (int x = 0; x < discosMostrar.size(); x++) {
                                            Object nuevo[] = {discosMostrar.get(x), discosMostrar.get(x + 1), discosMostrar.get(x + 2), discosMostrar.get(x + 3), discosMostrar.get(x + 4)};
                                            x = x + 4;
                                            tempo.addRow(nuevo);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se a encontrado discos que esten dentro de este rango");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El primer precio debe ser menor a el segundo precio para poder realizar la consulta");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Los precios no pueden ser los mismos");
                        }
                    }
                }
            }
        }
    }

    public void valida(String genero, String dato, String bus) {
        DefaultTableModel tempo = (DefaultTableModel) table.getModel();
        if (verificar.equals("Musica")) {
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
                                if (lista1[5].equals("stayin alive") || lista1[6].equals("stayin alive")) {
                                    direccion = "Stayin-Alive.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("pasodobles") || lista1[6].equals("pasodobles")) {
                                    direccion = "Pasodobles.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("como te voy a olvidar") || lista1[6].equals("como te voy a olvidar")) {
                                    direccion = "como_te_voy_a_olvidar.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("lloraras") || lista1[6].equals("lloraras")) {
                                    direccion = "lloraras.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("noche de fantasia") || lista1[6].equals("noche de fantasia")) {
                                    direccion = "noche_de_fantasia.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else {
                                    btnRepro.setVisible(false);
                                }
                            }
                        } else if (bus.equals("aut")) {
                            if (lista1[1].equals(dato) & lista1[2].equals(genero)) {
                                tempo.setRowCount(0);
                                Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4], lista1[5], lista1[6]};
                                tempo.addRow(nuevo);
                                if (lista1[5].equals("stayin alive") || lista1[6].equals("stayin alive")) {
                                    direccion = "Stayin-Alive.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("pasodobles") || lista1[6].equals("pasodobles")) {
                                    direccion = "Pasodobles.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("como te voy a olvidar") || lista1[6].equals("como te voy a olvidar")) {
                                    direccion = "como_te_voy_a_olvidar.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("lloraras") || lista1[6].equals("lloraras")) {
                                    direccion = "lloraras.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[5].equals("noche de fantasia") || lista1[6].equals("noche de fantasia")) {
                                    direccion = "noche_de_fantasia.wav";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else {
                                    btnRepro.setVisible(false);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
            }
        } else if (verificar.equals("Pelicula")) {
            String temp = "";
            try {
                try (BufferedReader bf = new BufferedReader(new FileReader("archivoPeliculas.txt"))) {
                    String bfRead;
                    while ((bfRead = bf.readLine()) != null) {
                        temp = bfRead;
                        String lista = temp;
                        String[] lista1 = lista.split(",");
                        if (bus.equals("nom")) {
                            if (lista1[2].equals(genero) && (lista1[0].equals(dato))) {
                                tempo.setRowCount(0);
                                Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4]};
                                tempo.addRow(nuevo);
                                if (lista1[0].equals("todo todo")) {
                                    direccion = "TODO TODO   Trailer Banda Sonora   Oficial Warner Bros Pictures.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("guardianes de la galaxia")) {
                                    direccion = "Guardianes de la Galaxia Vol2   Nuevo Tráiler.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("saw 8")) {
                                    direccion = "Saw VIII Trailer Oficial Español.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("la mascara")) {
                                    direccion = "Trailer La Mascara.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("ruta equivocada")) {
                                    direccion = "Wrong Turn (2003) Trailer.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else {
                                    btnRepro.setVisible(false);
                                }
                            }
                        } else if (bus.equals("aut")) {
                            if (lista1[1].equals(dato) & lista1[2].equals(genero)) {
                                tempo.setRowCount(0);
                                Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4]};
                                tempo.addRow(nuevo);
                                if (lista1[0].equals("todo todo")) {
                                    direccion = "TODO TODO   Trailer Banda Sonora   Oficial Warner Bros Pictures.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("guadianes de la galaxia 2")) {
                                    direccion = "Guardianes de la Galaxia Vol2   Nuevo Tráiler.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("saw 8")) {
                                    direccion = "Saw VIII Trailer Oficial Español.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("la mascara")) {
                                    direccion = "Trailer La Mascara.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else if (lista1[0].equals("ruta equivocada")) {
                                    direccion = "Wrong Turn (2003) Trailer.mp4";
                                    reproducirMusica(direccion);
                                    btnRepro.setVisible(true);
                                } else {
                                    btnRepro.setVisible(false);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
            }
        }
    }

    public void reproducirMusica(String direccion) throws IOException {
        String file = direccion;
        path = new File(file);
//        Desktop.getDesktop().open(path);
    }

    public void compraDiscosMusicaPeliculas(String nombreU, boolean valor, String verificar) {
        nombreUser.add(nombreU);
        int row = 0;
        String numero;
        tablaModelo = (TableModel) table.getModel();
        row = table.getSelectedRow();
        numero = String.valueOf(row);
        try {
            try {
                if (valor == false) {

                } else {

                    if (numero.equals("-1")) {//validad que se aya seleccionado una cancion en el Jtable
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un disco y la cantidad que desea comprar");
                    } else {

                        String cantidadDisponible = tablaModelo.getValueAt(row, 4).toString();//obtiene la cantidad de los dicos disponibles
                        int disponible = Integer.parseInt(cantidadDisponible);//transforma la variable "cantidadDisponible" a Integer
                        canti = Integer.parseInt(txtCantidad.getText());

                        if (disponible == 0) {
                            JOptionPane.showMessageDialog(null, "En este momento se encuntra agotado el articulo. "
                                    + "Si desea realizar una PreCompra presione el boton de PreCompra");//verifica que si la cantidad del disco este en 0
                            btnPrecompra.setEnabled(true);//Activa el boton de preCompra para que realize la funcion
                        } else if (canti > disponible) {
                            JOptionPane.showMessageDialog(null, "Esa cantidad no se encuentra disponible"); //verifica que la cantidad que se digito no sea mayor a la que esta en el archivo
                            txtCantidad.setText("");
                        } else if (canti == 0) {
                            JOptionPane.showMessageDialog(null, "La compra no puede ser 0 discos tiene que ser por lo menos 1 disco");
                        } else if (canti <= disponible) { //validad que la cantidad que se digito sea menor o igual a la wue se encuentra en el archivo
                            String User = (String) nombreUser.get(0);
                            String strResultado = tablaModelo.getValueAt(row, 0).toString();
                            String Precio = tablaModelo.getValueAt(row, 3).toString();
                            String genero = tablaModelo.getValueAt(row, 2).toString();

                            ventanaCompras compra = new ventanaCompras(); //llama ventana compra
                            compra.registrarCompra(strResultado, Precio, canti, User, verificar, genero);
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

    public void preCompras() {
        int row;
        row = table.getSelectedRow();

        if (row != -1) {
            if (canti != 0) {
                String User = (String) nombreUser.get(0);
                String nombreDiscoPelicula = tablaModelo.getValueAt(row, 0).toString();
                String Precio = tablaModelo.getValueAt(row, 3).toString();

                vetanaPreCompra preorden = new vetanaPreCompra();
                preorden.preCompra(nombreDiscoPelicula, Precio, canti, User, verificar);
                preorden.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Debe indicar la cantidad de Discos o de Peliculas para realizar la Pre Orden");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar en la tabla el nombre de la pelicula o el nombre del Disco de Musica para realizar la Pre Compra");
        }
    }

    public void validaMouseClicked(String nombre, String dato) {
        if (verificar.equals("Musica")) {
            String temp = "";
            try {
                try (BufferedReader bf = new BufferedReader(new FileReader("archivoDiscosMusica.txt"))) {
                    String bfRead;
                    while ((bfRead = bf.readLine()) != null) {
                        temp = bfRead;
                        String lista = temp;
                        String[] lista1 = lista.split(",");

                        if (lista1[0].equals(nombre) && (lista1[2].equals(dato))) {                       
                            if (lista1[0].equals("saturday night Fever")) {
                                direccion = "Stayin-Alive.wav";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("guayacan")) {
                                direccion = "Pasodobles.wav";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("azul vivo")) {
                                direccion = "como_te_voy_a_olvidar.wav";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("en vivo")) {
                                direccion = "lloraras.wav";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("noches de fantasia")) {
                                direccion = "noche_de_fantasia.wav";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else {
                                btnRepro.setVisible(false);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
            }
        } else if (verificar.equals("Pelicula")) {
            String temp = "";
            try {
                try (BufferedReader bf = new BufferedReader(new FileReader("archivoPeliculas.txt"))) {
                    String bfRead;
                    while ((bfRead = bf.readLine()) != null) {
                        temp = bfRead;
                        String lista = temp;
                        String[] lista1 = lista.split(",");
                        if (lista1[0].equals(nombre) && (lista1[2].equals(dato))) {                         
                            if (lista1[0].equals("todo todo")) {
                                direccion = "TODO TODO   Trailer Banda Sonora   Oficial Warner Bros Pictures.mp4";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("guardianes de la galaxia")) {
                                direccion = "Guardianes de la Galaxia Vol2   Nuevo Tráiler.mp4";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("saw 8")) {
                                direccion = "Saw VIII Trailer Oficial Español.mp4";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("la mascara")) {
                                direccion = "Trailer La Mascara.mp4";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else if (lista1[0].equals("ruta equivocada")) {
                                direccion = "Wrong Turn (2003) Trailer.mp4";
                                reproducirMusica(direccion);
                                btnRepro.setVisible(true);
                            } else {
                                btnRepro.setVisible(false);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se encontro el archivo" + e);
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
        btnBuscar = new javax.swing.JButton();
        txtRangoPrecio = new javax.swing.JTextField();
        txtPrecio2 = new javax.swing.JTextField();
        jLabel3pre = new javax.swing.JLabel();
        jLabel4pre = new javax.swing.JLabel();
        jLabelpre = new javax.swing.JLabel();
        btnRepro = new javax.swing.JButton();
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        nombre.setBackground(java.awt.Color.gray);
        buttonGroup1.add(nombre);
        nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Nombre de la cancion");
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        autor.setBackground(java.awt.Color.gray);
        buttonGroup1.add(autor);
        autor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        autor.setForeground(new java.awt.Color(255, 255, 255));
        autor.setText("Autor");
        autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorActionPerformed(evt);
            }
        });

        precio.setBackground(java.awt.Color.gray);
        buttonGroup1.add(precio);
        precio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        precio.setForeground(new java.awt.Color(255, 255, 255));
        precio.setText("Precio");
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

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
        btnPrecompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecompraActionPerformed(evt);
            }
        });

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

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtRangoPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRangoPrecio.setBorder(null);
        txtRangoPrecio.setEnabled(false);

        txtPrecio2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecio2.setBorder(null);
        txtPrecio2.setEnabled(false);

        jLabel3pre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3pre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3pre.setText("Precio 1");

        jLabel4pre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4pre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4pre.setText("Precio 2");

        jLabelpre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelpre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelpre.setText("Indique Rango Precios");

        btnRepro.setText("Reproducir");
        btnRepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarCesion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ComboxCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4pre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelpre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3pre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRangoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCompra)))
                        .addGap(18, 18, 18)
                        .addComponent(btnPrecompra))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombre)
                                .addGap(18, 18, 18)
                                .addComponent(txtSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(precio)
                            .addComponent(autor))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRepro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(69, 69, 69))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(6, 6, 6)
                        .addComponent(precio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnRepro)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCompra)
                            .addComponent(btnPrecompra))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jLabelpre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRangoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3pre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4pre)
                            .addComponent(txtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
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
        if (ComboxCateg.getSelectedIndex() != -1) {
            String texto = ComboxCateg.getSelectedItem().toString();
            verificarDatos verifica = new verificarDatos();
            verifica.buscarArchivo(texto, (DefaultTableModel) tabla, bus);
            nombre.setEnabled(true);
            autor.setEnabled(true);
            precio.setEnabled(true);
            txtSeleccion.setEditable(true);
            btnBuscar.setEnabled(true);
            btnRepro.setVisible(false);
        }
    }//GEN-LAST:event_ComboxCategActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtroBusqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void menuItemMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMusicaActionPerformed
        bus = true;
        verificar = "Musica";
        nombre.setLabel("Nombre de la Canción"); //Lo que hace es cambiar el nombre del label para colocar nombre Musica
        ComboxCateg.removeAllItems();
        ComboxCateg.addItem("Seleccionar");
        ComboxCateg.addItem("Merengue");
        ComboxCateg.addItem("Clasica");
        ComboxCateg.addItem("Salsa");
        ComboxCateg.addItem("PasoDoble");
        ComboxCateg.addItem("Cumbia");
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "NOMBRE DISCO", "AUTOR", "GENERO", "PRECIO", "CANTIDAD", "CANCION 1", "CANCION 2"
                }
        ));
        btnRepro.setVisible(false);
    }//GEN-LAST:event_menuItemMusicaActionPerformed

    private void menuItemPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPeliculasActionPerformed
        bus = false;
        verificar = "Pelicula";
        nombre.setLabel("Nombre de la Pelicula");//Lo que hace es cambiar el nombre del label para colocar nombre Pelcula
        ComboxCateg.removeAllItems();
        ComboxCateg.addItem("Seleccionar");
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
        btnRepro.setVisible(false);
    }//GEN-LAST:event_menuItemPeliculasActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        String nombre = "";
        boolean valor1 = true;
        compraDiscosMusicaPeliculas(nombre, valor1, verificar);
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnPrecompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecompraActionPerformed
        preCompras();
    }//GEN-LAST:event_btnPrecompraActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        //consulta por precio del disco o pelicula

        txtSeleccion.setEditable(false);
        jLabel3pre.setVisible(true);
        jLabel4pre.setVisible(true);
        jLabelpre.setVisible(true);
        txtRangoPrecio.setBackground(Color.WHITE);
        txtPrecio2.setBackground(Color.WHITE);
        txtRangoPrecio.setEnabled(true);
        txtPrecio2.setEnabled(true);
        txtSeleccion.setText("");
        btnRepro.setVisible(false);
    }//GEN-LAST:event_precioActionPerformed

    private void autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorActionPerformed
        //consulta por nombre de autor del disco o pelicula

        txtSeleccion.setEditable(true);
        jLabel3pre.setVisible(false);
        jLabel4pre.setVisible(false);
        jLabelpre.setVisible(false);
        txtRangoPrecio.setBackground(Color.GRAY);
        txtPrecio2.setBackground(Color.GRAY);
        txtRangoPrecio.setEnabled(false);
        txtPrecio2.setEnabled(false);
        txtRangoPrecio.setText("");
        txtPrecio2.setText("");
        btnRepro.setVisible(false);
    }//GEN-LAST:event_autorActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        //consulta por nombre del disco o pelicula

        txtSeleccion.setEditable(true);
        jLabel3pre.setVisible(false);
        jLabel4pre.setVisible(false);
        jLabelpre.setVisible(false);
        txtRangoPrecio.setBackground(Color.GRAY);
        txtPrecio2.setBackground(Color.GRAY);

        txtRangoPrecio.setEnabled(false);
        txtPrecio2.setEnabled(false);

        txtRangoPrecio.setText("");
        txtPrecio2.setText("");
        btnRepro.setVisible(false);
    }//GEN-LAST:event_nombreActionPerformed

    private void btnReproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproActionPerformed
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(vistaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReproActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        TableModel tablaModelo1;
        tablaModelo1 = (TableModel) table.getModel();
        int row = table.getSelectedRow();
        try {
            try {
                if (verificar.equals("Musica")) {
                    String name = tablaModelo1.getValueAt(row, 0).toString();
                    String genero= tablaModelo1.getValueAt(row, 2).toString();
                    validaMouseClicked(name, genero);
                }else if(verificar.equals("Pelicula")){
                    String name = tablaModelo1.getValueAt(row, 0).toString();
                    String genero= tablaModelo1.getValueAt(row, 2).toString();
                    validaMouseClicked(name, genero);
                }
            } catch (java.lang.NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar");
            }
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar");
        }
    }//GEN-LAST:event_tableMouseClicked

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
    private javax.swing.JButton btnRepro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3pre;
    private javax.swing.JLabel jLabel4pre;
    private javax.swing.JLabel jLabelpre;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuItemMusica;
    private javax.swing.JMenuItem menuItemPeliculas;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JRadioButton nombre;
    private javax.swing.JRadioButton precio;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio2;
    private javax.swing.JTextField txtRangoPrecio;
    private javax.swing.JTextField txtSeleccion;
    // End of variables declaration//GEN-END:variables
}
