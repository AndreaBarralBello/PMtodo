package com.example.todo;

public class Tarea {

    String nombre;

    boolean realiazada;

    public Tarea() {
    }

    public Tarea(String nombre, boolean realiazada) {
        this.nombre = nombre;
        this.realiazada = realiazada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRealiazada() {
        return realiazada;
    }

    public void setRealiazada(boolean realiazada) {
        this.realiazada = realiazada;
    }
}
