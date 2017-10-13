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
        
        File direccion = new File("archivoUser");
        
        try{
            try(FileWriter escribir = new FileWriter(direccion,true)){
                escribir.write(nombre + " ");
                escribir.write(Clave + " ");
                escribir.write(Cedula + " ");
                escribir.write(correo + " ");
                escribir.close();
                
                JOptionPane.showMessageDialog(null, "Se registro con exito");
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error no se pudo leer el archivo" + e);
        }
    }
    public void registrarDiscoMusica(String nombreDisco, String autor, String genero, String precio, String cantidadDisponible, String cancion1, String cancion2){
        //Se crea el archivo para registrar la infomacion de los discos de musica.
        File DiscosMusica;
        try {
            DiscosMusica = new File("archivoDiscosMusica");
            if (DiscosMusica.createNewFile()) {

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
        }
        //se escribe la informacion de los discos de musica.
        File direccion = new File("archivoDiscosMusica");
        
        try{
            try(FileWriter escribir = new FileWriter(direccion,true)){
                escribir.write(nombreDisco + " ");
                escribir.write(autor + " ");
                escribir.write(genero + " ");
                escribir.write(precio + " ");
                escribir.write(cantidadDisponible + " ");
                escribir.write(cancion1 + " ");
                escribir.write(cancion2 + " ");
                escribir.close();
                
                JOptionPane.showMessageDialog(null, "Se registro con exito");
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar la informacion en el archivo" + e);
        }
    }
}
