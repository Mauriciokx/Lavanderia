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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


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
    
    //Varibles para folio
    private static final int FOLIO_LENGTH = 5;
    private static final int MAX_FOLIOS = (int) Math.pow(10, FOLIO_LENGTH); // 100000
    private static final Set<Integer> generatedFolios = new HashSet<>();
    private static final Random random = new Random();
    
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
    
    public static void mostrar(JDesktopPane principal, Pedidos frmPedidos){
        principal.add(frmPedidos);
        frmPedidos.show();
        limpiarTabla();
        Pedido.consultarPedido(frmPedidos);
    }
    
    public static void mostrar2(JDesktopPane principal, AgregarPedido frmAgregarPedido){
        principal.add(frmAgregarPedido);
        frmAgregarPedido.show();
        llenarComboProductos();
        llenarComboClientes();
        frmAgregarPedido.folio.setText(generarFolio());
    }
    
    public static void limpiarTabla(){
        while (vPedidos.listPedidos.getRowCount() > 0) {
            modelo = (DefaultTableModel) vPedidos.listPedidos.getModel();
            modelo.removeRow(0);
        }
    }
    
    public static void llenarComboProductos(){
        String sql = "select nombre from productos where estatus = 1";
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
        String sql = "select nombre from clientes where estatus = 1";
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
    
    public static void agregarPedidos(){
        String nom = (String)vAgregarPed.nomCliente.getSelectedItem();
        Date selectedDate = vAgregarPed.fEntrega.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fE = dateFormat.format(selectedDate);
        int es = 1;
        String folio = vAgregarPed.folio.getText();
        Pedido.agregarPedido(nom, fE, es, folio);
        vAgregarPed.dispose();
    }
    
    public static void aplicarPromocion(){
        
    }
    
    public static String generarFolio() {
        if (generatedFolios.size() == MAX_FOLIOS) {
            throw new RuntimeException("Todos los folios posibles han sido generados.");
        }

        int folio;
        do {
            folio = random.nextInt(MAX_FOLIOS);
        } while (generatedFolios.contains(folio));

        generatedFolios.add(folio);
        return String.format("%05d", folio); // Formatear a 5 cifras con ceros iniciales si es necesario
    }
    
    
}
