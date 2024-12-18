package TP01;

import java.util.Scanner; 
public class ej16 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Ingrese un numero entero: ");
        int numero = scanner.nextInt(); 
        scanner.close(); 

        String binario = convertirABinario(numero); 
        System.out.println("El numero " + numero + " en binario es: " + binario); 
    }

    private static String convertirABinario(int numero) { 
        if (numero == 0) {
            return "0";
        }

        StringBuilder resultado = new StringBuilder(); 

        while (numero > 0) {
            int resto = numero % 2;
            resultado.append(resto); 
            numero /= 2; }

        return resultado.reverse().toString();
    }
}
