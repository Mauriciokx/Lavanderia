/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Conexion.Conexion;
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
    //public static AgregarPromocion v3 =  new AgregarPromocion();
    public static Promociones vPromociones = new Promociones();
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();
    
    public static void mostrar(JDesktopPane principal, JInternalFrame vPromociones){
        principal.add(vPromociones);
        vPromociones.show();
        consultar();
    }
    
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
}
