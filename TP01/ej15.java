package TP01;

public class ej15{

    public static void main(String[] args) {

        int arreglo[], aux;
        arreglo = new int [args.length];

        for(int i=0; i < arreglo.length; i++){
            try{
                arreglo[i] = Integer.parseInt(args[i]);
            } catch(NumberFormatException e){
                System.out.println("Error en " + args[i]);   
            }
        } 

        //Metodo burbuja
        for(int i=0; i<(arreglo.length-1); i++){
            for(int j=0; j<(arreglo.length-1); j++){
                if (arreglo[j] > arreglo[j+1]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
            }
        }

        System.out.println("\nMostrando el arreglo: ");        
        for(int i=0; i<arreglo.length; i++){
            System.out.println(arreglo[i] + " - ");
        }
    }
}