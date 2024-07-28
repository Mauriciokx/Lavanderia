/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Conexion.Conexion;
import static Controlador.ControladorNota.vNota;
import Vista.AgregarPedido;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Nota;
import Vista.Pedidos;
import Vista.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 18:01:12
 */
public class ControladorPedido {
    //public static AgregarPedido v4 = new AgregarPedido();
    public static DefaultTableModel model;
    public static int cont = 0;
    public static Principal vPrincipal = new Principal();
    public static Pedidos vPedidos = new Pedidos();
    public static AgregarPedido vAgregarPed = new AgregarPedido();
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();
    //public static Nota vNota = new Nota();
    
    public static void agregarProducto(){
        String nomPro = (String)vAgregarPed.producto.getSelectedItem();
        int can = Integer.parseInt(vAgregarPed.cantidad.getText());
        double precio = consultarProducto();
        cont = cont+1;
        double costo = 0;
        costo = can*precio;
        model = (DefaultTableModel) vAgregarPed.listProductos.getModel();
        model.addRow(new Object[]{cont,nomPro, can, costo});
    }

    public static void agregarPedido(){
        String nomCliente = (String)vAgregarPed.nomCliente.getSelectedItem();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaI = currentDate.format(formatter);
        String fechaP = vAgregarPed.fEntrega.getDateFormatString();
        String es = "activo";
        
        try {
            String sql = "insert into pedidos (nombreCliente, fechaIngreso, fechaEntregaP, estatus) values ('"+nomCliente+"','"+fechaI+"','"+fechaP+"','"+es+"')";
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            vAgregarPed.dispose();
            //Llamado a la ventana nota
            ControladorNota.mostrar(vPrincipal.principal, vNota);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
       
    }
    
    public static void mostrar(JDesktopPane principal, JInternalFrame vPedidos){
        principal.add(vPedidos);
        vPedidos.show();
        limpiarTabla();
        consultar();
    }
    
    public static void mostrar2(JDesktopPane principal, JInternalFrame vAgregarPed){
        principal.add(vAgregarPed);
        vAgregarPed.show();
        llenarComboProductos();
        llenarComboClientes();
    }
    
    public static void consultar(){
        String sql = "select idPedidos ,nombreCliente, fechaIngreso, fechaEntregaP, fechaEntregaR from pedidos where estatus = 'activo'";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            Object[] datos = new Object[5];
            modelo = (DefaultTableModel) vPedidos.listPedidos.getModel();
            
            while(rs.next()){
                datos[0] = rs.getInt("idPedidos");
                datos[1] = rs.getString("nombreCliente");
                datos[2] = rs.getString("fechaIngreso");
                datos[3] = rs.getString("fechaEntregaP");
                datos[4] = rs.getString("fechaEntregaR");
                modelo.addRow(datos);
            }
            vPedidos.listPedidos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
        
    }
    
    public static void limpiarTabla(){
        while (vPedidos.listPedidos.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    
    public static void llenarComboProductos(){
        String sql = "select nombre from productos where estatus = 'activo'";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String nom = rs.getString("nombre");
                vAgregarPed.producto.addItem(nom);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void llenarComboClientes(){
        String sql = "select nombre from clientes where estatus = 'activo'";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String nom = rs.getString("nombre");
                vAgregarPed.nomCliente.addItem(nom);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static double consultarProducto(){
        String pro = (String)vAgregarPed.producto.getSelectedItem();
        String sql = "select costo from productos where nombre = '"+pro+"'";
        double pre=0;
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                pre = rs.getDouble("costo");
            }
        } catch (Exception e) {
        }
        return pre;
    }
}
