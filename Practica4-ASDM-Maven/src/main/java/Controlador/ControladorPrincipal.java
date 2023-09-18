/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.FamiliaTablas;
import Modelo.Familiar_Concreto;
import Modelo.Familiar_Concreto2;
import Modelo.Persona;
import Vista.VistaFamilias;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import Vista.VistaNuevaPersona;
import Vista.VistaNuevoFamiliar;
import Vista.VistaPorDefecto;
import Vista.VistaPrincipal;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author juald
 */
public class ControladorPrincipal implements ActionListener {

    private VistaLogin vLogin;
    private VistaMensaje vMensaje;
    private VistaPrincipal vPrincipal;
    private VistaPorDefecto vPorDefecto;
    private VistaFamilias vFamilias;
    private FamiliaTablas tablaFamilia;
    private ArrayList<Persona> personas;
    private VistaNuevoFamiliar vNuevoFamiliar;
    private VistaNuevaPersona vNuevaPersona;

    public ControladorPrincipal(VistaLogin vLogin, VistaMensaje vMensaje) {
        this.vLogin = vLogin;
        this.vMensaje = vMensaje;
        this.vPrincipal = new VistaPrincipal();
        this.vPorDefecto = new VistaPorDefecto();
        this.vFamilias = new VistaFamilias();
        this.tablaFamilia = new FamiliaTablas(this.vFamilias);
        this.personas = new ArrayList() {
            {
                Persona p1 = new Familiar_Concreto("Domínguez Castro", "959259564", "Madrid", "23005");
                Persona p2 = new Familiar_Concreto2("Juan Alberto","Domínguez Pérez", "959259564", "Madrid", "23005", "juan@gmail.com", "Superiores");
                Persona p3 = new Familiar_Concreto2("Irene","Castro Maldonado", "959259564", "Madrid", "23005", "irene@gmail.com", "Superiores");
                Persona p4 = new Familiar_Concreto("Domínguez Castro", "959259564", "Madrid", "23005");
                Persona p5 = new Familiar_Concreto("Domínguez Castro", "959259564", "Madrid", "23005");
                p1.setNombre("Saul");
                p1.setCorreo("saul@gmail.com");
                p1.setNivelEstudios("Superiores");
                p4.setNombre("Marina");
                p4.setCorreo("marina@gmail.com");
                p4.setNivelEstudios("Ninguno");
                p5.setNombre("Álex");
                p5.setCorreo("alex@gmail.com");
                p5.setNivelEstudios("Básicos");
                add(p1);
                add(p2);
                add(p3);
                add(p4);
                add(p5);               
            }
        };
        this.vNuevoFamiliar = new VistaNuevoFamiliar();
        this.vNuevaPersona = new VistaNuevaPersona();

        addListeners();

        this.vPrincipal.setLayout(new CardLayout());

        this.vPrincipal.add(vPorDefecto);
        this.vPrincipal.add(this.vFamilias);

        this.vPorDefecto.setVisible(true);
        this.vFamilias.setVisible(false);
        this.vLogin.setVisible(false);
        this.vNuevoFamiliar.setVisible(false);
        this.vNuevaPersona.setVisible(false);

        this.vNuevoFamiliar.Apellidos.setText("Dominguez Castro");
        this.vNuevoFamiliar.Telefono.setText("959259564");
        this.vNuevoFamiliar.CodigoPostal.setText("23005");
        this.vNuevoFamiliar.Direccion.setText("Madrid");

        this.vPrincipal.setTitle("Práctica 4 - ASDM - Familias - Juan Alberto Domínguez Vázquez");
        this.vPrincipal.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Gestión Familias": {
                this.vPorDefecto.setVisible(false);
                this.vFamilias.setVisible(true);

                this.vFamilias.TablaFamilias.setModel(tablaFamilia);
                DiseñoTablaFamilias();
                pidePersona();
                break;
            }

            case "Añadir una nueva persona": {
                this.vNuevaPersona.setLocationRelativeTo(null);
                this.vNuevaPersona.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vPorDefecto.setVisible(false);
                this.vNuevaPersona.setVisible(true);
                break;
            }

            case "Añadir un familiar": {
                this.vNuevoFamiliar.setLocationRelativeTo(null);
                this.vNuevoFamiliar.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vPorDefecto.setVisible(false);
                this.vNuevoFamiliar.setVisible(true);
                break;
            }

            case "AñadirPersona": {
                añadirPersona();
                this.vNuevaPersona.dispose();
                break;
            }

            case "AñadirFamiliar": {
                añadirFamiliar();
                this.vNuevoFamiliar.dispose();
                break;
            }

            case "Salir": {
                this.vNuevaPersona.dispose();
                this.vNuevoFamiliar.dispose();
                break;
            }

            case "Salir de la aplicación": {
                this.vMensaje.MensajeInformacion("Saliendo de la aplicación");
                this.vPrincipal.dispose();
                System.exit(0);
                break;
            }
        }
    }

    private void DiseñoTablaFamilias() {
        //Para no permitir el redimensionamiento de las columnas con el ratón
        this.vFamilias.TablaFamilias.getTableHeader().setResizingAllowed(false);
        this.vFamilias.TablaFamilias.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        this.vFamilias.TablaFamilias.getColumnModel().getColumn(0).setPreferredWidth(350);
        this.vFamilias.TablaFamilias.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.vFamilias.TablaFamilias.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.vFamilias.TablaFamilias.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.vFamilias.TablaFamilias.getColumnModel().getColumn(4).setPreferredWidth(350);
        this.vFamilias.TablaFamilias.getColumnModel().getColumn(5).setPreferredWidth(350);
        this.vFamilias.TablaFamilias.getColumnModel().getColumn(6).setPreferredWidth(350);
    }

    private void pidePersona() {
        ArrayList<Persona> personas = this.listaPersonas();
        this.tablaFamilia.vaciarTablaFamilias();
        this.tablaFamilia.rellenarTablaFamilias(personas);
    }

    public ArrayList<Persona> listaPersonas() {
        return this.personas;
    }

    public void añadirPersona() {
        String nombre = this.vNuevaPersona.Nombre.getText();
        String apellido = this.vNuevaPersona.Apellidos.getText();
        String telefono = this.vNuevaPersona.Telefono.getText();
        String correo = this.vNuevaPersona.Correo.getText();
        String direccion = this.vNuevaPersona.Direccion.getText();
        String codigoPostal = this.vNuevaPersona.CodigoPostal.getText();
        String nivelEstudios = this.vNuevaPersona.NivelEstudios.getText();

        Persona personaAuxiliar = new Familiar_Concreto2(nombre, apellido, telefono, direccion, codigoPostal, correo, nivelEstudios);
        this.personas.add(personaAuxiliar);
        this.tablaFamilia.vaciarTablaFamilias();
        this.tablaFamilia.rellenarTablaFamilias(this.personas);
    }

    public void añadirFamiliar() {
        String nombre = this.vNuevoFamiliar.Nombre.getText();
        String correo = this.vNuevoFamiliar.Correo.getText();
        String nivelEstudios = this.vNuevoFamiliar.NivelEstudios.getText();

        Persona personaAuxiliar = new Familiar_Concreto("Domínguez Castro", "959259564", "Madrid", "23005");       
        personaAuxiliar.setNombre(nombre);
        personaAuxiliar.setCorreo(correo);
        personaAuxiliar.setNivelEstudios(nivelEstudios);
        personaAuxiliar.clonar();
        this.personas.add(personaAuxiliar);
        this.tablaFamilia.vaciarTablaFamilias();
        this.tablaFamilia.rellenarTablaFamilias(this.personas);
    }

    private void addListeners() {
        this.vPrincipal.GestionFamilias.addActionListener(this);
        this.vPrincipal.SalirDeLaAplicacion.addActionListener(this);
        this.vFamilias.AñadirFamiliar.addActionListener(this);
        this.vFamilias.AñadirNuevaPersona.addActionListener(this);
        this.vNuevaPersona.Añadir.addActionListener(this);
        this.vNuevaPersona.Salir.addActionListener(this);
        this.vNuevoFamiliar.Añadir.addActionListener(this);
        this.vNuevoFamiliar.Salir.addActionListener(this);
    }
}
