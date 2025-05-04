package com.reto.compras.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarjetaDeCredito {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    public TarjetaDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public boolean registraCompra (Compra compra){

        if (compra.getValor() <= saldo){
            compras.add(compra);
            saldo -= compra.getValor();
            System.out.println("Compra realizada!");
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }

    }

    public double getSaldo() {
        return saldo;
    }

    public void comprasRealizadas(){
        Collections.sort(compras);
        System.out.println("******************************");
        System.out.println("COMPRAS REALIZADAS:\n");

        for(Compra compra: compras){
            System.out.println(compra);
        }

        System.out.println("\n******************************");
        System.out.println("Saldo de la tarjeta: S/"+saldo);

    }


}

