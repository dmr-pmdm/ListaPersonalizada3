package com.example.listapersonalizada3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<Animal> listAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listPersonalizada);

        String[] animales = getResources().getStringArray(R.array.animales);
        TypedArray fotos = getResources().obtainTypedArray(R.array.imagenes);
        String[] descripciones = getResources().getStringArray(R.array.descripcion);
        TypedArray iconos = getResources().obtainTypedArray(R.array.iconos);

        cargarArray(animales, fotos, descripciones, iconos);


        AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(this,
                listAnimales);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Elección: " + listAnimales.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cargarArray(String[] animales, TypedArray fotos, String[] descripciones, TypedArray iconos) {
        listAnimales = new ArrayList<>();
        for (int i = 0; i < animales.length; i++) {
            listAnimales.add(new Animal(animales[i], fotos.getResourceId(i, -1), descripciones[i], iconos.getResourceId(i,-1)));
        }
    }
}
