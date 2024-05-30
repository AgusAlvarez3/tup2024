package ar.edu.utn.frbb.tup.presentation.input;

import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cliente;
import ar.edu.utn.frbb.tup.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MenuInputProcessor extends BaseInputProcessor{

    ClienteInputProcessor clienteInputProcessor;

    boolean exit = false;

    public MenuInputProcessor(ClienteInputProcessor clienteInputProcessor) {
        this.clienteInputProcessor = clienteInputProcessor;
    }

    public void renderMenu() {

        while (!exit) {
            System.out.println("Bienveido a la aplicación de Banco!");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Crear una nueva Cuenta");
            System.out.println("3. Generar un movimiento");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    clienteInputProcessor.altaCliente();
                    break;
//            case 2:
//                createAccount();
//                break;
//            case 3:
//                performTransaction();
//                break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
            clearScreen();
        }
    }
}
