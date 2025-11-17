public class ColaClientes {
    private Cliente frente;
    private int tamaño;

    public ColaClientes() {
        this.frente = null;
        this.tamaño = 0;
    }

    // Para meter un cliente en la cola
    // los ingresamos de acuerto a la prioridad
    // pra agilizar a la hora de atender
    public void encolar(Cliente cliente) {
        // Vacía
        if (frente == null) {
            frente = cliente;
        } else {
            // Buscar la posición correcta según la prioridad
            // Prioridad más alta (3) va primero, luego 2, luego 1
            // Si hay empate, se inserta después de los de la misma prioridad (FIFO)
            
            Cliente actual = frente;
            Cliente anterior = null;
            
            while (actual != null && actual.getPrioridad() >= cliente.getPrioridad()) {
                anterior = actual;  // Guardamos el último nodo con >= prioridad
                actual = actual.getSiguiente();
            }
            
            if (anterior == null) {
                cliente.setSiguiente(frente);
                frente = cliente;
            } else {

                anterior.setSiguiente(cliente);
                cliente.setSiguiente(actual);
            }
        }
        
        tamaño++;
    }

    // Desencolar siguente es facil ya los ordenamos 
    // pr prioridad cuando lo encolamos
    public Cliente desencolar() {
        if (frente == null) {
            return null;
        }

        Cliente clienteAtendido = frente;
        frente = frente.getSiguiente();
        
        // Este queda huerfano ya que no se puede "eliminar"
        clienteAtendido.setSiguiente(null);
        
        tamaño--;
        return clienteAtendido;
    }

    // Ver nada mas
    public Cliente verSiguiente() {
        if (frente == null) {
            return null;
        }
        return frente;
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Obtener el tamaño de la cola
    public int getTamaño() {
        return tamaño;
    }

    // Mostrar todos los clientes en la cola
    public void mostrarCola() {
        if (frente == null) {
            System.out.println("La cola de clientes está vacía.");
            return;
        }

        System.out.println("═══════════════════════════════════════");
        System.out.println("Cola de Clientes");
        System.out.println("Total de clientes en cola: " + tamaño);
        System.out.println("═══════════════════════════════════════");
        
        Cliente actual = frente;
        int posicion = 1;
        
        while (actual != null) {
            System.out.println(posicion + ". " + actual.toString());
            actual = actual.getSiguiente();
            posicion++;
        }
        
        System.out.println("═══════════════════════════════════════");
    }
}

