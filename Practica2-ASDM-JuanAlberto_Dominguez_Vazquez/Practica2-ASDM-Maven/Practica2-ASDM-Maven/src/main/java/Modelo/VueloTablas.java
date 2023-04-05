/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaVuelos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juald
 */
public class VueloTablas extends DefaultTableModel {

    private VistaVuelos vVuelo;

    /**
     * Constructor de la clase que hace una llamada al metodo
     * dibujaTablaMonitores para que se muestre el diseño que queremos en la
     * tabla
     *
     * @param vVuelo
     */
    public VueloTablas(VistaVuelos vVuelo) {
        this.vVuelo = vVuelo;
        dibujarTablaVuelos(vVuelo);
    }

    /**
     * Metodo que prohibe la edicion de las celdas de la tabla
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Metodo que diseña la tabla con los campos que queremos
     *
     * @param vVuelo
     */
    public void dibujarTablaVuelos(VistaVuelos vVuelo) {
        String[] columnasTabla = {"Compañía", "Destino", "Número de vuelo", "Puerta de embarque", "Estado", "Hora Salida", "Hora Llegada"};
        setColumnIdentifiers(columnasTabla);
    }

    /**
     * Metodo que rellena la tabla de monitores con el array de monitores pasado
     * como parametro
     *
     * @param vuelos
     */
    public void rellenarTablaVuelos(ArrayList<Vuelo> vuelos) {
        Object[] fila = new Object[7];
        int numRegistros = vuelos.size();
        for (int i = 0; i < numRegistros; i++) {
            fila[0] = vuelos.get(i).getCompañiaAerea();
            fila[1] = vuelos.get(i).getDestino();
            fila[2] = vuelos.get(i).getNumeroDeVuelo();
            fila[3] = vuelos.get(i).getPuertaDeEmbarque();
            fila[4] = vuelos.get(i).getEstado();
            fila[5] = vuelos.get(i).getHoraSalida();
            fila[6] = vuelos.get(i).getHoraLlegada();
            this.addRow(fila);
        }
    }

    /**
     * Metodo que vacia la tabla de monitores
     */
    public void vaciarTablaVuelos() {
        while (this.getRowCount() > 0) {
            this.removeRow(0);
        }
    }
}
