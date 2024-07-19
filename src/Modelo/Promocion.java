/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Mauricio Pacheco
 */
public class Promocion {
    private String nombre;
    private String descripcion;
    private String nomProducto;
    private int cantidad;
    private double costo;

    public Promocion(String nombre, String descripcion, String nomProducto, int cantidad, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nomProducto = nomProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Promocion(String nombre, String descripcion, int cantidad, double costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Promocion{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", nomProducto=" + nomProducto + ", cantidad=" + cantidad + ", costo=" + costo + '}';
    }
     
}
