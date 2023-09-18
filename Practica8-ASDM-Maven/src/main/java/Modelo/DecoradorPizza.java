/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public abstract class DecoradorPizza extends Pizza {

    protected Pizza pizza;

    public DecoradorPizza(Pizza pizza) {
        super(pizza.getNombre());
        this.pizza = pizza;
    }

    @Override
    public double getCoste() {
        return pizza.getCoste();
    }

    @Override
    public String getIngredientes() {
        return pizza.getIngredientes();
    }

    @Override
    public String getFormaPreparacion() {
        return pizza.getFormaPreparacion();
    }
}
