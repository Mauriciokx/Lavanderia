/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;


import Controlador.ControladorClientes;
import Controlador.ControladorProducto;
import Controlador.ControladorPromocion;
import Controlador.ControladorPedido;
import Conexion.Conexion;
import java.sql.Connection;
import Controlador.ControladorLogin;
/**
 * 
 * @author Mauricio Pacheco
 */
public class app {
    public static void main(String args[]){
        //ControladorClientes.mostrar();
        //ControladorProducto.mostrar();
        //ControladorPromocion.mostrar();
        //ControladorPedido.mostrar();
        //Connection conexion = Conexion.obtenerConexion();
        ControladorLogin.mostrar();
    }
}
