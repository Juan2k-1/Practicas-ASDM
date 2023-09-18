/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class Reloj {

    private String hora;
    private String minutos;
    private String segundos;

    public Reloj(String hora, String minutos, String segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }

    public String getHora() {
        return this.hora;
    }

    public String getMinutos() {
        return this.minutos;
    }

    public String getSegundos() {
        return this.segundos;
    }
}
