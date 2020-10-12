/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consultas;
import Modelo.Empleado;
import Modelo.Empresa;
import Vista.Interfaz_Admin;
import Vista.Interfaz_home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.CellEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Controlador_Admin  implements ActionListener {

    private Interfaz_Admin view;
    private Consultas con;
    private Empresa emp;

    public Controlador_Admin(Interfaz_Admin view, Consultas con, Empresa emp) {

        this.view = view;
        this.con = con;
        this.emp = emp;
        this.view.setVisible(true);
        this.JtableEmp(); // rellena las jtables
        this.view.btn_exit.addActionListener(this);
        this.view.btn_eliminarEmpleado.addActionListener(this);
        this.view.btn_modifcarEmpleado.addActionListener(this);
    }

    public Controlador_Admin() {
        view = new Interfaz_Admin();
        con = new Consultas();
        emp = new Empresa();
        view.setVisible(true);
        JtableEmp();
        this.view.btn_exit.addActionListener(this);
        this.view.btn_eliminarEmpleado.addActionListener(this);
        this.view.btn_modifcarEmpleado.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btn_exit) {
            Controlador_Home home = new Controlador_Home(new Interfaz_home(), new Interfaz_Admin());
            this.view.setVisible(false);
            home.rellenar_JTable();
        }
        if (e.getSource() == view.Btn_agregarEmpleado) {
            
        }
        if (e.getSource() == view.btn_eliminarEmpleado) {
            if (view.JtableEmpleado.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea continuar con la accion? Se eliminara un registro", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    int id_vendedor = view.JtableEmpleado.getSelectedRow() + 1;
                    con.EliminarEmpleado(id_vendedor);
                    this.JtableEmp();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Elija una fila porfavor");
            }

        }
        if (e.getSource() == view.btn_modifcarEmpleado) {
            if (view.JtableEmpleado.getSelectedRowCount()> 0) {
                   view.JtableEmpleado.setEnabled(true);
            }
        }

    }

    public void JtableEmp() {
        DefaultTableModel model1 = new DefaultTableModel();
        DefaultTableModel model = new DefaultTableModel();
        //Columnas del modelo de Tabla Cliente
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Provincia");
        model.addColumn("Ciudad");
        model.addColumn("Direccion");
        model.addColumn("Sueldo");
        //Columnas del modelo de tabla de ventas
        model1.addColumn("Nombre");
        model1.addColumn("Apellido");
        model1.addColumn("Total Ventas");
        model1.addColumn("Recaudacion");
        
        ArrayList<Empresa> empr = con.totalventas();
        ArrayList<Empleado> empleados = con.NombresEmpleados();
        for (int i = 0; i < empr.size()-1; i++) {
            model1.addRow(new Object[]{empr.get(i).getEmpleado().getNombre(),empr.get(i).getEmpleado().getApellido(),empr.get(i).getEmpleado().getNum_Ventas(),empr.get(i).getEmpleado().getTotaltodasventas()});
            
        }
        int c = 0;
        while (c <= empleados.size() - 1) {

            model.addRow(new Object[]{empleados.get(c).getNombre(), empleados.get(c).getApellido(),"","","", empleados.get(c).getSueldo()});
            c++;
        }
       
        view.JtableEmpleado.setModel(model);
        view.Jtable_ventas.setModel(model1);
        
        //  for (int i = 0; i < empleados.size(); i++) {

        /*  model.setValueAt();
            model.setValueAt(empleados.get(i).getApellido(), i, 1);
            model.setValueAt(, i, 5);
         */
        //}
        for (int i = 0; i < con.metodospago().size(); i++) {
            view.JboxMetodopago.addItem(con.metodospago().get(i));
        }
    }
    


}
