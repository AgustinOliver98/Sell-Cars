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
public class Mod_Agregarauto {

    private int id_Marca;
    private Marca marcaauto;

    public Mod_Agregarauto() {

    }

    public Mod_Agregarauto( Marca marcaauto, int precio,ArrayList <ModeloAuto> modelos) {
        
        this.marcaauto = marcaauto;
        this.precio = precio;
        this.marcaauto.setModelo(modelos);
    }
    
    
    private int precio;
    private String color;

    public int getId_Marca() {
        return id_Marca;
    }

    public void setId_Marca(int id_Marca) {
        this.id_Marca = id_Marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Marca getMarcaauto() {
        return marcaauto;
    }

    public void setMarcaauto(Marca marca) {
        this.marcaauto = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
