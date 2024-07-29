/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Conexion.Conexion;
import Modelo.Producto;
import Vista.AgregarPromocion;
import Modelo.Promocion;
import Vista.Promociones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 17:43:52
 */
public class ControladorPromocion {
    public static AgregarPromocion vAgregarPr =  new AgregarPromocion();
    public static Promociones vPromociones = new Promociones();
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();
    
    public static void mostrar(JDesktopPane principal, Promociones frmPromociones){
        principal.add(frmPromociones);
        frmPromociones.show();
        limpiarTabla();
        Promocion.consultarPromociones(frmPromociones);
    }
    
    public static void mostrar2(JDesktopPane principal, AgregarPromocion frmAgregarPromocion){
        principal.add(frmAgregarPromocion);
        frmAgregarPromocion.show();
    }
    /*
    public static void consultar(){
        String sql = "select idPromocion, nombre, descripcion, producto, cantidad, costo, fechaInicio, fechaFin, estatusP from promociones where estatus = 'activo'";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            Object[] datos = new Object[9];
            modelo = (DefaultTableModel) vPromociones.listPromociones.getModel();
            
            while(rs.next()){
               datos[0] = rs.getInt("IdPromocion");
               datos[1] = rs.getString("nombre");
               datos[2] = rs.getString("descripcion");
               datos[3] = rs.getString("producto");
               datos[4] = rs.getString("cantidad");
               datos[5] = rs.getString("costo");
               datos[6] = rs.getString("fechaInicio");
               datos[7] = rs.getString("fechaFin");
               datos[8] = rs.getString("estatusP");
               modelo.addRow(datos); 
            }
            vPromociones.listPromociones.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void insertar(){
        String nom = vAgregarPr.nombre.getText();
        String desc = vAgregarPr.desc.getText();
        String prod = (String)vAgregarPr.producto.getSelectedItem();
        String can = vAgregarPr.cantidad.getText();
        String cos = vAgregarPr.costo.getText();
        String fI = vAgregarPr.fechaI.getDateFormatString();
        String fF = vAgregarPr.fechaF.getDateFormatString();
        String est = (String)vAgregarPr.esta.getSelectedItem();
        String es = "activo";
        try {
            if(vAgregarPr.nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Falta agregar datos");
            }else{
                String sql = "insert into promociones (nombre, descripcion, producto, cantidad, costo, fechaInicio, fechaFin, estatusP, estatus) values ('"+nom+"','"+desc+"','"+prod+"','"+can+"','"+cos+"','"+fI+"','"+fF+"','"+est+"','"+es+"')";
                conexion = con.obtenerConexion();
                st = conexion.createStatement();
                st.executeUpdate(sql);
                vAgregarPr.dispose();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    */
    
    public static void limpiarTabla(){
        while (vPromociones.listPromociones.getRowCount() > 0) {
            modelo = (DefaultTableModel) vPromociones.listPromociones.getModel();
            modelo.removeRow(0);
        }
    }
    
    public static void agregarPromociones(){
        String nom = vAgregarPr.nombre.getText();
        String des = vAgregarPr.desc.getText();
        String prod = (String)vAgregarPr.producto.getSelectedItem();
        String can = vAgregarPr.cantidad.getText();
        String costo = vAgregarPr.costo.getText();
        String fI = vAgregarPr.fechaI.getDateFormatString();
        String fF = vAgregarPr.fechaF.getDateFormatString();
        int es = 1;
        Promocion.agregarPromocion(nom, des, prod, can, costo, fI, fF, es);
        vAgregarPr.dispose();
    }
    
    public static void modificarPromociones(String nom,String des,String pro,String can,String cos,String fI,String fF){
        Promocion.modificarPromocion(nom, des, pro, can, cos, fI, fF);
        limpiarTabla();
        Promocion.consultarPromociones(vPromociones);
        vPromociones.nombre.setText("");
        vPromociones.descripcion.setText("");
        vPromociones.cantidad.setText("");
        vPromociones.costo.setText("");
    }
    
    public static void eliminarPromociones(String nom){
        Promocion.eliminarPromocion(nom);
        limpiarTabla();
        Promocion.consultarPromociones(vPromociones);
        vPromociones.nombre.setText("");
        vPromociones.descripcion.setText("");
        vPromociones.cantidad.setText("");
        vPromociones.costo.setText("");
    }
}
