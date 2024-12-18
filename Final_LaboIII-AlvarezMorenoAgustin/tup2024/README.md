# Proyecto Final Laboratorio 3 - Sistema Bancario - Tup2024 

## Descripción del Proyecto

Este proyecto implementa un sistema de gestión bancaria que incluye la creación y administración de clientes, cuentas y préstamos. Sus principales características incluyen:

- Inicialización de objetos mediante constructores.  
- Representación de entidades del sistema (clientes, cuentas y préstamos) en la capa **Model**.  
- Gestión de la interacción con la base de datos a través de la capa **Persistence**.  
- Implementación de lógica de negocio en la capa **Service**, encargada de la creación de clientes y cuentas, gestión de préstamos, pagos y saldos.  
- Validación de funcionalidades mediante **Postman** para probar endpoints REST.  
- Cobertura de pruebas mediante la ejecución de test unitarios utilizando **JUnit**.  


---

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java JDK 19 o superior**  
- **Apache Maven 3.9.6 o superior**  
- **Postman**

---
## Endpoints Principales

### **Clientes**

- **Crear un cliente**  
  **POST**  `https://localhost:8080/api/cliente`  
  **Cuerpo JSON de ejemplo**:
  ```json
  {
      "nombre": "Agustin",
      "apellido": "Alvarez",
      "dni": 45460664,
      "fechaNacimiento": "2004-01-11",
      "tipoPersona": "F",
      "banco": "Banco Nacional"
  }

- **Buscar un cliente por DNI**  
  **GET**  `https://localhost:8080/api/cliente/{dni}`  

- **Buscar todos los clientes**  
  **GET**  `https://localhost:8080/api/cliente/all`  


---

### **Cuentas**

- **Crear una cuenta**  
  **POST**  `https://localhost:8080/api/cuenta`  
  **Cuerpo JSON de ejemplo**:
  ```json
    {
        "tipoCuenta": "C",  
        "moneda": "P",  
        "dniTitular": 45460664
    }

- **Consultar cuentas de un cliente**  
  **GET**  `https://localhost:8080/api/cuenta/{numeroCuenta}`  

  ---

### **Préstamos**

- **Solicitar un préstamo**  
  **POST**  `https://localhost:8080/api/prestamo`  
  **Cuerpo JSON de ejemplo**:
    ```json
    {
        "numeroCliente": 45460664,
        "monto": 50000,
        "plazoMeses": 12,
        "moneda": "P"
    }

- **Pagar Cuota**  
  **POST**  `https://localhost:8080/api/prestamo/{id}`  

- **Consultar prestamos**  
  **GET**  `https://localhost:8080/api/prestamo/{dni}`  

