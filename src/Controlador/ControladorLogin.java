/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;


import Conexion.Conexion;
import Vista.InicioSesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlador.ControladorPagPrincipal;
import javax.swing.JOptionPane;
import Modelo.Login;
/**
 *
 * @author Mauricio Pacheco
 * 19 jul. 2024 - 11:16:15
 */
public class ControladorLogin {
    public static Connection conexion = Conexion.obtenerConexion();
    public static InicioSesion v5 = new InicioSesion();
    public static ControladorPagPrincipal v7 = new ControladorPagPrincipal();
    
    public static void comprobar(String nombre, String contraseña){
        
        boolean ban= Login.buscarUsuario(nombre, contraseña);
        if(ban){
            v7.mostrar();
            v5.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }
    
    public static void mostrar(){
        v5.setVisible(true);
    }
}
