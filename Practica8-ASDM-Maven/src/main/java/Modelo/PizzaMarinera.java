/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class PizzaMarinera extends Pizza {

    public PizzaMarinera() {
        super("Marinera");
    }

    @Override
    public double getCoste() {
        return 8.00;
    }

    @Override
    public String getIngredientes() {
        return "Tomate, queso mozzarella, atún, aceitunas, ajo";
    }

    @Override
    public String getFormaPreparacion() {
        return "Hornear durante 15 minutos a 200°C";
    }
}
