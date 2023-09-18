/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AdaptadorFecha;
import Modelo.AdaptadorHora;
import Modelo.CalendarioAdaptador;
import Modelo.RelojAdaptador;
import Vista.VistaCalendario;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import Vista.VistaPorDefecto;
import Vista.VistaPrincipal;
import Vista.VistaReloj;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JFrame;

/**
 *
 * @author juald
 */
public class ControladorPrincipal implements ActionListener {

    private VistaMensaje vMensaje;
    private VistaLogin vLogin;
    private VistaPorDefecto vPorDefecto;
    private VistaPrincipal vPrincipal;
    private VistaReloj vReloj;
    private VistaCalendario vCalendario;
    private LocalTime horaActual;
    private LocalDate fechaActual;
    private AdaptadorHora adaptadorHora;
    private AdaptadorFecha adaptadorFecha;

    public ControladorPrincipal(VistaLogin vLogin, VistaMensaje vMensaje) {
        this.vLogin = vLogin;
        this.vMensaje = vMensaje;
        this.vPorDefecto = new VistaPorDefecto();
        this.vPrincipal = new VistaPrincipal();
        this.vCalendario = new VistaCalendario();
        this.vReloj = new VistaReloj();
        this.horaActual = LocalTime.now();
        this.fechaActual = LocalDate.now();
        this.adaptadorHora = new RelojAdaptador(horaActual);
        this.adaptadorFecha = new CalendarioAdaptador(fechaActual);

        addListeners();
        this.vPrincipal.setLayout(new CardLayout());

        this.vPrincipal.add(this.vPorDefecto);

        this.vPorDefecto.setVisible(true);
        this.vLogin.setVisible(false);
        this.vCalendario.setVisible(false);
        this.vReloj.setVisible(false);

        this.vPrincipal.setTitle("Práctica 5 - ASDM - Calendario Universal - Juan Alberto Domínguez Vázquez");
        this.vPrincipal.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar

        this.vReloj.MostrarHora.setText(this.adaptadorHora.formato12Horas());
        this.vReloj.MostrarHora2.setText(this.adaptadorHora.formato24Horas());

        this.vCalendario.MostrarFecha.setText(this.adaptadorFecha.formatoDMY());
        this.vCalendario.MostrarFecha2.setText(this.adaptadorFecha.formatoMDY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Mostrar Fecha": {
                this.vCalendario.setLocationRelativeTo(null);
                this.vCalendario.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vPorDefecto.setVisible(false);
                this.vCalendario.setVisible(true);
                break;
            }
            case "Mostrar Hora": {
                this.vReloj.setLocationRelativeTo(null);
                this.vReloj.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vPorDefecto.setVisible(false);
                this.vReloj.setVisible(true);
                break;
            }
        }
    }

    private void addListeners() {
        this.vPrincipal.MostrarFecha.addActionListener(this);
        this.vPrincipal.MostrarHora.addActionListener(this);
    }
}
