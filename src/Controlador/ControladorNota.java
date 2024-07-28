/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Vista.Nota;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Mauricio Pacheco
 * 25 jul. 2024 - 23:12:37
 */
public class ControladorNota {
    
    public static Nota vNota = new Nota();
    
    public static void mostrar(JDesktopPane principal, JInternalFrame vNota){
        principal.add(vNota);
        vNota.show();
        
    }

}
