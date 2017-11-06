/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import NegocioVeficarDatos.verificarDatos;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kendall
 */
public class reportesPeliculas extends javax.swing.JFrame {

    /**
     * Creates new form reportesPeliculas
     */
    public static JFreeChart grafica1;
    ChartPanel Panel1;
    ChartPanel Panel;
    ChartPanel Panel3;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
//    DefaultCategoryDataset Datos2 = new DefaultCategoryDataset();
//    DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();
    ArrayList datosReporte1Peliculas = new ArrayList();
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date = new Date();

    int numero = 0;
    String genero1, usuario;
    String cancion1, cancion2;
    int maximo2, menor2;
    int indice;
    int indice2;

    ArrayList datosPersonaArc = new ArrayList();
    ArrayList datosDiscoArc = new ArrayList();
    ArrayList usersCompr = new ArrayList();
    ArrayList<Integer> cantiDis = new ArrayList<>();
    ArrayList DiscosComp = new ArrayList();
    ArrayList<Integer> cantidadTotal = new ArrayList<>();
    ArrayList<Integer> userscanpo = new ArrayList<>();
    ArrayList totalUsers = new ArrayList<>();

    public reportesPeliculas() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setTitle("Reportes Peliculas");
        this.pack();
        agregaCombo();
        combo.setVisible(false);
        dtFecha.setVisible(false);
    }

    public void greficarMovie() {
        verificarDatos reporte1 = new verificarDatos();
        datosReporte1Peliculas = reporte1.reporte1Peliculas();
        if (datosReporte1Peliculas.isEmpty() == false) {
            for (int x = 0; x < datosReporte1Peliculas.size(); x++) {
                x = 0;
                indice = x;

                genero1 = (String) datosReporte1Peliculas.get(indice);
                cancion1 = (String) datosReporte1Peliculas.get(indice + 1);
                maximo2 = (int) datosReporte1Peliculas.get(indice + 2);
                cancion2 = (String) datosReporte1Peliculas.get(indice + 3);
                menor2 = (int) datosReporte1Peliculas.get(indice + 4);

                Datos.addValue(maximo2, cancion1, genero1 + " " + "+");
                Datos.addValue(menor2, cancion2, genero1 + " " + "-");

                indice2 = datosReporte1Peliculas.indexOf(genero1);
                int cont = 0;
                while (cont != 5) {
                    datosReporte1Peliculas.remove(indice2);
                    cont++;
                }
            }
            grafica1 = ChartFactory.createBarChart3D("Peliculas Más y Menos Comprados",
                    "Generos", "Compras", Datos,
                    PlotOrientation.VERTICAL, true, true, false);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos para graficar");
        }
    }

    public void mostrarEnPanel() {
        Panel = new ChartPanel(grafica1);
        PanelPeliculas.setLayout(new java.awt.BorderLayout());
        PanelPeliculas.add(Panel);
        PanelPeliculas.validate();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void grafica2() {
        for (int j = 0; j < datosDiscoArc.size(); j++) {
            Datos.addValue(cantidadTotal.get(j), (Comparable) datosDiscoArc.get(j), (Comparable) datosDiscoArc.get(j));
        }
        grafica1 = ChartFactory.createBarChart3D("Discos Más y Menos Comprados",
                usuario, "Compras", Datos,
                PlotOrientation.VERTICAL, true, true, false);
    }

    public void mostrarEnPanel2() {
        Panel = new ChartPanel(grafica1);
        PanelPeliculas.setLayout(new java.awt.BorderLayout());
        PanelPeliculas.add(Panel);
        PanelPeliculas.validate();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void leerDatosMusica() {
        String linea70;
        String[] nombreDisco;
        File direccion0 = new File("archivoPeliculas.txt");
        try {
            FileReader leer = new FileReader(direccion0);
            BufferedReader archivo = new BufferedReader(leer);
            while ((linea70 = archivo.readLine()) != null) {
                nombreDisco = linea70.split(",");
                datosDiscoArc.add(nombreDisco[0]);
                cantidadTotal.add(0);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        String linea72;
        String[] nombrePersona2;
        File direccion2 = new File("archivoComprasPeliculas.txt");
        try {
            FileReader leer = new FileReader(direccion2);
            BufferedReader archivo = new BufferedReader(leer);
            while ((linea72 = archivo.readLine()) != null) {
                nombrePersona2 = linea72.split(",");
                if (nombrePersona2[0].equals(usuario)) {
                    DiscosComp.add(nombrePersona2[3]);
                    cantiDis.add(Integer.parseInt(nombrePersona2[4]));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        int i = 0;
        int p = 0;
        while (p < datosDiscoArc.size()) {
            for (; i < DiscosComp.size();) {
                if (DiscosComp.get(i).equals(datosDiscoArc.get(p))) {
                    int cantidad1 = (int) cantidadTotal.get(p);
                    int cantidad2 = (int) cantiDis.get(i);
                    int cantiTo = cantidad1 + cantidad2;
                    cantidadTotal.set(p, cantiTo);
                }
                i++;
            }
            p++;
            i = 0;
        }
        int j;
        for (j = 0; j < cantidadTotal.size();) {
            if (cantidadTotal.get(j).equals(0)) {
                cantidadTotal.remove(j);
                datosDiscoArc.remove(j);
                j = 0;
            } else {
                j++;
            }
        }
    }

    public void agregaCombo() {
        String linea7;
        String[] nombrePersona;
        File direccion = new File("archivoUser.txt");
        try {
            FileReader leer = new FileReader(direccion);
            BufferedReader archivo = new BufferedReader(leer);
            while ((linea7 = archivo.readLine()) != null) {
                nombrePersona = linea7.split(" ");
                datosPersonaArc.add(nombrePersona[0]);
                totalUsers.add(0);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        String linea71;
        String[] nombrePersona1;
        File direccion1 = new File("archivoComprasPeliculas.txt");
        try {
            FileReader leer = new FileReader(direccion1);
            BufferedReader archivo = new BufferedReader(leer);
            while ((linea71 = archivo.readLine()) != null) {
                nombrePersona1 = linea71.split(",");
                usersCompr.add(nombrePersona1[0]);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }

        int i = 0;
        int p = 0;
        while (p < datosPersonaArc.size()) {
            for (; i < usersCompr.size();) {
                if (usersCompr.get(i).equals(datosPersonaArc.get(p))) {
                    int cantidad1 = (int) totalUsers.get(p);
                    int cantidad2 = 1;
                    int cantiTo = cantidad1 + cantidad2;
                    totalUsers.set(p, cantiTo);
                }
                i++;
            }
            p++;
            i = 0;
        }
        int j;
        for (j = 0; j < totalUsers.size();) {
            if (totalUsers.get(j).equals(0)) {
                totalUsers.remove(j);
                datosPersonaArc.remove(j);
                j = 0;
            } else {
                j++;
            }
        }
        for (int k = 0; k < datosPersonaArc.size(); k++) {
            combo.addItem((String) datosPersonaArc.get(k));
        }
    }

    public void validaFecha() throws ParseException {
        if (this.dtFecha.getCalendar() != null) {
            String fechaActual = dateFormat.format(date);
            Date time = this.dtFecha.getDate();
            String fechaDig = dateFormat.format(time);
            verificarDatos ver = new verificarDatos();
            ver.validaFechaRep3(fechaActual, fechaDig);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fecha deseada");
        }
    }

    public void grafica3(ArrayList datosDicos, ArrayList<Integer> CantidadTotal, String fechaDi) {
        for (int k = 0; k < datosDicos.size(); k++) {
            Datos.addValue((Number) CantidadTotal.get(k), (Comparable) datosDicos.get(k), (Comparable) datosDicos.get(k));
        }
        grafica1 = ChartFactory.createBarChart3D("Discos Más y Menos Comprados",
                fechaDi, "Compras", Datos,
                PlotOrientation.VERTICAL, true, true, false);
    }

    public void mostrarEnPanel3() {
        Panel = new ChartPanel(grafica1);
        PanelPeliculas.setLayout(new java.awt.BorderLayout());
        PanelPeliculas.add(Panel);
        PanelPeliculas.validate();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jLabel1 = new javax.swing.JLabel();
        Reporte1 = new javax.swing.JRadioButton();
        Reporte2 = new javax.swing.JRadioButton();
        Reporte3 = new javax.swing.JRadioButton();
        btnGraficar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        PanelPeliculas = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        dtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Opcionés");

        Reporte1.setBackground(java.awt.Color.gray);
        buttonGroup1.add(Reporte1);
        Reporte1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Reporte1.setForeground(new java.awt.Color(255, 255, 255));
        Reporte1.setText("Más vendidos y menos vendido por categoria");
        Reporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte1ActionPerformed(evt);
            }
        });

        Reporte2.setBackground(java.awt.Color.gray);
        buttonGroup1.add(Reporte2);
        Reporte2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Reporte2.setForeground(new java.awt.Color(255, 255, 255));
        Reporte2.setText("Más comprados por Usuario");
        Reporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte2ActionPerformed(evt);
            }
        });

        Reporte3.setBackground(java.awt.Color.gray);
        buttonGroup1.add(Reporte3);
        Reporte3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Reporte3.setForeground(new java.awt.Color(255, 255, 255));
        Reporte3.setText("Cantidad de disco mas vendidos por rango de fecha");
        Reporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte3ActionPerformed(evt);
            }
        });

        btnGraficar.setBackground(new java.awt.Color(51, 204, 0));
        btnGraficar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGraficar.setForeground(new java.awt.Color(255, 255, 255));
        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        PanelPeliculas.setBackground(java.awt.Color.gray);
        PanelPeliculas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelPeliculasLayout = new javax.swing.GroupLayout(PanelPeliculas);
        PanelPeliculas.setLayout(PanelPeliculasLayout);
        PanelPeliculasLayout.setHorizontalGroup(
            PanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelPeliculasLayout.setVerticalGroup(
            PanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Reporte2)
                            .addComponent(Reporte1))
                        .addGap(14, 14, 14)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(btnGraficar)
                        .addGap(388, 388, 388)
                        .addComponent(btnRegresar)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Reporte3)
                                .addGap(147, 147, 147)
                                .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Reporte1)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reporte2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGraficar)
                            .addComponent(btnRegresar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Reporte3)
                    .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        if (Reporte1.isSelected()) {///Se estan hacinedo Prubas con las graficas
            if (PanelPeliculas == null) {
                PanelPeliculas.remove(Panel);
                PanelPeliculas.repaint();
            } else {
                greficarMovie();
                mostrarEnPanel();
            }
        } else if (Reporte2.isSelected()) {
            if (PanelPeliculas == null) {
                PanelPeliculas.remove(Panel);
                PanelPeliculas.repaint();
            } else {
                if (combo.getSelectedIndex() != -1) {
                    leerDatosMusica();
                    grafica2();
                    mostrarEnPanel2();
                }
            }
        } else if (Reporte3.isSelected()) {
            if (PanelPeliculas == null) {
                PanelPeliculas.remove(Panel);
                PanelPeliculas.repaint();
            } else {
                try {
                    validaFecha();
                    mostrarEnPanel3();
                } catch (ParseException ex) {
                    Logger.getLogger(reportesPeliculas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una de las tres opciones");
        }
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        accesoAdminstrador acc = new accesoAdminstrador();
        acc.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
        datosDiscoArc = new ArrayList();
        usersCompr = new ArrayList();
        cantiDis = new ArrayList<>();
        DiscosComp = new ArrayList();
        cantidadTotal = new ArrayList<>();
        userscanpo = new ArrayList<>();
        totalUsers = new ArrayList<>();
        usuario = "";
        Datos.clear();
        usuario = combo.getSelectedItem().toString();
        PanelPeliculas.removeAll();
        if (Panel != null) {
            PanelPeliculas.remove(Panel);
            PanelPeliculas.repaint();
        }
    }//GEN-LAST:event_comboActionPerformed

    private void Reporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte1ActionPerformed
        // TODO add your handling code here:
        Datos.clear();
        PanelPeliculas.removeAll();
        combo.setVisible(false);
        dtFecha.setVisible(false);
    }//GEN-LAST:event_Reporte1ActionPerformed

    private void Reporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte2ActionPerformed
        // TODO add your handling code here:
        Datos.clear();
        PanelPeliculas.removeAll();
        combo.setVisible(true);
        dtFecha.setVisible(false);
    }//GEN-LAST:event_Reporte2ActionPerformed

    private void Reporte3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte3ActionPerformed
        // TODO add your handling code here:
        Datos.clear();
        PanelPeliculas.removeAll();
        combo.setVisible(false);
        dtFecha.setVisible(true);
    }//GEN-LAST:event_Reporte3ActionPerformed

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
            java.util.logging.Logger.getLogger(reportesPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportesPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportesPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportesPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reportesPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPeliculas;
    private javax.swing.JRadioButton Reporte1;
    private javax.swing.JRadioButton Reporte2;
    private javax.swing.JRadioButton Reporte3;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
