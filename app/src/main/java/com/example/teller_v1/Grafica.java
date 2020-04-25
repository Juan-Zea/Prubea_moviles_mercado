package com.example.teller_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.teller_v1.logica.ServicioTienda;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class Grafica extends AppCompatActivity {
    GraphView grafica;
    final static String QUESO = ServicioTienda.getLista().get(0).getNombre();
    final static String JAMON = ServicioTienda.getLista().get(0).getNombre();
    final static String LECHUGA = ServicioTienda.getLista().get(0).getNombre();
    final static String SALCHICHON = ServicioTienda.getLista().get(0).getNombre();
    final static int CANTIDAD = ServicioTienda.getLista().get(0).getCantidad();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);

        grafica = findViewById(R.id.grafica);

        // DATOS DE LAS BARRAS
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(Double.parseDouble(QUESO),CANTIDAD),
                new DataPoint(Double.parseDouble(JAMON),CANTIDAD),
                new DataPoint(Double.parseDouble(LECHUGA),CANTIDAD),
                new DataPoint(Double.parseDouble(SALCHICHON),CANTIDAD)

        });
        grafica.addSeries(series);

        // ESTILO
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(20);

        // DIBUJANDO LOS VALORES
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
    }
    }

