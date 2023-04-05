/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaFamilias;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juald
 */
public class FamiliaTablas extends DefaultTableModel {

    private VistaFamilias vFamilia;

    /**
     * Constructor de la clase que hace una llamada al metodo
     * dibujaTablaMonitores para que se muestre el diseño que queremos en la
     * tabla
     *
     * @param vFamilia
     */
    public FamiliaTablas(VistaFamilias vFamilia) {
        this.vFamilia = vFamilia;
        dibujarTablaFamilias(vFamilia);
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
    public void dibujarTablaFamilias(VistaFamilias vFamilia) {
        String[] columnasTabla = {"Nombre", "Apellidos", "Dirección", "Correo", "Nivel de estudios", "Código postal", "Teléfono"};
        setColumnIdentifiers(columnasTabla);
    }

    /**
     * Metodo que rellena la tabla de monitores con el array de monitores pasado
     * como parametro
     *
     * @param vuelos
     */
    public void rellenarTablaFamilias(ArrayList<Persona> personas) {
        Object[] fila = new Object[7];
        int numRegistros = personas.size();
        for (int i = 0; i < numRegistros; i++) {
            fila[0] = personas.get(i).getNombre();
            fila[1] = personas.get(i).getApellidos();
            fila[2] = personas.get(i).getDireccion();
            fila[3] = personas.get(i).getCorreo();
            fila[4] = personas.get(i).getNivelEstudios();
            fila[5] = personas.get(i).getCodigoPostal();
            fila[6] = personas.get(i).getTelefono();
            this.addRow(fila);
        }
    }

    /**
     * Metodo que vacia la tabla de monitores
     */
    public void vaciarTablaFamilias() {
        while (this.getRowCount() > 0) {
            this.removeRow(0);
        }
    }
}
