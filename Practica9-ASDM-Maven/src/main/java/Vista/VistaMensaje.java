/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author juald
 */
public class VistaMensaje {

    public void MensajeDeError(String texto) {
        JOptionPane.showMessageDialog(null, texto, "", JOptionPane.ERROR_MESSAGE);
    }

    /**
     *
     * @param texto texto que queremos mostrar en la ventana para informar al
     * usuario
     */
    public void MensajeInformacion(String texto) {
        JOptionPane.showMessageDialog(null, texto, "", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeDeError(String texto, String message) {
        JOptionPane.showMessageDialog(null, texto + "\n" + message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
