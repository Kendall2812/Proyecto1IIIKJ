/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaUsuario;

import NegocioVeficarDatos.verificarDatos;
import static VistaUsuario.reportesPeliculas.date;
import static VistaUsuario.reportesPeliculas.dateFormat;
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
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kendall
 */
public class reportesDiscosMusica extends javax.swing.JFrame {

    /**
     * Creates new form reportesDiscosMusica
     */
    public static JFreeChart grafica1;
    ChartPanel Panel;
    ArrayList datosReporte1 = new ArrayList();
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    String genero1;
    String cancion1, cancion2;
    String usuario;
    int maximo2, menor2;
    int indice;
    int indice2;
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date date = new Date();
    ArrayList datosPersonaArc = new ArrayList();
    ArrayList datosDiscoArc = new ArrayList();
    ArrayList usersCompr = new ArrayList();
    ArrayList<Integer> cantiDis = new ArrayList<>();
    ArrayList DiscosComp = new ArrayList();
    ArrayList<Integer> cantidadTotal = new ArrayList<>();
    ArrayList<Integer> userscanpo = new ArrayList<>();
    ArrayList totalUsers = new ArrayList<>();

    public reportesDiscosMusica() {
        initComponents();
        this.getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setTitle("Reportes Musica");
        this.pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        agregaCombo();
        combo.setVisible(false);
        dtFecha.setVisible(false);
    }

    public void grafica() {
        verificarDatos reporte1 = new verificarDatos();
        datosReporte1 = reporte1.reporte1Musica();

        if (datosReporte1.isEmpty() == false) {
            for (int x = 0; x < datosReporte1.size(); x++) {
                x = 0;
                indice = x;

                genero1 = (String) datosReporte1.get(indice);
                cancion1 = (String) datosReporte1.get(indice + 1);
                maximo2 = (int) datosReporte1.get(indice + 2);
                cancion2 = (String) datosReporte1.get(indice + 3);
                menor2 = (int) datosReporte1.get(indice + 4);

                Datos.addValue(maximo2, cancion1, genero1 + " " + "+");
                Datos.addValue(menor2, cancion2, genero1 + " " + "-");

                indice2 = datosReporte1.indexOf(genero1);
                int cont = 0;
                while (cont != 5) {
                    datosReporte1.remove(indice2);
                    cont++;
                }
            }

            grafica1 = ChartFactory.createBarChart3D("Discos Más y Menos Comprados",
                    "Generos", "Compras", Datos,
                    PlotOrientation.VERTICAL, true, true, false);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos para graficar");
        }
    }

    public void grafica2() {
        for (int j = 0; j < datosDiscoArc.size(); j++) {
            Datos.addValue(cantidadTotal.get(j), (Comparable) datosDiscoArc.get(j), (Comparable) datosDiscoArc.get(j));
        }
        grafica1 = ChartFactory.createBarChart3D("Discos Más y Menos Comprados",
                usuario, "Compras", Datos,
                PlotOrientation.VERTICAL, true, true, false);
    }

    public void mostrarEnPanel() {
        Panel = new ChartPanel(grafica1);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(Panel);
        jPanel1.validate();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void mostrarEnPanel2() {
        Panel = new ChartPanel(grafica1);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(Panel);
        jPanel1.validate();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void leerDatosMusica() {
        String linea70;
        String[] nombreDisco;
        File direccion0 = new File("archivoDiscosMusica.txt");
        try {
            FileReader leer = new FileReader(direccion0);
            BufferedReader archivo = new BufferedReader(leer);
            while ((linea70 = archivo.readLine()) != null) {
                nombreDisco = linea70.split(",");
                datosDiscoArc.add(nombreDisco[0]);
                cantidadTotal.add(0);
            }
            //System.out.println("1" + datosDiscoArc);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error a la hora de leer el la informacion del archivo");
        }
        String linea72;
        String[] nombrePersona2;
        File direccion2 = new File("archivoCompras.txt");
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
        //System.out.println("CantidadTotal" + cantidadTotal);
        //System.out.println("discosComprados" + DiscosComp);
        //System.out.println("ArcDis" + datosDiscoArc);
        for (j = 0; j < cantidadTotal.size();) {
            if (cantidadTotal.get(j).equals(0)) {
                cantidadTotal.remove(j);
                datosDiscoArc.remove(j);
                j = 0;
            } else {
                j++;
            }
        }
        //System.out.println("CantidadTotal" + cantidadTotal);
        //System.out.println("ArcDis" + datosDiscoArc);
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
        File direccion1 = new File("archivoCompras.txt");
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
            ver.validaFechaRep3Mu(fechaActual, fechaDig);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fecha deseada");
        }
    }

    public void grafica4(ArrayList datosDicos, ArrayList<Integer> CantidadTotal, String fechaDi) {
        for (int k = 0; k < datosDicos.size(); k++) {
            Datos.addValue((Number) CantidadTotal.get(k), (Comparable) datosDicos.get(k), (Comparable) datosDicos.get(k));
        }
        grafica1 = ChartFactory.createBarChart3D("Discos Más y Menos Comprados",
                fechaDi, "Compras", Datos,
                PlotOrientation.VERTICAL, true, true, false);
    }

    public void mostrarEnPanel3() {
        Panel = new ChartPanel(grafica1);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(Panel);
        jPanel1.validate();
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
        jrbMasMenosVendidos = new javax.swing.JRadioButton();
        jrbComprasPorUser = new javax.swing.JRadioButton();
        jrbPorRango = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGraficar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        dtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jrbMasMenosVendidos.setBackground(java.awt.Color.gray);
        buttonGroup1.add(jrbMasMenosVendidos);
        jrbMasMenosVendidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbMasMenosVendidos.setForeground(new java.awt.Color(255, 255, 255));
        jrbMasMenosVendidos.setText("Más vendidos y menos vendido por categoria");
        jrbMasMenosVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMasMenosVendidosActionPerformed(evt);
            }
        });

        jrbComprasPorUser.setBackground(java.awt.Color.gray);
        buttonGroup1.add(jrbComprasPorUser);
        jrbComprasPorUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbComprasPorUser.setForeground(new java.awt.Color(255, 255, 255));
        jrbComprasPorUser.setText("Más comprados por Usuario");
        jrbComprasPorUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbComprasPorUserActionPerformed(evt);
            }
        });

        jrbPorRango.setBackground(java.awt.Color.gray);
        buttonGroup1.add(jrbPorRango);
        jrbPorRango.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrbPorRango.setForeground(new java.awt.Color(255, 255, 255));
        jrbPorRango.setText("Cantidad de disco mas vendidos por rango de fecha");
        jrbPorRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorRangoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.gray);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));
        jPanel1.setPreferredSize(new java.awt.Dimension(4, 651));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Opciones");

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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbMasMenosVendidos)
                        .addGap(18, 18, 18)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)
                        .addComponent(btnGraficar)
                        .addGap(580, 580, 580)
                        .addComponent(btnRegresar))
                    .addComponent(jrbComprasPorUser)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbPorRango)
                        .addGap(173, 173, 173)
                        .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1387, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMasMenosVendidos)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGraficar)
                    .addComponent(btnRegresar))
                .addGap(7, 7, 7)
                .addComponent(jrbComprasPorUser)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbPorRango)
                    .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        if (jrbMasMenosVendidos.isSelected()) {///Se estan hacinedo Prubas con las graficas
            if (jPanel1 == null) {
                jPanel1.remove(Panel);
                jPanel1.repaint();
            } else {
                grafica();
                mostrarEnPanel();
            }
        } else if (jrbComprasPorUser.isSelected()) {
            if (jPanel1 == null) {
                jPanel1.remove(Panel);
                jPanel1.repaint();
            } else {
                if (combo.getSelectedIndex() != -1) {
                    leerDatosMusica();
                    grafica2();
                    mostrarEnPanel2();
                }
            }
        } else if (jrbPorRango.isSelected()) {
            if (jPanel1 == null) {
                jPanel1.remove(Panel);
                jPanel1.repaint();
            } else {
                try {
                    jPanel1.removeAll();
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
        // TODO add your handling code here:
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
        jPanel1.removeAll();
        if (Panel != null) {
            jPanel1.remove(Panel);
            jPanel1.repaint();
        }
    }//GEN-LAST:event_comboActionPerformed

    private void jrbMasMenosVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMasMenosVendidosActionPerformed
        // TODO add your handling code here:
        Datos.clear();
        jPanel1.removeAll();
        combo.setVisible(false);
        dtFecha.setVisible(false);
    }//GEN-LAST:event_jrbMasMenosVendidosActionPerformed

    private void jrbComprasPorUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbComprasPorUserActionPerformed
        // TODO add your handling code here:
        Datos.clear();
        jPanel1.removeAll();
        combo.setVisible(true);
        dtFecha.setVisible(false);
    }//GEN-LAST:event_jrbComprasPorUserActionPerformed

    private void jrbPorRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorRangoActionPerformed
        // TODO add your handling code here:
        Datos.clear();
        jPanel1.removeAll();
        combo.setVisible(false);
        dtFecha.setVisible(true);
    }//GEN-LAST:event_jrbPorRangoActionPerformed

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
            java.util.logging.Logger.getLogger(reportesDiscosMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportesDiscosMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportesDiscosMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportesDiscosMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reportesDiscosMusica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jrbComprasPorUser;
    private javax.swing.JRadioButton jrbMasMenosVendidos;
    private javax.swing.JRadioButton jrbPorRango;
    // End of variables declaration//GEN-END:variables
}
