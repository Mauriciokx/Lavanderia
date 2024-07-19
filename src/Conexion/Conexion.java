/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Mauricio Pacheco
 * 17 jul. 2024 - 18:59:57
 */
public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/lavanderia";
    private static final String user = "root";
    private static final String password = "2510";
    
    private static Connection conexion;
    
    public static Connection obtenerConexion(){
        if(conexion == null){
            try {
                conexion = DriverManager.getConnection(url,user,password);
                System.out.println("Conexion exitosa");
            } catch (SQLException e) {
                System.out.println("Error al intentar conectar: "+e.getMessage());
            }
        }
        return conexion;
    }
    
    public static void cerrarConexion(){
        if(conexion != null){
            try {
                conexion.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion: "+e.getMessage());
            }
        }
    }
}
