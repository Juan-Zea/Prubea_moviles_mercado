package com.example.teller_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

       private Button btn_Siguiente;
        private RadioButton rbtn_Login,rbtn_Tienda;
        private Spinner spInicio;
        private RadioGroup radioG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Siguiente = (Button) findViewById(R.id.btnBienvenido);
        spInicio = (Spinner) findViewById(R.id.spInicio);


        String[] opciones = {"Login","Tienda"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spInicio.setAdapter(adapter);
    }

    public void btnNvaActivity(View view){
        String seleccion = spInicio.getSelectedItem().toString();
        if (seleccion.equals("Login")){
            Intent Sele = new Intent(this,Seleccion.class);
            startActivity(Sele);
        }else if(seleccion.equals("Tienda")){
            Intent Tienda = new Intent(this, com.example.teller_v1.Tienda.class);
            startActivity(Tienda);
        }



    }

}
