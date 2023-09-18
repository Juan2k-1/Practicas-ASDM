/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package App;

import Controlador.ControladorLogin;
import Modelo.ConExtraQueso;
import Modelo.Pizza;
import Modelo.PizzaPeperoni;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author juald
 */
public class Practica8ASDMMaven {

    public static void main(String[] args) {
        /*Pizza pizza = new PizzaPeperoni();
        System.out.println("Pedido: " + pizza.getNombre());
        System.out.println("Ingredientes: " + pizza.getIngredientes());
        System.out.println("Forma de preparación: " + pizza.getFormaPreparacion());
        System.out.println("Coste: " + pizza.getCoste());

        pizza = new ConExtraQueso(pizza);
        System.out.println("\nPedido: " + pizza.getNombre());
        System.out.println("Ingredientes: " + pizza.getIngredientes());
        System.out.println("Forma de preparación: " + pizza.getFormaPreparacion());
        System.out.println("Coste: " + pizza.getCoste());*/

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel
            Logger.getLogger(Practica8ASDMMaven.class.getName()).log(Level.SEVERE, null, e);
        }
        ControladorLogin c = new ControladorLogin();
    }
}
