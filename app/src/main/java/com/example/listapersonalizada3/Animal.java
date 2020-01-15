package com.example.listapersonalizada3;

import android.app.Activity;
import android.content.res.TypedArray;
import android.widget.ImageView;

public class Animal {

    private String nombre;
    private int foto;
    private String descripcion;
    private int icono;

    public Animal(String nombre, int foto, String descripcion, int icono) {
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
