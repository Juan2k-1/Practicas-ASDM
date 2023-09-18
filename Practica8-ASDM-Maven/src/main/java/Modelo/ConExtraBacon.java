/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class ConExtraBacon extends DecoradorPizza {

    public ConExtraBacon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCoste() {
        return super.getCoste() + 1.00;
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", bacon extra";
    }

    @Override
    public String getFormaPreparacion() {
        return super.getFormaPreparacion() + ", añadir bacon extra antes de hornear";
    }
}
