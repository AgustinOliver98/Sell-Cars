/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author PC
 */
public class Fecha {
    
    private Date fecha;

    public Fecha() {
    }

    public Fecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public java.sql.Date TranformarFecha(String strFecha) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed =  format.parse(strFecha);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
      
        return sql;
        
    }
}
