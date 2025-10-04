import java.sql.Date;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== LinkedList simple test ===");

        LinkedList list = new LinkedList();

        // Create images lists
        ArrayList<String> imgs1 = new ArrayList<>();
        imgs1.add("apple.png");
        ArrayList<String> imgs2 = new ArrayList<>();
        imgs2.add("banana.png");
        ArrayList<String> imgs3 = new ArrayList<>();
        imgs3.add("carrot.png");

        // Create products
        Product p1 = new Product("Apple", 0.5, "Fruit", 100, Date.valueOf("2025-12-31"), imgs1);
        Product p2 = new Product("Banana", 0.3, "Fruit", 80, Date.valueOf("2025-11-30"), imgs2);
        Product p3 = new Product("Carrot", 0.2, "Vegetable", 200, Date.valueOf("2026-01-15"), imgs3);

        // Wrap in nodes
        ProductNode n1 = new ProductNode(p1);
        ProductNode n2 = new ProductNode(p2);
        ProductNode n3 = new ProductNode(p3);

        // Add to list
        list.addToEnd(n1);
        list.addToEnd(n2);
        list.addToStart(n3); // carrot at the start

        // Display list
        System.out.println("\nList after adding 3 products:");
        list.displayList();

        // Search
        System.out.println("\nSearching for 'Banana':");
        list.searchByName("Banana");

        // Delete
        System.out.println("\nDeleting 'Apple':");
        list.deleteByName("Apple");

        // Final list
        System.out.println("\nFinal list:");
        list.displayList();

        System.out.println("=== Test complete ===");
    }
}
