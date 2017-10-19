/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import NegocioVeficarDatos.Controlador;
import NegocioVeficarDatos.Correo;
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
    String nombre2, clave2, valores;
    ArrayList datos2 = new ArrayList();
    ArrayList nombreUser = new ArrayList();
    ArrayList dateMusic = new ArrayList();
    String nombre3, cedula3, correo3;
    String nombred, autor, categoria, precio4, disponibles, cancion1, cancion2;
    int restaCantidad = 0;
    int catidadResta = 0;
    int cambioCantidad = 0;
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date = new Date();
    Correo c = new Correo();
    String usuario, nombreDisco, mensaje, asunto;

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

    public String[] datosUser() { //Lee el archivo de usuario

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
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return datos1;
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
                escribir.write(nombre + " ");
                escribir.write(autor + " ");
                escribir.write(categoria + " ");
                escribir.write(precio + " ");
                escribir.write(cantidad + " ");
                escribir.write("*" + "\n");
                escribir.close();

                JOptionPane.showMessageDialog(null, "Se registro con exito");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }

    public void buscarGeneroMusicaPelicual(String genero, DefaultTableModel tabla) {
        DefaultTableModel tempo = (DefaultTableModel) tabla;
        String temp = "";
        try {
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

    public void editarInfoMusica(ArrayList datosNuevos) {
        boolean valor = false;
        File direccion = new File("archivoDiscosMusica.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion)) {
                for (int x = 0; x < datosNuevos.size(); x++) {
                    escribir.write(datosNuevos.get(x).toString());
                    escribir.write(",");

                    if (datosNuevos.get(x).equals("*")) {
                        escribir.write("\n");
                        valor = true;
                    }
                }
                escribir.close();
                if (valor == true) {
                    JOptionPane.showMessageDialog(null, "El cambio se realizo con exito");
                } else {
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
                nombrePeliculas = linea7.split(" ");

                for (int x = 0; x < nombrePeliculas.length; x++) {
                    datosPelicula.add(nombrePeliculas[x]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        return datosPelicula;
    }

    public void guardarInfoPelicEditada(ArrayList datosNuevos) {
        File direccion = new File("archivoPeliculas.txt");
        try {
            try (FileWriter escribir = new FileWriter(direccion)) {
                for (int x = 0; x < datosNuevos.size(); x++) {
                    escribir.write(datosNuevos.get(x).toString());
                    escribir.write(" ");

                    if (datosNuevos.get(x).equals("*")) {
                        escribir.write("\n");
                    }
                }
                escribir.close();

                JOptionPane.showMessageDialog(null, "El cambio se realizo con exito");
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
                    escribir.write(" ");

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

    public void guardarCompras(String nombre, String precio, String cantidad, String nameUser) {
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
                    enviarCorreo(usuario, mensaje, asunto);

                    JOptionPane.showMessageDialog(null, "Se registro con exito");
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
            }
            //nombred,autor,categoria,precio4,disponibles,cancion1,cancion2
            dateMusic = leerDatosMusica();
            for (int t = 0; t < dateMusic.size(); t++) {
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
                    editarInfoMusica(dateMusic);
                    break;
                }
            }
        }
    }

    public void enviarCorreo(String usuario, String mensaje, String asunt) {
        c.setContraseña("ieyoydtabzekgfhl");
        c.setUsuarioCorreo("jennim2430@gmail.com");
        c.setAsunto(asunt);
        c.setMensaje(mensaje);
        c.setDestino(usuario);

        Controlador co = new Controlador();
        if (co.enviarCorreo(c)) {
            JOptionPane.showMessageDialog(null, "El correo ha sido enviado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al enviar el correo");
        }
    }

}
