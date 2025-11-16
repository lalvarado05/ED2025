
import java.util.ArrayList;

public class ArbolProductos {
    private Producto raiz;

    public ArbolProductos() {
        this.raiz = null;
    }

    // Insertar un producto en el árbol
    public void insertar(Producto producto) {
        raiz = insertarRecursivo(raiz, producto);
    }

    private Producto insertarRecursivo(Producto nodo, Producto producto) {
        if (nodo == null) {
            return producto;
        }

        // Comparar por nombre (llave)
        int comparacion = producto.getName().compareToIgnoreCase(nodo.getName());
        
        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), producto));
        } else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), producto));
        } else {
            // esto es por si la comparacion da igual,
            // quiere decir que el producto ya existe y
            // actualizamos la cantidad en vez de crear uno nuevo
            nodo.setQuantity(nodo.getQuantity() + producto.getQuantity());
        }
        
        return nodo;
    }

    // Buscar un producto por nombre
    public Producto buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    private Producto buscarRecursivo(Producto nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        int comparacion = nombre.compareToIgnoreCase(nodo.getName());
        
        if (comparacion == 0) {
            return nodo;
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), nombre);
        } else {
            return buscarRecursivo(nodo.getDerecho(), nombre);
        }
    }

    // in-order
    public void obtenerProductosEnOrden(ArrayList<Producto> lista) {
        obtenerProductosEnOrdenRecursivo(raiz, lista);
    }

    private void obtenerProductosEnOrdenRecursivo(Producto nodo, ArrayList<Producto> lista) {
        if (nodo != null) {
            obtenerProductosEnOrdenRecursivo(nodo.getIzquierdo(), lista);
            lista.add(nodo);
            obtenerProductosEnOrdenRecursivo(nodo.getDerecho(), lista);
        }
    }

    // Mostrar todo
    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }

        ArrayList<Producto> productos = new ArrayList<>();
        obtenerProductosEnOrden(productos);
        
        System.out.println("═══════════════════════════════════════");
        System.out.println("Inventario de la Tienda");
        System.out.println("═══════════════════════════════════════");
        
        int index = 1;
        for (Producto producto : productos) {
            System.out.println(index + ". " + producto.getName() + 
                             " - Precio: $" + String.format("%.2f", producto.getPrice()) + 
                             " - Cantidad disponible: " + producto.getQuantity() + 
                             " - Categoría: " + producto.getCategory());
            index++;
        }
        System.out.println("═══════════════════════════════════════");
    }

    // Vacio?
    public boolean estaVacio() {
        return raiz == null;
    }
}

