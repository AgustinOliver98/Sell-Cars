/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auto;
import Modelo.Cliente;
import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Empresa;
import Modelo.Mod_Agregarauto;
import Modelo.ModeloAuto;
import Vista.ClienteForm;
import Vista.Frm_Auto;
import Vista.Interfaz_Admin;
import Vista.Interfaz_home;
import Vista.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class Controlador_Home implements ActionListener {
    
    private Interfaz_home frmEmpleado;
    private Interfaz_Admin frmAdmin;
    
    public Controlador_Home(Interfaz_home frmEmpleado, Interfaz_Admin frmAdmin) {
        this.frmEmpleado = frmEmpleado;
        this.frmAdmin = frmAdmin;
        this.frmEmpleado.setVisible(true);
        this.frmEmpleado.btn_auto.addActionListener(this);
        this.frmEmpleado.bnt_agregarCliente.addActionListener(this);
        this.frmEmpleado.btn_vender.addActionListener(this);
        this.frmEmpleado.btnadmin.addActionListener(this);
        this.TableVenta();
        this.tablecliente();
        
    }
    
    public Controlador_Home() {
        frmEmpleado = new Interfaz_home();
        frmEmpleado.setVisible(true);
        this.frmEmpleado.btn_auto.addActionListener(this);
        this.frmEmpleado.bnt_agregarCliente.addActionListener(this);
        this.frmEmpleado.btn_vender.addActionListener(this);
        this.frmEmpleado.btnadmin.addActionListener(this);
        this.TableVenta();
        this.tablecliente();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmEmpleado.btn_auto) {
            Mod_Agregarauto auto = new Mod_Agregarauto();
            Frm_Auto view = new Frm_Auto();
            Consultas con = new Consultas();
            Controlador_auto car = new Controlador_auto(auto, view, con);
        }
        if (e.getSource() == frmEmpleado.bnt_agregarCliente) {
            
            Cliente per = new Cliente();
            ClienteForm view = new ClienteForm();
            Consultas con = new Consultas();
            
            Controlador_Cliente cliente = new Controlador_Cliente(per, view, con);
            
        }
        if (e.getSource() == frmEmpleado.btn_vender) {
            Cliente per = new Cliente();
            Venta view = new Venta();
            Consultas con = new Consultas();
            Empleado empleado = new Empleado();
            Auto auto = new Auto();
            
            con.NombresEmpleados();
            Controlador_Compra compra = new Controlador_Compra(per, empleado, auto, con, view);
            ArrayList<String> adicionales = con.adicionales();
            ArrayList<String> tipopago = con.metodospago();
            for (int i = 0; i < adicionales.size(); i++) {
                view.CboxAdicional.addItem(adicionales.get(i));
                view.jComboBox6.addItem(tipopago.get(i));
            }
            
        }
        if (e.getSource() == frmEmpleado.btnadmin) {
            Controlador_Admin adm = new Controlador_Admin();
            this.frmEmpleado.setVisible(false);
        }
        
    }
    
    public void rellenar_JTable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowindex, int columindex) {
                return false;
            }
        };
        
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Stock");
        model.addColumn("Precio");
        
        Consultas con = new Consultas();
        ArrayList<Auto> auto = con.car();
        
        int i = 0;
        while (i <= auto.size() - 1) {
            model.addRow(new Object[]{auto.get(i).getMarca().getMarca(), auto.get(i).getModelo().getNombre(), 1, auto.get(i).getPrecio()});
            i++;
        }
        frmEmpleado.jTable_Auto.setModel(model);
        
    }
    
    public void TableVenta() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowindex, int columindex) {
                return false;
            }
        };
        
        model.addColumn("Vendedor");
        model.addColumn("Cliente");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Total");
        model.addColumn("Fecha");
        
        Consultas con = new Consultas();
        ArrayList<Modelo.Venta> venta = con.ConsultaVenta();
        for (int i = 0; i < venta.size(); i++) {
            model.addRow(new Object[]{venta.get(i).getEmpleado().getNombre() + " " + venta.get(i).getEmpleado().getApellido(), venta.get(i).getCliente().getNombre() + " " + venta.get(i).getCliente().getApellido(), venta.get(i).getAuto().getMarca().getMarca(), venta.get(i).getAuto().getModelo().getNombre(), venta.get(i).getCliente().getGastototal(), venta.get(i).getFecha().getFecha()});
            
        }
        frmEmpleado.JTable_venta.setModel(model);
    }
    
    public void tablecliente() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowindex, int columindex) {
                return false;
            }
        };
        
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Domicilio");
        model.addColumn("Ciudad");
        model.addColumn("Provincia");
        model.addColumn("Telefono");
        
        Consultas con = new Consultas();
        ArrayList<Cliente> clientes = con.NombresClientes();
        for (int i = 0; i < clientes.size(); i++) {
            model.addRow(new Object[]{clientes.get(i).getNombre(), clientes.get(i).getApellido(), clientes.get(i).getDireccion(), clientes.get(i).getCiudad(), clientes.get(i).getProvincia(), clientes.get(i).getProvincia(), clientes.get(i).getTelefono()});
            
        }
        frmEmpleado.Jtable_clientes.setModel(model);
    }
    
    public void desactivarboton() {
        this.frmEmpleado.btnadmin.setEnabled(false);
        
    }
    
}
