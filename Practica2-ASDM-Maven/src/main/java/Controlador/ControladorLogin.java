/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaCompañia;
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
    private VistaCompañia vCompañia;

    public ControladorLogin() {
        this.vLogin = new VistaLogin();
        this.vMensaje = new VistaMensaje();
        this.vCompañia = new VistaCompañia();

        addListeners();

        vLogin.setLocationRelativeTo(null); // Para que la ventana se muestre en el centro de la pantalla
        vLogin.setVisible(true); // Para que la ventana sea visible al usuario
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Conectar": {
                this.vMensaje.MensajeInformacion("Conexión Correcta!");
                if (this.vLogin.jComboBoxRol.getSelectedItem().equals("Director de la aviación civil")
                        || this.vLogin.jComboBoxRol.getSelectedItem().equals("Director Aeropuerto")
                        || this.vLogin.jComboBoxRol.getSelectedItem().equals("Subdirector Aeropuerto")) {
                    ControladorAeropuerto control = ControladorAeropuerto.obtenerControl();
                } else {
                    String compañia = this.vLogin.jTextFieldUsuario.getText();
                    System.out.println(compañia);
                    ControladorCompañia com = new ControladorCompañia(compañia);
                }

                this.vLogin.dispose();
                break;
            }
            case "Salir": {
                this.vLogin.dispose();
                System.exit(0);
                break;
            }
            case "comboBoxChanged": {
                comprobarLogin();
                break;
            }
        }
    }

    private void addListeners() {
        this.vLogin.Salir.addActionListener(this);
        this.vLogin.Conectar.addActionListener(this);
        this.vLogin.jComboBoxRol.addActionListener(this);
    }

    public void comprobarLogin() {
        String rol = (String) this.vLogin.jComboBoxRol.getSelectedItem();
        if (rol.toLowerCase().equals("compañía aérea")) {
            this.vLogin.jTextFieldUsuario.setText("");
            this.vLogin.jPasswordFieldContraseña.setText("1236");
        } else {
            this.vLogin.jTextFieldUsuario.setText("ADMIN");
            this.vLogin.jPasswordFieldContraseña.setText("1235");
        }

    }

}
