package com.example.teller_v1.logica;


import java.util.ArrayList;

public class ServicioTienda {


    public  static ArrayList<Productos> producto= new ArrayList<Productos>();



    public static void adicionarProducto(Productos p) {

        producto.add(p);
    }

    public static int CalculoTotal(){
        int precioT=0;
        for (Productos producto : producto){

            precioT = precioT + (producto.getPrecio()*producto.getCantidad());

        }

        return precioT;

    }

    public static Productos findByName(String name)
    {
        Productos encontrado = null;
        for (Productos producto : producto){
            if (producto.getNombre().equals(name))
            {
                encontrado = producto;
            }
        }
        return encontrado;
    }

    public static ArrayList<Productos> getLista()
    {
        return producto;
    }


}
