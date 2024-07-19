/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import Conexion.Conexion;
import static Controlador.ControladorLogin.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Pacheco
 * 19 jul. 2024 - 11:55:37
 */
public class Login {
    //private String usuario="Juan";
    //private String contraseña="123";
    //private String consulta;
    
    private static boolean ban = false;
    public static Connection conexion = Conexion.obtenerConexion();

    public static boolean buscarUsuario(String usuario, String contraseña){
        
        String query = "SELECT usuario FROM usuarios WHERE usuario = ? AND contraseña = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Usuario autenticado
                    //v7.mostrar();
                    ban = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return ban;
    }
            

}
