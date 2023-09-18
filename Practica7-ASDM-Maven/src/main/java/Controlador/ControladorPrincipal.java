/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MedioComunicacion;
import Modelo.MediosComunicacion;
import Modelo.Partido;
import Modelo.Pedido;
import Modelo.PedidoConcreto;
import Vista.VistaActualizarMarcador;
import Vista.VistaMensaje;
import Vista.VistaPartida;
import Vista.VistaPorDefecto;
import Vista.VistaPrincipal;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author juald
 */
public class ControladorPrincipal implements ActionListener {

    private VistaPorDefecto vPorDefecto;
    private VistaPrincipal vPrincipal;
    private VistaMensaje vMensaje;
    private VistaPartida vPartida;
    private VistaActualizarMarcador vActualizarMarcador;
    private Pedido miFabrica;
    private MediosComunicacion medios;
    private Partido partido;
    private String tipoMedio;

    public ControladorPrincipal() {
        this.vPorDefecto = new VistaPorDefecto();
        this.vPrincipal = new VistaPrincipal();
        this.vMensaje = new VistaMensaje();
        this.vPartida = new VistaPartida();
        this.vActualizarMarcador = new VistaActualizarMarcador();
        this.partido = new Partido(0, 0);

        addListeners();

        this.vPrincipal.setLayout(new CardLayout());
        this.vPrincipal.add(this.vPorDefecto);
        this.vPorDefecto.setVisible(true);
        this.vPrincipal.setVisible(false);
        this.vPartida.setVisible(false);
        this.vActualizarMarcador.setVisible(false);

        this.vPrincipal.setTitle("Práctica 7 - ASDM - Observer - Juan Alberto Domínguez Vázquez");
        this.vPrincipal.setLocationRelativeTo(null); //Para que la ventana se muestre en el centro de la pantalla
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Ver Partido": {
                this.vPorDefecto.setVisible(false);
                this.vPartida.setLocationRelativeTo(null);
                this.vPartida.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vPartida.setVisible(true);
                this.vPartida.jTextField1.setText("");
                break;
            }
            case "CambiarMedio": {
                this.tipoMedio = (String) this.vPartida.SeleccionMedio.getSelectedItem();
                this.miFabrica = new PedidoConcreto(this.tipoMedio, this.partido);
                this.medios = this.miFabrica.factoryMethod();
                this.partido.registrarObservador((MedioComunicacion) medios);
                //this.partido.ejecutarAccion(1, 0);
                //this.partido.ejecutarAccion(1, 1);
                this.vPartida.jTextField1.setText(this.partido.getResultadoLocal() + " - " + this.partido.getResultadoVisitante());
                break;
            }
            case "ActualizarMarcador": {
                this.vActualizarMarcador.setLocationRelativeTo(null);
                this.vActualizarMarcador.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.vActualizarMarcador.setVisible(true);
                break;
            }
            case "Actualizar": {
                actualizar();
                break;
            }
        }
    }

    private void addListeners() {
        this.vPrincipal.VerPartido.addActionListener(this);
        this.vPartida.SeleccionMedio.addActionListener(this);
        this.vPartida.ActualizarMarcador.addActionListener(this);
        this.vActualizarMarcador.Actualizar.addActionListener(this);
    }

    public void actualizar() {
        String resultLocal = this.vActualizarMarcador.ResultadoLocal.getText();
        String resultVisitante = this.vActualizarMarcador.ResultadoVisitante.getText();
        this.partido.ejecutarAccion(Integer.parseInt(resultLocal), Integer.parseInt(resultVisitante));
    }
}
