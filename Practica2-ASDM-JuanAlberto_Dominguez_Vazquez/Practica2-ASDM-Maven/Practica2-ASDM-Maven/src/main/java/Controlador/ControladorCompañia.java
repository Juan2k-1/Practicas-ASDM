/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.VueloCompañiaTablas;
import Vista.VistaCompañia;
import Vista.VistaVuelosCompañia;
import Vista.VistaPorDefecto;
import Modelo.Vuelo;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author juald
 */
public class ControladorCompañia implements ActionListener {

    private VistaCompañia vCompañia = null;
    private VistaPorDefecto vPorDefecto = null;
    private VistaVuelosCompañia vVueloCompañia = null;

    private VueloCompañiaTablas vTablas;
    private String compañia;
    private ControladorVuelosCompañia controladorVuelosCompañia;

    public ControladorCompañia(String compañia) {
        this.vCompañia = new VistaCompañia();
        this.vPorDefecto = new VistaPorDefecto();
        this.vVueloCompañia = new VistaVuelosCompañia();
        this.vTablas = new VueloCompañiaTablas(vVueloCompañia);
        this.compañia = compañia;

        addListeners();

        this.vCompañia.setLayout(new CardLayout());
        this.vCompañia.add(vPorDefecto);
        this.vCompañia.add(vVueloCompañia);
        this.vPorDefecto.setVisible(true);
        this.vCompañia.setVisible(false);

        this.vCompañia.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vCompañia.setVisible(true); // Para hacer la ventana visible
        this.vCompañia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Gestiondevuelos": {
                this.controladorVuelosCompañia = new ControladorVuelosCompañia(this.vVueloCompañia, this.vTablas, this.compañia);
                this.vPorDefecto.setVisible(false);
                this.vVueloCompañia.setVisible(true);
                this.vVueloCompañia.TablaVuelos.setModel(vTablas);
                DiseñoTablaVuelosCompañia();
                pideVuelosCompañia();
                break;
            }
            case "Salir de la aplicación": {
                this.vCompañia.dispose();
                System.exit(0);
                break;
            }
        }
    }

    private void addListeners() {
        this.vCompañia.GestionDeVuelos.addActionListener(this);
        this.vCompañia.jMenuItem1.addActionListener(this);
    }

    private void DiseñoTablaVuelosCompañia() {
        //Para no permitir el redimensionamiento de las columnas con el ratón
        vVueloCompañia.TablaVuelos.getTableHeader().setResizingAllowed(false);
        vVueloCompañia.TablaVuelos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(0).setPreferredWidth(350);
        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(1).setPreferredWidth(350);
        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(2).setPreferredWidth(350);
        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(3).setPreferredWidth(350);
        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(4).setPreferredWidth(350);
        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(5).setPreferredWidth(350);
        vVueloCompañia.TablaVuelos.getColumnModel().getColumn(6).setPreferredWidth(350);
    }

    private void pideVuelosCompañia() {
        ArrayList<Vuelo> vuelos = this.listaVuelos();
        this.vTablas.vaciarTablaVuelos();
        this.vTablas.rellenarTablaVuelos(vuelos);
    }

    public ArrayList<Vuelo> listaVuelos() {
        return this.controladorVuelosCompañia.getVuelos();
    }
}
