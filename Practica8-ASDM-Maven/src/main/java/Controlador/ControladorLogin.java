/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaLogin;
import Vista.VistaMensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juald
 */
public class ControladorLogin implements ActionListener {

    private VistaLogin vLogin;
    private VistaMensaje vMensaje;

    public ControladorLogin() {
        this.vLogin = new VistaLogin();
        this.vMensaje = new VistaMensaje();

        addListeners();

        vLogin.setLocationRelativeTo(null); // Para que la ventana se muestre en el centro de la pantalla
        vLogin.setVisible(true); // Para que la ventana sea visible al usuario
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Conectar": {
                comprobarCredenciales();
                break;
            }

            case "Salir": {
                this.vLogin.dispose();
                System.exit(0);
                break;
            }
        }
    }

    private void addListeners() {
        this.vLogin.Salir.addActionListener(this);
        this.vLogin.Conectar.addActionListener(this);
    }

    public void comprobarCredenciales() {
        String usuario = this.vLogin.Usuario.getText().trim().toUpperCase();
        char[] password = this.vLogin.Contraseña.getPassword();
        if (usuario.equalsIgnoreCase("ADMIN")) {
            if (new String(password).equals("1235")) {
                this.vMensaje.MensajeInformacion("Conexión Correcta!");
                ControladorPrincipal c = new ControladorPrincipal(vLogin, vMensaje);
                this.vLogin.dispose();
            } else {
                this.vMensaje.MensajeDeError("Error al introducir su contraseña");
            }
        } else {
            this.vMensaje.MensajeDeError("Error al introducir su usuario");
        }
    }
}
