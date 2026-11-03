package com.example.todo;

public class Tarea {

    private String nombre;
    private boolean realizada;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.realizada = false;
    }

    public Tarea(String nombre, boolean realizada) {
        this.nombre = nombre;
        this.realizada = realizada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
}