package com.example.teller_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teller_v1.logica.Productos;
import com.example.teller_v1.logica.ServicioLogin;
import com.example.teller_v1.logica.ServicioTienda;
import com.example.teller_v1.logica.Persona;


public class Tienda extends AppCompatActivity {

    private Button btn_Agregar, btn_Continuar,btn_Buscar;
    private RadioGroup RadioG;
    private RadioButton rdQueso;
    private RadioButton rdJamon;
    private RadioButton rdLechuga;
    private RadioButton rdSalchichon;
    private TextView txt_Cantidad,txt_Cedula ;
    final static int Precio_Queso = 2000;
    final static int Precio_jamon = 3000;
    final static int Precio_Lechuga = 1500;
    final static int Precio_Salchichon = 2000;
    public static Persona cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        btn_Agregar = (Button) findViewById(R.id.btnAgregar);
        btn_Continuar = (Button) findViewById(R.id.btnContinuar);
        btn_Buscar = (Button) findViewById(R.id.btnBuscar);
        rdQueso = (RadioButton) findViewById(R.id.rdQueso) ;
        rdJamon = (RadioButton) findViewById(R.id.rdJamon);
        rdLechuga = (RadioButton) findViewById(R.id.rdLechuga);
        rdSalchichon = (RadioButton) findViewById(R.id.rdSalchichon);
        txt_Cedula = (TextView) findViewById(R.id.txtCedula);
        txt_Cantidad = (TextView)findViewById(R.id.txtCantidad);
    }


        public void btnNvaActivity(View view){
            Intent activityVisualizacion = new Intent(this, Visualizacion.class);
            startActivity(activityVisualizacion);


       }

         public void btnAgregar(View view) {

             Productos p,j;
             int cantidad = 0;

            if(rdQueso.isChecked()){

                cantidad =Integer.parseInt(txt_Cantidad.getText().toString());
                p = new Productos(rdQueso.getText().toString(),Precio_Queso,Integer.parseInt(txt_Cantidad.getText().toString()),R.mipmap.queso);

                ServicioTienda.adicionarProducto(p);
                Toast.makeText(this,"Su producto esta en el carrito",Toast.LENGTH_LONG).show();
            }
            else if (rdJamon.isChecked())
            {
                 cantidad =Integer.parseInt(txt_Cantidad.getText().toString());
                j = new Productos(rdJamon.getText().toString(),Precio_jamon,Integer.parseInt(txt_Cantidad.getText().toString()),R.mipmap.jamon);

                ServicioTienda.adicionarProducto(j);
                Toast.makeText(this,"Su producto esta en el carrito",Toast.LENGTH_LONG).show();
            }
            else if (rdLechuga.isChecked()){
                cantidad =Integer.parseInt(txt_Cantidad.getText().toString());
                j = new Productos(rdLechuga.getText().toString(),Precio_Lechuga,Integer.parseInt(txt_Cantidad.getText().toString()),R.mipmap.lechuga);

                ServicioTienda.adicionarProducto(j);
                Toast.makeText(this,"Su producto esta en el carrito",Toast.LENGTH_LONG).show();
            }

            else if(rdSalchichon.isChecked()){
                cantidad =Integer.parseInt(txt_Cantidad.getText().toString());
                j = new Productos(rdSalchichon.getText().toString(),Precio_Salchichon,Integer.parseInt(txt_Cantidad.getText().toString()),R.mipmap.salchichon);

                ServicioTienda.adicionarProducto(j);
                Toast.makeText(this,"Su producto esta en el carrito",Toast.LENGTH_LONG).show();
            }
         }

    public static void setPersona(Persona clientes)
    {
        cliente = clientes;
    }

    public void btnBuscarCliente(View view) {
        if (ServicioLogin.findByCedula(txt_Cedula.getText().toString())!=null)
        {
            setPersona(ServicioLogin.findByCedula(txt_Cedula.getText().toString()));
            Toast.makeText(this,"Cliente encontrado",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Cliente no encontrado",Toast.LENGTH_LONG).show();
        }

    }


    }


