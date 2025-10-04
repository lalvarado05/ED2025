package ed2025;

/**
 * Clase principal para ejecutar el programa de Estructuras de Datos 2025
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Bienvenido a Estructuras de Datos 2025");
        
        // Ejemplo de uso de Lista
        Lista lista = new Lista();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        
        System.out.println("Lista creada con éxito!");
        lista.mostrar();
    }
}
