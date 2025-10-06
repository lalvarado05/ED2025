public class LinkedList {

    private ProductNode head;


    // Constructor
    public LinkedList() {
        this.head = null;
    }

    //Getters y Setters
    public ProductNode getHead() {
        return head;
    }
    public void setHead(ProductNode head) {
        this.head = head;
    }

    public void addToStart(ProductNode newNode) {
        if (head == null) {
            setHead(newNode);
        } else {
            newNode.setNext(head);
            setHead(newNode);
        }
    }

    public void addToEnd(ProductNode newNode) {
        if (head == null) {
            setHead(newNode);
        } else {
            ProductNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public ProductNode searchByName(String name) {
        ProductNode current = head;
        while (current != null) {
            if (current.getProduct().getName().equals(name)) {
                System.out.println("Product found:\n" + current);
                return current;
            }
            current = current.getNext();
        }
        System.out.println("Product with name " + name + " not found.");
        return null;
    }

    public void deleteByName(String name) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head.getProduct().getName().equals(name)) {
            head = head.getNext();
            System.out.println("Product with name " + name + " deleted.");
            return;
        }

        ProductNode current = head;
        ProductNode previous = null;

        while (current != null && !current.getProduct().getName().equals(name)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Product with name " + name + " not found.");
        } else {
            previous.setNext(current.getNext());
            System.out.println("Product with name " + name + " deleted.");
        }
    }

    public void displayList() {
    if (head == null) {
        System.out.println("The list is empty.");
        return;
    }

    ProductNode current = head;
    int index = 1;
    System.out.println("Products List");

    while (current != null) {
        System.out.println(index + ". " + current.getProduct());
        current = current.getNext();
        index++;
    }
}
}


