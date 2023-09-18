/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class ConExtraJamon extends DecoradorPizza {

    public ConExtraJamon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCoste() {
        return super.getCoste() + 0.75;
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", jamón extra";
    }

    @Override
    public String getFormaPreparacion() {
        return super.getFormaPreparacion() + ", añadir jamón extra antes de hornear";
    }
}
