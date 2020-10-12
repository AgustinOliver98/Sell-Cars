/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consultas;
import Modelo.Hash;
import Modelo.Logeo;
import Vista.Intefaz_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Controlador_Login implements ActionListener {

    private Logeo modelo;
    private Intefaz_Login view;
    private Consultas modelo_consulta;

    public Controlador_Login(Logeo modelo, Intefaz_Login view, Consultas modelo_consulta) {
        this.modelo = modelo;
        this.view = view;
        this.modelo_consulta = modelo_consulta;
        this.view.btniniciar.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Login Consecionaria");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btniniciar) {
            Hash encrp = new Hash();
            modelo.setUsuario(view.txtUsuario.getText());
            modelo.setPass(encrp.md5(view.txtContra.getText()));
            if (modelo_consulta.Logeo(modelo).equals("Administrador")) {
                JOptionPane.showMessageDialog(null, "Ingreso Valido");
                Controlador_Home ctrlH = new Controlador_Home();
                this.view.setVisible(false);
                ctrlH.rellenar_JTable();

            } else if (modelo_consulta.Logeo(modelo).equals("Empleado")) {
                JOptionPane.showMessageDialog(null, "Ingreso Valido");
                    Controlador_Home ctrlH = new Controlador_Home();
                this.view.setVisible(false);
                ctrlH.rellenar_JTable();
                ctrlH.desactivarboton();

            } else {
                view.confirmacion.setText("¡Usuario o Contraseña incorrectos!");
            }

        }

    }

}
