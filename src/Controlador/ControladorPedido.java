/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Vista.AgregarPedido;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Pedidos;
import Vista.Principal;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 18:01:12
 */
public class ControladorPedido {
    public static AgregarPedido v4 = new AgregarPedido();
    public static DefaultTableModel model = new DefaultTableModel();
    int con = 0;
    public static Principal vPrinciapal = new Principal();
    public static Pedidos vPedidos = new Pedidos();
    
    public static void agregarProducto(){
        //falta jalar bien los datos falta hacer auto incrementable el no
        String precio = "12";
        String no = "0";
        String nomProducto = (String)v4.producto.getSelectedItem();
        String cantidad = v4.cantidad.getText();
        v4.listProductos.setModel(model);
        model.addRow(new String[]{no,nomProducto,cantidad,precio});
    }
    
    public static void agregarPedido(){
       
    }
    
    public static void mostrar(JDesktopPane principal, JInternalFrame vPedidos){
        model.addColumn("No");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        principal.add(vPedidos);
        vPedidos.show();
    }
}
