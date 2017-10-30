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
    boolean valor;
    String genero1, genero2, genero3, genero4, genero5;
    String cancion1, cancion2, cancion3;
    String cancion4, cancion5, cancion6; 
    String cancion7, cancion8, cancion9, cancion10;
    int maximo = 0;
    int menor = 0;
    int maximo2, menor2;
    int maximo3, menor3;
    int maximo4, menor4;
    int maximo5, menor5;
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
        ArrayList generos = new ArrayList();
        ArrayList geneDisco = new ArrayList();

        ArrayList clasica = new ArrayList();
        ArrayList musicClasic = new ArrayList();
        ArrayList<Integer> mayorMenorClasico = new ArrayList<Integer>();

        ArrayList musicMerengue = new ArrayList();
        ArrayList Merengue = new ArrayList();
        ArrayList<Integer> mayorMenorMerengue = new ArrayList<Integer>();

        ArrayList musicSalsa = new ArrayList();
        ArrayList Salsa = new ArrayList();
        ArrayList<Integer> mayorMenorSalsa = new ArrayList<Integer>();

        ArrayList musicPasoDoble = new ArrayList();
        ArrayList PasoDoble = new ArrayList();
        ArrayList<Integer> mayorMenorPasoDoble = new ArrayList<Integer>();

        ArrayList musicCumbia = new ArrayList();
        ArrayList Cumbia = new ArrayList();
        ArrayList<Integer> mayorMenorCumbia = new ArrayList<Integer>();

        String cancion = "";
        int cont = 0;

        archivosProyecto comprasDiscoMusica = new archivosProyecto();

        datosMusica = comprasDiscoMusica.leerDatosMusica();
        masMenoVendido = comprasDiscoMusica.leerArchivoCompraMusica1();

        for (int y = 0; y < masMenoVendido.size(); y++) {//son los nombres de los discos que estan registrados en el archivo de compras
            if (y == 3) {
                generos.add(masMenoVendido.get(y));
                y = y + 3;
                generos.add(masMenoVendido.get(y));
                y = y + 4;
            } else if (y > 3) {
                generos.add(masMenoVendido.get(y));
                y = y + 3;
                generos.add(masMenoVendido.get(y));
                y = y + 4;
            }
        }
        for (int x = 0; x < datosMusica.size(); x++) {//Son discos que estan registradas en el archivo
            geneDisco.add(datosMusica.get(x));
            x = x + 7;
        }
        //Todo esta parte es para determinar solo el genero Clasico
        for (int x = 1; x < generos.size(); x++) {
            if (generos.get(x).equals("Clasica")) {
                genero1 = "Clasica";
                for (int f = 1; f < generos.size(); f++) {
                    if (generos.get(f).equals("Clasica")) {
                        cancion = (String) generos.get(f - 1);
                        musicClasic.add(cancion);
                        f = f + 1;
                    }
                }
                for (int t = 0; t < geneDisco.size(); t++) {
                    cont = 0;
                    for (int h = 0; h < musicClasic.size(); h++) {
                        if (geneDisco.get(t).equals(musicClasic.get(h))) {
                            cont++;
                        }
                    }
                    if (cont != 0) {
                        clasica.add(cont);
                        clasica.add(geneDisco.get(t));
                    }
                }
                break;
            }
            x = x + 1;
        }
        for (int p = 0; p < clasica.size(); p++) { // este for es para sacar de la lista clasica los numeros de las veces que se repite un disco
            mayorMenorClasico.add((Integer) clasica.get(p));
            p = p + 1;
        }
        
        //esto es para determinar cual disco es el que mas se compro y cual menos se compro
        maximo = (mayorMenorClasico.stream().mapToInt(l -> l).max().getAsInt()); // se esta aplicando las expreciones Lambda
        menor = (mayorMenorClasico.stream().mapToInt(z -> z).min().getAsInt());

        System.out.print("Genero Clasico " + "Mas vendido: " + maximo + " y " + " menos vendido: " + menor + "\n");
        boolean valor1 = true;
        boolean valor2 = true;

        for (int u = 0; u < clasica.size(); u++) {
            if (clasica.get(u).equals(maximo) && valor1 == true) {
                u = u + 1;
                cancion1 = (String) clasica.get(u);
                System.out.println(cancion1);
                valor1 = false;
            } else if (clasica.get(u).equals(menor) && valor2 == true) {
                u = u + 1;
                cancion2 = (String) clasica.get(u);
                System.out.println(cancion2);
                valor2 = false;
            }
        }
        reporteMusica1.add(genero1);
        reporteMusica1.add(cancion1);
        reporteMusica1.add(maximo);
        reporteMusica1.add(cancion2);
        reporteMusica1.add(menor);

        // Esta parte es para determinar solo el generos Merengue
        for (int x = 1; x < generos.size(); x++) { // este for es para determinar el genero
            if (generos.get(x).equals("Merengue")) { // verifica el genero merengue
                for (int f = 1; f < generos.size(); f++) { // este for es para obtener solamente las canciones de este genero
                    genero2 = "Merengue";
                    if (generos.get(f).equals("Merengue")) {
                        cancion = (String) generos.get(f - 1);
                        musicMerengue.add(cancion);
                        f = f + 1;
                    }
                }
                for (int t = 0; t < geneDisco.size(); t++) { // este for es para determinar cuantas veces se repite una cancion 
                    cont = 0;
                    for (int h = 0; h < musicMerengue.size(); h++) { //este for recorrer esta lista para obtener los nombres de los disco que se compraron
                        if (geneDisco.get(t).equals(musicMerengue.get(h))) { // y aqui se obtiene el nombre del disco que esta en geneDisco y se revisa cuantas veces se compro este disco
                            cont++; // aumenta el contadaor cada vez que una cancion se repita
                        }
                    }
                    if (cont != 0) { // aqui se valida que el contador sea diferente de 0 para que se pueda escribir en la lista Clasica
                        Merengue.add(cont);
                        Merengue.add(geneDisco.get(t)); // y aqui se le agrega las veces que se repite el disco y el nombre del disco
                    }
                }
                break;
            }
            x = x + 1;
        }
        for (int p = 0; p < Merengue.size(); p++) { // este for es para sacar de la lista Merengue los numeros de las veces que se repite un disco
            mayorMenorMerengue.add((Integer) Merengue.get(p)); // y se agrega a mayorMenorMerengue
            p = p + 1;
        }
        //esto es para determinar cual disco es el que mas se compro y cual menos se compro
        maximo2 = (mayorMenorMerengue.stream().mapToInt(q -> q).max().getAsInt()); // se esta aplicando las expreciones Lambda
        menor2 = (mayorMenorMerengue.stream().mapToInt(a -> a).min().getAsInt());

        System.out.print("Genero Merengue " + "Mas vendido: " + maximo2 + " y " + " menos vendido: " + menor2 + "\n");
        boolean valor3 = true;
        boolean valor4 = true;

        for (int u = 0; u < Merengue.size(); u++) { // este for es para verificar aquien le pertene el numero para asi poder obtener el nombre del disco
            if (Merengue.get(u).equals(maximo2) && valor3 == true) {
                u = u + 1;
                cancion3 = (String) Merengue.get(u);
                System.out.println(cancion3);
                valor3 = false;
            } else if (Merengue.get(u).equals(menor2) && valor4 == true) {
                u = u + 1;
                cancion4 = (String) Merengue.get(u);
                System.out.println(cancion4);
                valor4 = false;
            }
        }
        reporteMusica1.add(genero2);
        reporteMusica1.add(cancion3);
        reporteMusica1.add(maximo2);
        reporteMusica1.add(cancion4);
        reporteMusica1.add(menor2);
        
        // Esta parte es para determinar solo el generos Salsa
        for (int x = 1; x < generos.size(); x++) { // este for es para determinar el genero
            if (generos.get(x).equals("Salsa")) { // verifica el genero merengue
                for (int f = 1; f < generos.size(); f++) { // este for es para obtener solamente las canciones de este genero
                    genero3 = "Salsa";
                    if (generos.get(f).equals("Salsa")) {
                        cancion = (String) generos.get(f - 1);
                        musicSalsa.add(cancion);
                        f = f + 1;
                    }
                }
                for (int t = 0; t < geneDisco.size(); t++) { // este for es para determinar cuantas veces se repite una cancion 
                    cont = 0;
                    for (int h = 0; h < musicSalsa.size(); h++) { //este for recorrer esta lista para obtener los nombres de los disco que se compraron
                        if (geneDisco.get(t).equals(musicSalsa.get(h))) { // y aqui se obtiene el nombre del disco que esta en geneDisco y se revisa cuantas veces se compro este disco
                            cont++; // aumenta el contadaor cada vez que una cancion se repita
                        }
                    }
                    if (cont != 0) { // aqui se valida que el contador sea diferente de 0 para que se pueda escribir en la lista Clasica
                        Salsa.add(cont);
                        Salsa.add(geneDisco.get(t)); // y aqui se le agrega las veces que se repite el disco y el nombre del disco
                    }
                }
                break;
            }
            x = x + 1;
        }
        for (int p = 0; p < Salsa.size(); p++) { // este for es para sacar de la lista Salsa los numeros de las veces que se repite un disco
            mayorMenorSalsa.add((Integer) Salsa.get(p)); // y se agrega a mayorMenorSalsa
            p = p + 1;
        }
        //esto es para determinar cual disco es el que mas se compro y cual menos se compro
        maximo3 = (mayorMenorSalsa.stream().mapToInt(q -> q).max().getAsInt()); // se esta aplicando las expreciones Lambda
        menor3 = (mayorMenorSalsa.stream().mapToInt(a -> a).min().getAsInt());

        System.out.print("Genero Salsa " + "Mas vendido: " + maximo3 + " y " + " menos vendido: " + menor3 + "\n");
        boolean valor5 = true;
        boolean valor6 = true;

        for (int u = 0; u < Salsa.size(); u++) { // este for es para verificar aquien le pertene el numero para asi poder obtener el nombre del disco
            if (Salsa.get(u).equals(maximo3) && valor5 == true) {
                u = u + 1;
                cancion5 = (String) Salsa.get(u);
                System.out.println(cancion5);
                valor5 = false;
            } else if (Salsa.get(u).equals(menor3) && valor6 == true) {
                u = u + 1;
                cancion6 = (String) Salsa.get(u);
                System.out.println(cancion6);
                valor6 = false;
            }
        }
        reporteMusica1.add(genero3);
        reporteMusica1.add(cancion5);
        reporteMusica1.add(maximo3);
        reporteMusica1.add(cancion6);
        reporteMusica1.add(menor3);
        

        // Esta parte es para determinar solo el genero PasoDoble
        for (int x = 1; x < generos.size(); x++) { // este for es para determinar el genero
            if (generos.get(x).equals("PasoDoble")) { // verifica el genero merengue
                for (int f = 1; f < generos.size(); f++) { // este for es para obtener solamente las canciones de este genero
                    genero4 = "PasoDoble";
                    if (generos.get(f).equals("PasoDoble")) {
                        cancion = (String) generos.get(f - 1);
                        musicPasoDoble.add(cancion);
                        f = f + 1;
                    }
                }
                for (int t = 0; t < geneDisco.size(); t++) { // este for es para determinar cuantas veces se repite una cancion 
                    cont = 0;
                    for (int h = 0; h < musicPasoDoble.size(); h++) { //este for recorrer esta lista para obtener los nombres de los disco que se compraron
                        if (geneDisco.get(t).equals(musicPasoDoble.get(h))) { // y aqui se obtiene el nombre del disco que esta en geneDisco y se revisa cuantas veces se compro este disco
                            cont++; // aumenta el contadaor cada vez que una cancion se repita
                        }
                    }
                    if (cont != 0) { // aqui se valida que el contador sea diferente de 0 para que se pueda escribir en la lista Clasica
                        PasoDoble.add(cont);
                        PasoDoble.add(geneDisco.get(t)); // y aqui se le agrega las veces que se repite el disco y el nombre del disco
                    }
                }
                break;
            }
            x = x + 1;
        }
        for (int p = 0; p < PasoDoble.size(); p++) { // este for es para sacar de la lista PasoDoble los numeros de las veces que se repite un disco
            mayorMenorPasoDoble.add((Integer) PasoDoble.get(p)); // y se agrega a mayorMenorPasoDoble
            p = p + 1;
        }
        //esto es para determinar cual disco es el que mas se compro y cual menos se compro
        maximo4 = (mayorMenorPasoDoble.stream().mapToInt(q -> q).max().getAsInt()); // se esta aplicando las expreciones Lambda
        menor4 = (mayorMenorPasoDoble.stream().mapToInt(a -> a).min().getAsInt());

        System.out.print("Genero PasoDoble " + "Mas vendido: " + maximo4 + " y " + " menos vendido: " + menor4 + "\n");
        boolean valor7 = true;
        boolean valor8 = true;

        for (int u = 0; u < PasoDoble.size(); u++) { // este for es para verificar aquien le pertene el numero para asi poder obtener el nombre del disco
            if (PasoDoble.get(u).equals(maximo4) && valor7 == true) {
                u = u + 1;
                cancion7 = (String) PasoDoble.get(u);
                System.out.println(cancion7);
                valor7 = false;
            } else if (PasoDoble.get(u).equals(menor4) && valor8 == true) {
                u = u + 1;
                cancion8 = (String) PasoDoble.get(u);
                System.out.println(cancion8);
                valor8 = false;
            }
        }
        reporteMusica1.add(genero4);
        reporteMusica1.add(cancion7);
        reporteMusica1.add(maximo4);
        reporteMusica1.add(cancion8);
        reporteMusica1.add(menor4);
        
        // Esta parte es para determinar solo el genero Cumbia
        for (int x = 1; x < generos.size(); x++) { // este for es para determinar el genero
            if (generos.get(x).equals("Cumbia")) { // verifica el genero merengue
                genero5 = "Cumbia";
                for (int f = 1; f < generos.size(); f++) { // este for es para obtener solamente las canciones de este genero
                    if (generos.get(f).equals("Cumbia")) {
                        cancion = (String) generos.get(f - 1);
                        musicCumbia.add(cancion);
                        f = f + 1;
                    }
                }
                for (int t = 0; t < geneDisco.size(); t++) { // este for es para determinar cuantas veces se repite una cancion 
                    cont = 0;
                    for (int h = 0; h < musicCumbia.size(); h++) { //este for recorrer esta lista para obtener los nombres de los disco que se compraron
                        if (geneDisco.get(t).equals(musicCumbia.get(h))) { // y aqui se obtiene el nombre del disco que esta en geneDisco y se revisa cuantas veces se compro este disco
                            cont++; // aumenta el contadaor cada vez que una cancion se repita
                        }
                    }
                    if (cont != 0) { // aqui se valida que el contador sea diferente de 0 para que se pueda escribir en la lista Clasica
                        Cumbia.add(cont);
                        Cumbia.add(geneDisco.get(t)); // y aqui se le agrega las veces que se repite el disco y el nombre del disco
                    }
                }
                break;
            }
            x = x + 1;
        }
        for (int p = 0; p < Cumbia.size(); p++) { // este for es para sacar de la lista PasoDoble los numeros de las veces que se repite un disco
            mayorMenorCumbia.add((Integer) Cumbia.get(p)); // y se agrega a mayorMenorPasoDoble
            p = p + 1;
        }
        //esto es para determinar cual disco es el que mas se compro y cual menos se compro
        maximo5 = (mayorMenorCumbia.stream().mapToInt(q -> q).max().getAsInt()); // se esta aplicando las expreciones Lambda
        menor5 = (mayorMenorCumbia.stream().mapToInt(a -> a).min().getAsInt());

        System.out.print("Genero Cumbia " + "Mas vendido: " + maximo5 + " y " + " menos vendido: " + menor5 + "\n");
        boolean valor9 = true;
        boolean valor10 = true;

        for (int u = 0; u < Cumbia.size(); u++) { // este for es para verificar aquien le pertene el numero para asi poder obtener el nombre del disco
            if (Cumbia.get(u).equals(maximo5) && valor9 == true) {
                u = u + 1;
                cancion9 = (String) Cumbia.get(u);
                System.out.println(cancion9);
                valor9 = false;
            } else if (Cumbia.get(u).equals(menor5) && valor10 == true) {
                u = u + 1;
                cancion10 = (String) Cumbia.get(u);
                System.out.println(cancion10);
                valor10 = false;
            }
        }
        reporteMusica1.add(genero5);
        reporteMusica1.add(cancion9);
        reporteMusica1.add(maximo5);
        reporteMusica1.add(cancion10);
        reporteMusica1.add(menor5);
        
        return reporteMusica1;
    }
    public ArrayList reporte1Pelicualas(){
        
        
        
        
        
        
        
        
        
        return null;
    }
}
