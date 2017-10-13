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

/**
 *
 * @author Kendall
 */
public class verificarDatos {    
   String[]valores, datosUsuario;
   String nombre1, clave1;
   String[] datosUser;
   ArrayList Usuario = new ArrayList();
   boolean valor;
    public boolean datosAdministrador(String nombre, String Clave){//verifica el usuario y clave del administrador
        archivosProyecto datos = new archivosProyecto();
        String datos2 = datos.datosAdmin();
        valores = datos2.split(" ");
        nombre1 = valores[0];
        clave1 = valores[1];
        
        if(nombre1.equals(nombre)){
            if(clave1.equals(Clave)){
                System.out.println("Entro a el programa");
                valor = true;
            }
        }
        return valor;
    }
    public boolean datosUsuarios(String nombre, String Clave){//verifica el nombre y clave de los usuarios
        archivosProyecto datos = new archivosProyecto();
        datosUser = datos.datosUser();

        for (int x = 0; x < datosUser.length; x++) {
            Usuario.add(datosUser[x]);
        }
        for (int y = 0; y < Usuario.size(); y = y+4) {
            if (nombre.equals(Usuario.get(y))) {
                y = y + 1;
                if (Clave.equals(Usuario.get(y))) {
                    valor = true;
                    break;
                }
            }
        }
        return valor;
    }
    public void guardarInfoRegistro(String nombre, String Clave, String Cedula, String correo){ // guarda los datos de los usuarios
        archivosProyecto informacionUsuario = new archivosProyecto();
        informacionUsuario.registrosUsuarios(nombre, Clave, Cedula, correo);
    }
    public void registrarDiscoMusica(String nombreDisco, String autor, String genero, String precio, String cantidadDisponible, String cancion1, String cancion2){
        
        archivosProyecto datosMusica = new archivosProyecto();
        datosMusica.registrarDiscoMusica(nombreDisco,autor,genero,precio,cantidadDisponible,cancion1,cancion2);
    }
    public void registrarPelicula(){
        
    }
}
