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
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();

    public static void mostrar(JDesktopPane principal, JInternalFrame vProductos){
        principal.add(vProductos);
        vProductos.show();
        consultar();
    }
    
    public static void consultar(){
        String sql = "select idProducto, nombre, unidad, precio from productos where estatus = 'activo'";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            Object[] datos = new Object[4];
            modelo = (DefaultTableModel) vProductos.listProductos.getModel();
            
            while(rs.next()){
                datos[0] = rs.getInt("IdProducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("unidad");
                datos[3] = rs.getDouble("precio");
                modelo.addRow(datos);
            }
            vProductos.listProductos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
}
