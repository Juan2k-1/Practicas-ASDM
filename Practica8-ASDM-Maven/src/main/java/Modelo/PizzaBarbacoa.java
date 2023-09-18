/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class PizzaBarbacoa extends Pizza {

    public PizzaBarbacoa() {
        super("Barbacoa");
    }

    @Override
    public double getCoste() {
        return 11.50;
    }

    @Override
    public String getIngredientes() {
        return "Tomate, queso mozzarella, pollo, cebolla, salsa barbacoa";
    }

    @Override
    public String getFormaPreparacion() {
        return "Hornear durante 25 minutos a 180°C";
    }
}
