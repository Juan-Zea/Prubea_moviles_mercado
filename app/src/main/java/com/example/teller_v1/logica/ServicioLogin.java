package com.example.teller_v1.logica;


import java.util.ArrayList;

public class ServicioLogin {

    private static ArrayList<Persona> cliente = new ArrayList<Persona>();

    public static void adicionarCliente(Persona client) {

        cliente.add(client);
    }

    public static ArrayList<Persona> getLista()
    {
        return cliente;
    }
    public static Persona findByCedula(String cedula)
    {
        Persona encontrado = null;
        for (Persona persona : cliente){
            if (persona.getCedula().equals(cedula))
            {
                encontrado = persona;
            }
        }
        return encontrado;
    }


}
