/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PC
 */
public class Auto extends Vehiculo {
    private int id_auto;
    private Cliente dueño; 

    @Override
    public String toString() {
        return "Auto{" + "id_auto=" + id_auto + ", id_adicional=" + id_adicional +super.toString()+ '}';
    }
    private Empleado vendedor; 
    private int id_adicional;

    public int getId_adicional() {
        return id_adicional;
    }

    public void setId_adicional(int id_adicional) {
        this.id_adicional = id_adicional;
    }

    public Auto(int precio, Marca marca, Modelo.ModeloAuto modelo, String color) {
        super(precio, marca, modelo, color);
    }

    public Auto() {
        
    }

    

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }
   
}
