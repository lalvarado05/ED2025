public class LinkedList {

    private Product head;


    // Constructor
    public LinkedList() {
        this.head = null;
    }

    //Getters y Setters
    public Product getHead() {
        return head;
    }
    public void setHead(Product head) {
        this.head = head;
    }

    public void addToStart(Product newNode) {
        if (head == null) {
            setHead(newNode);
        } else {
            newNode.setNext(head);
            setHead(newNode);
        }
    }

    public void addToEnd(Product newNode) {
        if (head == null) {
            setHead(newNode);
        } else {
            Product current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Product searchByName(String name) {
        Product current = head;
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

        Product current = head;
        Product previous = null;

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

    Product current = head;
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
        Product current = head;
        while (current != null) {
            totalCost += current.getPrice() * current.getQuantity();
            current = current.getNext();
        }
        return totalCost;
    }
}


