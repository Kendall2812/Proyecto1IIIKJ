/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NegocioVeficarDatos;

import Archivos.archivosProyecto;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import NegocioVeficarDatos.Controlador;
//import NegocioVeficarDatos.Correo;

/**
 *
 * @author Kendall
 */

public class verificarDatos {

    String[] valores, datosUsuario;
    String nombre1, clave1;
    String[] datosUser;
    ArrayList Usuario = new ArrayList();
    ArrayList datosDisco = new ArrayList();
    boolean valor;
    Correo c = new Correo();

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
        archivosProyecto user = new archivosProyecto();
        ArrayList Usuario = new ArrayList();
        Usuario = user.datosUser();
        
        for(int x = 0; x < Usuario.size(); x = x+4){
            if(Usuario.get(x).equals(nombre)){
                x = x + 1;
                if(Usuario.get(x).equals(Clave)){
                    valor1 = true;
                    break;
                }
            }
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

    public void registrarPelicula(String nombre, String autor, String categoria, String precio, String cantidad) {
        archivosProyecto registroPelicula = new archivosProyecto();
        registroPelicula.registrarPeliculas(nombre, autor, categoria, precio, cantidad);
    }

    public void buscarArchivo(String genero, DefaultTableModel tabla, boolean bus) {//busca los generos en el archivo
        archivosProyecto buscarInfo = new archivosProyecto();
        buscarInfo.buscarGeneroMusicaPelicual(genero, (DefaultTableModel) tabla, bus);   
    }
    public ArrayList editarMusica(){
        ArrayList nombre = new ArrayList();
        archivosProyecto buscarNombreDisco = new archivosProyecto();
        datosDisco = buscarNombreDisco.leerDatosMusica();
        return datosDisco;
    }
    public void guardarMusicaEdidata(ArrayList datosNuevos){
        archivosProyecto guardar = new archivosProyecto();
        guardar.editarInfoMusica(datosNuevos,true);
    }
    public void eliminarDisco(ArrayList datosEliminar){
        archivosProyecto eliminar = new archivosProyecto();
        eliminar.eliminarInfoMusica(datosEliminar);
    }
    public ArrayList eidtarPeliculas(){
        ArrayList datosPelicula = new ArrayList();
        archivosProyecto buscarNombrePelicula = new archivosProyecto();
        datosPelicula = buscarNombrePelicula.leerDatosPeliculas();
        return datosPelicula;
    }
    public void guardarPeliculaEditada(ArrayList datosMovieNuevos){
        archivosProyecto guardar = new archivosProyecto();
        guardar.guardarInfoPelicEditada(datosMovieNuevos,true);
    }
    public void eliminarPelicula(ArrayList elimarDateMovie){
        archivosProyecto eliminarMovie = new archivosProyecto();
        eliminarMovie.eliminarPelicula(elimarDateMovie);
    }
    public void controlCompras(String nombre, String precio, String cantidad,String nameUser,String verificar){
        archivosProyecto compras = new archivosProyecto();
        compras.guardarCompras(nombre, precio, cantidad, nameUser,verificar);
    }
    public void registrarPreCompra(String usuario,String nombreArticulo,String cantida,String total,String genero){
        archivosProyecto precompra = new archivosProyecto();
        precompra.registrarPreCompra2(usuario, nombreArticulo, cantida, total, genero);
    }
    
    public void enviarCorreo2(String usuario, String mensaje, String asunt) { // enviar Correo
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
