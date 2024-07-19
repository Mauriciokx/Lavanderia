/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Mauricio Pacheco
 */
public class Producto {
    private String nombre;
    private String unidad;
    private double costo;
    //private Promocion promocion;

    public Producto(String nombre, String unidad, double costo) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", unidad=" + unidad + ", costo=" + costo + '}';
    }
}
