/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Conexion.Conexion;
import Vista.AgregarProducto;
import Modelo.Producto;
import Vista.Productos;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 11:47:45
 */
public class ControladorProducto {
    //public static AgregarProducto v2 = new AgregarProducto();
    public static Productos vProductos = new Productos();
    public static AgregarProducto vAgregarP = new AgregarProducto();
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();

    public static void mostrar(JDesktopPane principal, Productos frmProductos){
        principal.add(frmProductos);
        frmProductos.show();
        limpiarTabla();
        Producto.consultarProductos(frmProductos);
    }
    
    public static void mostrar2(JDesktopPane principal, AgregarProducto frmAgregarProducto){
        principal.add(frmAgregarProducto);
        frmAgregarProducto.show();
    }
    
    public static void limpiarTabla(){
        while (vProductos.listProductos.getRowCount() > 0) {
            modelo = (DefaultTableModel) vProductos.listProductos.getModel();
            modelo.removeRow(0);
        }
    }
    
    public static void agregarProductos(){
        String nombre = vAgregarP.nombre.getText();
        String unidad = (String)vAgregarP.unidad.getSelectedItem();
        //String unidad = unidad0.toUpperCase();
        String costo = vAgregarP.costo.getText();
        int es = 1;
        Producto.agregarProducto(nombre, unidad, costo, es);
        vAgregarP.dispose();
    }
    
    public static void modificarProductos(int id,String nom,String un,double costo){
        Producto.modificarProducto(id,nom, un, costo);
        limpiarTabla();
        Producto.consultarProductos(vProductos);
        vProductos.nombre.setText("");
        vProductos.costo.setText("");
        vProductos.ID.setText("");
    }
    
    public static void eliminarProductos(int id){
        Producto.eliminarProducto(id);
        limpiarTabla();
        Producto.consultarProductos(vProductos);
        vProductos.nombre.setText("");
        vProductos.costo.setText("");
        vProductos.ID.setText("");
    }
}
