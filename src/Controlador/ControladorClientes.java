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
import Vista.ModificarCliente;

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
    
    //Instancia de modelo Cliente
    
    //Instancia vista modificar Cliente
    public static ModificarCliente vModificarCliente = new ModificarCliente();
    
    
    public static void mostrar(JDesktopPane principal, Clientes frmClientes){
        principal.add(frmClientes);
        frmClientes.show();
        limpiarTabla();
        Cliente.consultarClientes(frmClientes);
        //consultar();
        
    }
    
    public static void mostrar2(JDesktopPane principal, AgregarCliente frmAgregarCliente){
        principal.add(frmAgregarCliente);
        frmAgregarCliente.show();
    }
    /* No lo usare :v
    public static void mostrar3(JDesktopPane principal, ModificarCliente frmModificarCliente){
        principal.add(frmModificarCliente);
        frmModificarCliente.show();
        //llenarCampos(frmModificarCliente);
    }
    */
    
    //Metodo cambiado al modelo de Cliente
    /*
    public static void consultar(){
        String sql = "select idClientes, nombre, telefono, direccion, rfc from clientes where estatus = 1";
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
    */
    /*
    public static void insertarCliente(){
        String nom = vAgregarC.nombre.getText();
        String tel = vAgregarC.telefono.getText();
        String dir = vAgregarC.direccion.getText();
        String rfc = vAgregarC.rfc.getText();
        int es = 1;
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
    */
    
    //Metodo para limpiar la tabla
    public static void limpiarTabla(){
        while (vClientes.listClientes.getRowCount() > 0) {
            modelo = (DefaultTableModel) vClientes.listClientes.getModel();
            modelo.removeRow(0);
        }
    }
    
    //Metodo de llamado para insertar clientes
    public static void insertarClientes(){
        String nom = vAgregarC.nombre.getText();
        String tel = vAgregarC.telefono.getText();
        String dir = vAgregarC.direccion.getText();
        String rfc = vAgregarC.rfc.getText();
        int es = 1;
        Cliente.insertarCliente(nom, tel, dir, rfc, es);
        vAgregarC.dispose();
    }
    
    //Metodo para llamar modificar cliente
    public static void modificarClientes(String nom,String tel,String dir,String rfc){
        Cliente.modificarCliente(nom, tel, dir, rfc);
        limpiarTabla();
        Cliente.consultarClientes(vClientes);
        vClientes.nombre.setText("");
        vClientes.telefono.setText("");
        vClientes.direccion.setText("");
        vClientes.campoRfc.setText("");
    }
    
    public static void eliminarClientes(String rfc){
        Cliente.eliminarCliente(rfc);
        limpiarTabla();
        Cliente.consultarClientes(vClientes);
        vClientes.nombre.setText("");
        vClientes.telefono.setText("");
        vClientes.direccion.setText("");
        vClientes.campoRfc.setText("");
    }
    
}
