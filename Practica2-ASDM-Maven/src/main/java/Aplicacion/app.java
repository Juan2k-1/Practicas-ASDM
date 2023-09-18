/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Aplicacion;

import Controlador.ControladorLogin;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author juald
 */
public class app {

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel(new FlatDarkLaf());

        } catch (UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, e);
        }
        ControladorLogin c = new ControladorLogin();
    }
}
