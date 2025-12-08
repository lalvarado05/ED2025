public class Cliente {
    private String nombre;
    private int prioridad; // 1: básico, 2: afiliado, 3: premium
    private ListaEnlazadaProductos carrito; // Lista de productos del cliente
    private Cliente siguiente; // Enlace al siguiente cliente en la cola
    private String ubicacion; // Ubicación del cliente (vértice en el grafo)

    public Cliente(String nombre, int prioridad, String ubicacion) {
        this.nombre = nombre;
        if (prioridad >= 1 && prioridad <= 3) {
            this.prioridad = prioridad;
        } else {
            this.prioridad = 1; // Esto es en case de que se ingrese mal el valor
        }
        this.carrito = new ListaEnlazadaProductos();
        this.siguiente = null;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 3) {
            this.prioridad = prioridad;
        }
    }

    public ListaEnlazadaProductos getCarrito() {
        return carrito;
    }

    public void setCarrito(ListaEnlazadaProductos carrito) {
        this.carrito = carrito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Getters y Setters para el enlace siguiente (cola)
    public Cliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Cliente siguiente) {
        this.siguiente = siguiente;
    }

    public String getTipoPrioridad() {
        switch (prioridad) {
            case 1:
                return "Básico";
            case 2:
                return "Afiliado";
            case 3:
                return "Premium";
            default:
                return "Básico";
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " (Prioridad: " + getTipoPrioridad() + " - " + prioridad + ")";
    }
}

