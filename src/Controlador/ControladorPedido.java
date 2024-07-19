/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Vista.AgregarPedido;
import Modelo.Pedido;
import Modelo.Producto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 18:01:12
 */
public class ControladorPedido {
    public static AgregarPedido v4 = new AgregarPedido();
    public static DefaultTableModel model = new DefaultTableModel();
    
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
       //Pedido p1 = new Pedido();
    }
    
    public static void mostrar(){
        model.addColumn("No");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        v4.setVisible(true);
    }
}
