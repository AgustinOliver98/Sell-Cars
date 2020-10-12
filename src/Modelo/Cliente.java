/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Cliente extends Persona {
    private int id_cliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    private int pago; //tipopago

    public int getGastototal() {
        return gastototal;
    }

    public void setGastototal(int gastototal) {
        this.gastototal = gastototal;
    }
    private int gastototal;
    private Auto auto; 
    private String id; 

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente(int gastototal, String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        this.gastototal = gastototal;
    }

    public Cliente(String nombre, String apellido, String dni, String provincia, String direccion, String ciudad, int año, int mes, int dia, int telefono, Date fechanac) {
        super(nombre, apellido, dni, provincia, direccion, ciudad, año, mes, dia, telefono, fechanac);
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" + "pago=" + pago + ", auto=" + auto + ", id=" + id +super.toString()+ '}';
    }
    
    
}
