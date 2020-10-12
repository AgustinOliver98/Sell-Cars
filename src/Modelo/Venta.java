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
public class Venta {

    private Auto auto;
    private Cliente cliente;
    private Empleado empleado;
    private Fecha fecha;

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Venta(Auto auto, Cliente cliente, Empleado empleado,Fecha fecha) {
        this.auto = auto;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
    }

    public Venta() {
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Venta{" + "auto=" + auto + ", cliente=" + cliente + ", empleado=" + empleado + ", fecha=" + fecha + '}';
    }
    

}
