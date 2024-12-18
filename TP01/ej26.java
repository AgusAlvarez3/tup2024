package TP01;

public class ej26 {
    private final int variableFinal;
    // Constructor para inicializar la variable final
    public ej26(int valor) {
        this.variableFinal = valor;
    }

    // Método para mostrar el valor de la variable final en la consola
    public void mostrarValorFinal() {
        System.out.println("El valor de la variable final es: " + this.variableFinal);
    }

    public static void main(String args[]) {
        // Crear una instancia de la clase con un valor inicial de 13
        ej26 instancia = new ej26(13);

        // Llamar al método para mostrar el valor de la variable final
        instancia.mostrarValorFinal();
    }

}
