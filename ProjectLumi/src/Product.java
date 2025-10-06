import java.util.ArrayList;
import java.sql.Date;

public class Product {
    String name;
    double price;
    String category;
    int quantity;
    Date expirationDate;
    ArrayList<String> imagesList;

    public Product(String name, double price, String category, int quantity, Date expirationDate, ArrayList<String> imagesList) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.imagesList = imagesList;
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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", imagesList=" + imagesList +
                '}';
    }

}
