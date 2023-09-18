/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author juald
 */
public class Partido implements I_Partido {

    private int resultadoLocal;
    private int resultadoVisitante;
    private ArrayList<MedioComunicacion> medios;

    public Partido(int resultadoLocal, int resultadoVisitante) {
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        this.medios = new ArrayList<>();
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    @Override
    public void registrarObservador(MedioComunicacion o) {
        this.medios.add(o);
    }

    @Override
    public void retirarObservador(MedioComunicacion o) {
        this.medios.remove(o);
    }

    @Override
    public void ejecutarAccion(int resultadoLocal, int resultadoVisitante) {
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        notificar();
    }

    @Override
    public void notificar() {
        for (MedioComunicacion medio : medios) {
            medio.actualizar();
        }
    }
}
