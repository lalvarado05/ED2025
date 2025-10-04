package ed2025;

/**
 * Implementación básica de una Lista Enlazada Simple
 */
public class Lista {
    
    private Nodo cabeza;
    private int tamano;
    
    /**
     * Clase interna que representa un nodo de la lista
     */
    private class Nodo {
        int dato;
        Nodo siguiente;
        
        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    /**
     * Constructor de la lista
     */
    public Lista() {
        this.cabeza = null;
        this.tamano = 0;
    }
    
    /**
     * Agrega un elemento al final de la lista
     * @param dato El valor a agregar
     */
    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
    }
    
    /**
     * Elimina un elemento de la lista
     * @param dato El valor a eliminar
     * @return true si se eliminó el elemento, false en caso contrario
     */
    public boolean eliminar(int dato) {
        if (cabeza == null) {
            return false;
        }
        
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            tamano--;
            return true;
        }
        
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            return true;
        }
        
        return false;
    }
    
    /**
     * Busca un elemento en la lista
     * @param dato El valor a buscar
     * @return true si el elemento existe, false en caso contrario
     */
    public boolean buscar(int dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    
    /**
     * Obtiene el tamaño de la lista
     * @return El número de elementos en la lista
     */
    public int getTamano() {
        return tamano;
    }
    
    /**
     * Verifica si la lista está vacía
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    /**
     * Muestra todos los elementos de la lista
     */
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        System.out.print("Lista: ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
