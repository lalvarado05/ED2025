package ed2025;

/**
 * Clase de prueba básica para la clase Pila
 */
public class PilaTest {
    
    public static void main(String[] args) {
        System.out.println("=== Pruebas de Pila ===");
        
        // Prueba 1: Crear pila y apilar elementos
        System.out.println("\nPrueba 1: Apilar elementos");
        Pila pila = new Pila();
        pila.apilar(5);
        pila.apilar(10);
        pila.apilar(15);
        pila.mostrar();
        System.out.println("Tamaño: " + pila.getTamano());
        
        // Prueba 2: Ver tope
        System.out.println("\nPrueba 2: Ver tope");
        System.out.println("Elemento en el tope: " + pila.verTope());
        
        // Prueba 3: Desapilar elementos
        System.out.println("\nPrueba 3: Desapilar elementos");
        System.out.println("Desapilado: " + pila.desapilar());
        System.out.println("Desapilado: " + pila.desapilar());
        pila.mostrar();
        System.out.println("Tamaño: " + pila.getTamano());
        
        // Prueba 4: Verificar si está vacía
        System.out.println("\nPrueba 4: Verificar si está vacía");
        System.out.println("¿Está vacía? " + pila.estaVacia());
        
        System.out.println("\n=== Todas las pruebas completadas ===");
    }
}
