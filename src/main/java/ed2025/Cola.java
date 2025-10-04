package ed2025;

/**
 * Implementación básica de una Cola (Queue) circular usando arreglo
 */
public class Cola {
    
    private int[] elementos;
    private int frente;
    private int finalCola;
    private int tamano;
    private int capacidad;
    
    /**
     * Constructor de la cola con capacidad inicial
     * @param capacidad Capacidad inicial de la cola
     */
    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamano = 0;
    }
    
    /**
     * Constructor por defecto con capacidad de 10 elementos
     */
    public Cola() {
        this(10);
    }
    
    /**
     * Agrega un elemento al final de la cola
     * @param elemento El valor a agregar
     */
    public void encolar(int elemento) {
        if (estaLlena()) {
            expandir();
        }
        finalCola = (finalCola + 1) % capacidad;
        elementos[finalCola] = elemento;
        tamano++;
    }
    
    /**
     * Remueve y retorna el elemento del frente de la cola
     * @return El elemento en el frente de la cola
     * @throws RuntimeException si la cola está vacía
     */
    public int desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        tamano--;
        return elemento;
    }
    
    /**
     * Retorna el elemento del frente sin removerlo
     * @return El elemento en el frente de la cola
     * @throws RuntimeException si la cola está vacía
     */
    public int verFrente() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos[frente];
    }
    
    /**
     * Verifica si la cola está vacía
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return tamano == 0;
    }
    
    /**
     * Verifica si la cola está llena
     * @return true si la cola está llena, false en caso contrario
     */
    public boolean estaLlena() {
        return tamano == capacidad;
    }
    
    /**
     * Obtiene el tamaño actual de la cola
     * @return El número de elementos en la cola
     */
    public int getTamano() {
        return tamano;
    }
    
    /**
     * Expande la capacidad de la cola cuando está llena
     */
    private void expandir() {
        int nuevaCapacidad = capacidad * 2;
        int[] nuevosElementos = new int[nuevaCapacidad];
        
        for (int i = 0; i < tamano; i++) {
            nuevosElementos[i] = elementos[(frente + i) % capacidad];
        }
        
        elementos = nuevosElementos;
        frente = 0;
        finalCola = tamano - 1;
        capacidad = nuevaCapacidad;
    }
    
    /**
     * Muestra todos los elementos de la cola
     */
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return;
        }
        
        System.out.print("Cola (frente -> final): ");
        for (int i = 0; i < tamano; i++) {
            System.out.print(elementos[(frente + i) % capacidad]);
            if (i < tamano - 1) {
                System.out.print(" <- ");
            }
        }
        System.out.println();
    }
}
