/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalTime;

/**
 *
 * @author juald
 */
public class RelojAdaptador implements AdaptadorHora {

    private LocalTime horaActual;

    /**
     *
     * @param horaActual
     */
    public RelojAdaptador(LocalTime horaActual) {
        this.horaActual = horaActual;
    }

    /**
     *
     * @return
     */
    @Override
    public String formato12Horas() {
        int hora = this.horaActual.getHour();
        String sufijo;
        if (hora >= 12) {
            sufijo = "pm";
        } else {
            sufijo = "am";
        }
        hora = hora % 12;
        if (hora == 0) {
            hora = 12;
        }
        return String.format("%d:%02d:%02d %s", hora, horaActual.getMinute(), horaActual.getSecond(), sufijo);
    }

    /**
     *
     * @return
     */
    @Override
    public String formato24Horas() {
        return String.format("%02d:%02d:%02d", horaActual.getHour(), horaActual.getMinute(), horaActual.getSecond());
    }
}
