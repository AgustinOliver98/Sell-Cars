/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.text.ParseException;


public class Persona {

    // Clase persona
    private String nombre, apellido, dni, provincia, direccion, ciudad;
    private Date fechanac;
    private int telefono, id_provincia;

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", provincia=" + provincia + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono=" + telefono + ", id_provincia=" + id_provincia + "fechanac:"+fechanac+'}';
    }

    public Persona(String nombre, String apellido, String dni, String provincia, String direccion, String ciudad, int año, int mes, int dia, int telefono, Date fechanac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.provincia = provincia;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fechanac = fechanac;
        this.telefono = telefono;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) throws ParseException {
        Fecha fc = new Fecha();
        this.fechanac = fc.TranformarFecha(fechanac);
    }

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
