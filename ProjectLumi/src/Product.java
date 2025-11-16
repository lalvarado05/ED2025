import java.util.ArrayList;
import java.sql.Date;

public class Product {
    String name;
    double price;
    String category;
    int quantity;
    Date expirationDate;
    ArrayList<String> imagesList;
    Product next; // Enlace al siguiente nodo en la lista enlazada

    public Product(String name, double price, String category, int quantity, Date expirationDate, ArrayList<String> imagesList) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.imagesList = imagesList;
        this.next = null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public int getQuantity() {
        return quantity;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public ArrayList<String> getImagesList() {
        return imagesList;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public void addImagen(String rutaImagen) {
        if (this.imagesList == null) {
        this.imagesList = new ArrayList<>();
        }
        this.imagesList.add(rutaImagen);
    }

    // Getters y Setters para el enlace next
    public Product getNext() {
        return next;
    }

    public void setNext(Product next) {
        this.next = next;
    }

    @Override
    public String toString() {
1        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(name).append("\n");
        sb.append("Precio: $").append(String.format("%.2f", price)).append("\n");
        sb.append("Categoría: ").append(category).append("\n");
        sb.append("Cantidad: ").append(quantity).append("\n");
        
        if (expirationDate != null) {
            sb.append("Fecha de vencimiento: ").append(expirationDate).append("\n");
        } else {
            sb.append("Fecha de vencimiento: No aplica\n");
        }
        
        if (imagesList != null && !imagesList.isEmpty()) {
            sb.append("Imágenes: ").append(imagesList.size()).append(" imagen(es)\n");
        } else {
            sb.append("Imágenes: Sin imágenes\n");
        }
        
        return sb.toString();
    }

}
