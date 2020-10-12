/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Consultas;
import Vista.ClienteForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Controlador_Cliente implements ActionListener {
    private Cliente per ;
    private ClienteForm view; 
    private Consultas con; 

    public Controlador_Cliente(Cliente per, ClienteForm view, Consultas con) {
        this.per = per;
        this.view = view;
        this.con = con;
        view.setVisible(true);
        this.view.btn_agregarCliente.addActionListener(this);
        this.view.btncancelar.addActionListener(this);
    }

    public Controlador_Cliente() {
        this.view.btn_agregarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== view.btn_agregarCliente){
            if(view.txtNombre.getText().isEmpty()|| view.txtApellido.getText().isEmpty()|| view.TxtTelefono.getText().isEmpty()|| view.TxtDNI.getText().isEmpty()||view.TxtDireccion.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Cajas vacias");
            }
            else{
                per.setNombre(view.txtNombre.getText());
                per.setApellido(view.txtApellido.getText());
                String anio= (String) view.CboxAnio.getSelectedItem();
                String mes = (String) view.CBoxMes.getSelectedItem();
                String dia = (String) view.CBoxDia.getSelectedItem();
                System.out.println(anio+"-"+mes+"-"+dia);
                try {
                    per.setFechanac(anio+"-"+mes+"-"+dia);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                per.setProvincia((String) view.CboxProvincia.getSelectedItem());
                per.setId_provincia(view.CboxProvincia.getSelectedIndex());
                per.setCiudad((String) view.CboxCiudad.getSelectedItem());
                per.setTelefono(Integer.valueOf(view.TxtTelefono.getText()));
                per.setDireccion((String) view.TxtDireccion.getText());
                con.AgregarCliente(per);
                JOptionPane.showMessageDialog(null,"Se agrego correctamente");
                this.view.setVisible(false);
            }
        }
        if(e.getSource()== view.btncancelar){
            this.view.setVisible(false);
        }
    }
    
    
    
}
