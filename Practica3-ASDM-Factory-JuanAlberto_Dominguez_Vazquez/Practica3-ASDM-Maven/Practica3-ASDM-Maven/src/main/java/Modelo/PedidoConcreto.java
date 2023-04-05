/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class PedidoConcreto extends Pedido {

    private String tipoPizza;

    public PedidoConcreto(String tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    @Override
    public Pizza factoryMethod() {

        if (this.tipoPizza.equalsIgnoreCase("Barbacoa")) {
            return new PizzaBarbacoa(tipoPizza);
        } else if (this.tipoPizza.equalsIgnoreCase("Cuatro Quesos")) {
            return new PizzaCuatroQuesos(tipoPizza);
        } else if (this.tipoPizza.equalsIgnoreCase("Marinera")) {
            return new PizzaMarinera(tipoPizza);
        } else if (this.tipoPizza.equalsIgnoreCase("Peperoni")) {
            return new PizzaPeperoni(tipoPizza);
        } else {
            return null;
        }
    }
}
