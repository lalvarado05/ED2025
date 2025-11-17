public class Tienda {
    private ArbolProductos inventario;
    private ColaClientes colaClientes;

    public Tienda() {
        this.inventario = new ArbolProductos();
        this.colaClientes = new ColaClientes();
    }

    // Getters
    public ArbolProductos getInventario() {
        return inventario;
    }

    public ColaClientes getColaClientes() {
        return colaClientes;
    }

    // Agregar producto al inventario
    public void agregarProductoAlInventario(Producto producto) {
        inventario.insertar(producto);
        System.out.println("Producto '" + producto.getName() + "' agregado al inventario.");
    }

    // Agregar cliente a la cola
    public void agregarCliente(Cliente cliente) {
        colaClientes.encolar(cliente);
        System.out.println("Cliente '" + cliente.getNombre() + "' agregado a la cola.");
    }

    // Atender al siguiente cliente (el de mayor prioridad)
    public void atenderSiguienteCliente() {
        if (colaClientes.estaVacia()) {
            System.out.println("No hay clientes en la cola para atender.");
            return;
        }

        Cliente cliente = colaClientes.desencolar();
        ListaEnlazadaProductos carrito = cliente.getCarrito();
        
        if (carrito.getHead() == null) {
            System.out.println("El cliente '" + cliente.getNombre() + "' no tiene productos en su carrito.");
            return;
        }

        // Generar factura
        generarFactura(cliente, carrito);
    }

    // Generar factura para un cliente
    private void generarFactura(Cliente cliente, ListaEnlazadaProductos carrito) {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("                    FACTURA DE COMPRA");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Tipo: " + cliente.getTipoPrioridad());
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
        System.out.println("═══════════════════════════════════════════════════════════\n");
    }
}

