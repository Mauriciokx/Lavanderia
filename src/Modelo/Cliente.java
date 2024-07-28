/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Vista.Clientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 *
 * @author Mauricio Pacheco
 */
public class Cliente {
    
    //private int idCliente;
    private String nombre;
    private String telefono;
    private String direccion;
    private String rfc;
    //private Pedido pedido;
    
    //Variables de conexion
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();

    public Cliente(String nombre, String telefono, String direccion, String rfc) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    public static void consultarClientes(Clientes vClientes){
        String sql = "select idClientes ,nombre, telefono, direccion, rfc from clientes where estatus = 1";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            Object[] datos = new Object[5];
            modelo = (DefaultTableModel) vClientes.listClientes.getModel();
            
            while(rs.next()){
                datos[0] = rs.getInt("IdClientes");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("telefono");
                datos[3] = rs.getString("direccion");
                datos[4] = rs.getString("rfc");
                modelo.addRow(datos);
            }
            vClientes.listClientes.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void insertarCliente(String nom,String tel,String dir,String rfc,int es){
        try {
            if(nom.equals("")||tel.equals("")||dir.equals("")||rfc.equals("")){
                JOptionPane.showMessageDialog(null, "Falta agregar datos");
            }else{
                String sql = "INSERT INTO clientes (nombre, telefono, direccion, rfc, estatus) values ('"+nom+"','"+tel+"','"+dir+"','"+rfc+"','"+es+"')";
                conexion = con.obtenerConexion();
                st = conexion.createStatement();
                st.executeUpdate(sql);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void modificarCliente(String nom,String tel, String dir,String rfc){
        try {
            String sql = "Update clientes set nombre='"+nom+"',telefono='"+tel+"',direccion='"+dir+"',rfc='"+rfc+"' where rfc ='"+rfc+"'";
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void eliminarCliente(String rfc){
        try {
            int es = 0;
            String sql = "Update clientes set estatus='"+es+"' where rfc ='"+rfc+"'";
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
}
