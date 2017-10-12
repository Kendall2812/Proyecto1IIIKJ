/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kendall
 */
public class archivosProyecto {
    String[] datos1;
    String nombre2, clave2, valores;
    ArrayList datos2 = new ArrayList();
    
    public String datosAdmin(){ //Lee el archivo del administrador
        
        File administrador;
        try{
            administrador = new File("archivoAdministrador");
            if(administrador.createNewFile()){
                
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
        }
        
        File direccion = new File("archivoAdministrador");

        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo2 = new BufferedReader(leer);
            String linea6;
            while((linea6 = archivo2.readLine())!= null){
                datos1 = linea6.split(" ");
                
                for(int x = 0; x < datos1.length; x++){
                    datos2.add(datos1[x]);
                }
            }
            nombre2 = (String) datos2.get(0);
            clave2 = (String) datos2.get(1);
            valores = nombre2 +" "+ clave2;
            
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        return valores;
    }
    public String[] datosUser() { //Lee el archivo de usuario
        
        File usuarios;
        try {
            usuarios = new File("archivoUser");
            if (usuarios.createNewFile()) {

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se creo el archio" + e);
        }

        File direccion = new File("archivoUser");

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
}
