package ed2025;

/**
 * Clase de prueba básica para la clase Cola
 */
public class ColaTest {
    
    public static void main(String[] args) {
        System.out.println("=== Pruebas de Cola ===");
        
        // Prueba 1: Crear cola y encolar elementos
        System.out.println("\nPrueba 1: Encolar elementos");
        Cola cola = new Cola();
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.mostrar();
        System.out.println("Tamaño: " + cola.getTamano());
        
        // Prueba 2: Ver frente
        System.out.println("\nPrueba 2: Ver frente");
        System.out.println("Elemento en el frente: " + cola.verFrente());
        
        // Prueba 3: Desencolar elementos
        System.out.println("\nPrueba 3: Desencolar elementos");
        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("Desencolado: " + cola.desencolar());
        cola.mostrar();
        System.out.println("Tamaño: " + cola.getTamano());
        
        // Prueba 4: Verificar si está vacía
        System.out.println("\nPrueba 4: Verificar si está vacía");
        System.out.println("¿Está vacía? " + cola.estaVacia());
        
        System.out.println("\n=== Todas las pruebas completadas ===");
    }
}
