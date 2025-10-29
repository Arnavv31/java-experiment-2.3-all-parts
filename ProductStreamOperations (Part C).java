import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

public class partC {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 70000, "Electronics"),
                new Product("Phone", 30000, "Electronics"),
                new Product("Shirt", 1500, "Clothing"),
                new Product("Jeans", 2000, "Clothing"),
                new Product("Book", 500, "Books")
        );

        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products grouped by category:");
        grouped.forEach((k, v) -> System.out.println(k + ": " + v));

        Map<String, Optional<Product>> maxPrice = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost expensive product in each category:");
        maxPrice.forEach((k, v) -> System.out.println(k + ": " + v.get()));

        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage price of all products: " + avgPrice);
    }
}
