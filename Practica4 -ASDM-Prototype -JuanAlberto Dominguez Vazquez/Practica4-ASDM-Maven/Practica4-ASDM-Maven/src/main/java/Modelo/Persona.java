/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public interface Persona {

    public String getNombre();

    public String getApellidos();

    public String getTelefono();

    public String getDireccion();

    public String getCodigoPostal();

    public String getCorreo();

    public String getNivelEstudios();

    public void setNombre(String nombre);

    public void setCorreo(String correo);

    public void setNivelEstudios(String nivelEstudios);

    public Persona clonar();
}
