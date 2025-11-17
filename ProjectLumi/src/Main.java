import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Tienda tienda;
    private static Scanner sc;

    public static void main(String[] args) {
        tienda = new Tienda();
        sc = new Scanner(System.in);
        menu();
        sc.close();
    }

    // Método para limpiar la consola
    private static void limpiarConsola() {
        try {
            String sistemaOperativo = System.getProperty("os.name").toLowerCase();
            
            if (sistemaOperativo.contains("windows")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux, macOS, Unix
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, imprimir líneas en blanco como alternativa
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void menu() {
        int opcion;

        do {
            limpiarConsola();
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("    SISTEMA DE GESTIÓN DE INVENTARIOS");
            System.out.println("═══════════════════════════════════════");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Ver inventario");
            System.out.println("3. Agregar cliente a la cola");
            System.out.println("4. Ver cola de clientes");
            System.out.println("5. Atender siguiente cliente");
            System.out.println("0. Salir");
            System.out.println("═══════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        limpiarConsola();
                        agregarProductoAlInventario();
                        System.out.println("\nPresione Enter para continuar...");
                        sc.nextLine();
                        break;
                    case 2:
                        limpiarConsola();
                        tienda.getInventario().mostrarInventario();
                        System.out.println("\nPresione Enter para continuar...");
                        sc.nextLine();
                        break;
                    case 3:
                        limpiarConsola();
                        agregarClienteALaCola();
                        System.out.println("\nPresione Enter para continuar...");
                        sc.nextLine();
                        break;
                    case 4:
                        limpiarConsola();
                        tienda.getColaClientes().mostrarCola();
                        System.out.println("\nPresione Enter para continuar...");
                        sc.nextLine();
                        break;
                    case 5:
                        limpiarConsola();
                        tienda.atenderSiguienteCliente();
                        System.out.println("\nPresione Enter para continuar...");
                        sc.nextLine();
                        break;
                    case 0:
                        limpiarConsola();
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        System.out.println("\nPresione Enter para continuar...");
                        sc.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
                sc.nextLine(); // Limpiar buffer en caso de error
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // Método para agregar un producto al inventario
    private static void agregarProductoAlInventario() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("   AGREGAR PRODUCTO AL INVENTARIO");
        System.out.println("═══════════════════════════════════════");
        
        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese precio: $");
        double precio = sc.nextDouble();
        sc.nextLine();
        
        System.out.print("Ingrese categoría: ");
        String categoria = sc.nextLine();
        
        System.out.print("Ingrese cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        
        Date fechaVencimiento = null;
        System.out.print("¿Tiene fecha de vencimiento? (s/n): ");
        String tieneFecha = sc.nextLine();
        if (tieneFecha.equalsIgnoreCase("s")) {
            System.out.print("Ingrese fecha de vencimiento (YYYY-MM-DD): ");
            String fechaStr = sc.nextLine();
            try {
                fechaVencimiento = Date.valueOf(fechaStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Fecha inválida. Se establecerá como sin fecha de vencimiento.");
            }
        }
        
        ArrayList<String> imagenes = new ArrayList<>();
        Producto producto = new Producto(nombre, precio, categoria, cantidad, fechaVencimiento, imagenes);
        
        tienda.agregarProductoAlInventario(producto);
    }

    // Método para agregar un cliente a la cola y llenar su carrito
    private static void agregarClienteALaCola() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("      AGREGAR CLIENTE A LA COLA");
        System.out.println("═══════════════════════════════════════");
        
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        
        System.out.println("Seleccione el tipo de cliente:");
        System.out.println("1. Básico");
        System.out.println("2. Afiliado");
        System.out.println("3. Premium");
        System.out.print("Opción: ");
        
        int tipoCliente = sc.nextInt();
        sc.nextLine();
        
        if (tipoCliente < 1 || tipoCliente > 3) {
            System.out.println("Tipo inválido. Se asignará como cliente básico.");
            tipoCliente = 1;
        }
        
        Cliente cliente = new Cliente(nombreCliente, tipoCliente);
        
        // Llenar el carrito del cliente
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("      LLENAR CARRITO DEL CLIENTE");
        System.out.println("═══════════════════════════════════════");
        
        String continuar;
        do {
            if (tienda.getInventario().estaVacio()) {
                System.out.println("El inventario está vacío. No se pueden agregar productos al carrito.");
                break;
            }
            
            tienda.getInventario().mostrarInventario();
            
            System.out.print("\nIngrese el nombre del producto a agregar al carrito: ");
            String nombreProducto = sc.nextLine();
            
            Producto productoInventario = tienda.getInventario().buscar(nombreProducto);
            
            if (productoInventario == null) {
                System.out.println("Producto no encontrado en el inventario.");
            } else {
                System.out.print("Ingrese la cantidad a agregar (disponible: " + productoInventario.getQuantity() + "): ");
                int cantidad = sc.nextInt();
                sc.nextLine();
                
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor a cero.");
                } else if (cantidad > productoInventario.getQuantity()) {
                    System.out.println("No hay suficiente cantidad disponible en el inventario.");
                } else {
                    // Crear una copia del ArrayList de imágenes
                    ArrayList<String> imagenesCopia = new ArrayList<>();
                    if (productoInventario.getImagesList() != null) {
                        imagenesCopia.addAll(productoInventario.getImagesList());
                    }
                    
                    // Crear una copia del producto para el carrito
                    Producto productoCarrito = new Producto(
                        productoInventario.getName(),
                        productoInventario.getPrice(),
                        productoInventario.getCategory(),
                        cantidad,
                        productoInventario.getExpirationDate(),
                        imagenesCopia
                    );
                    
                    cliente.getCarrito().addToEnd(productoCarrito);
                    
                    // Actualizar la cantidad en el inventario
                    productoInventario.setQuantity(productoInventario.getQuantity() - cantidad);
                    
                    System.out.println("Producto agregado al carrito.");
                }
            }
            
            System.out.print("\n¿Desea agregar otro producto al carrito? (s/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        
        // Agregar cliente a la cola
        tienda.agregarCliente(cliente);
        
        System.out.println("\nCliente '" + cliente.getNombre() + "' agregado a la cola con " + 
                         (cliente.getCarrito().getHead() != null ? "productos en su carrito." : "carrito vacío."));
    }
}

