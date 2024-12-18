package TP01;

public class ej23 {
    private int numero1, numero2;

    // Constructor que recibe los números a utilizar en el cálculo
    public ej23(int num1, int num2) {
        this.numero1 = num1;
        this.numero2 = num2;
    }

    // Método de suma
    public int sumar() {
        return numero1 + numero2;
    }

    // Método de resta
    public int restar() {
        return numero1 - numero2;
    }

    // Método de multiplicacion 
    public int multiplicar() {
        return numero1 * numero2;
    }

    // Método main para probar la clase
    public static void main(String []args) {
        // Instancia de la clase Calculadora
        ej23 calc = new ej23(10, 5);

        // Resultados
        System.out.println("Suma: " + calc.sumar());
        System.out.println("Resta: " + calc.restar());
        System.out.println("Multiplicación: " + calc.multiplicar());
    }
}
