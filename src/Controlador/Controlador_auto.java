/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auto;
import Modelo.Consultas;
import Modelo.Mod_Agregarauto;
import Modelo.ModeloAuto;
import Vista.Frm_Auto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import sun.nio.cs.ext.TIS_620;

/**
 *
 * @author PC
 */
public class Controlador_auto implements ActionListener {

    private Mod_Agregarauto auto;
    private Frm_Auto frmAuto;
    private Consultas consulta;

    public Controlador_auto() {
        
    }

    public Controlador_auto(Mod_Agregarauto auto, Frm_Auto frmAuto, Consultas con) {
        this.auto = auto;
        this.frmAuto = frmAuto;
        this.consulta = con;
       
        this.frmAuto.setVisible(true);
        this.frmAuto.btnagregar.addActionListener(this);
        this.frmAuto.btn_cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== frmAuto.btnagregar){
           if(frmAuto.txtmodeloAuto.getText().isEmpty() || frmAuto.txtprecioauto.getText().isEmpty() || frmAuto.CBoxMarcaAuto.getSelectedIndex()==0){
               JOptionPane.showMessageDialog(null,"Las cajas estan vacias");
           }
           else{
               this.auto.setId_Marca((int) frmAuto.CBoxMarcaAuto.getSelectedItem());
               this.auto.getMarcaauto().setModelo(new ArrayList <>((Collection<? extends ModeloAuto>) new ModeloAuto(this.frmAuto.txtmodeloAuto.getText())));
               this.auto.setPrecio(Integer.valueOf(this.frmAuto.txtprecioauto.getText()));
               this.auto.setColor((String) this.frmAuto.CboxColorAuto.getSelectedItem());
               
               this.consulta.AgregarAuto(auto);
               
               this.frmAuto.setVisible(false);
               
           }
       }
       if(e.getSource()== frmAuto.btn_cancelar){
           this.frmAuto.setVisible(false);
       }
    }

}
