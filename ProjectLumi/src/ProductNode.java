public class ProductNode {
    // Clase  nodo para una lista enlazada simple productos

    // Atributos
    private Product product;
    private ProductNode next;

    //Metodos
    // Constructor
    public ProductNode(Product product) {
        this.product = product;
        this.next = null;
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public ProductNode getNext() {
        return next;
    }

    // Setters
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setNext(ProductNode next) {
        this.next = next;
    }
}
