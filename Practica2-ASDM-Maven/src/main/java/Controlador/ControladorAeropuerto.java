/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaPrincipal;
import Modelo.VueloTablas;
import Vista.VistaLogin;
import Vista.VistaPorDefecto;
import Vista.VistaVuelos;
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
public class ControladorAeropuerto implements ActionListener {

    private VistaPrincipal vPrincipal = null;
    private VistaPorDefecto vPorDefecto = null;
    private VistaVuelos vVuelos = null;
    private static VistaLogin vLogin = null;

    private VueloTablas vTablas;
    private ControladorVuelos ControladorVuelos;
    private static final ControladorAeropuerto control = new ControladorAeropuerto(vLogin);

    private ControladorAeropuerto(VistaLogin vLogin) {
        this.vPrincipal = new VistaPrincipal();
        this.vVuelos = new VistaVuelos();
        this.vPorDefecto = new VistaPorDefecto();
        this.vTablas = new VueloTablas(vVuelos);
        ControladorAeropuerto.vLogin = vLogin;

        addListeners();

        this.vPrincipal.setLayout(new CardLayout());

        this.vPrincipal.add(vPorDefecto);
        this.vPrincipal.add(vVuelos);
        this.vPorDefecto.setVisible(true);
        this.vVuelos.setVisible(false);

        this.vPrincipal.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
    }

    /**
     *
     * @return
     */
    public static ControladorAeropuerto obtenerControl() {
        return control;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "GestionVuelos": {
                this.ControladorVuelos = new ControladorVuelos(this.vVuelos, this.vTablas);
                this.vPorDefecto.setVisible(false);
                this.vVuelos.setVisible(true);
                this.vVuelos.TablaVuelos.setModel(vTablas);
                DiseñoTablaVuelos();
                pideVuelos();
                break;
            }
            case "Salir de la aplicación": {
                this.vPrincipal.dispose();
                System.exit(0);
                break;
            }
        }
    }

    private void addListeners() {
        this.vPrincipal.GestionVuelos.addActionListener(this);
        this.vPrincipal.salirDeLaAplicacion.addActionListener(this);
    }

    private void DiseñoTablaVuelos() {
        //Para no permitir el redimensionamiento de las columnas con el ratón
        vVuelos.TablaVuelos.getTableHeader().setResizingAllowed(false);
        vVuelos.TablaVuelos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vVuelos.TablaVuelos.getColumnModel().getColumn(0).setPreferredWidth(350);
        vVuelos.TablaVuelos.getColumnModel().getColumn(1).setPreferredWidth(350);
        vVuelos.TablaVuelos.getColumnModel().getColumn(2).setPreferredWidth(350);
        vVuelos.TablaVuelos.getColumnModel().getColumn(3).setPreferredWidth(350);
        vVuelos.TablaVuelos.getColumnModel().getColumn(4).setPreferredWidth(350);
        vVuelos.TablaVuelos.getColumnModel().getColumn(5).setPreferredWidth(350);
        vVuelos.TablaVuelos.getColumnModel().getColumn(6).setPreferredWidth(350);
    }

    private void pideVuelos() {
        ArrayList<Vuelo> vuelos = this.listaVuelos();
        this.vTablas.vaciarTablaVuelos();
        this.vTablas.rellenarTablaVuelos(vuelos);
    }

    public ArrayList<Vuelo> listaVuelos() {
        return this.ControladorVuelos.getVuelos();
    }
}
