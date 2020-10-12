/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Conector {
 // Conexion a BD 
    private String Driver = "com.mysql.jdbc.Driver";
    private String conexion = "jdbc:mysql://192.168.188.100/proyecto";
    private String usuario = "phpmyadmin";
    private String pass = "40966416";
    private static Connection con;

    public Connection getConexion() {
            try{
                Class.forName(Driver);
                con=DriverManager.getConnection(conexion, usuario, pass);
            }catch(Exception e){
                System.out.print(e);
            }
      return con;      
    }
   //cierra conexion 
    public void CerrarConexion() {
        try{
            con.close();
        }catch(SQLException ex){
            System.out.println(ex);
            
        }
        
    }

}
