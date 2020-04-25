package com.example.teller_v1.logica;

public class Productos {

    private String nombre;
    private int precio;
    private int cantidad;
    private int icon;


    public Productos(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Productos(String nombre, int precio, int cantidad, int icon) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.icon = icon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString()
    {
        return nombre+" Precio $"+precio+" x "+cantidad;
    }
}
