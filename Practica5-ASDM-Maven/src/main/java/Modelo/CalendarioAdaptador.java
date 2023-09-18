/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author juald
 */
public class CalendarioAdaptador implements AdaptadorFecha {

    private LocalDate fechaActual;

    /**
     *
     * @param fechaActual
     */
    public CalendarioAdaptador(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     *
     * @return
     */
    @Override
    public String formatoDMY() {
        return String.format("%02d/%02d/%04d", fechaActual.getDayOfMonth(), fechaActual.getMonthValue(), fechaActual.getYear());
    }

    /**
     *
     * @return
     */
    @Override
    public String formatoMDY() {
        return String.format("%02d/%02d/%04d", fechaActual.getMonthValue(), fechaActual.getDayOfMonth(), fechaActual.getYear());
    }
}
