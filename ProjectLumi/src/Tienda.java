public class Tienda {
    private ArbolProductos inventario;
    private ColaClientes colaClientes;
    private String ubicacion;
    private Grafo grafoUbicaciones;
    private static int contadorClientes = 0; // Contador para generar IDs de ubicaciones

    public Tienda() {
        this.inventario = new ArbolProductos();
        this.colaClientes = new ColaClientes();
        this.ubicacion = "Tienda";
        this.grafoUbicaciones = new Grafo();
        // Agregar la ubicación de la tienda al grafo
        this.grafoUbicaciones.agregarVertice(this.ubicacion);
    }

    // Getters
    public ArbolProductos getInventario() {
        return inventario;
    }

    public ColaClientes getColaClientes() {
        return colaClientes;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Grafo getGrafoUbicaciones() {
        return grafoUbicaciones;
    }

    // Agregar producto al inventario
    public void agregarProductoAlInventario(Producto producto) {
        inventario.insertar(producto);
        System.out.println("Producto '" + producto.getName() + "' agregado al inventario.");
    }

    // Agregar cliente a la cola
    public void agregarCliente(Cliente cliente) {
        // Agregar la ubicación del cliente al grafo
        grafoUbicaciones.agregarVertice(cliente.getUbicacion());

        // Crear arista con peso random entre la ubicación del cliente y un vértice
        // existente
        java.util.Random random = new java.util.Random();
        int pesoArista = random.nextInt(10) + 1; // Peso entre 1 y 10

        // Obtener todos los vértices existentes
        java.util.List<String> verticesExistentes = new java.util.ArrayList<>(
                grafoUbicaciones.getListaAdyacencia().keySet());

        // Si hay más de un vértice (además del que acabamos de agregar), conectar con
        // uno random
        if (verticesExistentes.size() > 1) {
            String verticeRandom;
            do {
                verticeRandom = verticesExistentes.get(random.nextInt(verticesExistentes.size()));
            } while (verticeRandom.equals(cliente.getUbicacion())); // Evitar conectar consigo mismo

            grafoUbicaciones.agregarArista(cliente.getUbicacion(), verticeRandom, pesoArista);
            System.out.println("Ubicación '" + cliente.getUbicacion() + "' conectada a '" + verticeRandom
                    + "' con distancia " + pesoArista);
        } else {
            // Si es el primer cliente, conectar directamente con la tienda
            grafoUbicaciones.agregarArista(cliente.getUbicacion(), ubicacion, pesoArista);
            System.out.println(
                    "Ubicación '" + cliente.getUbicacion() + "' conectada a 'Tienda' con distancia " + pesoArista);
        }

        colaClientes.encolar(cliente);
        System.out.println("Cliente '" + cliente.getNombre() + "' agregado a la cola.");
    }

    // Generar ID de ubicación automático para clientes
    public static String generarUbicacionCliente() {
        contadorClientes++;
        return "Cliente" + contadorClientes;
    }

    // Agregar vértice al grafo
    public void agregarVertice(String nombreVertice) {
        grafoUbicaciones.agregarVertice(nombreVertice);
        System.out.println("Ubicación '" + nombreVertice + "' agregada al mapa.");
    }

    // Agregar arista al grafo
    public void agregarArista(String origen, String destino, int peso) {
        grafoUbicaciones.agregarArista(origen, destino, peso);
        System.out.println("Conexión creada entre '" + origen + "' y '" + destino + "' con distancia " + peso);
    }

    // Mostrar el grafo de ubicaciones
    public void mostrarGrafoUbicaciones() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("    MAPA DE UBICACIONES");
        System.out.println("═══════════════════════════════════════");
        grafoUbicaciones.mostrarGrafo();
        System.out.println("═══════════════════════════════════════");
    }

    // Verificar si una ubicación está conectada al grafo
    private boolean estaConectada(String ubicacion) {
        java.util.Map<String, Integer> distancias = new java.util.HashMap<>();
        java.util.Map<String, String> predecesores = new java.util.HashMap<>();

        grafoUbicaciones.algoritmoDijkstra(this.ubicacion, distancias, predecesores);

        // Si la distancia es infinita, no está conectada
        return distancias.get(ubicacion) != null && distancias.get(ubicacion) != Integer.MAX_VALUE;
    }

    // Atender al siguiente cliente (el de mayor prioridad)
    public void atenderSiguienteCliente() {
        if (colaClientes.estaVacia()) {
            System.out.println("No hay clientes en la cola para atender.");
            return;
        }

        Cliente cliente = colaClientes.verSiguiente(); // Verificar primero sin desencolar

        // Verificar si la ubicación del cliente está conectada
        if (!estaConectada(cliente.getUbicacion())) {
            System.out.println("\n═══════════════════════════════════════════════════════════");
            System.out.println("ERROR: No se puede atender al cliente '" + cliente.getNombre() + "'");
            System.out.println("La ubicación '" + cliente.getUbicacion() + "' está desconectada del mapa.");
            System.out.println("Por favor, agregue una conexión a esta ubicación primero.");
            System.out.println("═══════════════════════════════════════════════════════════\n");
            return;
        }

        // Ahora sí desencolamos
        cliente = colaClientes.desencolar();
        ListaEnlazadaProductos carrito = cliente.getCarrito();

        if (carrito.getHead() == null) {
            System.out.println("El cliente '" + cliente.getNombre() + "' no tiene productos en su carrito.");
            return;
        }

        // Calcular el camino más corto usando Dijkstra
        java.util.Map<String, Integer> distancias = new java.util.HashMap<>();
        java.util.Map<String, String> predecesores = new java.util.HashMap<>();
        grafoUbicaciones.algoritmoDijkstra(ubicacion, distancias, predecesores);

        java.util.List<String> camino = grafoUbicaciones.reconstruirCamino(ubicacion, cliente.getUbicacion(),
                predecesores);
        int distanciaTotal = distancias.get(cliente.getUbicacion());

        // Generar factura con información de entrega
        generarFactura(cliente, carrito, camino, distanciaTotal);
    }

    // Generar factura para un cliente
    private void generarFactura(Cliente cliente, ListaEnlazadaProductos carrito, java.util.List<String> camino,
            int distanciaTotal) {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("                    FACTURA DE COMPRA");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Tipo: " + cliente.getTipoPrioridad());
        System.out.println("Ubicación: " + cliente.getUbicacion());
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("Productos:");
        System.out.println("───────────────────────────────────────────────────────────");

        Producto actual = carrito.getHead();
        int item = 1;
        double total = 0.0;

        while (actual != null) {
            double subtotal = actual.getPrice() * actual.getQuantity();
            total += subtotal;

            System.out.println(item + ". " + actual.getName());
            System.out.println("   Cantidad: " + actual.getQuantity());
            System.out.println("   Precio unitario: $" + String.format("%.2f", actual.getPrice()));
            System.out.println("   Subtotal: $" + String.format("%.2f", subtotal));
            System.out.println("───────────────────────────────────────────────────────────");

            actual = actual.getNext();
            item++;
        }

        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", total));
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("INFORMACIÓN DE ENTREGA");
        System.out.println("───────────────────────────────────────────────────────────");
        System.out.println("Camino de entrega óptimo:");
        System.out.println(String.join(" -> ", camino));
        System.out.println("Distancia total: " + distanciaTotal + " unidades");
        System.out.println("═══════════════════════════════════════════════════════════\n");
    }
}

