public class HelloWorld {
    public static void main(String args[]) {
        if(args.length != 2){
            System.out.println("No se ingresaron la cantidad de datos correctos");
        } else {
            System.out.println("Hello, World! " + args[0] + args[1]);
        }
    }
}

//Javac -Nombre de la clase-
//-nombre de la clase-.Java -> y aca la cadena de caracteres   