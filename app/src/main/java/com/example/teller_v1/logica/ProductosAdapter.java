package com.example.teller_v1.logica;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.teller_v1.R;

import java.util.ArrayList;
import java.util.List;

public class ProductosAdapter extends ArrayAdapter<Productos> {

    private Context context;
    private int resource;
    private ArrayList<Productos> productos;

    public ProductosAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Productos> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.productos = objects;
    }

    public View getView(int posicion, View view , ViewGroup parent){
        ProductosHolder holder = null;

        if(view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view  = inflater.inflate(resource,parent,false);
            holder = new ProductosHolder();
            holder.setImagen((ImageView) view.findViewById(R.id.imagenListProducto));
            holder.setTexto((TextView) view.findViewById(R.id.txtListProducto));
            view.setTag(holder);
        }else{
            holder = (ProductosHolder) view.getTag();
        }

        Productos producto  = productos.get(posicion);
        holder.setTexto(producto.getNombre()+" --Cantidad: "+producto.getCantidad()+" --Preció unidad: $"+producto.getPrecio());
        holder.setImagen(producto.getIcon());
        return view;
    }

    //Clase estatica Holder
    static class ProductosHolder {

        private ImageView imagen;
        private TextView texto;


        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getTexto() {
            return texto;
        }

        public void setTexto(TextView texto) {
            this.texto = texto;
        }

        public void setImagen(int imagen) {
            this.imagen.setImageResource(imagen);
        }

        public void setTexto(String texto) {
            this.texto.setText(texto);
        }
    }


}



