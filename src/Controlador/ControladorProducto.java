/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Vista.AgregarProducto;
import Modelo.Producto;
import javax.swing.JOptionPane;
/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 11:47:45
 */
public class ControladorProducto {
    public static AgregarProducto v2 = new AgregarProducto();
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

    public static void mostrar(){
        v2.setVisible(true);
    }
}
