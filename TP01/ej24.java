package TP01;

public class ej24 {
    private int variable;

    //Metodo set
    public void setVariable(int valor) {
        this.variable = valor;
    }
    //Metodo get
    public int getVariable() {
        return this.variable;
    }

    public static void main(String args[]) {
        // Crear una instancia de la clase
        ej24 instancia = new ej24();

        instancia.setVariable(42);

        System.out.println("El valor de la variable es: " + instancia.getVariable());
    }
}
