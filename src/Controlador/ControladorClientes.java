/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.AgregarCliente;
import Modelo.Cliente;
import Vista.Clientes;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import Conexion.Conexion;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Conexion.Conexion;

/**
 *
 * @author Mauricio Pacheco
 */
public class ControladorClientes {
    //public static AgregarCliente v1 = new AgregarCliente();
    public static Clientes vClientes = new Clientes();
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();
    public static AgregarCliente vAgregarC = new AgregarCliente();
    //public static Cliente cliente =  new Cliente();
    
    public static void mostrar(JDesktopPane principal, JInternalFrame vClientes){
        principal.add(vClientes);
        vClientes.show();
        limpiarTabla();
        consultar();
    }
    
    public static void mostrar2(JDesktopPane principal, JInternalFrame vAgregarC){
        principal.add(vAgregarC);
        vAgregarC.show();
    }
    
    public static void consultar(){
        String sql = "select idClientes, nombre, telefono, direccion, rfc from clientes";
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
    
    public static void insertarCliente(){
        String nom = vAgregarC.nombre.getText();
        String tel = vAgregarC.telefono.getText();
        String dir = vAgregarC.direccion.getText();
        String rfc = vAgregarC.rfc.getText();
        String es = "activo";
        try {
            if(vAgregarC.nombre.equals("") || vAgregarC.telefono.equals("") || vAgregarC.direccion.equals("") || vAgregarC.rfc.equals("")){
                JOptionPane.showMessageDialog(null, "Falta agregar datos");
            }else{
                String sql = "INSERT INTO clientes (nombre, telefono, direccion, rfc, estatus) values ('"+nom+"','"+tel+"','"+dir+"','"+rfc+"','"+es+"')";
                conexion = con.obtenerConexion();
                st = conexion.createStatement();
                st.executeUpdate(sql);
                vAgregarC.dispose();
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void limpiarTabla(){
        while (vClientes.listClientes.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
}
