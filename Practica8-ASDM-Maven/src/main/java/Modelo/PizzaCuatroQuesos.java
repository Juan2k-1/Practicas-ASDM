/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class PizzaCuatroQuesos extends Pizza {

    public PizzaCuatroQuesos() {
        super("Cuatro Quesos");
    }

    @Override
    public double getCoste() {
        return 10.00;
    }

    @Override
    public String getIngredientes() {
        return "Tomate, queso gorgonzola, queso parmesano, queso mozzarella, queso de cabra";
    }

    @Override
    public String getFormaPreparacion() {
        return "Hornear durante 20 minutos a 220°C";
    }
}
