/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class Familiar_Concreto2 implements Persona {

    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private String correo;
    private String nivelEstudios;
    
    public Familiar_Concreto2(String nombre, String apellidos, String telefono, String direccion, String codigoPostal, String correo, String nivelEstudios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.nivelEstudios = nivelEstudios;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getApellidos() {
        return this.apellidos;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    @Override
    public String getCorreo() {
        return this.correo;
    }

    @Override
    public String getNivelEstudios() {
        return this.nivelEstudios;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    @Override
    public Persona clonar() {
        Persona p = new Familiar_Concreto2(this.nombre, this.apellidos, this.telefono, this.direccion, this.codigoPostal, this.correo, this.nivelEstudios);
        return p;
    }
}
