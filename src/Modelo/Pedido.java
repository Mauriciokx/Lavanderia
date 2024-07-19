/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Mauricio Pacheco
 */
public class Pedido {
    
    //private String noPedido;
    private String nomCliente;
    private String telefono;
    private String direccion;
    private String rfc;
    //private Nota nota;
    private ArrayList<String> listProductos;

    public Pedido(String nomCliente, String telefono, String direccion, String rfc, ArrayList<String> listProductos) {
        this.nomCliente = nomCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rfc = rfc;
        //this.nota = nota;
        this.listProductos = listProductos;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
/*
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
*/
    public ArrayList<String> getListProductos() {
        return listProductos;
    }

    public void setListProductos(ArrayList<String> listProductos) {
        this.listProductos = listProductos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nomCliente=" + nomCliente + ", telefono=" + telefono + ", direccion=" + direccion + ", rfc=" + rfc + '}';
    }

}
