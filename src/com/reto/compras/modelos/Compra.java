package com.reto.compras.modelos;

public class Compra implements Comparable<Compra> {
    private String descripcion;
    private double valor;

    public Compra(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "-> "+descripcion + " - S/ " +valor;
    }

    @Override
    public int compareTo(Compra otra) {
        return Double.compare(this.valor,otra.valor);
    }
}
