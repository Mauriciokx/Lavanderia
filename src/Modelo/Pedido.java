/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Vista.Pedidos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Mauricio Pacheco
 */
public class Pedido {
    
    //private String noPedido;
    private String nomCliente;
    private String telefono;
    private String direccion;
    private String rfc;
    //private Nota nota;
    private ArrayList<String> listProductos;
    
    //Variables de conexion
    public static Connection conexion;
    public static DefaultTableModel modelo;
    public static Statement st;
    public static ResultSet rs;
    public static Conexion con = new Conexion();

    public Pedido(String nomCliente, String telefono, String direccion, String rfc, ArrayList<String> listProductos) {
        this.nomCliente = nomCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rfc = rfc;
        //this.nota = nota;
        this.listProductos = listProductos;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
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
    
    public ArrayList<String> getListProductos() {
        return listProductos;
    }

    public void setListProductos(ArrayList<String> listProductos) {
        this.listProductos = listProductos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nomCliente=" + nomCliente + ", telefono=" + telefono + ", direccion=" + direccion + ", rfc=" + rfc + '}';
    }
    
    public static void consultarPedido(Pedidos vPedidos){
        String sql = "select idPedidos ,nombreCliente, fechaIngreso, fechaEntregaP, fechaEntregaR from pedidos where estatus = 1";
        try {
            conexion = con.obtenerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            Object[] datos = new Object[5];
            modelo = (DefaultTableModel) vPedidos.listPedidos.getModel();
            
            while(rs.next()){
                datos[0] = rs.getInt("IdPedidos");
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
    
    public static void agregarPedido(String nom,String fEp,int es,String folio){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fI = currentDate.format(formatter);
        try {
            if(nom.equals("")){
                JOptionPane.showMessageDialog(null, "Falta agregar datos");
            }else{
                String sql = "insert into pedidos (nombreCliente, fechaIngreso, fechaEntregaP, estatus, folio) values ('"+nom+"','"+fI+"','"+fEp+"',"+es+",'"+folio+"')";
                conexion = con.obtenerConexion();
                st = conexion.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Pedido agregado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }

}
