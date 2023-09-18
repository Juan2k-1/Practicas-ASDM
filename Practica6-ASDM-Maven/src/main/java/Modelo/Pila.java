/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Iterator;

/**
 *
 * @author juald
 * @param <T>
 */
public class Pila<T> extends Estructura implements Iterable<T> {

    private int tamañoMaximo;
    private int tamañoActual;
    private Nodo<T> cima;

    // Constructor
    public Pila(String tipo, int tamañoMaximo) {
        super(tipo);
        this.tamañoMaximo = tamañoMaximo;
        this.tamañoActual = 0;
        this.cima = null;
    }

    // Método para añadir un elemento a la pila
    public void apilar(T valor) throws Exception {
        if (this.tamañoActual == this.tamañoMaximo) {
            throw new Exception("La pila está llena");
        }
        Nodo<T> nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = this.cima;
        this.cima = nuevoNodo;
        this.tamañoActual++;
    }

    // Método para quitar un elemento de la pila y devolver su valor
    public T desapilar() throws Exception {
        if (this.tamañoActual == 0) {
            throw new Exception("La pila está vacía");
        }
        Nodo<T> nodoAEliminar = this.cima;
        this.cima = this.cima.siguiente;
        this.tamañoActual--;
        return (T) nodoAEliminar.valor;
    }

    // Método para ver el elemento en la cima de la pila sin sacarlo
    public T verCima() throws Exception {
        if (this.tamañoActual == 0) {
            throw new Exception("La pila está vacía");
        }
        return (T) this.cima.valor;
    }

    // Método para comprobar si la pila está vacía
    public boolean estaVacia() {
        return this.tamañoActual == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new PilaIterador(this.cima);
    }

    public Nodo<T> getCima() {
        return cima;
    }
}
