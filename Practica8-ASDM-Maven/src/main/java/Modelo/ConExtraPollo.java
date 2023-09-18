/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class ConExtraPollo extends DecoradorPizza {

    public ConExtraPollo(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCoste() {
        return super.getCoste() + 0.75;
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", aceitunas negras extra";
    }

    @Override
    public String getFormaPreparacion() {
        return super.getFormaPreparacion() + ", añadir aceitunas negras extra antes de hornear";
    }
}
