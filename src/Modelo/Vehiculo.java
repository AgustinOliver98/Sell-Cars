/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Vehiculo {
  // Clase Vehiculo en caso futuro para otros vehiculos 
    private String motor;
    private int caballos_fuerza;
    private int precio;
    private Marca marca;
    private ModeloAuto modelo;
    private String proovedor;
    private String color;

    public Vehiculo(int precio, Marca marca, ModeloAuto modelo, String color) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public Vehiculo() {
    }
 

    public String getProovedor() {
        return proovedor;
    }

    public void setProovedor(String proovedor) {
        this.proovedor = proovedor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getCaballos_fuerza() {
        return caballos_fuerza;
    }

    public void setCaballos_fuerza(int caballos_fuerza) {
        this.caballos_fuerza = caballos_fuerza;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public ModeloAuto getModelo() {
        return modelo;
    }

    public void SetModelo(ModeloAuto modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "motor=" + motor + ", caballos_fuerza=" + caballos_fuerza + ", precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + ", proovedor=" + proovedor + ", color=" + color + '}';
    }
}
