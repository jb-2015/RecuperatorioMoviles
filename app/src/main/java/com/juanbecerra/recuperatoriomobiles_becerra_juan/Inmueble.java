package com.juanbecerra.recuperatoriomobiles_becerra_juan;

import androidx.annotation.Nullable;

import java.util.Objects;

public class Inmueble {
    private int codigo;
    private String descripcion;
    private int cant_ambientes;
    private float precio;

    public Inmueble(int codigo, String descripcion, int cant_ambientes, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cant_ambientes = cant_ambientes;
        this.precio = precio;
    }

    public Inmueble() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCant_ambientes() {
        return cant_ambientes;
    }

    public void setCant_ambientes(int cant_ambientes) {
        this.cant_ambientes = cant_ambientes;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass() != obj.getClass())  return false;
        Inmueble inm = (Inmueble) obj;
        return Integer.compare(inm.codigo,codigo) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
