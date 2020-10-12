/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Controlador_Compra implements ActionListener {

    private Cliente cliente;
    private Empleado empleado;
    private Auto auto;
    private Consultas consulta;
    private Venta view;
    private Fecha fechaaux = new Fecha();

    public Controlador_Compra(Cliente cliente, Empleado empleado, Auto auto, Consultas consulta, Venta view) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.auto = auto;
        this.consulta = consulta;
        this.view = view;
        view.setVisible(true);
        this.view.btnventa.addActionListener(this);
    }

    public Controlador_Compra() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date fecha = new Date();
        if (e.getSource() == view.btnventa) {
            if (view.txtFecha.getText().isEmpty() || view.TxtTotal.getText().isEmpty() || view.CboxMarca.getSelectedIndex() == 0 || view.CboxVendedor.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione bien en el formulario");

            } else {
                auto.setMarca(new Marca(view.CboxMarca.getSelectedIndex(), (String) view.CboxMarca.getSelectedItem()));
                auto.SetModelo(new ModeloAuto((String) view.CboxModelo.getSelectedItem()));
                cliente.setId_cliente(view.CboxCliente.getSelectedIndex());
                cliente.setPago(view.jComboBox6.getSelectedIndex());
                empleado.setId(view.CboxVendedor.getSelectedIndex());
                auto.setId_adicional(view.CboxAdicional.getSelectedIndex());
                cliente.setGastototal(Integer.valueOf(view.TxtTotal.getText()));

                try {
                    fecha = fechaaux.TranformarFecha(view.txtFecha.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador_Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
                Consultas con = new Consultas();
                con.Compra(auto, empleado, cliente, fecha);
                JOptionPane.showMessageDialog(null,"Venta Exitosa");
                this.view.setVisible(false);
                
            }
        }
        
        if(e.getSource()== view.btnsalir_venta){
            this.view.setVisible(false);
        }

    }

}
