/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class TransmisionInternet extends MediosComunicacion implements MedioComunicacion {

    private Partido partido;

    public TransmisionInternet(String nombre, Partido partido) {
        super(nombre);
        this.partido = partido;
    }

    @Override
    public void actualizar() {
        System.out.println("Está viendo el partido a través de: " + this.getNombre() + ", el resultado actual es: " + partido.getResultadoLocal() + " - " + partido.getResultadoVisitante());
    }
}
