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
public class ModeloAuto {
      private  String nombre; 
      private int id_modelos;

    public int getId_modelos() {
        return id_modelos;
    }

    public void setId_modelos(int id_modelos) {
        this.id_modelos = id_modelos;
    }

    public ModeloAuto() {
    }

    public ModeloAuto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
}
