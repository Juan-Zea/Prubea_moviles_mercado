package com.example.teller_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teller_v1.logica.ServicioLogin;
import com.example.teller_v1.logica.Persona;

public class Seleccion extends AppCompatActivity {

    EditText txt_nombre,txt_cedula;
    Button btn_ingresar,btn_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        txt_nombre = (EditText) findViewById(R.id.ediTextNombre);
        txt_cedula = (EditText) findViewById(R.id.ediTextCedula);
        btn_ingresar = (Button) findViewById(R.id.btnIngresar);
        btn_agregar = (Button) findViewById(R.id.btnClienteAgregar);
    }



    public void btnAdicionarCliente_Click(View view){
        String nombre,cedula;
        Persona nvaP;
        nombre = txt_nombre.getText().toString();
        cedula = txt_cedula.getText().toString();

        nvaP = new Persona(nombre,cedula);
        ServicioLogin.adicionarCliente(nvaP);

        Toast.makeText(this,"Cliente Reguistrado."+nvaP.getNombre(),Toast.LENGTH_LONG).show();
    }
    public void btnNvaActivity(View view){

        Intent activityDos = new Intent(this, Tienda.class);
        startActivity(activityDos);
    }
}
