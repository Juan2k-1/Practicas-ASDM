/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class PizzaPeperoni extends Pizza {

    public PizzaPeperoni() {
        super("Peperoni");
    }

    @Override
    public double getCoste() {
        return 7.50;
    }

    @Override
    public String getIngredientes() {
        return "Tomate, queso mozzarella, peperoni";
    }

    @Override
    public String getFormaPreparacion() {
        return "Hornear durante 15 minutos a 200°C";
    }

}
