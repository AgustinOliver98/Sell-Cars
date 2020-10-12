/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Consultas {
    // Logeo de interfaz - Retorna un resultado si es valido o no
        Conector conexion = new Conector();
    public String Logeo(Logeo usr) {
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        String resultado = "";
        String sql = "SELECT u.Usuario,u.Pass,t.tipo FROM usuario u join tipo_usuario t where (u.id_tipousuario=t.id_tipousuario)and u.Usuario='" + usr.getUsuario() + "'and u.Pass='" + usr.getPass() + "'";
        ResultSet rs;
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                resultado = rs.getString("tipo");

            }

        } catch (SQLException ex) {

            System.out.println(ex);

        }
        conexion.CerrarConexion();
        return resultado;
    }

    // Agrega a la base de datos un auto por medio del administrador o empleado
    public void AgregarAuto(Mod_Agregarauto auto) {
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        String sql = "INSERT INTO Modelos_autos (modelos,precio,color,id_marca)VALUES ('" + auto.getMarcaauto().getModelo().get(0).getNombre() + "'," + auto.getPrecio() + ",'" + auto.getColor() + "'," + auto.getId_Marca() + ")";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
    }

    public void AgregarCliente(Cliente persona) {
        int id_ciudad;
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        ResultSet rs = null;
        int idCiudad = 0;

        String sql1 = "SELECT c.id_ciudad from ciudad c join Domicilio d on (c.id_provincia = d.id_Domicilio)and c.id_provincia=" + persona.getId_provincia() + " and c.ciudad='" + persona.getCiudad() + "'";

        try {
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            if (rs.next()) {
                idCiudad = rs.getInt("id_ciudad");
                System.out.println(idCiudad);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String sql = "INSERT INTO cliente (nombre,Apellido,fecha_nac,telefono,id_ciudad,Direccion)VALUES ('" + persona.getNombre() + "','" + persona.getApellido() + "','" + persona.getFechanac() + "'," + persona.getTelefono() + "," + idCiudad + ",'" + persona.getDireccion() + "')";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
         conexion.CerrarConexion();
    }

    public ArrayList<Cliente> NombresClientes() {
        int a = 0;
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "select p.*,c.ciudad,a.provincia from cliente p join ciudad c on (p.id_ciudad=c.id_ciudad) join Domicilio a on (a.id_domicilio=c.id_provincia)";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString("nombre"), rs.getString("Apellido"), "", rs.getString("provincia"), rs.getString("Direccion"), rs.getString("ciudad"), 0, 0, 0, rs.getInt("telefono"), null));
                a++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return clientes;

    }

    public ArrayList<Empleado> NombresEmpleados() {
        int a = 0;
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        ResultSet rs = null;
        ArrayList<Empleado> empleados = new ArrayList();
        String sql = "SELECT e.nombre ,e.apellido,e.sueldo from vendedor e where e.id_estado <> 0";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                empleados.add(new Empleado(rs.getInt("sueldo"),rs.getString("nombre"),rs.getString("apellido"), ""));
                a++;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return empleados;

    }

    public ArrayList<String> MarcaAutos() {
        ArrayList<String> Marca_Autos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String Sql = "Select m.marca from Marca_autos m";

        try {
            ps = con.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Marca_Autos.add(rs.getString("marca"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return Marca_Autos;
    }

    public ArrayList<String> ModelosAutos(String Marca) {
        ArrayList<String> modelos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String sql = "Select m.modelos from Modelos_autos m join Marca_autos p on (m.id_marca= p.id_marca and p.marca='" + Marca + "')";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                modelos.add(rs.getString("modelos"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return modelos;
    }

    public ArrayList<Auto> car() {
        ArrayList<Auto> auto = new ArrayList<>();
        Mod_Agregarauto aux = new Mod_Agregarauto();
        ArrayList<ModeloAuto> Models = new ArrayList<>();

        Connection con = conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "Select p.marca,m.modelos,m.precio from Marca_autos p join Modelos_autos m on (p.id_marca = m.id_marca) ORDER BY p.marca";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                auto.add(new Auto(rs.getInt("precio"), new Marca(rs.getString("marca")), new ModeloAuto(rs.getString("modelos")), ""));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return auto;

    }

    public ArrayList<String> adicionales() {
        Connection con = conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<String> adicionales = new ArrayList<>();
        String sql = "SELECT a.adicional from auto_adicional a";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                adicionales.add(rs.getString("adicional"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return adicionales;
    }

    public ArrayList<String> metodospago() {
        Connection con = conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<String> metodospago = new ArrayList<>();
        String sql = "SELECT t.tipo from tipo_venta t";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                metodospago.add(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
         conexion.CerrarConexion();
        return metodospago;
    }

    public void Compra(Auto auto, Empleado empleado, Cliente cliente, Date fecha) {
        Connection con = conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        int id_modelo = 0;

        String sql2 = "select id_modelos from Modelos_autos m join Marca_autos p on (p.id_marca = m.id_marca and m.modelos='" + auto.getModelo().getNombre() + "')";

        try {
            ps = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            if (rs.next()) {
                id_modelo = rs.getInt("id_modelos");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String sql = "insert into factura (id_tipofactura,id_cliente,id_empleado,id_modelo,fecha,id_adicional,id_tipopago,total) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, cliente.getId_cliente());
            ps.setInt(3, empleado.getId());
            ps.setInt(4, id_modelo);
            ps.setDate(5, (java.sql.Date) fecha);
            ps.setInt(6, auto.getId_adicional());
            ps.setInt(7, cliente.getPago());
            ps.setInt(8, cliente.getGastototal());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();

    }

    public ArrayList<Venta> ConsultaVenta() {
        ArrayList<Venta> venta = new ArrayList<>();

        Connection con = conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select c.nombre as cliente_nombre, c.apellido as cliente_apellido , e.nombre as nombre_empleado, e.apellido as apellido_empleado,m.modelos,p.marca,f.total,f.fecha from cliente c join factura f on (f.id_cliente = c.id_cliente) join vendedor e on (f.id_empleado=e.id_vendedor) join Modelos_autos m on (m.id_modelos = f.id_modelo) join Marca_autos p on (m.id_marca =p.id_marca)";
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                venta.add(new Venta(new Auto(0, new Marca(rs.getString("marca")), new ModeloAuto(rs.getString("modelos")), ""), new Cliente(rs.getInt("total"), rs.getString("cliente_nombre"), rs.getString("cliente_apellido"), ""), new Empleado(rs.getString("nombre_empleado"), rs.getString("apellido_empleado"), ""), new Fecha(rs.getDate("fecha"))));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return venta;
    }

    public ArrayList<Empresa> totalventas() {
        Connection con = conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select e.nombre,e.apellido,e.sueldo, SUM(f.total) as recaudacion , count(f.id_empleado) as total_ventas from factura f join vendedor e on (f.id_empleado=e.id_vendedor) group by id_empleado";
        ArrayList <Empresa> emp = new ArrayList<>();
        
        try{
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                emp.add(new Empresa(new Empleado(rs.getInt("total_ventas"),rs.getInt("recaudacion"),rs.getString("nombre"),rs.getString("apellido"),"")));
            }
                
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
         conexion.CerrarConexion();
        return emp;
    }
    
    public void EliminarEmpleado(int id_empleado){
        Connection con = conexion.getConexion();
        PreparedStatement ps; 
        
        String SQL = "update vendedor as e set id_estado=0 where e.id_vendedor="+id_empleado;
        
        
        try{
           ps = con.prepareStatement(SQL);
           ps.execute();
           
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }

}
