/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Vista.Promociones;
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
public class Promocion {
    private String nombre;
    private String descripcion;
    private String nomProducto;
    private int cantidad;
    private double costo;
    
    //Variables de conexion
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();

    public Promocion(String nombre, String descripcion, String nomProducto, int cantidad, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nomProducto = nomProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Promocion(String nombre, String descripcion, int cantidad, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Promocion{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", nomProducto=" + nomProducto + ", cantidad=" + cantidad + ", costo=" + costo + '}';
    }
    
    public static void consultarPromociones(Promociones vPromociones){
        String sql = "select idPromocion ,nombre, descripcion, producto, cantidad,costo, fechaInicio, fechaFin from promociones where estatus = 1";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            Object[] datos = new Object[8];
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
                modelo.addRow(datos);
            }
            vPromociones.listPromociones.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void agregarPromocion(String nom,String des,String pro,String can,String cos,String fI,String fF,int es){
        try {
            if(nom.equals("")||des.equals("")||pro.equals("")){
                JOptionPane.showMessageDialog(null, "Falta agregar datos");
            }else{
                String sql = "insert into promociones (nombre, descripcion, producto, cantidad, costo, fechaInicio, fechaFin, estatus) values ('"+nom+"','"+des+"','"+pro+"','"+can+"','"+cos+"','"+fI+"','"+fF+"','"+es+"')";
                conexion = con.obtenerConexion();
                st = conexion.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Promocion agregada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void modificarPromocion(int id,String nom,String des,String pro,String can,String cos,String fI,String fF){
        try {
            String sql = "Update promociones set nombre='"+nom+"',descripcion='"+des+"',producto='"+pro+"',cantidad='"+can+"',costo='"+cos+"',fechaInicio='"+fI+"',fechaFin='"+fF+"' where idPromocion ="+id;
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Promocion modificada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void eliminarPromocion(int id){
        try {
            int es = 0;
            String sql = "Update promociones set estatus='"+es+"' where idPromocion ="+id;
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Promocion eliminada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
     
}
