/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Aplicacion;

import Modelo.Cola;
import Modelo.ColaIterador;
import Modelo.Creador;
import Modelo.Estructura;
import Modelo.EstructuraConcreta;
import Modelo.Pila;
import Modelo.PilaIterador;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juald
 */
public class App {

    public static void main(String[] args) {
        try {
            String tipoEstructura;
            int tamaño;
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            Scanner sc = new Scanner(System.in);

            System.out.println("Indique el tipo de estructura que desea crear: (COLA/PILA)");
            tipoEstructura = sc.next();
            System.out.println("Indique el tamaño de la estructura que desea crear: ");
            tamaño = sc.nextInt();
            Creador miFabrica = new EstructuraConcreta(tipoEstructura, tamaño);
            Estructura estructura = miFabrica.Factory_method();

            Pila<Integer> pila = new Pila<>(tipoEstructura, tamaño);
            for (int i = 0; i < tamaño; i++) {
                pila.apilar(random.nextInt(100));
            }

            Cola<String> cola = new Cola<>(tipoEstructura, tamaño);
            for (int i = 0; i < tamaño; i++) {
                cola.encolar("Uno");
            }
            
            // Recorrer y mostrar los elementos de la pila
            System.out.println("Elementos de la Pila:");
            PilaIterador<Integer> iteradorPila;
            iteradorPila = new PilaIterador<>(pila.getCima());
            while (iteradorPila.tieneSiguiente()) {
                System.out.println(iteradorPila.siguiente());
            }

            // Recorrer y mostrar los elementos de la cola
            System.out.println("\nElementos de la Cola:");
            ColaIterador<String> iteradorCola;
            iteradorCola = new ColaIterador<>(cola.getCabeza());
            while (iteradorCola.tieneSiguiente()) {
                System.out.println(iteradorCola.siguiente());
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
