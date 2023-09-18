/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package App;

import Controlador.ControladorPrincipal;
import Modelo.MedioComunicacion;
import Modelo.MediosComunicacion;
import Modelo.Partido;
import Modelo.Pedido;
import Modelo.PedidoConcreto;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author juald
 */
public class Practica7ASDMMaven {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        Partido partido = new Partido(0, 0);
        Pedido miFabrica;
        MediosComunicacion m;

        System.out.println("¿Que retransmisión del partido desea ver? (RADIO/INTERNET/TELEVISION)");
        String tipoMedio = sc.nextLine();
        miFabrica = new PedidoConcreto(tipoMedio, partido);
        m = miFabrica.factoryMethod();

        partido.registrarObservador((MedioComunicacion) m);
        partido.ejecutarAccion(1, 0);
        partido.ejecutarAccion(1, 1);
        partido.ejecutarAccion(2, 1);
        
        partido.retirarObservador((MedioComunicacion) m);
        System.out.println("¿Que retransmisión del partido desea ver? (RADIO/INTERNET/TELEVISION)");
        tipoMedio = sc.nextLine();
        miFabrica = new PedidoConcreto(tipoMedio, partido);
        m = miFabrica.factoryMethod();
        
        partido.registrarObservador((MedioComunicacion) m);        
        partido.ejecutarAccion(3, 1);*/

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel
            Logger.getLogger(Practica7ASDMMaven.class.getName()).log(Level.SEVERE, null, e);
        }
        ControladorPrincipal c = new ControladorPrincipal();
    }
}
