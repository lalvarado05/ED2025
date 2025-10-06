import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
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