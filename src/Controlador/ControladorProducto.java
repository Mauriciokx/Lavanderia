/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Vista.AgregarProducto;
import Modelo.Producto;
import Vista.Productos;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 11:47:45
 */
public class ControladorProducto {
    public static AgregarProducto v2 = new AgregarProducto();
    public static Productos vProductos = new Productos();
    /*
    public static void agregraProducto(){
        try {
            Producto p1 = new Producto(v2.nombre.getText(), (String)v2.unidad.getSelectedItem(),
        Double.parseDouble(v2.costo.getText()));
            System.out.println(p1.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Solo se permiten numeros en la casilla de costo");
            v2.costo.setText("");
        }
    }
*/

    public static void mostrar(JDesktopPane principal, JInternalFrame vProductos){
        principal.add(vProductos);
        vProductos.show();
    }
}
