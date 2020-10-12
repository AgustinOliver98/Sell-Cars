/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import Controlador.Controlador_Login;
import Modelo.Consultas;
import Modelo.Logeo;
import Vista.Intefaz_Login;

/**
 *
 * @author PC
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logeo login = new Logeo ();
        Consultas consulta = new Consultas();
        Intefaz_Login frmlog = new Intefaz_Login();
        
        Controlador_Login ctrl = new Controlador_Login(login, frmlog, consulta);
        
        ctrl.iniciar();
        frmlog.setVisible(true);
        
    }
    
}
