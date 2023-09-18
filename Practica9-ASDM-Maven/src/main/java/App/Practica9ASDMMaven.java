/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package App;

import Controlador.ControladorPrincipal;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author juald
 */
public class Practica9ASDMMaven {

    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese un número decimal: ");
            int decimal = sc.nextInt();
            CambioSistemaNumerico cambio = new CambioSistemaNumerico(decimal);
            System.out.println("El número en binario es: " + cambio.decimalABinario());
            System.out.println("El número en octal es: " + cambio.decimalAOctal());
            System.out.println("El número en hexadecimal es: " + cambio.decimalAHexadecimal());
            sc.close();*/
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Practica9ASDMMaven.class.getName()).log(Level.SEVERE, null, ex);
        }
        ControladorPrincipal c = new ControladorPrincipal();
    }
}
