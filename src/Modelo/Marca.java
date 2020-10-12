/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class Marca {
    private int id_marca;

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }
    private String Marca;
    private ArrayList <ModeloAuto> Modelo;

    public ArrayList<ModeloAuto> getModelo() {
        return Modelo;
    }

    public void setModelo(ArrayList<ModeloAuto> Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Marca(String Marca) {
        this.Marca = Marca;
    }

    public Marca() {
        
    }

    public Marca(int id_marca, String Marca) {
        this.id_marca = id_marca;
        this.Marca = Marca;
    }
            
            
}
