/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.AgregarCliente;
import Modelo.Cliente;

/**
 *
 * @author Mauricio Pacheco
 */
public class ControladorClientes {
    public static AgregarCliente v1 = new AgregarCliente();
   
    /*
    public static void agregarCliente(){
        Cliente c1 = new Cliente(v1.nombre.getText(), v1.direccion.getText(),
            v1.telefono.getText(), v1.rfc.getText());
        //System.out.println(v1.nombre.getText());
        System.out.println(c1.toString());
    }
*/
    
    public static void mostrar(){
        v1.setVisible(true);
    }
}
