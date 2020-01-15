package com.example.listapersonalizada3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class AdaptadorPersonalizado extends ArrayAdapter {
    private Activity context;
    private ArrayList<Animal> animales;

    public AdaptadorPersonalizado(@NonNull Activity context, ArrayList<Animal> animales) {
        super(context, R.layout.layout_fila, animales);
        this.context = context;
        this.animales = animales;
    }

    static class ViewHolder {
        LinearLayout llFila;
        TextView txtAnimal;
        ImageView foto;
        TextView txtDescripcion;
        ImageView icono;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila = convertView;
        ViewHolder holder;

        if (fila == null) {
            LayoutInflater inflador = context.getLayoutInflater();
            fila = inflador.inflate(R.layout.layout_fila, null);

            //Creamos el objeto ViewHolder para cargar las referencias en el propio objeto y optimizar el código
            holder = new ViewHolder();
            holder.llFila = (LinearLayout) fila.findViewById(R.id.llFila);
            holder.txtAnimal = (TextView) fila.findViewById(R.id.txtAnimal);
            holder.foto = (ImageView) fila.findViewById(R.id.imgAnimal);
            holder.txtDescripcion = (TextView) fila.findViewById(R.id.txtDescripcion);
            holder.icono = (ImageView) fila.findViewById(R.id.imgColor);

            fila.setTag(holder);
        } else { //Si ya existe la fila cargamos los tags desde el ViewHolder
            holder = (ViewHolder)fila.getTag();
        }



        if ((position+1)%2 == 0) {
            holder.txtAnimal.setTextColor(context.getResources().getColor(R.color.nombre_par));
            holder.llFila.setBackgroundColor(context.getResources().getColor(R.color.columna_par));
        } else {
            holder.txtAnimal.setTextColor(context.getResources().getColor(R.color.nombre_impar));
            holder.llFila.setBackgroundColor(context.getResources().getColor(R.color.columna_impar));
        }

        holder.txtAnimal.setText(animales.get(position).getNombre());
        holder.foto.setImageResource(animales.get(position).getFoto());
        holder.txtDescripcion.setText(animales.get(position).getDescripcion());
        holder.icono.setImageResource(animales.get(position).getIcono());

        return fila;
    }
}
