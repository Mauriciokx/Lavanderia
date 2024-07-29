/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Vista.Productos;
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
public class Producto {
    private String nombre;
    private String unidad;
    private double costo;
    //private Promocion promocion;
    
    //Variables de conexion
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();

    public Producto(String nombre, String unidad, double costo) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", unidad=" + unidad + ", costo=" + costo + '}';
    }
    
    public static void agregarProducto(String nom,String unidad,String costo,int es){
        try {
            if(nom.equals("")||unidad.equals("")||costo.equals("")){
                JOptionPane.showMessageDialog(null, "Falta agregar datos");
            }else{
                String sql = "INSERT INTO productos (nombre, unidad, costo, estatus) values ('"+nom+"','"+unidad+"','"+costo+"',"+es+")";
                conexion = con.obtenerConexion();
                st = conexion.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Producto agregado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void consultarProductos(Productos vProductos){
        String sql = "select idProducto ,nombre, unidad, costo from productos where estatus = 1";
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
                datos[3] = rs.getString("costo");
                modelo.addRow(datos);
            }
            vProductos.listProductos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void modificarProducto(int id,String nom,String un,double costo){
        try {
            String sql = "Update productos set nombre='"+nom+"',unidad='"+un+"',costo="+costo+" where idProducto="+id;
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Producto modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    public static void eliminarProducto(int id){
        try {
            int es = 0;
            String sql = "Update productos set estatus='"+es+"' where idProducto ="+id;
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Producto eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
}
