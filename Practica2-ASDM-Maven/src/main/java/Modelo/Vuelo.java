/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class Vuelo {

    private String compañiaAerea;
    private String destino;
    private String numeroDeVuelo;
    private String puertaDeEmbarque;
    private String estado;
    private String horaLlegada;
    private String horaSalida;

    public Vuelo(String numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public void setCompañiaAerea(String compañiaAerea) {
        this.compañiaAerea = compañiaAerea;
    }

    public void setNumeroVuelo(String numVuelo) {
        this.numeroDeVuelo = numVuelo;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPuertaDeEmbarque(String puertaDeEmbarque) {
        this.puertaDeEmbarque = puertaDeEmbarque;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Vuelo(String compañia, String destino, String numeroDeVuelo, String puertaDeEmbarque, String estado, String horaSalida, String horaLlegada) {
        this.compañiaAerea = compañia;
        this.destino = destino;
        this.numeroDeVuelo = numeroDeVuelo;
        this.puertaDeEmbarque = puertaDeEmbarque;
        this.estado = estado;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public String getCompañiaAerea() {
        return compañiaAerea;
    }

    public String getDestino() {
        return destino;
    }

    public String getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public String getPuertaDeEmbarque() {
        return puertaDeEmbarque;
    }

    public String getEstado() {
        return estado;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Vuelo[ numVuelo=" + this.numeroDeVuelo + " ]";
    }
}
