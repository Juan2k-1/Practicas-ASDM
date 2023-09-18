/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class CambioSistemaNumerico {

    private int numeroDecimal;

    public CambioSistemaNumerico(int num) {
        this.numeroDecimal = num;
    }

    public String decimalAOctal() {
        String numOctal = Integer.toOctalString(this.numeroDecimal);
        return numOctal;
    }

    public String decimalABinario() {
        String numBinario = Integer.toBinaryString(this.numeroDecimal);
        return numBinario;
    }

    public String decimalAHexadecimal() {
        String numHexadecimal = Integer.toHexString(this.numeroDecimal);
        return numHexadecimal;
    }
}
