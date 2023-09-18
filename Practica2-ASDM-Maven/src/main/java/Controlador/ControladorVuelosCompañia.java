/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaActualizarVueloCompañia;
import Vista.VistaInsertarVueloCompañia;
import Vista.VistaMensaje;
import Vista.VistaVuelosCompañia;
import Modelo.Vuelo;
import Modelo.VueloCompañiaTablas;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author juald
 */
public class ControladorVuelosCompañia implements ActionListener {

    private VistaVuelosCompañia vVuelos = null;
    private VistaMensaje vMensaje = null;
    private VistaInsertarVueloCompañia vNuevoVuelo = null;
    private VistaActualizarVueloCompañia vActualizarVuelo = null;

    private VueloCompañiaTablas vTablas;
    private Vuelo vuelo;
    private ArrayList<Vuelo> vuelos;
    private String compañia;

    public ControladorVuelosCompañia(VistaVuelosCompañia vVuelos, VueloCompañiaTablas vTabla, String compañia) {
        this.vVuelos = vVuelos;
        this.vTablas = vTabla;
        this.compañia = compañia;
        this.vMensaje = new VistaMensaje();
        this.vNuevoVuelo = new VistaInsertarVueloCompañia();
        this.vActualizarVuelo = new VistaActualizarVueloCompañia();
        this.vuelos = new ArrayList() {
            {
                Vuelo v1 = new Vuelo("Iberia", "Sevilla", "1", "4", "En hora", "18:00", "19:00");
                Vuelo v2 = new Vuelo("Iberia", "Badajoz", "2", "3", "En hora", "11:00", "13:00");
                Vuelo v3 = new Vuelo("Iberia", "A Coruña", "3", "1", "Cancelado", "-", "-");
                Vuelo v4 = new Vuelo("Vueling", "Valencia", "4", "4", "En hora", "14:00", "17:00");
                Vuelo v5 = new Vuelo("Vueling", "Madrid", "5", "2", "Retrasado", "20:00", "23:00");
                Vuelo v6 = new Vuelo("Ryanair", "Barcelona", "6", "3", "Retrasado", "14:00", "18:00");
                Vuelo v7 = new Vuelo("Ryanair", "Madrid", "7", "2", "En hora", "09:00", "12:00");
                Vuelo v8 = new Vuelo("Ryanair", "Toledo", "8", "1", "En hora", "12:00", "13:00");
                add(v1);
                add(v2);
                add(v3);
                add(v4);
                add(v5);
                add(v6);
                add(v7);
                add(v8);
            }
        };

        addListeners();

        this.vNuevoVuelo.Compañia.setText(this.compañia);
        this.vActualizarVuelo.Compañia.setText(this.compañia);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "InsertarVuelo": {
                this.vNuevoVuelo.setLocationRelativeTo(null);
                this.vNuevoVuelo.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vNuevoVuelo.setVisible(true);
                break;
            }
            case "EliminarVuelo": {
                eliminarVuelo();
                break;
            }
            case "ModificarVuelo": {
                this.vActualizarVuelo.setLocationRelativeTo(null);
                this.vActualizarVuelo.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vActualizarVuelo.setVisible(true);
                this.vNuevoVuelo.setVisible(false);
                break;
            }
            case "Insertar": {
                insertarVuelo();
                this.vNuevoVuelo.dispose();
                break;
            }
            case "Modificar": {
                modificarVuelo();
                this.vActualizarVuelo.dispose();
                break;
            }
            case "Atrás": {
                this.vNuevoVuelo.dispose();
                break;
            }
            case "Atrás2": {
                this.vActualizarVuelo.dispose();
                break;
            }
        }
    }

    private void addListeners() {
        this.vVuelos.jButtonEliminarVuelo.addActionListener(this);
        this.vVuelos.jButtonInsertarVuelo.addActionListener(this);
        this.vVuelos.jButtonModificarVuelo.addActionListener(this);
        this.vNuevoVuelo.Insertar.addActionListener(this);
        this.vNuevoVuelo.Atras.addActionListener(this);
        this.vActualizarVuelo.Modificar.addActionListener(this);
        this.vActualizarVuelo.Atras.addActionListener(this);
    }

    public ArrayList<Vuelo> listaVuelos() {
        return this.buscarVuelosCompañia(compañia);
    }

    /**
     *
     */
    public void insertarVuelo() {
        String compañia = this.compañia;
        String destino = this.vNuevoVuelo.Destino.getText();
        String numVuelo = this.vNuevoVuelo.NumVuelo.getText();
        String puertaEmbarque = this.vNuevoVuelo.PuertaEmbarque.getText();
        String estado = this.vNuevoVuelo.Estado.getText();
        String horaSalida = this.vNuevoVuelo.HoraSalida.getText();
        String horaLlegada = this.vNuevoVuelo.HoraLlegada.getText();

        this.vuelo = new Vuelo(compañia, destino, numVuelo, puertaEmbarque, estado, horaSalida, horaLlegada);

        int buscarVuelo = buscarVuelo(numVuelo);
        System.out.println(buscarVuelo);
        if (buscarVuelo == -1) {
            this.vuelos = this.buscarVuelosCompañia(this.compañia);
            this.vuelos.add(vuelo);
            this.vTablas.vaciarTablaVuelos();
            this.vTablas.rellenarTablaVuelos(this.listaVuelos());
            this.vMensaje.MensajeInformacion("Vuelo insertado con éxito");
        } else {
            this.vMensaje.MensajeDeError("Error, el vuelo introducido ya existe");
        }
        this.vNuevoVuelo.Compañia.setText(this.compañia);
        this.vNuevoVuelo.Destino.setText("");
        this.vNuevoVuelo.NumVuelo.setText("");
        this.vNuevoVuelo.PuertaEmbarque.setText("");
        this.vNuevoVuelo.Estado.setText("");
        this.vNuevoVuelo.HoraSalida.setText("");
        this.vNuevoVuelo.HoraLlegada.setText("");
    }

    /**
     *
     */
    public void modificarVuelo() {
        int fila = this.vVuelos.TablaVuelos.getSelectedRow();
        Vuelo seleccionado = this.listaVuelos().get(fila);
        Vuelo nuevo = seleccionado;

        String compañia = this.compañia;
        String destino = this.vActualizarVuelo.Destino.getText();
        String numVuelo = this.vActualizarVuelo.NumVuelo.getText();
        String puertaEmbarque = this.vActualizarVuelo.PuertaEmbarque.getText();
        String estado = this.vActualizarVuelo.Estado.getText();
        String horaSalida = this.vActualizarVuelo.HoraSalida.getText();
        String horaLlegada = this.vActualizarVuelo.HoraLlegada.getText();

        nuevo.setCompañiaAerea(compañia);
        nuevo.setDestino(destino);
        nuevo.setNumeroVuelo(numVuelo);
        nuevo.setPuertaDeEmbarque(puertaEmbarque);
        nuevo.setEstado(estado);
        nuevo.setHoraSalida(horaSalida);
        nuevo.setHoraLlegada(horaLlegada);

        int buscarVuelo = buscarVuelo(numVuelo);
        if (buscarVuelo != -1) {
            this.vuelos = this.buscarVuelosCompañia(this.compañia);
            this.vuelos.remove(seleccionado);
            this.vuelos.add(nuevo);
            this.vTablas.vaciarTablaVuelos();
            this.vTablas.rellenarTablaVuelos(this.listaVuelos());
            this.vMensaje.MensajeInformacion("Vuelo modificado con éxito");
        } else {
            this.vMensaje.MensajeDeError("Error, el vuelo que desea modificar no existe");
        }
        this.vActualizarVuelo.Compañia.setText(this.compañia);
        this.vActualizarVuelo.Destino.setText("");
        this.vActualizarVuelo.NumVuelo.setText("");
        this.vActualizarVuelo.PuertaEmbarque.setText("");
        this.vActualizarVuelo.Estado.setText("");
        this.vActualizarVuelo.HoraSalida.setText("");
        this.vActualizarVuelo.HoraLlegada.setText("");
    }

    /**
     *
     * @param numVuelo
     */
    public void eliminarVuelo() {
        int fila = this.vVuelos.TablaVuelos.getSelectedRow();
        Vuelo seleccionado = this.listaVuelos().get(fila);
        String numVuelo = seleccionado.getNumeroDeVuelo();

        int buscarVuelo = buscarVuelo(numVuelo);
        if (buscarVuelo != -1) {
            this.vuelos = this.buscarVuelosCompañia(this.compañia);
            this.vuelos.remove(seleccionado);
            this.vTablas.vaciarTablaVuelos();
            this.vTablas.rellenarTablaVuelos(this.listaVuelos());
            this.vMensaje.MensajeInformacion("Vuelo eliminado con éxito");
        } else {
            this.vMensaje.MensajeDeError("Error, el vuelo que desea modificar no existe");
        }
    }

    /**
     *
     * @param numVuelo
     * @return
     */
    public int buscarVuelo(String numVuelo) {
        boolean encontrado = false;
        int i = 0;
        while (i < buscarVuelosCompañia(this.compañia).size() && !encontrado) {
            if (numVuelo.equals(buscarVuelosCompañia(this.compañia).get(i).getNumeroDeVuelo())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (encontrado) {
            return i;
        } else {
            return -1;
        }
    }

    public ArrayList<Vuelo> buscarVuelosCompañia(String compañia) {
        ArrayList<Vuelo> auxiliar = new ArrayList<>();
        for (int i = 0; i < vuelos.size(); i++) {
            if (compañia.toLowerCase().equals(vuelos.get(i).getCompañiaAerea().toLowerCase())) {
                auxiliar.add(vuelos.get(i));
            }
        }
        return auxiliar;
    }

    public ArrayList<Vuelo> getVuelos() {
        return this.buscarVuelosCompañia(this.compañia);
    }
}
