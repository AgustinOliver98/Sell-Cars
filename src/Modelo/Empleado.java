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
public class Empleado extends Persona {
    private int sueldo; 
    private int id; 
    private int num_Ventas;
    private int totaltodasventas;

    public Empleado(int num_Ventas, int totaltodasventas, String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        this.num_Ventas = num_Ventas;
        this.totaltodasventas = totaltodasventas;
    }

    public Empleado(int sueldo, String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }

    public int getTotaltodasventas() {
        return totaltodasventas;
    }

    public void setTotaltodasventas(int totaltodasventas) {
        this.totaltodasventas = totaltodasventas;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_Ventas() {
        return num_Ventas;
    }

    @Override
    public String toString() {
        return "Empleado{" + "sueldo=" + sueldo + ", id=" + id + ", num_Ventas=" + num_Ventas +super.toString()+ '}';
    }

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    public void setNum_Ventas(int num_Ventas) {
        this.num_Ventas = num_Ventas;
    }
    
}
