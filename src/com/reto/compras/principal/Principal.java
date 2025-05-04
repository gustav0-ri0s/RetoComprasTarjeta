package com.reto.compras.principal;

import com.reto.compras.modelos.Compra;
import com.reto.compras.modelos.TarjetaDeCredito;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double limite = leerValorPositivo(teclado,"Escriba el límite de la tarjeta: ");
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int continuar = 1;

        while (continuar == 1){

            System.out.print("\nEscriba la descripción de la compra: ");
            String descripcion = teclado.nextLine();

            double valor = leerValorPositivo(teclado,"Escriba el valor de la compra (S/): ");

            Compra compra = new Compra(descripcion,valor);
            boolean registroValido = tarjeta.registraCompra(compra);
            if(!registroValido){
                break;
            }

            if (tarjeta.getSaldo()==0){
                System.out.println("Ya no cuenta con saldo para mas compras");
                break;
            }


            System.out.print("\nEscriba 0 para salir o 1 para continuar: ");
            continuar = teclado.nextInt();
            teclado.nextLine();

        }
        tarjeta.comprasRealizadas();
        teclado.close();

    }

    public static double leerValorPositivo(Scanner scanner, String mensaje) {
        double valor;
        do {
            System.out.print(mensaje);
            valor = scanner.nextDouble();
            scanner.nextLine(); // limpiar el buffer

            if (valor <= 0) {
                System.out.println("El valor debe ser mayor que cero. Intente nuevamente.");
            }
        } while (valor <= 0);

        return valor;
    }

}
