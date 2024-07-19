/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.LinkedList;

/**
 *
 * @author Mauricio Pacheco
 */
public class Lavanderia {
    private String nombre;
    private String ubicacion;
    private String horario;
    private LinkedList<Pedido> pedido;

    public Lavanderia(String nombre, String ubicacion, String horario, LinkedList<Pedido> pedido) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.pedido = pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public LinkedList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(LinkedList<Pedido> pedido) {
        this.pedido = pedido;
    }
    
    
}
