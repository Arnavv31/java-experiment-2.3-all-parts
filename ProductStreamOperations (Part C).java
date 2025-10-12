import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %.2f", name, category, price);
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 85000, "Electronics"),
            new Product("Mouse", 800, "Electronics"),
            new Product("Shirt", 1200, "Clothing"),
            new Product("Jeans", 2000, "Clothing"),
            new Product("Mixer", 4500, "Home Appliance"),
            new Product("Fridge", 25000, "Home Appliance"),
            new Product("T-Shirt", 700, "Clothing")
        );

        System.out.println("Product List:");
        products.forEach(System.out::println);

        System.out.println("\nProducts Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        maxByCategory.forEach((category, product) ->
                System.out.println(category + " -> " + product.get().getName() + " (" + product.get().getPrice() + ")")
        );

        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
