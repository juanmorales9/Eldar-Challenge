package com.eldar.challenge.creditCard;

public abstract class Marca {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double calcularTasa(){
        return (double) 0;
    };
}
