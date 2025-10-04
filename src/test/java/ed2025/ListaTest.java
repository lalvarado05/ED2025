package ed2025;

/**
 * Clase de prueba básica para la clase Lista
 */
public class ListaTest {
    
    public static void main(String[] args) {
        System.out.println("=== Pruebas de Lista ===");
        
        // Prueba 1: Crear lista y agregar elementos
        System.out.println("\nPrueba 1: Agregar elementos");
        Lista lista = new Lista();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.mostrar();
        System.out.println("Tamaño: " + lista.getTamano());
        
        // Prueba 2: Buscar elementos
        System.out.println("\nPrueba 2: Buscar elementos");
        System.out.println("¿Existe 20? " + lista.buscar(20));
        System.out.println("¿Existe 40? " + lista.buscar(40));
        
        // Prueba 3: Eliminar elemento
        System.out.println("\nPrueba 3: Eliminar elemento");
        System.out.println("Eliminando 20: " + lista.eliminar(20));
        lista.mostrar();
        System.out.println("Tamaño: " + lista.getTamano());
        
        // Prueba 4: Lista vacía
        System.out.println("\nPrueba 4: Verificar si está vacía");
        System.out.println("¿Está vacía? " + lista.estaVacia());
        
        System.out.println("\n=== Todas las pruebas completadas ===");
    }
}
