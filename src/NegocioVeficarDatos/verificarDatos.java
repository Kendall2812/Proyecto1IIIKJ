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
    ArrayList reporteMusica1 = new ArrayList();
    ArrayList reportePelicula1 = new ArrayList();
    boolean valor;
    String genero1, genero2, genero3, genero4, genero5;
    String cancion1, cancion2, cancion3;
    String cancion4, cancion5, cancion6; 
    String cancion7, cancion8, cancion9, cancion10;
    String pelicula1, pelicula2;
    String cancion11, cancion12;
    int maximo = 0;
    int menor = 0;
    int maximo2, menor2;
    int maximo3, menor3;
    int maximo4, menor4;
    int maximo5, menor5;
    int maximo6 = 0, menor6 = 0;
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
    public void controlCompras(String nombre, String precio, String cantidad,String nameUser,String verificar,String genero){
        archivosProyecto compras = new archivosProyecto();
        compras.guardarCompras(nombre, precio, cantidad, nameUser,verificar,genero);
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
    public ArrayList reporte1Musica() {
        //Merengue,Clasica,Salsa,PasoDoble,Cumbia  
        ArrayList masMenoVendido = new ArrayList();
        ArrayList datosMusica = new ArrayList();
        ArrayList nombreDisco = new ArrayList();
        ArrayList DatosMusica = new ArrayList();
        ArrayList Musica = new ArrayList();
        ArrayList Generos = new ArrayList();
        ArrayList<Integer> maximoMinimo = new ArrayList<Integer>();
        
        String nameMovie = "";
        String genero = "";

        String nombreMovie = "";
        int cantidadComprada = 0;
        boolean entro1 = false;
        String generoMusic = "";
        int borrarGenero = 0;

        boolean valor10 = true;
        boolean valor11 = true;
        boolean valor12 = false;

        archivosProyecto comprasMusica = new archivosProyecto();

        masMenoVendido = comprasMusica.leerArchivoCompraMusica1();
        datosMusica = comprasMusica.leerDatosMusica();

        for (int x = 0; x < masMenoVendido.size(); x++) {
            if (x == 3) {
                nombreDisco.add(masMenoVendido.get(x));
                x = x + 1;
                nombreDisco.add(masMenoVendido.get(x));
                x = x + 6;
            } else if (x > 3) {
                nombreDisco.add(masMenoVendido.get(x));
                x = x + 1;
                nombreDisco.add(masMenoVendido.get(x));
                x = x + 6;
            }
        }

        for (int x = 0; x < datosMusica.size(); x++) {//Son discos que el administrador registra
            DatosMusica.add(datosMusica.get(x));
            x = x + 2;
            DatosMusica.add(datosMusica.get(x));
            x = x + 5;
        }
        int contador = 0;
        String numero = "";
        int sumador = 0;
        for (int v = 0; v < DatosMusica.size(); v++) {
            contador = 0;
            for (int h = 0; h < nombreDisco.size(); h++) {
                if (DatosMusica.get(v).equals(nombreDisco.get(h))) { // esta comparando los nombres  de los discos
                    nameMovie = (String) DatosMusica.get(v); /// nombre pelicula
                    v = v + 1;
                    genero = (String) DatosMusica.get(v); // genero pelicula
                    v = v - 1;

                    h = h + 1;
                    numero = (String) nombreDisco.get(h); // cantidad que fue comprada esta pelicula
                    sumador = Integer.parseInt(numero);

                    contador = contador + sumador;
                    h = h - 1;
                }
            }
            if (contador != 0) {
                Musica.add(genero);
                Musica.add(contador);
                Musica.add(nameMovie);
                valor12 = true;
            }
            contador = 0;
            v = v + 1;
        }
        
        if (valor12 == true) {
            for (int r = 0; r < Musica.size(); r++) {
                for (int w = 0; w < Musica.size(); w++) {
                    if (Musica.get(r).equals(Musica.get(w))) {

                        for (int t = 0; t < Musica.size(); t++) {
                            if (Musica.get(t).equals(Musica.get(r))) {
                                generoMusic = (String) Musica.get(t); // captura el genero del pelicula
                                t = t + 1;
                                cantidadComprada = (int) Musica.get(t);// captura la cantidad que fue comprada de la pelicula
                                t = t + 1;
                                nombreMovie = (String) Musica.get(t); // captura el nombre de la pelicula

                                Generos.add(cantidadComprada);
                                Generos.add(nombreMovie);
                            }
                        }
                        for (int f = 0; f < Musica.size(); f++) { // este for es para eliminar las peliculas que ya estan agregadas a la lista Generos para que no genere errores

                            if (entro1 == true) {
                                f = 0;
                                entro1 = false;
                            }
                            if (Musica.get(f).equals(generoMusic)) {
                                borrarGenero = Musica.indexOf(generoMusic);
                                Musica.remove(borrarGenero);
                                Musica.remove(borrarGenero);
                                Musica.remove(borrarGenero);
                                entro1 = true;
                            }
                        }
                        if (Generos.isEmpty() == false) {

                            for (int c = 0; c < Generos.size(); c++) { //aparta los numero de los nombre de los discos para agregarlos a otra lista
                                maximoMinimo.add((Integer) Generos.get(c));
                                c = c + 1;
                            }
                            int cantidad = maximoMinimo.size();

                            if (cantidad == 1) {

                                maximo6 = (maximoMinimo.stream().mapToInt(p -> p).max().getAsInt()); // se esta aplicando las expreciones Lambda
                                menor6 = 0;

                                for (int u = 0; u < Generos.size(); u++) { // este for es para verificar aquien le pertene el numero para asi poder obtener el nombre del disco
                                    if (Generos.get(u).equals(maximo6) && valor11 == true) {
                                        u = u + 1;
                                        cancion11 = (String) Generos.get(u);
                                        System.out.println(cancion11);
                                        valor11 = false;
                                    }
                                }
                                cancion12 = "null";

                                reporteMusica1.add(generoMusic);
                                reporteMusica1.add(cancion11);
                                reporteMusica1.add(maximo6);
                                reporteMusica1.add(cancion12);
                                reporteMusica1.add(menor6);
                            } else {
                                maximo6 = (maximoMinimo.stream().mapToInt(p -> p).max().getAsInt()); // se esta aplicando las expreciones Lambda
                                menor6 = (maximoMinimo.stream().mapToInt(a -> a).min().getAsInt());

                                for (int u = 0; u < Generos.size(); u++) {
                                    if (Generos.get(u).equals(maximo6) && valor10 == true) {
                                        u = u + 1;
                                        cancion11 = (String) Generos.get(u);
                                        System.out.println(cancion11);
                                        valor10 = false;
                                    } else if (Generos.get(u).equals(menor6) && valor11 == true) {
                                        u = u + 1;
                                        cancion12 = (String) Generos.get(u);
                                        System.out.println(cancion12);
                                        valor11 = false;
                                    }
                                }
                                reporteMusica1.add(generoMusic);
                                reporteMusica1.add(cancion11);
                                reporteMusica1.add(maximo6);
                                reporteMusica1.add(cancion12);
                                reporteMusica1.add(menor6);
                            }

                            cancion11 = "";
                            cancion12 = "";
                            Generos.clear();
                            maximoMinimo.clear();
                            valor11 = true;
                            valor10 = true;
                        }
                    }
                    w = 0 - 1; // se le resta a 0 para que la lista arranque desde 0 y pueda verificar ese campo de la lista
                }
                r = r + 2;
            }
        }
        return reporteMusica1;
    }

    public ArrayList reporte1Peliculas(){
        ArrayList masMenoVendido = new ArrayList();
        ArrayList datosPelicula = new ArrayList();
        ArrayList nombrePelicula = new ArrayList();
        ArrayList DatosPelicula = new ArrayList();
        ArrayList Peliculas = new ArrayList();
        ArrayList Generos = new ArrayList();
        ArrayList<Integer> maximoMinimo = new ArrayList<Integer>();

        String nameMovie = "";
        String genero = "";

        String nombreMovie = "";
        int cantidadComprada = 0;
        boolean entro1 = false;
        String generoPeli = "";
        int borrarGenero = 0;

        boolean valor10 = true;
        boolean valor11 = true;
        boolean valor12 = false;

        archivosProyecto comprasPelicula = new archivosProyecto();

        masMenoVendido = comprasPelicula.leerArchivoCompraPelicula1();
        datosPelicula = comprasPelicula.leerDatosPeliculas();

        for (int x = 0; x < masMenoVendido.size(); x++) {
            if (x == 3) {
                nombrePelicula.add(masMenoVendido.get(x));
                x = x + 1;
                nombrePelicula.add(masMenoVendido.get(x));
                x = x + 5;
            } else if (x > 3) {
                nombrePelicula.add(masMenoVendido.get(x));
                x = x + 1;
                nombrePelicula.add(masMenoVendido.get(x));
                x = x + 5;
            }
        }

        for (int x = 0; x < datosPelicula.size(); x++) {//Son discos que estan registradas en el archivo
            DatosPelicula.add(datosPelicula.get(x));
            x = x + 2;
            DatosPelicula.add(datosPelicula.get(x));
            x = x + 3;
        }
        int contador = 0;
        String numero = "";
        int sumador = 0;
        for (int v = 0; v < DatosPelicula.size(); v++) {
            contador = 0;
            for (int h = 0; h < nombrePelicula.size(); h++) {
                if (DatosPelicula.get(v).equals(nombrePelicula.get(h))) {
                    nameMovie = (String) DatosPelicula.get(v); /// nombre pelicula
                    v = v + 1;
                    genero = (String) DatosPelicula.get(v); // genero pelicula
                    v = v - 1;

                    h = h + 1;
                    numero = (String) nombrePelicula.get(h); // cantidad que fue comprada esta pelicula
                    sumador = Integer.parseInt(numero);

                    contador = contador + sumador;
                    h = h - 1;
                }
            }
            if (contador != 0) {
                Peliculas.add(genero);
                Peliculas.add(contador);
                Peliculas.add(nameMovie);
                valor12 = true;
            }
            contador = 0;
            v = v + 1;
        }
        
        if (valor12 == true) {
            for (int r = 0; r < Peliculas.size(); r++) {
                for (int w = 0; w < Peliculas.size(); w++) {
                    if (Peliculas.get(r).equals(Peliculas.get(w))) {

                        for (int t = 0; t < Peliculas.size(); t++) {
                            if (Peliculas.get(t).equals(Peliculas.get(r))) {
                                generoPeli = (String) Peliculas.get(t); // captura el genero del pelicula
                                t = t + 1;
                                cantidadComprada = (int) Peliculas.get(t);// captura la cantidad que fue comprada de la pelicula
                                t = t + 1;
                                nombreMovie = (String) Peliculas.get(t); // captura el nombre de la pelicula

                                Generos.add(cantidadComprada);
                                Generos.add(nombreMovie);
                            }
                        }
                        for (int f = 0; f < Peliculas.size(); f++) { // este for es para eliminar las peliculas que ya estan agregadas a la lista Generos para que no genere errores

                            if (entro1 == true) {
                                f = 0;
                                entro1 = false;
                            }
                            if (Peliculas.get(f).equals(generoPeli)) {
                                borrarGenero = Peliculas.indexOf(generoPeli);
                                Peliculas.remove(borrarGenero);
                                Peliculas.remove(borrarGenero);
                                Peliculas.remove(borrarGenero);
                                entro1 = true;
                            }
                        }
                        if (Generos.isEmpty() == false) {

                            for (int c = 0; c < Generos.size(); c++) { //aparta los numero de los nombre de los discos para agregarlos a otra lista
                                maximoMinimo.add((Integer) Generos.get(c));
                                c = c + 1;
                            }
                            int cantidad = maximoMinimo.size();

                            if (cantidad == 1) {

                                maximo6 = (maximoMinimo.stream().mapToInt(p -> p).max().getAsInt()); // se esta aplicando las expreciones Lambda
                                menor6 = 0;

                                for (int u = 0; u < Generos.size(); u++) { // este for es para verificar aquien le pertene el numero para asi poder obtener el nombre del disco
                                    if (Generos.get(u).equals(maximo6) && valor11 == true) {
                                        u = u + 1;
                                        pelicula1 = (String) Generos.get(u);
                                        System.out.println(pelicula1);
                                        valor11 = false;
                                    }
                                }
                                pelicula2 = "null";

                                reportePelicula1.add(generoPeli);
                                reportePelicula1.add(pelicula1);
                                reportePelicula1.add(maximo6);
                                reportePelicula1.add(pelicula2);
                                reportePelicula1.add(menor6);
                            } else {
                                maximo6 = (maximoMinimo.stream().mapToInt(p -> p).max().getAsInt()); // se esta aplicando las expreciones Lambda
                                menor6 = (maximoMinimo.stream().mapToInt(a -> a).min().getAsInt());

                                for (int u = 0; u < Generos.size(); u++) {
                                    if (Generos.get(u).equals(maximo6) && valor10 == true) {
                                        u = u + 1;
                                        pelicula1 = (String) Generos.get(u);
                                        System.out.println(pelicula1);
                                        valor10 = false;
                                    } else if (Generos.get(u).equals(menor6) && valor11 == true) {
                                        u = u + 1;
                                        pelicula2 = (String) Generos.get(u);
                                        System.out.println(pelicula2);
                                        valor11 = false;
                                    }
                                }
                                reportePelicula1.add(generoPeli);
                                reportePelicula1.add(pelicula1);
                                reportePelicula1.add(maximo6);
                                reportePelicula1.add(pelicula2);
                                reportePelicula1.add(menor6);
                            }

                            pelicula1 = "";
                            pelicula2 = "";
                            Generos.clear();
                            maximoMinimo.clear();
                            valor11 = true;
                            valor10 = true;
                        }
                    }
                    w = 0 - 1; // se le resta a 0 para que la lista arranque desde 0 y pueda verificar ese campo de la lista
                }
                r = r + 2;
            }
        }
        return reportePelicula1;
    }
}
