package ed2025;

/**
 * Implementación básica de una Pila (Stack) usando arreglo dinámico
 */
public class Pila {
    
    private int[] elementos;
    private int tope;
    private int capacidad;
    
    /**
     * Constructor de la pila con capacidad inicial
     * @param capacidad Capacidad inicial de la pila
     */
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.tope = -1;
    }
    
    /**
     * Constructor por defecto con capacidad de 10 elementos
     */
    public Pila() {
        this(10);
    }
    
    /**
     * Agrega un elemento al tope de la pila
     * @param elemento El valor a agregar
     */
    public void apilar(int elemento) {
        if (estaLlena()) {
            expandir();
        }
        elementos[++tope] = elemento;
    }
    
    /**
     * Remueve y retorna el elemento del tope de la pila
     * @return El elemento en el tope de la pila
     * @throws RuntimeException si la pila está vacía
     */
    public int desapilar() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos[tope--];
    }
    
    /**
     * Retorna el elemento del tope sin removerlo
     * @return El elemento en el tope de la pila
     * @throws RuntimeException si la pila está vacía
     */
    public int verTope() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos[tope];
    }
    
    /**
     * Verifica si la pila está vacía
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return tope == -1;
    }
    
    /**
     * Verifica si la pila está llena
     * @return true si la pila está llena, false en caso contrario
     */
    public boolean estaLlena() {
        return tope == capacidad - 1;
    }
    
    /**
     * Obtiene el tamaño actual de la pila
     * @return El número de elementos en la pila
     */
    public int getTamano() {
        return tope + 1;
    }
    
    /**
     * Expande la capacidad de la pila cuando está llena
     */
    private void expandir() {
        capacidad *= 2;
        int[] nuevosElementos = new int[capacidad];
        System.arraycopy(elementos, 0, nuevosElementos, 0, elementos.length);
        elementos = nuevosElementos;
    }
    
    /**
     * Muestra todos los elementos de la pila
     */
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return;
        }
        
        System.out.print("Pila (tope -> base): ");
        for (int i = tope; i >= 0; i--) {
            System.out.print(elementos[i]);
            if (i > 0) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
}
