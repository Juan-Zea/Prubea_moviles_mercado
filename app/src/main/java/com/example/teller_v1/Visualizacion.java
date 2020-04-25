package com.example.teller_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teller_v1.logica.ProductosAdapter;
import com.example.teller_v1.logica.ServicioLogin;
import com.example.teller_v1.logica.ServicioTienda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Visualizacion extends AppCompatActivity {

    private ListView listCompra;
    private Button generar;
    private TextView precio,nombre,cedula,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion);
        listCompra =(ListView) findViewById(R.id.ListviewProductos);
        precio = (TextView)findViewById(R.id.textVPre);
        generar = (Button) findViewById(R.id.btnGenerar);
        nombre = (TextView)findViewById(R.id.textViewnombre);
        cedula =(TextView)findViewById(R.id.textViewcedula);
        fecha = (TextView)findViewById(R.id.textFecha);

        nombre.setText(ServicioLogin.getLista().get(0).getNombre());
        cedula.setText(ServicioLogin.getLista().get(0).getCedula());
//        if (Tienda.cliente !=null) {
//           nombre.setText(Tienda.cliente.getNombre());
//           cedula.setText(Tienda.cliente.getCedula());
//
//
//        }else{
//
//            nombre.setText("NO");
//            cedula.setText("NO");
//            Toast.makeText(this,"Pedido sin reguitro de cliente",Toast.LENGTH_LONG).show();
//
//        }




//       ProductosAdapter adapter= new ProductosAdapter(this,R.layout.listproductos_item_row,ServicioTienda.getLista());
//        listCompra =(ListView) findViewById(R.id.ListviewProductos);
//       listCompra.setAdapter(adapter);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//        Date date = new Date();
//
//         fecha.setText(dateFormat.format(date));
//
//        listCompra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        ProductosAdapter adapter= new ProductosAdapter(this,R.layout.listproductos_item_row,ServicioTienda.getLista());
        listCompra =(ListView) findViewById(R.id.ListviewProductos);
        listCompra.setAdapter(adapter);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        fecha.setText(dateFormat.format(date));

    }

//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
//    }




    public void onclick_MostrarPrecioTotal(View view)
    {
        precio.setText("Valor a pagar es: $"+ String.valueOf(ServicioTienda.CalculoTotal()));
        Toast.makeText(this,"Gracias por comprar",Toast.LENGTH_LONG).show();
    }

    public void btnGrafica(View view){
        Intent activityGrafica = new Intent(this, Grafica.class);
        startActivity(activityGrafica);


    }


}
