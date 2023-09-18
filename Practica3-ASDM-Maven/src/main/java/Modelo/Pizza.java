/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author juald
 */
public abstract class Pizza {

    private String nombre;
    private ArrayList<String> ingredientes;

    public Pizza(String nombre) {
        this.ingredientes = new ArrayList<>();
        this.nombre = nombre;
    }

    public void añadirIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<String> getIngredientes() {
        return this.ingredientes;
    }
}
