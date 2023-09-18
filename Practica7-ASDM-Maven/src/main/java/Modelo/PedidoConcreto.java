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

    private String tipoMedio;
    private Partido partido;

    public PedidoConcreto(String tipoMedio, Partido partido) {
        this.tipoMedio = tipoMedio;
        this.partido = partido;
    }

    @Override
    public MediosComunicacion factoryMethod() {

        if (this.tipoMedio.toUpperCase().equalsIgnoreCase("INTERNET")) {
            return new TransmisionInternet(tipoMedio, partido);
        } else if (this.tipoMedio.toUpperCase().equalsIgnoreCase("TELEVISIÓN")) {
            return new TransmisionTelevision(tipoMedio, partido);
        } else if (this.tipoMedio.toUpperCase().equalsIgnoreCase("RADIO")) {
            return new TransmisionRadio(tipoMedio, partido);
        } else {
            return null;
        }
    }
}
