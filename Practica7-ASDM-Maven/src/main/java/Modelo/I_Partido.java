/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public interface I_Partido {

    public void registrarObservador(MedioComunicacion o);

    public void retirarObservador(MedioComunicacion o);

    public void ejecutarAccion(int resultadoLocal, int resultadoVisitante);

    public void notificar();
}
