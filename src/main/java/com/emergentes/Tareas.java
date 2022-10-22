
package com.emergentes;


public class Tareas {
     private int id;
    private String pendientes;
    
     public Tareas() {
    }

    public Tareas(int id, String pendientes) {
        this.id = id;
        this.pendientes = pendientes;
        //this.cantidad = cantidad;
        //this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPendientes() {
        return pendientes;
    }

    public void setPendientes(String pendientes) {
        this.pendientes = pendientes;
    }

    
}
