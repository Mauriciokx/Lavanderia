/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Vista.AgregarPromocion;
import Modelo.Promocion;
/**
 *
 * @author Mauricio Pacheco
 * 16 jul. 2024 - 17:43:52
 */
public class ControladorPromocion {
    public static AgregarPromocion v3 =  new AgregarPromocion();
    
    public static void agregarPromocion(){
        Promocion pro1 = new Promocion(v3.nombre.getText(), v3.descripcion.getText(),
                (String)v3.producto.getSelectedItem(),
                Integer.parseInt(v3.cantidad.getText()),Double.parseDouble(v3.costo.getText()));
        System.out.println(pro1.toString());
    }
    
    public static void mostrar(){
        v3.setVisible(true);
    }
}
