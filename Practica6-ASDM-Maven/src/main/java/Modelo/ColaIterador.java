/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 * @param <T>
 */
public class ColaIterador<T> implements Iterador {

    private Nodo<T> siguienteNodo;

    public ColaIterador(Nodo<T> cabeza) {
        this.siguienteNodo = cabeza;
    }

    @Override
    public T siguiente() {
        T valor = this.siguienteNodo.valor;
        this.siguienteNodo = this.siguienteNodo.siguiente;
        return valor;
    }

    @Override
    public boolean tieneSiguiente() {
        return this.siguienteNodo != null;
    }
}
