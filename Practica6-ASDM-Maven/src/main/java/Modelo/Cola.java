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
public class Cola<T> extends Estructura implements Iterable<T> {

    private int tamañoMaximo;
    private int tamañoActual;
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    // Constructor
    public Cola(String tipo, int tamañoMaximo) {
        super(tipo);
        this.tamañoMaximo = tamañoMaximo;
        this.tamañoActual = 0;
        this.cabeza = null;
        this.cola = null;
    }

    // Método para añadir un elemento a la cola
    public void encolar(T valor) throws Exception {
        if (this.tamañoActual == tamañoMaximo) {
            throw new Exception("La cola está llena");
        }
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (this.cola == null) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            this.cola.siguiente = nuevoNodo;
            this.cola = nuevoNodo;
        }
        this.tamañoActual++;
    }

    // Método para quitar un elemento de la cola y devolver su valor
    public T desencolar() throws Exception {
        if (this.tamañoActual == 0) {
            throw new Exception("La cola está vacía");
        }
        T valor = (T) this.cabeza.valor;
        this.cabeza = this.cabeza.siguiente;
        this.tamañoActual--;
        if (this.tamañoActual == 0) {
            this.cola = null;
        }
        return valor;
    }

    // Método para ver el elemento en la cabeza de la cola sin quitarlo
    public T verCabeza() throws Exception {
        if (tamañoActual == 0) {
            throw new Exception("La cola está vacía");
        }
        return (T) this.cabeza.valor;
    }

    // Método para comprobar si la cola está vacía
    public boolean estaVacia() {
        return this.tamañoActual == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new ColaIterador(this.cabeza);
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }
}
