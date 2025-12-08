import java.sql.Date;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Crear una nueva tienda
        Tienda tienda = new Tienda();
        
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("  DEMOSTRACIÓN DEL SISTEMA DE GESTIÓN CON RUTAS DE ENTREGA");
        System.out.println("═══════════════════════════════════════════════════════════\n");
        
        // 1. Agregar algunos productos al inventario
        System.out.println("1. AGREGANDO PRODUCTOS AL INVENTARIO...\n");
        
        Producto p1 = new Producto("Laptop", 1200.00, "Electrónica", 10, null, new ArrayList<>());
        Producto p2 = new Producto("Mouse", 25.00, "Electrónica", 50, null, new ArrayList<>());
        Producto p3 = new Producto("Teclado", 45.00, "Electrónica", 30, null, new ArrayList<>());
        Producto p4 = new Producto("Monitor", 300.00, "Electrónica", 15, null, new ArrayList<>());
        
        tienda.agregarProductoAlInventario(p1);
        tienda.agregarProductoAlInventario(p2);
        tienda.agregarProductoAlInventario(p3);
        tienda.agregarProductoAlInventario(p4);
        
        System.out.println("\n2. INVENTARIO ACTUAL:");
        tienda.getInventario().mostrarInventario();
        
        // 2. Crear algunos clientes con ubicaciones automáticas
        System.out.println("\n3. AGREGANDO CLIENTES A LA COLA...\n");
        
        Cliente cliente1 = new Cliente("Juan Pérez", 3, Tienda.generarUbicacionCliente());
        cliente1.getCarrito().addToEnd(new Producto("Laptop", 1200.00, "Electrónica", 1, null, new ArrayList<>()));
        cliente1.getCarrito().addToEnd(new Producto("Mouse", 25.00, "Electrónica", 2, null, new ArrayList<>()));
        
        Cliente cliente2 = new Cliente("María García", 2, Tienda.generarUbicacionCliente());
        cliente2.getCarrito().addToEnd(new Producto("Teclado", 45.00, "Electrónica", 1, null, new ArrayList<>()));
        
        Cliente cliente3 = new Cliente("Carlos López", 1, Tienda.generarUbicacionCliente());
        cliente3.getCarrito().addToEnd(new Producto("Monitor", 300.00, "Electrónica", 1, null, new ArrayList<>()));
        
        tienda.agregarCliente(cliente1);
        System.out.println();
        tienda.agregarCliente(cliente2);
        System.out.println();
        tienda.agregarCliente(cliente3);
        
        // 3. Mostrar la cola de clientes
        System.out.println("\n4. COLA DE CLIENTES ACTUAL:");
        tienda.getColaClientes().mostrarCola();
        
        // 4. Mostrar el mapa de ubicaciones
        System.out.println("\n5. MAPA DE UBICACIONES GENERADO:");
        tienda.mostrarGrafoUbicaciones();
        
        // 5. Atender a los clientes (mostrar rutas de entrega)
        System.out.println("\n6. ATENDIENDO CLIENTES...\n");
        
        System.out.println("══════════════════════════════════════════════════════════");
        System.out.println("ATENDIENDO CLIENTE 1 (Prioridad más alta):");
        System.out.println("══════════════════════════════════════════════════════════");
        tienda.atenderSiguienteCliente();
        
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println("ATENDIENDO CLIENTE 2:");
        System.out.println("══════════════════════════════════════════════════════════");
        tienda.atenderSiguienteCliente();
        
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println("ATENDIENDO CLIENTE 3:");
        System.out.println("══════════════════════════════════════════════════════════");
        tienda.atenderSiguienteCliente();
        
        // 6. Demostración de cliente con ubicación desconectada
        System.out.println("\n7. DEMOSTRANDO VALIDACIÓN DE UBICACIÓN DESCONECTADA...\n");
        
        // Agregar una ubicación desconectada manualmente
        tienda.agregarVertice("UbicacionAislada");
        
        Cliente cliente4 = new Cliente("Ana Martínez", 3, "UbicacionAislada");
        cliente4.getCarrito().addToEnd(new Producto("Mouse", 25.00, "Electrónica", 1, null, new ArrayList<>()));
        
        // Este cliente no se puede atender porque su ubicación está desconectada
        tienda.getColaClientes().encolar(cliente4);
        
        System.out.println("Intentando atender cliente con ubicación desconectada:");
        tienda.atenderSiguienteCliente();
        
        // Conectar la ubicación aislada
        System.out.println("\nConectando la ubicación aislada al mapa...");
        tienda.agregarArista("UbicacionAislada", "Tienda", 15);
        
        System.out.println("\nAhora sí se puede atender:");
        tienda.atenderSiguienteCliente();
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("            DEMOSTRACIÓN COMPLETADA");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}

        Scanner sc = new Scanner(System.in);
        LinkedList listaProductos = new LinkedList();
        int opcion;

        do {
            System.out.println("Menu de gestor de productos");
            System.out.println("1. Agregar producto al inicio");
            System.out.println("2. Agregar producto al final");
            System.out.println("3. Mostrar lista de productos");
            System.out.println("4. Buscar producto por nombre");
            System.out.println("5. Eliminar producto por nombre");
            System.out.println("6. Modificar producto");
            System.out.println("7. Añadir imagen a un producto");
            System.out.println("8. Reporte de costos totales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    listaProductos.addToStart(crearProducto(sc));
                    break;

                case 2:
                    listaProductos.addToEnd(crearProducto(sc));
                    break;

                case 3:
                    listaProductos.displayList();
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreBuscar = sc.nextLine();
                    listaProductos.searchByName(nombreBuscar);
                    break;

                case 5:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    listaProductos.deleteByName(nombreEliminar);
                    break;

                case 6:
                    modificarProducto(sc, listaProductos);
                    break;

                case 7:
                    añadirImagenProducto(sc, listaProductos);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // Método para crear un producto
private static ProductNode crearProducto(Scanner sc) {
    System.out.print("Ingrese nombre: ");
    String nombre = sc.nextLine();
    System.out.print("Ingrese precio: ");
    double precio = sc.nextDouble();
    sc.nextLine(); // limpiar buffer
    System.out.print("Ingrese categoría: ");
    String categoria = sc.nextLine();
    System.out.print("Ingrese cantidad: ");
    int cantidad = sc.nextInt();
    sc.nextLine();
    
    // Manejo de fecha de vencimiento
    Date fechaVencimiento = null;
    System.out.print("¿Tiene fecha de vencimiento? (s/n): ");
    String tieneFecha = sc.nextLine();
    if (tieneFecha.equalsIgnoreCase("s")) {
        System.out.print("Ingrese fecha de vencimiento (YYYY-MM-DD): ");
        String fechaStr = sc.nextLine();
        fechaVencimiento = Date.valueOf(fechaStr);
    }
    
    // Lista de imágenes vacía inicialmente
    ArrayList<String> imagenes = new ArrayList<>();
    
    Product producto = new Product(nombre, precio, categoria, cantidad, fechaVencimiento, imagenes);
    
    // Mensaje de confirmación
    System.out.println("✅ Producto '" + nombre + "' creado exitosamente!");
    return new ProductNode(producto);
}
  // Método para añadir imagen a producto
private static void añadirImagenProducto(Scanner sc, LinkedList lista) {
    System.out.print("Ingrese el nombre del producto: ");
    String nombreImg = sc.nextLine();
    ProductNode nodoImg = lista.searchByName(nombreImg);
    
        if (nodoImg != null) {
            System.out.print("Ingrese la ruta de la nueva imagen: ");
            String rutaImg = sc.nextLine();
            nodoImg.getProduct().addImagen(rutaImg);
            System.out.println("✅ Imagen añadida correctamente al producto '" + nombreImg + "'.");
            }
        }
private static void modificarProducto(Scanner sc, LinkedList lista) {
    System.out.print("Ingrese el nombre del producto a modificar: ");
    String nombreModificar = sc.nextLine();
    ProductNode nodoMod = lista.searchByName(nombreModificar);
    
        if (nodoMod != null) {
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = sc.nextDouble();
            sc.nextLine();
            System.out.print("Nueva categoría: ");
            String nuevaCategoria = sc.nextLine();
            System.out.print("Nueva cantidad: ");
            int nuevaCantidad = sc.nextInt();
            sc.nextLine();

            nodoMod.getProduct().setName(nuevoNombre);
            nodoMod.getProduct().setPrice(nuevoPrecio);
            nodoMod.getProduct().setCategory(nuevaCategoria);
            nodoMod.getProduct().setQuantity(nuevaCantidad);

            System.out.println("Producto actualizado correctamente.");
        }
    }
}