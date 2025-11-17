public class ListaEnlazadaProductos {

    private Producto head;


    // Constructor
    public ListaEnlazadaProductos() {
        this.head = null;
    }

    //Getters y Setters
    public Producto getHead() {
        return head;
    }
    public void setHead(Producto head) {
        this.head = head;
    }

    public void addToStart(Producto newNode) {
        if (head == null) {
            setHead(newNode);
        } else {
            newNode.setNext(head);
            setHead(newNode);
        }
    }

    public void addToEnd(Producto newNode) {
        if (head == null) {
            setHead(newNode);
        } else {
            Producto current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Producto searchByName(String name) {
        Producto current = head;
        while (current != null) {
            if (current.getName().equals(name)) {
                System.out.println("Producto encontrado:\n" + current.toString());
                return current;
            }
            current = current.getNext();
        }
        System.out.println("Producto con nombre '" + name + "' no encontrado.");
        return null;
    }

    public void deleteByName(String name) {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (head.getName().equals(name)) {
            head = head.getNext();
            System.out.println("Producto con nombre '" + name + "' eliminado.");
            return;
        }

        Producto current = head;
        Producto previous = null;

        while (current != null && !current.getName().equals(name)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Producto con nombre '" + name + "' no encontrado.");
        } else {
            previous.setNext(current.getNext());
            System.out.println("Producto con nombre '" + name + "' eliminado.");
        }
    }

    public void displayList() {
    if (head == null) {
        System.out.println("La lista está vacía.");
        return;
    }

    Producto current = head;
    int index = 1;
    System.out.println("Lista de Productos");

    while (current != null) {
        System.out.println(index + ". " + current);
        current = current.getNext();
        index++;
    }
}

    public double getTotalCost() {
        double totalCost = 0.0;
        Producto current = head;
        while (current != null) {
            totalCost += current.getPrice() * current.getQuantity();
            current = current.getNext();
        }
        return totalCost;
    }
}


