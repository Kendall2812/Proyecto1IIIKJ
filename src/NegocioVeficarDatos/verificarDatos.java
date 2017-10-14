/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NegocioVeficarDatos;

import Archivos.archivosProyecto;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kendall
 */
public class verificarDatos {

    String[] valores, datosUsuario;
    String nombre1, clave1;
    String[] datosUser;
    ArrayList Usuario = new ArrayList();
    boolean valor;

    public boolean datosAdministrador(String nombre, String Clave) {//verifica el usuario y clave del administrador
        archivosProyecto datos = new archivosProyecto();
        String datos2 = datos.datosAdmin();
        valores = datos2.split(" ");
        nombre1 = valores[0];
        clave1 = valores[1];

        if (nombre1.equals(nombre)) {
            if (clave1.equals(Clave)) {
                System.out.println("Entro a el programa");
                valor = true;
            }
        }
        return valor;
    }

    public boolean datosUsuarios(String nombre, String Clave) {//verifica el nombre y clave de los usuarios
        String temp = "";
        boolean valor1 = false;
        try {
            try (BufferedReader bf = new BufferedReader(new FileReader("archivoUser.txt"))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(" ");
                    if (nombre.equals(lista1[0]) & Clave.equals(lista1[1])) {
                        valor1 = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo" + e);
        }
        return valor1;
    }

    public void guardarInfoRegistro(String nombre, String Clave, String Cedula, String correo) { // guarda los datos de los usuarios
        archivosProyecto informacionUsuario = new archivosProyecto();
        informacionUsuario.registrosUsuarios(nombre, Clave, Cedula, correo);
    }

    public void registrarDiscoMusica(String nombreDisco, String autor, String genero, String precio, String cantidadDisponible, String cancion1, String cancion2) {

        archivosProyecto datosMusica = new archivosProyecto();
        datosMusica.registrarDiscoMusica(nombreDisco, autor, genero, precio, cantidadDisponible, cancion1, cancion2);
    }

    public void registrarPelicula() {

    }

    public void buscarArchivo(String genero, DefaultTableModel tabla) {//busca los generos en el archivo
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
            System.out.println("No se encontro el archivo" + e);
        }
    }
}
