/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import NegocioVeficarDatos.verificarDatos;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kendall
 */
public class archivosProyecto {

    String[] datos1;
    String nombre2, clave2, valores, to;
    ArrayList datos2 = new ArrayList();
    ArrayList nombreUser = new ArrayList();
    ArrayList dateMusic = new ArrayList();
    ArrayList dateMovie = new ArrayList();
    String nombre3, cedula3, correo3;
    String nombred, autor, categoria, precio4, disponibles, cancion1, cancion2;
    int restaCantidad = 0;
    int catidadResta = 0;
    int cambioCantidad = 0;
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date = new Date();
    String usuario, nombreDisco, mensaje, asunto, nombrePelicula;
    int precio, monto;

    public String datosAdmin() { //Lee el archivo del administrador

        File administrador;
        try {
            administrador = new File("archivoAdministrador.txt");
            if (administrador.createNewFile()) {

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
        }

        File direccion = new File("archivoAdministrador.txt");

        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo2 = new BufferedReader(leer);
            String linea6;
            while ((linea6 = archivo2.readLine()) != null) {
                datos1 = linea6.split(" ");

                for (int x = 0; x < datos1.length; x++) {
                    datos2.add(datos1[x]);
                }
            }
            nombre2 = (String) datos2.get(0);
            clave2 = (String) datos2.get(1);
            valores = nombre2 + " " + clave2;

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return valores;
    }

    public ArrayList datosUser() { //Lee el archivo de usuario
        ArrayList User = new ArrayList();
        File usuarios;
        try {
            usuarios = new File("archivoUser.txt");
            if (usuarios.createNewFile()) {

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
        }

        File direccion = new File("archivoUser.txt");

        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo2 = new BufferedReader(leer);
            String linea6;
            while ((linea6 = archivo2.readLine()) != null) {
                datos1 = linea6.split(" ");

                for (int x = 0; x < datos1.length; x++) {
                    User.add(datos1[x]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return User;
    }

    public void registrarDiscoMusica(String nombreDisco, String autor, String genero, String precio, String cantidadDisponible, String cancion1, String cancion2) {
        //Se crea el archivo para registrar la infomacion de los discos de musica.
        File DiscosMusica;
        try {
            DiscosMusica = new File("archivoDiscosMusica.txt");
            if (DiscosMusica.createNewFile()) {

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
        }
        //se escribe la informacion de los discos de musica.
        File direccion = new File("archivoDiscosMusica.txt");

        try {
            try (FileWriter escribir = new FileWriter(direccion, true)) {
                escribir.write(nombreDisco + ",");
                escribir.write(autor + ",");
                escribir.write(genero + ",");
                escribir.write(precio + ",");
                escribir.write(cantidadDisponible + ",");
                escribir.write(cancion1 + ",");
                escribir.write(cancion2 + ",");
                escribir.write("*" + "\n");
                escribir.close();

                JOptionPane.showMessageDialog(null, "Se registro con exito");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }

    public void registrosUsuarios(String nombre, String Clave, String Cedula, String correo) {
        File direccion = new File("archivoUser.txt");

        try {
            try (FileWriter escribir = new FileWriter(direccion, true)) {
                escribir.write(nombre + " ");
                escribir.write(Clave + " ");
                escribir.write(Cedula + " ");
                escribir.write(correo + "\n");
                escribir.close();

                JOptionPane.showMessageDialog(null, "Se registro con exito");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }

    public void registrarPeliculas(String nombre, String autor, String categoria, String precio, String cantidad) {
        File Peliculas;
        try {
            Peliculas = new File("archivoPeliculas.txt");
            if (Peliculas.createNewFile()) {

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo crear el archivo" + e);
        }

        File direccion = new File("archivoPeliculas.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion, true)) {
                escribir.write(nombre + ",");
                escribir.write(autor + ",");
                escribir.write(categoria + ",");
                escribir.write(precio + ",");
                escribir.write(cantidad + ",");
                escribir.write("*" + "\n");
                escribir.close();

                JOptionPane.showMessageDialog(null, "Se registro con exito");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }

    public void buscarGeneroMusicaPelicual(String genero, DefaultTableModel tabla, boolean bus) {
        DefaultTableModel tempo = (DefaultTableModel) tabla;
        if (bus) {

            try {
                String temp = "";
                try (BufferedReader bf = new BufferedReader(new FileReader("archivoDiscosMusica.txt"))) {
                    String bfRead;
                    while ((bfRead = bf.readLine()) != null) {
                        temp = bfRead;
                        String lista = temp;
                        String[] lista1 = lista.split(",");
                        if (genero.equals(lista1[2])) {
                            Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4], lista1[5], lista1[6]};
                            tempo.addRow(nuevo);
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun disco con el genero que selecciono" + e);
            }
        }
        if (!bus) {
//            System.out.println("entro a buscar peliculas");
            try {
                String temp = "";
                try (BufferedReader bf = new BufferedReader(new FileReader("archivoPeliculas.txt"))) {
                    String bfRead;
                    while ((bfRead = bf.readLine()) != null) {
                        temp = bfRead;
                        String lista = temp;
                        String[] lista1 = lista.split(",");
                        if (genero.equals(lista1[2])) {
                            Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4]};
                            tempo.addRow(nuevo);
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun disco con el genero que selecciono" + e);
            }
        }
    }

    public ArrayList leerDatosMusica() {
        String linea7, linea8;
        String[] nombreDisco;
        ArrayList datosDisco = new ArrayList();

        File direccion = new File("archivoDiscosMusica.txt");
        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo = new BufferedReader(leer);

            while ((linea7 = archivo.readLine()) != null) {
                nombreDisco = linea7.split(",");

                for (int x = 0; x < nombreDisco.length; x++) {
                    datosDisco.add(nombreDisco[x]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        return datosDisco;
    }

    public void editarInfoMusica(ArrayList datosNuevos, boolean valor) {

        File direccion = new File("archivoDiscosMusica.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion)) {
                for (int x = 0; x < datosNuevos.size(); x++) {
                    escribir.write(datosNuevos.get(x).toString());
                    escribir.write(",");

                    if (datosNuevos.get(x).equals("*")) {
                        escribir.write("\n");
                    }
                }
                escribir.close();
                if (valor == true) {
                    JOptionPane.showMessageDialog(null, "El cambio se realizo con exito");
                }
                if (valor == false) {
                    JOptionPane.showMessageDialog(null, "Se realizo la compra con exito");
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }

    public void eliminarInfoMusica(ArrayList datosEliminar) {
        File direccion = new File("archivoDiscosMusica.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion)) {
                for (int x = 0; x < datosEliminar.size(); x++) {
                    escribir.write(datosEliminar.get(x).toString());
                    escribir.write(",");

                    if (datosEliminar.get(x).equals("*")) {
                        escribir.write("\n");
                    }
                }
                escribir.close();

                JOptionPane.showMessageDialog(null, "Se elimino con exito");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo eliminar la informacion en el archivo" + e);
        }
    }

    public ArrayList leerDatosPeliculas() { // lee el archivo de musica para extraer la informacion y agregarla en una lista para retornarla negocios
        String linea7, linea8;
        String[] nombrePeliculas;
        ArrayList datosPelicula = new ArrayList();

        File direccion = new File("archivoPeliculas.txt");
        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo = new BufferedReader(leer);

            while ((linea7 = archivo.readLine()) != null) {
                nombrePeliculas = linea7.split(",");

                for (int x = 0; x < nombrePeliculas.length; x++) {
                    datosPelicula.add(nombrePeliculas[x]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        return datosPelicula;
    }

    public void guardarInfoPelicEditada(ArrayList datosNuevos, boolean valor) {
        File direccion = new File("archivoPeliculas.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion)) {
                for (int x = 0; x < datosNuevos.size(); x++) {
                    escribir.write(datosNuevos.get(x).toString());
                    escribir.write(",");

                    if (datosNuevos.get(x).equals("*")) {
                        escribir.write("\n");
                    }
                }
                escribir.close();
                if (valor == true) {
                    JOptionPane.showMessageDialog(null, "El cambio se realizo con exito");
                }
                if (valor == false) {
                    JOptionPane.showMessageDialog(null, "Se realizo la compra con exito");
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }

    public void eliminarPelicula(ArrayList datosEliminarMovie) {
        File direccion = new File("archivoPeliculas.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion)) {
                for (int x = 0; x < datosEliminarMovie.size(); x++) {
                    escribir.write(datosEliminarMovie.get(x).toString());
                    escribir.write(",");

                    if (datosEliminarMovie.get(x).equals("*")) {
                        escribir.write("\n");
                    }
                }
                escribir.close();

                JOptionPane.showMessageDialog(null, "Se elimino con exito");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo eliminar la informacion en el archivo" + e);
        }
    }

    public void guardarCompras(String nombre, String precio, String cantidad, String nameUser, String verificar) {

        boolean valor1 = false;
        File direccion = new File("archivoUser.txt");

        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo2 = new BufferedReader(leer);
            String linea6;
            while ((linea6 = archivo2.readLine()) != null) {
                datos1 = linea6.split(" ");

                for (int x = 0; x < datos1.length; x++) {
                    nombreUser.add(datos1[x]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        for (int y = 0; y < nombreUser.size(); y = y + 4) {
            if (nombreUser.get(y).equals(nameUser)) {
                nombre3 = (String) nombreUser.get(y);
                cedula3 = (String) nombreUser.get(y + 2);
                correo3 = (String) nombreUser.get(y + 3);
                valor1 = true;
                break;
            }
        }
        if ("Musica".equals(verificar)) {

            if (valor1 == true) {
                File Compras;
                try {
                    Compras = new File("archivoCompras.txt");
                    if (Compras.createNewFile()) {

                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
                }
                //se escribe la informacion de las compras.
                File direccion2 = new File("archivoCompras.txt");

                try {
                    try (FileWriter escribir = new FileWriter(direccion2, true)) {
                        escribir.write(nombre3 + ",");
                        escribir.write(cedula3 + ",");
                        escribir.write(correo3 + ",");
                        escribir.write(nombre + ",");
                        escribir.write(cantidad + "," + dateFormat.format(date) + ",");
                        escribir.write("*" + "\n");
                        escribir.close();
                        usuario = correo3;
                        nombreDisco = nombre;
                        mensaje = "La compra de su disco: " + nombre + " fue exitosa, gracias por preferirnos";
                        asunto = "Compra existosa";
                        verificarDatos correo1 = new verificarDatos();
                        correo1.enviarCorreo2(usuario, mensaje, asunto);

                        //JOptionPane.showMessageDialog(null, "Se registro con exito");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
                }
                //nombred,autor,categoria,precio4,disponibles,cancion1,cancion2
                dateMusic = leerDatosMusica();
                for (int t = 0; t < dateMusic.size(); t = t + 8) {
                    if (dateMusic.get(t).equals(nombre)) {

                        nombred = (String) dateMusic.get(t);
                        autor = (String) dateMusic.get(t + 1);
                        categoria = (String) dateMusic.get(t + 2);
                        precio4 = (String) dateMusic.get(t + 3);

                        disponibles = (String) dateMusic.get(t + 4);
                        cancion1 = (String) dateMusic.get(t + 5);
                        cancion2 = (String) dateMusic.get(t + 6);

                        catidadResta = Integer.parseInt(disponibles);
                        cambioCantidad = Integer.parseInt(cantidad);
                        restaCantidad = catidadResta - cambioCantidad;

                        int y = dateMusic.indexOf(nombre);
                        int cont = 0;
                        while (cont != 8) {
                            dateMusic.remove(y);
                            cont++;
                        }

                        dateMusic.add(nombred);
                        dateMusic.add(autor);
                        dateMusic.add(categoria);
                        dateMusic.add(precio4);
                        dateMusic.add(restaCantidad);
                        dateMusic.add(cancion1);
                        dateMusic.add(cancion2);
                        dateMusic.add("*");
                        editarInfoMusica(dateMusic, false);
                        break;
                    }
                }
            }
        }
        if ("Pelicula".equals(verificar)) {
            //System.out.println("entro a comprar peliculas");
            if (valor1 == true) {
                File ComprasPeliculas;

                try {
                    ComprasPeliculas = new File("archivoComprasPeliculas.txt");
                    if (ComprasPeliculas.createNewFile()) {

                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
                }

                File direccion2 = new File("archivoComprasPeliculas.txt");

                try {
                    try (FileWriter escribir = new FileWriter(direccion2, true)) {
                        escribir.write(nombre3 + ",");
                        escribir.write(cedula3 + ",");
                        escribir.write(correo3 + ",");
                        escribir.write(nombre + ",");
                        escribir.write(cantidad + "," + dateFormat.format(date) + ",");
                        escribir.write("*" + "\n");
                        escribir.close();
                        usuario = correo3;
                        nombrePelicula = nombre;
                        mensaje = "La compra de su Pelicula: " + nombre + " fue exitosa, gracias por preferirnos";
                        asunto = "Compra existosa";
                        verificarDatos correo1 = new verificarDatos();
                        correo1.enviarCorreo2(usuario, mensaje, asunto);

                        //JOptionPane.showMessageDialog(null, "Se registro con exito");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
                }
                //nombred,autor,categoria,precio4,disponibles,cancion1,cancion2
                dateMovie = leerDatosPeliculas();
                for (int t = 0; t < dateMovie.size(); t = t + 6) {
                    if (dateMovie.get(t).equals(nombre)) {

                        //Enrredados james Comedia 15000 10 * 
                        nombred = (String) dateMovie.get(t);
                        autor = (String) dateMovie.get(t + 1);
                        categoria = (String) dateMovie.get(t + 2);
                        precio4 = (String) dateMovie.get(t + 3);
                        disponibles = (String) dateMovie.get(t + 4);

                        catidadResta = Integer.parseInt(disponibles);
                        cambioCantidad = Integer.parseInt(cantidad);
                        restaCantidad = catidadResta - cambioCantidad;

                        int y = dateMovie.indexOf(nombre);
                        int cont = 0;
                        while (cont != 6) {
                            dateMovie.remove(y);
                            cont++;
                        }

                        dateMovie.add(nombred);
                        dateMovie.add(autor);
                        dateMovie.add(categoria);
                        dateMovie.add(precio4);
                        dateMovie.add(restaCantidad);
                        dateMovie.add("*");
                        guardarInfoPelicEditada(dateMovie, false);
                        break;
                    }
                }
            }
        }
    }

    public void registrarPreCompra2(String usuario, String nombreArticulo, String cantidad, String total, String Genero) {
        ArrayList usuario5 = new ArrayList();
        usuario5 = datosUser();
        String correo4 = ""; //nombre1 
        boolean valor = false;

        for (int x = 0; x < usuario5.size(); x = x + 4) {
            if (usuario5.get(x).equals(usuario)) {
                correo4 = (String) usuario5.get(x + 3);
                valor = true;
                break;
            }
        }
        if (valor == true) {
            File preCompras;
            try {
                preCompras = new File("archivoPreCompras.txt");
                if (preCompras.createNewFile()) {

                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
            }

            File direccion2 = new File("archivoPreCompras.txt");

            try {
                try (FileWriter escribir = new FileWriter(direccion2, true)) {
                    escribir.write(usuario + ",");
                    escribir.write(correo4 + ",");
                    escribir.write(nombreArticulo + ",");
                    escribir.write(cantidad + ",");
                    escribir.write(Genero + ",");
                    escribir.write("*" + "\n");
                    escribir.close();

                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
            }
        }
    }

    public void mostrarPreOrden(DefaultTableModel tabla, String verificar, int cantidad, String articulo, String asunto, String tipo, String user) {
        DefaultTableModel tempo = (DefaultTableModel) tabla;
        try {
            String temp = "";
            try (BufferedReader bf = new BufferedReader(new FileReader("archivoPreCompras.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(",");
                    if (verificar.equals("abrir")) {
                        Object nuevo[] = {lista1[0], lista1[2], lista1[4], lista1[3]};
                        tempo.addRow(nuevo);
                    }
                    if (verificar.equals("musica")) {
                        if (user.equals(lista1[0])) {
                            to = lista1[1];
                            try {
                                String temp1 = "";
                                try (BufferedReader bf1 = new BufferedReader(new FileReader("archivoDiscosMusica.txt"))) {
                                    String bfRead1;
                                    while ((bfRead1 = bf1.readLine()) != null) {
                                        temp1 = bfRead1;
                                        String lista2 = temp1;
                                        String[] lista12 = lista2.split(",");
                                        if (lista12[0].equals(articulo)) {
                                            precio = Integer.parseInt(lista12[3]);
                                            if (Integer.parseInt(lista12[4]) > 0) {
                                                monto = (precio * cantidad);
                                                mensaje = "Hola, te informamos que el articulo de " + tipo + ":" + articulo
                                                        + "que solicitaste ya se encuentra disponible para su compra\n" + "Cantidad= " + cantidad + "\nMonto total=" + monto;
                                                verificarDatos corr = new verificarDatos();
                                                corr.enviarCorreo2(to, mensaje, asunto);
                                                eliminarPreOrden(tabla, user, to, articulo, tipo, String.valueOf(cantidad));
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Aun no hay cantidad disponible para ese articulo");
                                            }
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "No se encontro ningun disco con el genero que selecciono" + e);
                            }
                        }
                    } else if (verificar.equals("pelicula")) {
                        if (user.equals(lista1[0])) {
                            to = lista1[1];
                            try {
                                String temp1 = "";
                                try (BufferedReader bf1 = new BufferedReader(new FileReader("archivoPeliculas.txt"))) {
                                    String bfRead1;
                                    while ((bfRead1 = bf1.readLine()) != null) {
                                        temp1 = bfRead1;
                                        String lista2 = temp1;
                                        String[] lista12 = lista2.split(",");
                                        if (lista12[0].equals(articulo)) {
                                            precio = Integer.parseInt(lista12[3]);
                                            if (Integer.parseInt(lista12[4]) > 0) {
                                                monto = (precio * cantidad);
                                                mensaje = "Hola, te informamos que el articulo de " + tipo + ":" + articulo
                                                        + "que solicitaste ya se encuentra disponible para su compra\n" + "Cantidad= " + cantidad + "\nMonto total=" + monto;
                                                verificarDatos corr = new verificarDatos();
                                                corr.enviarCorreo2(to, mensaje, asunto);
                                                eliminarPreOrden(tabla, user, to, articulo, tipo, String.valueOf(cantidad));
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Aun no hay cantidad disponible para ese articulo");
                                            }
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, "error al abrir" + e);
                            }
                        }
                    }
                }

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
    }

    public void mostrarCompDisc(DefaultTableModel tabla) {
        DefaultTableModel tempo = (DefaultTableModel) tabla;
        try {
            String temp = "";
            try (BufferedReader bf = new BufferedReader(new FileReader("archivoCompras.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(",");
                    Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4]};
                    tempo.addRow(nuevo);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun disco con el genero que selecciono" + e);
        }

    }

    public void mostrarCompPeli(DefaultTableModel tabla) {
        DefaultTableModel tempo = (DefaultTableModel) tabla;
        try {
            String temp = "";
            try (BufferedReader bf = new BufferedReader(new FileReader("archivoComprasPeliculas.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(",");
                    Object nuevo[] = {lista1[0], lista1[1], lista1[2], lista1[3], lista1[4]};
                    tempo.addRow(nuevo);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun disco con el genero que selecciono" + e);
        }

    }

    public ArrayList leerArchivoCompraMusica1() {
        ArrayList comprasMusica = new ArrayList();
        File direccion = new File("archivoCompras.txt");

        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo2 = new BufferedReader(leer);
            String linea6;
            while ((linea6 = archivo2.readLine()) != null) {
                datos1 = linea6.split(",");

                for (int x = 0; x < datos1.length; x++) {
                    comprasMusica.add(datos1[x]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return comprasMusica;
    }

    public void eliminarPreOrden(DefaultTableModel tabla, String nombre, String correo, String articulo, String tipo, String cantidad) {
        DefaultTableModel tempo = (DefaultTableModel) tabla;
        try {
            String temp;
            try (BufferedReader bf = new BufferedReader(new FileReader("archivoPreCompras.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(",");
                    if (lista1[0].equals(nombre) & lista1[1].equals(correo) & lista1[2].equals(articulo) & lista1[3].equals(cantidad) & lista1[4].equals(tipo)) {
                        try {
                            File archivo = new File("archivoPreCompras.txt");
                            FileWriter escribir = new FileWriter(archivo, true);
                            String temp1;
                            try (BufferedReader bf1 = new BufferedReader(new FileReader("archivoPreCompras.txt"))) {
                                String bf1Read;
                                while ((bf1Read = bf1.readLine()) != null) {
                                    temp1 = bf1Read;
                                    if (temp1.equals(lista)) {
                                        BufferedWriter br = new BufferedWriter(new FileWriter("archivoPreCompras.txt"));
                                        continue;
                                    }
                                    escribir.write(temp1 + "\r\n");
                                    tempo.setRowCount(0);
                                }
                                escribir.close();
                                JOptionPane.showMessageDialog(null, "eliminado correctamente");
                                mostrarPreOrden(tabla, "abrir", 0, "", "", "", "");
                            }
                        } catch (IOException e) {
                            System.out.println("No se encontro el archivo" + e);
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo" + e);
        }
    }
    
}
