/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class EstructuraConcreta<T> extends Creador {

    private String tipoEstructura;
    private int tamaño;

    public EstructuraConcreta(String tipoEstructura, int tamaño) {
        this.tipoEstructura = tipoEstructura;
        this.tamaño = tamaño;
    }

    @Override
    public Estructura Factory_method() {
        if (this.tipoEstructura.equals("Cola")) {
            return new Cola<T>(tipoEstructura, tamaño);
        } else if (this.tipoEstructura.equals("Pila")) {
            return new Pila<>(tipoEstructura, tamaño);
        } else {
            return null;
        }
    }
}
