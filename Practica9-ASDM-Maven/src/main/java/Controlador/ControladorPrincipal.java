/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CambioSistemaNumerico;
import Vista.VistaConversor;
import Vista.VistaMensaje;
import Vista.VistaPorDefecto;
import Vista.VistaPrincipal;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author juald
 */
public class ControladorPrincipal implements ActionListener {

    private VistaConversor vConversor;
    private VistaPorDefecto vPorDefecto;
    private VistaMensaje vMensaje;
    private VistaPrincipal vPrincipal;
    private CambioSistemaNumerico cambioSistema;

    public ControladorPrincipal() {
        this.vConversor = new VistaConversor();
        this.vMensaje = new VistaMensaje();
        this.vPorDefecto = new VistaPorDefecto();
        this.vPrincipal = new VistaPrincipal();

        addListeners();

        this.vPrincipal.setLayout(new CardLayout());
        this.vPrincipal.add(this.vPorDefecto);

        this.vPorDefecto.setVisible(true);
        this.vConversor.setVisible(false);

        this.vPrincipal.setTitle("Práctica 9 - ASDM - Conversor - Juan Alberto Domínguez Vázquez");
        this.vPrincipal.setLocationRelativeTo(null);
        this.vPrincipal.setVisible(true); // Para hacer la ventana visible
        this.vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que la ventana se cierra cuando le doy a cerrar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Convertir2": {
                this.vPorDefecto.setVisible(false);
                this.vConversor.setLocationRelativeTo(null);
                this.vConversor.setVisible(true);
                this.vConversor.CampoDecimal.setText("");
                this.vConversor.SelectorSistema.setSelectedIndex(-1);
                this.vConversor.CampoConvertido.setText("");
                break;
            }
            case "Convertir": {
                boolean resultado = convertir();
                if (resultado) {
                    this.vMensaje.MensajeInformacion("¡Número convertido con éxito!");
                } else {
                    this.vMensaje.MensajeDeError("Error al convertir el número...");
                }
                break;
            }
        }
    }

    private void addListeners() {
        this.vPrincipal.Convertir.addActionListener(this);
        this.vConversor.Convertir.addActionListener(this);
    }

    public boolean convertir() {
        boolean resultado = false;
        String sistemaSeleccionado = (String) this.vConversor.SelectorSistema.getSelectedItem();
        if (sistemaSeleccionado.toUpperCase().equals("OCTAL")) {
            this.cambioSistema = new CambioSistemaNumerico(Integer.parseInt(this.vConversor.CampoDecimal.getText()));
            this.vConversor.CampoConvertido.setText(this.cambioSistema.decimalAOctal());
            resultado = true;
        } else if (sistemaSeleccionado.toUpperCase().equals("BINARIO")) {
            this.cambioSistema = new CambioSistemaNumerico(Integer.parseInt(this.vConversor.CampoDecimal.getText()));
            this.vConversor.CampoConvertido.setText(this.cambioSistema.decimalABinario());
            resultado = true;
        } else if (sistemaSeleccionado.toUpperCase().equals("HEXADECIMAL")) {
            this.cambioSistema = new CambioSistemaNumerico(Integer.parseInt(this.vConversor.CampoDecimal.getText()));
            this.vConversor.CampoConvertido.setText(this.cambioSistema.decimalAHexadecimal());
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }
}
